package org.ck.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.ck.model.cp;
import org.ck.model.gys;
import org.ck.model.inout;
import org.ck.model.xck;
import org.ck.model.yg;
import org.ck.dao.KucunMapper;
import org.ck.dao.RukuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;


@Service ("KucunService")	  
public class KucunService implements KucunServiceImpl {
		@Autowired
		private KucunMapper KucunMapper;

		/**
	     * 未入库模块
	     * @param session
	     * @return
	     */
		//查询出所有的未入库流水账单
		public String rukuNolist(HttpSession session){
			List<inout> rukuNolist=KucunMapper.rukuNolist();
			session.setAttribute("rukuNolist", rukuNolist);
			List<gys> gyslist=KucunMapper.gyslist();
			List<cp>  cplist =KucunMapper.cplist();
			List<xck> xcklist=KucunMapper.xcklist();
			session.setAttribute("gyslist", gyslist);
			session.setAttribute("cplist", cplist);
			session.setAttribute("xcklist", xcklist);
			return "/kucun/rukuNolist";
		}
	 
		//转到入库表单打印界面
		public String torukuApplyPrinting(String id,HttpSession session){
			inout inout=KucunMapper.selectInoutById(id);//根据id查询出流水记录
			session.setAttribute("inout", inout);
			List<gys> gyslist=KucunMapper.gyslist();
			List<cp>  cplist =KucunMapper.cplist();
			List<xck> xcklist=KucunMapper.xcklist();
			session.setAttribute("gyslist", gyslist);
			session.setAttribute("cplist", cplist);
			session.setAttribute("xcklist", xcklist);
			return "/ruku/rukuApplyPrinting";
		}
		
		//根据关键字模糊搜索相关未入库流水记录
		public String rukuNoSearch(String rukuNoSearch,HttpSession session){
			List<inout> rukuNolist=KucunMapper.rukuNoSearch(rukuNoSearch);
			session.setAttribute("rukuNolist", rukuNolist);
			List<gys> gyslist=KucunMapper.gyslist();
			List<cp>  cplist =KucunMapper.cplist();
			List<xck> xcklist=KucunMapper.xcklist();
			session.setAttribute("gyslist", gyslist);
			session.setAttribute("cplist", cplist);
			session.setAttribute("xcklist", xcklist);
			return "/kucun/rukuNolist";
		}
		
		//产品入库确认
		public String rukuSuccess(String id,HttpSession session){
			int i=KucunMapper.rukuSuccess(id);
			List<inout> rukuNolist=KucunMapper.rukuNolist();
			session.setAttribute("rukuNolist", rukuNolist);
			return "/kucun/rukuNolist";
		}
	    
		
		/**
	     * 已入库模块
	     * @param session
	     * @return
	     */
		//查询出所有的已入库流水账单
		public String rukuYeslist(HttpSession session){
			session.setAttribute("msg", "");
			List<inout> rukuYeslist=KucunMapper.rukuYeslist();
			session.setAttribute("rukuYeslist", rukuYeslist);
			List<gys> gyslist=KucunMapper.gyslist();
			List<cp>  cplist =KucunMapper.cplist();
			List<xck> xcklist=KucunMapper.xcklist();
			session.setAttribute("gyslist", gyslist);
			session.setAttribute("cplist", cplist);
			session.setAttribute("xcklist", xcklist);
			return "/kucun/rukuYeslist";
		}

		//转到出库表单打印界面
		public String tochukuApplyPrinting(String id,HttpSession session){
			inout inout=KucunMapper.selectInoutById(id);//根据id查询出流水记录
			if(inout.getOutTime()==null){
				session.setAttribute("msg", "供应商未申请该产品出库,操作失败");
				return "/kucun/rukuYeslist";
			}
			session.setAttribute("inout", inout);
			List<gys> gyslist=KucunMapper.gyslist();
			List<cp>  cplist =KucunMapper.cplist();
			List<xck> xcklist=KucunMapper.xcklist();
			session.setAttribute("gyslist", gyslist);
			session.setAttribute("cplist", cplist);
			session.setAttribute("xcklist", xcklist);
			return "/chuku/chukuApplyPrinting";
		}		
		
		//根据关键字模糊搜索相关已入库流水记录
		public String rukuYesSearch(String rukuYesSearch,HttpSession session){
			List<inout> rukuYeslist=KucunMapper.rukuYesSearch(rukuYesSearch);
			session.setAttribute("rukuYeslist", rukuYeslist);
			List<gys> gyslist=KucunMapper.gyslist();
			List<cp>  cplist =KucunMapper.cplist();
			List<xck> xcklist=KucunMapper.xcklist();
			session.setAttribute("gyslist", gyslist);
			session.setAttribute("cplist", cplist);
			session.setAttribute("xcklist", xcklist);
			return "/kucun/rukuYeslist";
		}		
		
		//产品出库确认
		public String chukuSuccess(String id,HttpSession session){	
			inout inout1=KucunMapper.selectInoutById(id);
			if(inout1.getOutTime()==null){
				session.setAttribute("msg", "供应商未申请该产品出库,操作失败");
				return "/kucun/rukuYeslist";
			}			
			KucunMapper.chukuSuccess(id);//出库成功
			List<inout> rukuYeslist=KucunMapper.rukuYeslist();
			session.setAttribute("rukuYeslist", rukuYeslist);
			inout inout=KucunMapper.selectInoutById(id);//根据id查询出流水记录
			KucunMapper.chukuUpdateXckSize1(inout.getSize(),inout.getXckId());//产品出库，小仓库容量恢复
			return "/kucun/rukuYeslist";
		}
		
		
	     
	     /**
	      * 已出库模块
	      * @param session
	      * @return
	      */
		
		//查询出所有的已出库流水账单
		public String chukuYeslist(HttpSession session){
			List<inout> chukuYeslist=KucunMapper.chukuYeslist();
			session.setAttribute("chukuYeslist", chukuYeslist);
			List<gys> gyslist=KucunMapper.gyslist();
			List<cp>  cplist =KucunMapper.cplist();
			List<xck> xcklist=KucunMapper.xcklist();
			session.setAttribute("gyslist", gyslist);
			session.setAttribute("cplist", cplist);
			session.setAttribute("xcklist", xcklist);
			return "/kucun/chukuYeslist";
		}
		
		//根据关键字模糊搜索相关已出库流水记录
		public String chukuYesSearch(String chukuYesSearch,HttpSession session){
			List<inout> chukuYeslist=KucunMapper.chukuYesSearch(chukuYesSearch);
			session.setAttribute("chukuYeslist", chukuYeslist);
			List<gys> gyslist=KucunMapper.gyslist();
			List<cp>  cplist =KucunMapper.cplist();
			List<xck> xcklist=KucunMapper.xcklist();
			session.setAttribute("gyslist", gyslist);
			session.setAttribute("cplist", cplist);
			session.setAttribute("xcklist", xcklist);
			return "/kucun/chukuYeslist";
		}	
		
}

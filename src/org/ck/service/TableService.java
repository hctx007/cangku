package org.ck.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.ck.model.cp;
import org.ck.model.gys;
import org.ck.model.inout;
import org.ck.model.xck;
import org.ck.model.yg;
import org.ck.dao.TableMapper;
import org.ck.dao.RukuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;


@Service ("TableService")	  
public class TableService implements TableServiceImpl {
		@Autowired
		private TableMapper TableMapper;

		
		//进入库存报表界面
		public String kucuntable(HttpSession session){
			List<inout> inoutlist=TableMapper.rukuNolist();//查询出所有的未入库流水账单  
			session.setAttribute("inoutlist", inoutlist);
			List<gys> gyslist=TableMapper.gyslist();
			List<cp>  cplist =TableMapper.cplist();
			List<xck> xcklist=TableMapper.xcklist();
			session.setAttribute("gyslist", gyslist);
			session.setAttribute("cplist", cplist);
			session.setAttribute("xcklist", xcklist);
			return "/baobiao/kucuntable";
		}
		
		//模糊搜索对应的流水记录
		public String kucunSearch(Integer state,String kucunSearch,HttpSession session){
			//System.out.println(kucunSearch+state);
			List<inout> inoutlist=TableMapper.kucunSearch(state,kucunSearch);//模糊搜索对应的流水记录
			session.setAttribute("inoutlist", inoutlist);
			List<gys> gyslist=TableMapper.gyslist();
			List<cp>  cplist =TableMapper.cplist();
			List<xck> xcklist=TableMapper.xcklist();
			session.setAttribute("gyslist", gyslist);
			session.setAttribute("cplist", cplist);
			session.setAttribute("xcklist", xcklist);
			return "/baobiao/kucuntable";			
		}
		
		
		//进入财务报表界面
		public String moneytable(HttpSession session){
			List<inout> inoutlist=TableMapper.rukuNolist();//查询出所有的未入库流水账单  
			session.setAttribute("inoutlist", inoutlist);
			List<gys> gyslist=TableMapper.gyslist();
			List<cp>  cplist =TableMapper.cplist();
			List<xck> xcklist=TableMapper.xcklist();
			session.setAttribute("gyslist", gyslist);
			session.setAttribute("cplist", cplist);
			session.setAttribute("xcklist", xcklist);
			return "/baobiao/moneytable";
		}
		
		//模糊搜索对应的财务流水记录
		public String moneySearch(Integer state,String moneySearch,HttpSession session){
			//System.out.println(kucunSearch+state);
			List<inout> inoutlist=TableMapper.moneySearch(state,moneySearch);//模糊搜索对应的财务流水记录
			session.setAttribute("inoutlist", inoutlist);
			List<gys> gyslist=TableMapper.gyslist();
			List<cp>  cplist =TableMapper.cplist();
			List<xck> xcklist=TableMapper.xcklist();
			session.setAttribute("gyslist", gyslist);
			session.setAttribute("cplist", cplist);
			session.setAttribute("xcklist", xcklist);
			return "/baobiao/kucuntable";			
		}
	 
		
		
}

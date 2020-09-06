package org.ck.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.ck.model.cp;
import org.ck.model.gys;
import org.ck.model.inout;
import org.ck.model.xck;
import org.ck.model.yg;
import org.ck.dao.ChukuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.util.MyUtil;


@Service ("ChukuService")	  
public class ChukuService implements ChukuServiceImpl {
		@Autowired
		private ChukuMapper ChukuMapper;


		//查询出全部的供应商、产品，进入出库申请页面
		public String chukuApply(HttpSession session){
			List<gys> gyslist=ChukuMapper.gyslist();
			List<cp> cplist=ChukuMapper.cplist();
			session.setAttribute("gyslist", gyslist);
			session.setAttribute("cplist", cplist);
			session.setAttribute("msg", "");	
			return "/chuku/chukuApply";
		}
	    
		//出库申请审核
		public String chukuApplyResult(inout inout , HttpSession session){
			inout inout1=ChukuMapper.selectInoutById(inout.getId());
			if(inout1!=null&&inout1.getOutTime()==null){
				inout1.setOutTime(inout.getOutTime());
				ChukuMapper.updateInoutOutTime(inout1);//记录出库时间
				session.setAttribute("inout", inout1);	
				session.setAttribute("msg", "出库审核通过");	
				return "/chuku/chukuApply";
			}
			session.setAttribute("msg", "出库审核失败");	
			return "/chuku/chukuApply";
		}
		
		//出库表单打印
		public String chukuApplyPrinting(){
			return "/chuku/chukuApplyPrinting";
		}
	    
		
}

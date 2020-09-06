package org.ck.service;

import java.util.List;

import javax.enterprise.inject.New;
import javax.servlet.http.HttpSession;

import org.ck.model.dck;
import org.ck.model.xck;
import org.ck.dao.DckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;


@Service ("DckService")	  
public class DckService implements DckServiceImpl {
		@Autowired
		private DckMapper DckMapper;

		//查询出大仓库的基本信息
		public String dcksetup(HttpSession session){
			if(DckMapper.dcksetup()!=null){
	    		dck dck1=DckMapper.dcksetup();
	    		//System.out.println("要编辑的大仓库是："+dck1);
	    		session.setAttribute("dck", dck1);
	    		return "/dacangku/dcksetup";
	    	}
			session.setAttribute("dck", null);
			return "/dacangku/dcksetup";
		}
		
		//查询出大仓库的基本信息
		public String dckEdit(dck dck){
			if(DckMapper.dcksetup()!=null){
	    		dck dck1=DckMapper.dcksetup();
	    		System.out.println("要编辑的大仓库是："+dck1);
	    		DckMapper.dckEdit(dck);
	    		return "redirect:/dcksetup.do"; 
	    	}
			System.out.println("要设置的大仓库是："+dck);
			DckMapper.dckAdd(dck);
			return "redirect:/dcksetup.do"; 
		}

		

	 	
}

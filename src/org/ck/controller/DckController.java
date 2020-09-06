package org.ck.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ck.model.dck;
import org.ck.service.DckService;

@Controller
public class DckController {
    @Autowired
    private DckService DckService;
   
  	
    //查询出大仓库的基本信息
  	@RequestMapping("/dcksetup")
	public String dcksetup(HttpSession session) {
		return DckService.dcksetup(session);
	}
  	
    //设置大仓库的基本信息
  	@RequestMapping("/dckEdit")
	public String dckEdit(dck dck) {
		return DckService.dckEdit(dck);
	}
  	

  		
}

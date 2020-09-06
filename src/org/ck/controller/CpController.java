package org.ck.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ck.model.cp;
import org.ck.service.CpService;



@Controller
public class CpController {
    @Autowired
    private CpService CpService;
  	
    //查询出全部的产品，进入管理产品页面
  	@RequestMapping("/cplist")
	public String cplist(HttpSession session) {
		return CpService.cplist(session);
	}
  	
    //模糊搜索产品	
  	@RequestMapping("/cpSearch")
	public String cpSearch(String cpSearch,HttpSession session) {
		return CpService.cpSearch(cpSearch,session);
	}
  	
    //根据id查询产品并转到产品编辑界面
    @RequestMapping("/tocpEdit")
	public String tocpEdit(Integer id,Model model) {
		return CpService.tocpEdit(id,model);	
	}
  	
    //修改产品信息
    @RequestMapping("/cpEdit")
	public String cpEdit(@ModelAttribute cp cp) {
		return CpService.cpEdit(cp);	
	}
    
    //删除指定id的产品
  	@RequestMapping("/cpDel")
	public String cpDel(Integer id) {
		return CpService.cpDel(id);
	}
    
  	//转到产品添加界面
    @RequestMapping("/tocpAdd")
	public String tocpAdd(HttpSession session) {
		return CpService.tocpAdd(session);	
	}
  	
    //添加产品
  	@RequestMapping("/cpAdd")
	public String cpAdd(@ModelAttribute cp cp) {
		return CpService.cpAdd(cp);
	}
  	
  	
  
  	
    
	
}

package org.ck.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ck.model.cgy;
import org.ck.service.CgyService;



@Controller
public class CgyController {
    @Autowired
    private CgyService CgyService;
   
    //仓管员登录处理
  	@RequestMapping("/login")
	public String login(@ModelAttribute cgy cgy, Model model, HttpSession session) {
		return CgyService.login(cgy, model, session);
	}
  	
  	//仓管员退出处理
  	@RequestMapping("/exit")
  	public String exit(HttpSession session,HttpServletRequest request){
  		return CgyService.exit(session, request);
  	}
  	
    //查询出全部的仓管员，进入管理仓管员页面
  	@RequestMapping("/cgylist")
	public String cgylist(HttpSession session) {
		return CgyService.cgylist(session);
	}
  	
    //根据用户名、姓名模糊搜索仓管员	
  	@RequestMapping("/cgySearch")
	public String cgySearch(String cgySearch,HttpSession session) {
		return CgyService.cgySearch(cgySearch,session);
	}
  	
    //根据id查询仓管员并转到仓管员编辑界面
    @RequestMapping("/tocgyEdit")
	public String tocgyEdit(Integer id,Model model) {
		return CgyService.tocgyEdit(id,model);	
	}
  	
    //修改仓管员信息
    @RequestMapping("/cgyEdit")
	public String cgyEdit(@ModelAttribute cgy cgy) {
		return CgyService.cgyEdit(cgy);	
	}
    
    //删除指定id的仓管员
  	@RequestMapping("/cgyDel")
	public String cgyDel(Integer id) {
		return CgyService.cgyDel(id);
	}
    
  	//转到仓管员添加界面
    @RequestMapping("/tocgyAdd")
	public String tocgyAdd() {
		return CgyService.tocgyAdd();	
	}
  	
    //添加仓管员
  	@RequestMapping("/cgyAdd")
	public String cgyAdd(@ModelAttribute cgy cgy) {
		return CgyService.cgyAdd(cgy);
	}
  	
  	
  
  	
    
	
}

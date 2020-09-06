package org.ck.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ck.model.yg;
import org.ck.service.YgService;



@Controller
public class YgController {
    @Autowired
    private YgService YgService;
   
  	
    //查询出全部的员工，进入管理员工页面
  	@RequestMapping("/yglist")
	public String yglist(HttpSession session) {
		return YgService.yglist(session);
	}
  	
    //根据用户名、姓名模糊搜索员工	
  	@RequestMapping("/ygSearch")
	public String ygSearch(String ygSearch,HttpSession session) {
		return YgService.ygSearch(ygSearch,session);
	}
  	
    //根据id查询员工并转到员工编辑界面
    @RequestMapping("/toygEdit")
	public String toygEdit(Integer id,Model model) {
		return YgService.toygEdit(id,model);	
	}
  	
    //修改员工信息
    @RequestMapping("/ygEdit")
	public String ygEdit(@ModelAttribute yg yg) {
		return YgService.ygEdit(yg);	
	}
    
    //删除指定id的员工
  	@RequestMapping("/ygDel")
	public String ygDel(Integer id) {
		return YgService.ygDel(id);
	}
    
  	//转到员工添加界面
    @RequestMapping("/toygAdd")
	public String toygAdd() {
		return YgService.toygAdd();	
	}
  	
    //添加员工
  	@RequestMapping("/ygAdd")
	public String ygAdd(@ModelAttribute yg yg) {
		return YgService.ygAdd(yg);
	}
  		
}

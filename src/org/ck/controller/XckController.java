package org.ck.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ck.model.xck;
import org.ck.service.XckService;

@Controller
public class XckController {
    @Autowired
    private XckService XckService;
   
  	
    //查询出全部的小仓库，进入管理小仓库页面
  	@RequestMapping("/xcklist")
	public String xcklist(HttpSession session) {
		return XckService.xcklist(session);
	}
  	
    //根据小仓库id模糊搜索小仓库
  	@RequestMapping("/xckSearch")
	public String xckSearch(String xckSearch,HttpSession session) {
		return XckService.xckSearch(xckSearch,session);
	}
  	
    //根据id查询小仓库并转到小仓库编辑界面
    @RequestMapping("/toxckEdit")
	public String toxckEdit(Integer id,Model model) {
		return XckService.toxckEdit(id,model);	
	}
  	
    //修改小仓库信息
    @RequestMapping("/xckEdit")
	public String xckEdit(@ModelAttribute xck xck) {
		return XckService.xckEdit(xck);	
	}
    
    //删除指定id的小仓库及其流水记录
  	@RequestMapping("/xckDel")
	public String xckDel(Integer id) {
		return XckService.xckDel(id);
	}
    
  	//转到小仓库添加界面
    @RequestMapping("/toxckAdd")
	public String toxckAdd() {
		return XckService.toxckAdd();	
	}
  	
    //添加小仓库
  	@RequestMapping("/xckAdd")
	public String xckAdd(@ModelAttribute xck xck) {
		return XckService.xckAdd(xck);
	}
  		
}

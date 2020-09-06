package org.ck.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ck.model.cgy;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

public interface CgyServiceImpl {
	
	public String login(cgy cgy, Model model, HttpSession session);//仓管员登录验证	
	public String exit(HttpSession session,HttpServletRequest request);//仓管员退出处理
	public String cgylist(HttpSession session);//查询出全部的仓管员，进入管理仓管员页面
	public String cgySearch(String cgySearch,HttpSession session);//根据用户名、姓名模糊搜索仓管员	
	public String tocgyEdit(Integer id,Model model);//根据id查询仓管员并转到仓管员编辑界面
	public String cgyEdit(cgy cgy);//修改仓管员信息
	public String cgyDel(Integer id);//删除指定id的仓管员
	public String tocgyAdd();//转到仓管员添加界面
	public String cgyAdd(cgy cgy);//添加仓管员
	
}

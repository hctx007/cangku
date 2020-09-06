package org.ck.service;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.ck.model.cp;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

public interface CpServiceImpl {
	
	public String cplist(HttpSession session);//查询出全部的产品，进入管理产品页面
	public String cpSearch(String cpSearch,HttpSession session);// 模糊搜索产品	
	public String tocpEdit(Integer id,Model model);//根据id查询产品并转到产品编辑界面
	public String cpEdit(cp cp);//修改产品信息
	public String cpDel(Integer id);//删除指定id的产品
	public String tocpAdd(HttpSession session);//转到产品添加界面
	public String cpAdd(cp cp);//添加产品
	
}

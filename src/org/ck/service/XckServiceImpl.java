package org.ck.service;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.ck.model.xck;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

public interface XckServiceImpl {
	
	public String xcklist(HttpSession session);//查询出全部的小仓库，进入管理小仓库页面
	public String xckSearch(String xckSearch,HttpSession session);//根据小仓库id模糊搜索小仓库	
	public String toxckEdit(Integer id,Model model);//根据id查询小仓库并转到小仓库编辑界面
	public String xckEdit(xck xck);//修改小仓库信息
	public String xckDel(Integer id);//删除指定id的小仓库及其流水记录
	public String toxckAdd();//转到小仓库添加界面
	public String xckAdd(xck xck);//添加小仓库
	
}

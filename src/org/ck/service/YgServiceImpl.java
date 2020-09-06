package org.ck.service;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.ck.model.cgy;
import org.ck.model.yg;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

public interface YgServiceImpl {
	
	public String yglist(HttpSession session);//查询出全部的员工，进入管理员工页面
	public String ygSearch(String ygSearch,HttpSession session);//根据用户名、姓名模糊搜索员工	
	public String toygEdit(Integer id,Model model);//根据id查询员工并转到员工编辑界面
	public String ygEdit(yg yg);//修改员工信息
	public String ygDel(Integer id);//删除指定id的员工
	public String toygAdd();//转到员工添加界面
	public String ygAdd(yg yg);//添加员工
	
}

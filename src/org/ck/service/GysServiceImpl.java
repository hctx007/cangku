package org.ck.service;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.ck.model.gys;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

public interface GysServiceImpl {
	
	public String gyslist(HttpSession session);//查询出全部的供应商，进入管理供应商页面
	public String gysSearch(String gysSearch,HttpSession session);//根据供应商id模糊搜索供应商	
	public String togysEdit(Integer id,Model model);//根据id查询供应商并转到供应商编辑界面
	public String gysEdit(gys gys);//修改供应商信息
	public String gysDel(Integer id);//删除指定id的供应商及相关产品和流水记录
	public String togysAdd();//转到供应商添加界面
	public String gysAdd(gys gys);//添加供应商
	
}

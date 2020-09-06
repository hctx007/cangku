package org.ck.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.ck.model.xck;
import org.ck.dao.XckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;


@Service ("XckService")	  
public class XckService implements XckServiceImpl {
		@Autowired
		private XckMapper XckMapper;

	    
	    //查询出全部的小仓库，进入管理小仓库页面
	    public String xcklist(HttpSession session){
	    	List<xck> xcklist=XckMapper.xcklist();
			session.setAttribute("xcklist", xcklist);	
	    	return "/xiaocangku/xcklist";
	    }
	    
	    //根据小仓库id模糊搜索小仓库	
	    public String xckSearch(String xckSearch,HttpSession session){
	    	System.out.println("小仓库搜索关键字："+xckSearch);
	    	List<xck> xcklist=XckMapper.xckSearch(xckSearch);
	    	session.setAttribute("xcklist", xcklist);
	    	return "/xiaocangku/xcklist";
	    }
	    
    	//根据id查询小仓库并转到小仓库编辑界面
	    public String toxckEdit(Integer id,Model model) {
	    	if(XckMapper.toxckEdit(id)!=null){
	    		xck xck1=XckMapper.toxckEdit(id);
	    		System.out.println("要编辑的小仓库是："+xck1);
	    		model.addAttribute("xck", xck1);
	    		return "/xiaocangku/xckedit";}
	    	else{
	    		return "redirect:/xcklist.do"; 
	    	}
	    }
	    
	    //修改小仓库信息
	    public String xckEdit(xck xck){
	    	System.out.println("编辑后的小仓库信息："+xck);
	    	XckMapper.xckEdit(xck);
	        return "redirect:/xcklist.do"; 
	    }
	    
	    //删除指定id的小仓库及其流水记录
	    public String xckDel(Integer id){
	    	System.out.println("删除的小仓库id:"+id);
	    	XckMapper.xckDel(id);
	    	return "redirect:/xcklist.do";
	    }
	    
	    //转到小仓库添加界面
	    public String toxckAdd(){
	        return "xiaocangku/xckadd";
	    }
	    
	    //添加小仓库
	    public String xckAdd(xck xck){
			System.out.println("添加的小仓库信息："+xck);
			XckMapper.xckAdd(xck);	
			return "redirect:/xcklist.do";
	    }
	    
	    
		
		
}

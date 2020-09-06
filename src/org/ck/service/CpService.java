package org.ck.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.ck.model.cgy;
import org.ck.model.cp;
import org.ck.model.gys;
import org.ck.dao.CpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;


@Service ("CPService")	  
public class CpService implements CpServiceImpl {
	@Autowired
	private CpMapper CpMapper;

    
    //查询出全部的产品，进入管理产品页面
    public String cplist(HttpSession session){
    	List<gys> gyslist=CpMapper.gyslist1();//查询出全部的供应商
    	List<cp> cplist=CpMapper.cplist();
		session.setAttribute("gyslist", gyslist);	
		session.setAttribute("cplist", cplist);	
    	return "/chanpin/cplist";
    }
    
    // 模糊搜索产品	
    public String cpSearch(String cpSearch,HttpSession session){   	
    	System.out.println("产品搜索关键字："+cpSearch);
    	List<cp> cplist=CpMapper.cpSearch(cpSearch);
    	session.setAttribute("cplist", cplist);
    	return "/chanpin/cplist";
    }
    
	//根据id查询产品并转到产品编辑界面
    public String tocpEdit(Integer id,Model model) {
    	if(CpMapper.tocpEdit(id)!=null){
    		cp cp1=CpMapper.tocpEdit(id);
    		System.out.println("要编辑的产品是："+cp1);
    		model.addAttribute("cp", cp1);
    		return "/chanpin/cpedit";}
    	else{
    		return "redirect:/cplist.do"; 
    	}
    }
    
    //修改产品信息
    public String cpEdit(cp cp){
    	System.out.println("编辑后的产品信息："+cp);
    	CpMapper.cpEdit(cp);
        return "redirect:/cplist.do"; 
    }
    
    //删除指定id的产品
    public String cpDel(Integer id){
    	System.out.println("删除的产品id:"+id);
    	CpMapper.cpDel(id);
    	return "redirect:/cplist.do";
    }
    
    //转到产品添加界面
    public String tocpAdd(HttpSession session){
    	List<gys> gyslist=CpMapper.gyslist1();//查询出全部的供应商
    	session.setAttribute("gyslist", gyslist);	
        return "chanpin/cpadd";
    }
    
    //添加产品
	public String cpAdd(cp cp){  	
		System.out.println("添加的产品信息："+cp);
		CpMapper.cpAdd(cp);	
		return "redirect:/cplist.do";
    }
	    
	    
	    
		
		
}

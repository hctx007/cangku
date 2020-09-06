package org.ck.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.ck.model.yg;
import org.ck.dao.YgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;


@Service ("YgService")	  
public class YgService implements YgServiceImpl {
		@Autowired
		private YgMapper YgMapper;

	    
	    //查询出全部的员工，进入管理员工页面
	    public String yglist(HttpSession session){
	    	List<yg> yglist=YgMapper.yglist();
			session.setAttribute("yglist", yglist);	
	    	return "/yuangong/yglist";
	    }
	    
	    //根据用户名、姓名模糊搜索员工	
	    public String ygSearch(String ygSearch,HttpSession session){
	    	System.out.println("员工搜索关键字："+ygSearch);
	    	List<yg> yglist=YgMapper.ygSearch(ygSearch);
	    	session.setAttribute("yglist", yglist);
	    	return "/yuangong/yglist";
	    }
	    
    	//根据id查询员工并转到员工编辑界面
	    public String toygEdit(Integer id,Model model) {
	    	if(YgMapper.toygEdit(id)!=null){
	    		yg yg1=YgMapper.toygEdit(id);
	    		System.out.println("要编辑的员工是："+yg1);
	    		model.addAttribute("yg", yg1);
	    		return "/yuangong/ygedit";}
	    	else{
	    		return "redirect:/yglist.do"; 
	    	}
	    }
	    
	    //修改员工信息
	    public String ygEdit(yg yg){
	    	System.out.println("编辑后的员工信息："+yg);
	    	YgMapper.ygEdit(yg);
	        return "redirect:/yglist.do"; 
	    }
	    
	    //删除指定id的员工
	    public String ygDel(Integer id){
	    	System.out.println("删除的员工id:"+id);
	    	YgMapper.ygDel(id);
	    	return "redirect:/yglist.do";
	    }
	    
	    //转到员工添加界面
	    public String toygAdd(){
	        return "yuangong/ygadd";
	    }
	    
	    //添加员工
	    public String ygAdd(yg yg){
			System.out.println("添加的员工信息："+yg);
			YgMapper.ygAdd(yg);	
			return "redirect:/yglist.do";
	    }
	    
	    
		
		
}

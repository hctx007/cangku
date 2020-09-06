package org.ck.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.ck.model.gys;
import org.ck.model.gys;
import org.ck.dao.GysMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;


@Service ("GysService")	  
public class GysService implements GysServiceImpl {
		
	@Autowired
	private GysMapper GysMapper;

    
    //查询出全部的供应商，进入管理供应商页面
    public String gyslist(HttpSession session){
    	List<gys> gyslist=GysMapper.gyslist();
		session.setAttribute("gyslist", gyslist);	
    	return "/gongyingshang/gyslist";
    }
    
    //根据供应商id模糊搜索供应商	
    public String gysSearch(String gysSearch,HttpSession session){
    	System.out.println("供应商搜索关键字："+gysSearch);
    	List<gys> gyslist=GysMapper.gysSearch(gysSearch);
    	session.setAttribute("gyslist", gyslist);
    	return "/gongyingshang/gyslist";
    }
    
	//根据id查询供应商并转到供应商编辑界面
    public String togysEdit(Integer id,Model model) {
    	if(GysMapper.togysEdit(id)!=null){
    		gys gys1=GysMapper.togysEdit(id);
    		System.out.println("要编辑的供应商是："+gys1);
    		model.addAttribute("gys", gys1);
    		return "/gongyingshang/gysedit";}
    	else{
    		return "redirect:/gyslist.do"; 
    	}
    }
    
    //修改供应商信息
    public String gysEdit(gys gys){
    	System.out.println("编辑后的供应商信息："+gys);
    	GysMapper.gysEdit(gys);
        return "redirect:/gyslist.do"; 
    }
    
    //删除指定id的供应商及相关产品和流水记录
    public String gysDel(Integer id){
    	System.out.println("删除的供应商id:"+id);
    	GysMapper.gysDel(id);
    	return "redirect:/gyslist.do";
    }
    
    //转到供应商添加界面
    public String togysAdd(){
        return "gongyingshang/gysadd";
    }
    
    //添加供应商
    public String gysAdd(gys gys){
		System.out.println("添加的供应商信息："+gys);
		GysMapper.gysAdd(gys);	
		return "redirect:/gyslist.do";
    }
	    
		
		
}

package org.ck.service;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ck.model.cgy;
import org.ck.model.cp;
import org.ck.model.gys;
import org.ck.model.xck;
import org.ck.dao.CgyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;


@Service ("CgyService")	  
public class CgyService implements CgyServiceImpl {
		@Autowired
		private CgyMapper CgyMapper;

	    //仓管员登录验证
	    @Override
		public String login(cgy cgy, Model model, HttpSession session) {
			if(CgyMapper.login(cgy) != null) {
				cgy cgy1=CgyMapper.login(cgy);
				session.setAttribute("cgy", cgy1);
				System.out.println(cgy1);
				model.addAttribute("msg", "");
				//查询出所有的供应商、产品、小仓库
				List<gys> gyslist=CgyMapper.gyslist();
				List<cp>  cplist =CgyMapper.cplist();
				List<xck> xcklist=CgyMapper.xcklist();
				session.setAttribute("gyslist", gyslist);
				session.setAttribute("cplist", cplist);
				session.setAttribute("xcklist", xcklist);
				return "back/main";
			}
			if(cgy.getPassword()==null)
				model.addAttribute("msg", "");
			else
			    model.addAttribute("msg", "用户名或密码错误！");
			return "/login";
		}
	    
	    
	    //仓管员退出处理
	    public String exit(HttpSession session,HttpServletRequest request){
	    	Enumeration em = request.getSession().getAttributeNames();  //得到session中所有的属性名
	    	while (em.hasMoreElements()) {
	            request.getSession().removeAttribute(em.nextElement().toString()); //遍历删除session中的值
	    	}
	    	return "/login"; 
	    }
	    
	    
	    
	    //查询出全部的仓管员，进入管理仓管员页面
	    public String cgylist(HttpSession session){
	    	List<cgy> cgylist=CgyMapper.cgylist();
			session.setAttribute("cgylist", cgylist);	
	    	return "/cangguanyuan/cgylist";
	    }
	    
	    //根据用户名、姓名模糊搜索仓管员	
	    public String cgySearch(String cgySearch,HttpSession session){
	    	System.out.println("仓管员搜索关键字："+cgySearch);
	    	List<cgy> cgylist=CgyMapper.cgySearch(cgySearch);
	    	session.setAttribute("cgylist", cgylist);
	    	return "/cangguanyuan/cgylist";
	    }
	    
    	//根据id查询仓管员并转到仓管员编辑界面
	    public String tocgyEdit(Integer id,Model model) {
	    	if(CgyMapper.tocgyEdit(id)!=null){
	    		cgy cgy1=CgyMapper.tocgyEdit(id);
	    		System.out.println("要编辑的仓管员是："+cgy1);
	    		model.addAttribute("cgy", cgy1);
	    		return "/cangguanyuan/cgyedit";}
	    	else{
	    		return "redirect:/cgylist.do"; 
	    	}
	    }
	    
	    //修改仓管员信息
	    public String cgyEdit(cgy cgy){
	    	System.out.println("编辑后的仓管员信息："+cgy);
	    	CgyMapper.cgyEdit(cgy);
	        return "redirect:/cgylist.do"; 
	    }
	    
	    //删除指定id的仓管员
	    public String cgyDel(Integer id){
	    	System.out.println("删除的仓管员id:"+id);
	    	CgyMapper.cgyDel(id);
	    	return "redirect:/cgylist.do";
	    }
	    
	    //转到仓管员添加界面
	    public String tocgyAdd(){
	        return "cangguanyuan/cgyadd";
	    }
	    
	    //添加仓管员
	    public String cgyAdd(cgy cgy){
			System.out.println("添加的仓管员信息："+cgy);
			CgyMapper.cgyAdd(cgy);	
			return "redirect:/cgylist.do";
	    }
	    
	    
	    
		
		
}

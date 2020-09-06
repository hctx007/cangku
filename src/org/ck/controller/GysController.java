package org.ck.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ck.model.gys;
import org.ck.service.GysService;

@Controller
public class GysController {
    @Autowired
    private GysService GysService;
   
  	
    //查询出全部的供应商，进入管理供应商页面
  	@RequestMapping("/gyslist")
	public String gyslist(HttpSession session) {
		return GysService.gyslist(session);
	}
  	
    //根据小仓库id模糊搜索供应商
  	@RequestMapping("/gysSearch")
	public String gysSearch(String gysSearch,HttpSession session) {
		return GysService.gysSearch(gysSearch,session);
	}
  	
    //根据id查询供应商并转到供应商编辑界面
    @RequestMapping("/togysEdit")
	public String togysEdit(Integer id,Model model) {
		return GysService.togysEdit(id,model);	
	}
  	
    //修改供应商信息
    @RequestMapping("/gysEdit")
	public String gysEdit(@ModelAttribute gys gys) {
		return GysService.gysEdit(gys);	
	}
    
    //删除指定id的供应商及相关产品和流水记录
  	@RequestMapping("/gysDel")
	public String gysDel(Integer id) {
		return GysService.gysDel(id);
	}
    
  	//转到供应商添加界面
    @RequestMapping("/togysAdd")
	public String togysAdd() {
		return GysService.togysAdd();	
	}
  	
    //添加供应商
  	@RequestMapping("/gysAdd")
	public String gysAdd(@ModelAttribute gys gys) {
		return GysService.gysAdd(gys);
	}
  		
}

package org.ck.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ck.model.inout;
import org.ck.service.RukuService;



@Controller
public class RukuController {
    @Autowired
    private RukuService RukuService;
   
  	
    //查询出全部的供应商、产品，进入入库申请页面
  	@RequestMapping("/rukuApply")
	public String rukuApply(HttpSession session) {
		return RukuService.rukuApply(session);
	}
  	
    //入库申请审核
  	@RequestMapping("/rukuApplyResult")
	public String rukuApplyResult(@ModelAttribute inout inout , HttpSession session) {
		return RukuService.rukuApplyResult(inout,session); 
	}
  	
  	//入库表单打印
  	@RequestMapping("/rukuApplyPrinting")
	public String rukuApplyPrinting() {
		return RukuService.rukuApplyPrinting(); 
	}
  	
   
}

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
import org.ck.service.ChukuService;



@Controller
public class ChukuController {
    @Autowired
    private ChukuService ChukuService;
   
  	
    //查询出全部的供应商、产品，进入入库申请页面
  	@RequestMapping("/chukuApply")
	public String chukuApply(HttpSession session) {
		return ChukuService.chukuApply(session);
	}
  	
    //出库申请审核
  	@RequestMapping("/chukuApplyResult")
	public String chukuApplyResult(@ModelAttribute inout inout , HttpSession session) {
		return ChukuService.chukuApplyResult(inout,session); 
	}
  	
  	//出库表单打印
  	@RequestMapping("/chukuApplyPrinting")
	public String chukuApplyPrinting() {
		return ChukuService.chukuApplyPrinting(); 
	}
  	
   
}

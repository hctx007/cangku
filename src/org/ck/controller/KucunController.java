package org.ck.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ck.model.yg;
import org.ck.service.KucunService;



@Controller
public class KucunController {
    @Autowired
    private KucunService KucunService;
   
    /**
     * 未入库模块
     * @param session
     * @return
     */
    
    //查询出所有的未入库流水账单
    @RequestMapping("/rukuNolist")
    public String rukuNolist(HttpSession session){
    	return KucunService.rukuNolist(session);
    }
  		
    //转到入库表单打印界面
    @RequestMapping("/torukuApplyPrinting")
	public String torukuApplyPrinting(String id,HttpSession session) {
		return KucunService.torukuApplyPrinting(id,session);	
	}
    
    //根据关键字模糊搜索相关未入库流水记录
    @RequestMapping("/rukuNoSearch")
	public String rukuNoSearch(String rukuNoSearch,HttpSession session) {
		return KucunService.rukuNoSearch(rukuNoSearch,session);	
	}
    
    //产品入库确认
    @RequestMapping("/rukuSuccess")
	public String rukuSuccess(String id,HttpSession session) {
		return KucunService.rukuSuccess(id,session);	
	}
    
    /**
     * 已入库模块
     * @param session
     * @return
     */
    //查询出所有的未入库流水账单
    @RequestMapping("/rukuYeslist")
    public String rukuYeslist(HttpSession session){
    	return KucunService.rukuYeslist(session);
    }
    
    //转到入库表单打印界面
    @RequestMapping("/tochukuApplyPrinting")
	public String tochukuApplyPrinting(String id,HttpSession session) {
		return KucunService.tochukuApplyPrinting(id,session);	
	}
    
    //根据关键字模糊搜索相关已入库流水记录
    @RequestMapping("/rukuYesSearch")
	public String rukuYesSearch(String rukuYesSearch,HttpSession session) {
		return KucunService.rukuYesSearch(rukuYesSearch,session);	
	}
    
    //产品出库确认
    @RequestMapping("/chukuSuccess")
	public String chukuSuccess(String id,HttpSession session) {
		return KucunService.chukuSuccess(id,session);	
	}    
    
    /**
     * 已出库模块
     * @param session
     * @return
     */
    //查询出所有的已出库流水账单
    @RequestMapping("/chukuYeslist")
    public String chukuYeslist(HttpSession session){
    	return KucunService.chukuYeslist(session);
    }

    //根据关键字模糊搜索相关已出库流水记录
    @RequestMapping("/chukuYesSearch")
	public String chukuYesSearch(String chukuYesSearch,HttpSession session) {
		return KucunService.chukuYesSearch(chukuYesSearch,session);	
	}
    
    
    
}

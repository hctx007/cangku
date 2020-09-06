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
import org.ck.service.TableService;



@Controller
public class TableController {
    @Autowired
    private TableService TableService;
   

    //进入库存报表界面
    @RequestMapping("/kucuntable")
    public String kucuntable(HttpSession session){
    	return TableService.kucuntable(session);
    }
  		
    //模糊搜索对应的流水记录
    @RequestMapping("/kucunSearch")
    public String kucunSearch(Integer state,String kucunSearch,HttpSession session){
    	return TableService.kucunSearch(state,kucunSearch,session);
    }
    
    //进入财务报表界面
    @RequestMapping("/moneytable")
    public String moneytable(HttpSession session){
    	return TableService.moneytable(session);
    }

    //模糊搜索对应的财务流水记录
    @RequestMapping("/moneySearch")
    public String moneySearch(Integer state,String moneySearch,HttpSession session){
    	return TableService.moneySearch(state,moneySearch,session);
    }
    
    
    
}

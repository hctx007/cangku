package org.ck.service;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.ck.model.cgy;
import org.ck.model.inout;
import org.ck.model.yg;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

public interface TableServiceImpl {
	
	public String kucuntable(HttpSession session);//进入库存报表界面
	public String kucunSearch(Integer state,String kucunSearch,HttpSession session);//模糊搜索对应的流水记录
	public String moneytable(HttpSession session);//进入财务报表界面
	public String moneySearch(Integer state,String moneySearch,HttpSession session);//模糊搜索对应的财务流水记录
	
}

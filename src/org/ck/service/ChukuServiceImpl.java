package org.ck.service;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.ck.model.cgy;
import org.ck.model.inout;
import org.ck.model.yg;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

public interface ChukuServiceImpl {
	
	public String chukuApply(HttpSession session);//查询出全部的供应商、产品，进入出库申请页面
	public String chukuApplyResult(inout inout , HttpSession session);//出库申请审核
	public String chukuApplyPrinting();//出库表单打印
}

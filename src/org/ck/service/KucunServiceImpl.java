package org.ck.service;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.ck.model.cgy;
import org.ck.model.inout;
import org.ck.model.yg;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

public interface KucunServiceImpl {
	
	/**
     * 未入库模块
     * @param session
     * @return
     */
	public String rukuNolist(HttpSession session);//查询出所有的未入库流水账单
	public String torukuApplyPrinting(String id,HttpSession session);//转到入库表单打印界面
	public String rukuNoSearch(String rukuNoSearch,HttpSession session);//根据关键字模糊搜索相关未入库流水记录
	public String rukuSuccess(String id,HttpSession session);//产品入库确认
	/**
     * 已入库模块
     * @param session
     * @return
     */
	public String rukuYeslist(HttpSession session);//查询出所有的已入库流水账单
	public String tochukuApplyPrinting(String id,HttpSession session);//转到入库表单打印界面
	public String rukuYesSearch(String rukuYesSearch,HttpSession session);//根据关键字模糊搜索相关已入库流水记录
	public String chukuSuccess(String id,HttpSession session);//产品出库确认
    
    /**
     * 已出库模块
     * @param session
     * @return
     */
	public String chukuYeslist(HttpSession session);//查询出所有的已出库流水账单
	public String chukuYesSearch(String chukuYesSearch,HttpSession session);//根据关键字模糊搜索相关已出库流水记录
}

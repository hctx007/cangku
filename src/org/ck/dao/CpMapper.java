package org.ck.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.ck.model.cgy;
import org.ck.model.cp;
import org.ck.model.gys;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;


    @Repository("CpMapper")
    @Mapper
    public interface CpMapper {
    	 
	     
	     public List<gys> gyslist1();//查询出全部的供应商
	     public List<cp> cplist();//查询出全部的产品，进入管理产品页面
	     public List<cp> cpSearch(String cpSearch);//模糊搜索产品	
	     public cp tocpEdit(Integer id);//根据id查询产品并转到产品编辑界面
	     public int cpEdit(cp cp);//修改产品信息
	     public int cpDel(Integer id);//删除指定id的产品
	     public int cpAdd(cp cp);//添加产品
	     
	     	
    }

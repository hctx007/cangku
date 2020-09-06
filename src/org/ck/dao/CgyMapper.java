package org.ck.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.ck.model.cgy;
import org.ck.model.cp;
import org.ck.model.gys;
import org.ck.model.xck;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;


    @Repository("CgyMapper")
    @Mapper
    public interface CgyMapper {
    	 
	     
	     public cgy login(cgy cgy);//仓管员登录	     
	     public List<cgy> cgylist();//查询出全部的仓管员，进入管理仓管员页面
	     public List<cgy> cgySearch(String cgySearch);//根据用户名、姓名模糊搜索仓管员	
	     public cgy tocgyEdit(Integer id);//根据id查询仓管员并转到仓管员编辑界面
	     public int cgyEdit(cgy cgy);//修改仓管员信息
	     public int cgyDel(Integer id);//删除指定id的仓管员
	     public int cgyAdd(cgy cgy);//添加仓管员
	     
	     public List<gys> gyslist();//查询出全部的供应商
	     public List<cp>  cplist();//查询出全部的产品
	     public List<xck> xcklist();//查询出全部的小仓库
	     
	     	
    }

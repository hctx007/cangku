package org.ck.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.ck.model.cp;
import org.ck.model.gys;
import org.ck.model.inout;
import org.ck.model.xck;
import org.ck.model.yg;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;


    @Repository("ChukukuMapper")
    @Mapper
    public interface ChukuMapper {
    	 
	     
	     public List<gys> gyslist();//查询出全部的供应商	 
	     public List<cp> cplist();//查询出全部的产品
         public inout selectInoutById(String id);//根据产品id查询产品记录
         public int updateInoutOutTime(inout inout);//记录出库时间
    }

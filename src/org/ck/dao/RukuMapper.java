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


    @Repository("RukuMapper")
    @Mapper
    public interface RukuMapper {
    	 
	     
	     public List<gys> gyslist();//查询出全部的供应商	 
	     public List<cp> cplist();//查询出全部的产品
         public cp selectCpById(Integer id);//根据产品id查询产品记录
         public List<xck> selectXckByArea(double Area);//根据所有产品的底面积查询有足够容量的小仓库记录
         public List<xck> selectXckBySize(double Size);//根据所有产品的总容量查询有足够容量的小仓库记录
         public int updateXckSize1(@Param("xckId")Integer xckId,@Param("size")double size);//小仓库的容量相应减少
         public int addInout(inout inout);//插入流水记录
    }

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


    @Repository("KucunMapper")
    @Mapper
    public interface KucunMapper {
    	/**
         * 未入库模块
         * @param session
         * @return
         */
	     public List<inout> rukuNolist();//查询出所有的未入库流水账单     
	     public List<inout> rukuNoSearch(String rukuNoSearch);//根据关键字模糊搜索相关未入库流水记录
	     public int rukuSuccess(String id);//产品入库确认
	     /**
	      * 已入库模块
	      * @param session
	      * @return
	      */
	     public List<inout> rukuYeslist();//查询出所有的已入库流水账单
	     public List<inout> rukuYesSearch(String rukuYesSearch);//根据关键字模糊搜索相关已入库流水记录
	     public int chukuSuccess(String id);//产品出库确认
	     public int chukuUpdateXckSize1(@Param("size")double size,@Param("id")Integer id);//产品出库，小仓库容量恢复
	     /**
	      * 已出库模块
	      * @param session
	      * @return
	      */
	     public List<inout> chukuYeslist();//查询出所有的已出库流水账单
	     public List<inout> chukuYesSearch(String chukuYesSearch);//根据关键字模糊搜索相关已出库流水记录
	     
	     /**
	      * 通用模块
	      * @param session
	      * @return
	      */
	     public inout selectInoutById(String id);//根据id查询流水记录
	     public List<gys> gyslist();//查询出全部的供应商
	     public List<cp>  cplist();//查询出全部的产品
	     public List<xck> xcklist();//查询出全部的小仓库
    }

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


    @Repository("TableMapper")
    @Mapper
    public interface TableMapper {

	     public List<inout> rukuNolist();//查询出所有的未入库流水账单     
	     public List<inout> kucunSearch(@Param("state")Integer state,@Param("kucunSearch")String kucunSearch);//模糊搜索对应的流水记录
	     public List<inout> moneySearch(@Param("state")Integer state,@Param("moneySearch")String moneySearch);//模糊搜索对应的财务流水记录
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

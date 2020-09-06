package org.ck.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.ck.model.xck;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;


    @Repository("XckMapper")
    @Mapper
    public interface XckMapper {
   
	     public List<xck> xcklist();//查询出全部的小仓库，进入管理小仓库页面
	     public List<xck> xckSearch(String xckSearch);//根据小仓库id模糊搜索小仓库	
	     public xck toxckEdit(Integer id);//根据id查询小仓库并转到小仓库编辑界面
	     public int xckEdit(xck xck);//修改小仓库信息
	     public int xckDel(Integer id);//删除指定id的小仓库及其流水记录
	     public int xckAdd(xck xck);//添加小仓库	     	
    }

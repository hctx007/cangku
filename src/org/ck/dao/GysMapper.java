package org.ck.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.ck.model.gys;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;


    @Repository("GckMapper")
    @Mapper
    public interface GysMapper {
   
	     public List<gys> gyslist();//查询出全部的供应商，进入管理供应商页面
	     public List<gys> gysSearch(String gysSearch);//根据供应商id模糊搜索供应商	
	     public gys togysEdit(Integer id);//根据id查询供应商并转到供应商编辑界面
	     public int gysEdit(gys gys);//修改供应商信息
	     public int gysDel(Integer id);//删除指定id的供应商及相关产品和流水记录
	     public int gysAdd(gys gys);//添加供应商	     	
    }

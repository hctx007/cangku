package org.ck.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.ck.model.yg;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;


    @Repository("YgMapper")
    @Mapper
    public interface YgMapper {
    	 
	     
	     public List<yg> yglist();//查询出全部的员工，进入管理员工页面
	     public List<yg> ygSearch(String ygSearch);//根据用户名、姓名模糊搜索员工	
	     public yg toygEdit(Integer id);//根据id查询员工并转到员工编辑界面
	     public int ygEdit(yg yg);//修改员工信息
	     public int ygDel(Integer id);//删除指定id的员工
	     public int ygAdd(yg yg);//添加员工
	     
	     	
    }

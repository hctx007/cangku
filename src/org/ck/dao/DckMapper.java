package org.ck.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.ck.model.dck;
import org.ck.model.xck;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;


    @Repository("DckMapper")
    @Mapper
    public interface DckMapper {
   
	     public dck dcksetup();//查询出大仓库的基本信息
	     public int dckAdd(dck dck);//添加大仓库的基本信息
	     public int dckEdit(dck dck);//修改大仓库的基本信息
   	
    }

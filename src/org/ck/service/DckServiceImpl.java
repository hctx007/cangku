package org.ck.service;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.ck.model.dck;
import org.ck.model.xck;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

public interface DckServiceImpl {
	
	public String dcksetup(HttpSession session);//查询出大仓库的基本信息
	public String dckEdit(dck dck);//设置大仓库的基本信息
}

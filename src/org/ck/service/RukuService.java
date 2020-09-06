package org.ck.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.ck.model.cp;
import org.ck.model.gys;
import org.ck.model.inout;
import org.ck.model.xck;
import org.ck.model.yg;
import org.ck.dao.RukuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.util.MyUtil;


@Service ("RukuService")	  
public class RukuService implements RukuServiceImpl {
		@Autowired
		private RukuMapper RukuMapper;

		//查询出全部的供应商、产品，进入入库申请页面
		public String rukuApply(HttpSession session){
			List<gys> gyslist=RukuMapper.gyslist();
			List<cp> cplist=RukuMapper.cplist();
			session.setAttribute("gyslist", gyslist);
			session.setAttribute("cplist", cplist);
			session.setAttribute("msg", "");	
			return "/ruku/rukuApply";
		}
	    
		//入库申请审核
		public String rukuApplyResult(inout inout , HttpSession session){
			MyUtil myUtil=new MyUtil();
			inout.setId(myUtil.getStringID());//通过随机函数得到产品流水id
			System.out.println(inout);
			cp cp=RukuMapper.selectCpById(inout.getCpId());//通过产品id查询产品记录
			System.out.println(cp);
			//设置inout里的总存储价格
			inout.setPrice(cp.getPrice()*inout.getStorageTime()*inout.getCpNumber());
			System.out.println("总存储价格："+cp.getPrice()*inout.getStorageTime()*inout.getCpNumber());
			if(cp.getStackable()==0)//产品不可堆叠，参数为产品底面积
			{
				//根据所有产品的底面积查询有足够容量的小仓库记录
				//System.out.println("总产品底面积"+cp.getSize()/cp.getCpHeight()*inout.getCpNumber());
			    List<xck> xcklist=RukuMapper.selectXckByArea(cp.getSize()/cp.getCpHeight()*inout.getCpNumber()); 
			    if(xcklist.isEmpty()){
			    	System.out.println("库存空间不足");
			    	session.setAttribute("msg", "库存空间不足");
			    	return "/ruku/rukuApply";
			    }
			    //System.out.println("一个合格的小仓库"+xcklist.get(0));
			    session.setAttribute("msg", "审核通过");	
			    //设置inout里的小仓库id
			    inout.setXckId(xcklist.get(0).getXckId());
			    //设置inout里的产品所占小仓库的空间
			    inout.setSize(cp.getSize()/cp.getCpHeight()*inout.getCpNumber()*xcklist.get(0).getXckHeight());
			    //System.out.println("总产品容量"+cp.getSize()/cp.getCpHeight()*inout.getCpNumber()*xcklist.get(0).getXckHeight());
			    //System.out.println(inout);
			    //小仓库的容量相应减少
			    RukuMapper.updateXckSize1(xcklist.get(0).getXckId(),cp.getSize()/cp.getCpHeight()*inout.getCpNumber()*xcklist.get(0).getXckHeight());
			    //插入流水记录
			    RukuMapper.addInout(inout);
			}
			else{//产品可堆叠，参数为产品总容量
				//根据所有产品的总容量查询有足够容量的小仓库记录
				//System.out.println("总产品容量"+cp.getSize()*inout.getCpNumber());
				List<xck> xcklist=RukuMapper.selectXckBySize(cp.getSize()*inout.getCpNumber()); 
				if(xcklist.isEmpty()){
			    	System.out.println("库存空间不足");
			    	session.setAttribute("msg", "库存空间不足");
			    	return "/ruku/rukuApply";
			    }
				//System.out.println("一个合格的小仓库"+xcklist.get(0));
				session.setAttribute("msg", "审核通过");	
				//设置inout里的小仓库id
			    inout.setXckId(xcklist.get(0).getXckId());
			    //设置inout里的产品所占小仓库的空间
			    inout.setSize(cp.getSize()*inout.getCpNumber());
			    //小仓库的容量相应减少
			    RukuMapper.updateXckSize1(xcklist.get(0).getXckId(),cp.getSize()*inout.getCpNumber());
			    //插入流水记录
			    RukuMapper.addInout(inout);
			}	
			session.setAttribute("inout", inout);//保存流水账单到session，方便打印入库表单
			return "/ruku/rukuApply";
		}
		
		//入库表单打印
		public String rukuApplyPrinting(){
			return "/ruku/rukuApplyPrinting";
		}
	    
		
		
}

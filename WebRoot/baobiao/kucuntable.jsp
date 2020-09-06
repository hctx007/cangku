<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">  
    <title>新闻管理界面</title>  
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
    <script language="JavaScript" src="${ pageContext.request.contextPath}/layui/layui.all.js" charset="utf-8"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
  </head>
    

  <body  >
  
  <div style="" align='center'>
    <button class="layui-btn" onclick="doPrint()">打印当前报表</button>
    
	<select name="state" id="state" style="height:25px;;margin-top:20px;">
		  <option value="0" <c:if test="${inoutlist.get(0).getState() eq 0 }">selected</c:if> >未入库</option>
		  <option value="1" <c:if test="${inoutlist.get(0).getState() eq 1 }">selected</c:if> >已入库</option>
	      <option value="2" <c:if test="${inoutlist.get(0).getState() eq 2 }">selected</c:if> >已出库</option>
	<select>					
    <input id="kucunSearch" type="text"  value="请输入查询内容" onclick="JavaScript:this.value=''" style="height:25px;;margin-top:20px;"/>
	
    <input id="submit" type="button" onclick="search()"  value="开始查询" style="background: #317ef3;border: 2px solid #317ef3;margin-top:20px;">
  </div>
      <!--startprint-->
  <table class="layui-table" id="demo" lay-filter="test">
    <thead>
    <tr> 
	    <th lay-data="{field:'id',width:200}">流水编号</th>
        <th lay-data="{field:'gys'}">供应商</th>
		<th lay-data="{field:'cp'}">产品</th>
		<th lay-data="{field:'xckId'}">仓库编号</th>
		<th lay-data="{field:'cpNumber'}">数量</th>
		<th lay-data="{field:'price'}">价格</th>
		<th lay-data="{field:'inTime'}">入库时间</th>
		<th lay-data="{field:'outTime'}">出库时间</th>
		<th lay-data="{field:'storageTime'}">存储时间</th>
    </tr>
	</thead>
	<tbody>
         <c:forEach items="${inoutlist}" var="inout">
				<tr>				  
					<td>${inout.getId() }</td>
					<td>
					    <c:forEach items="${gyslist}" var="gys">
		                  <c:if test="${inout.getGysId() eq gys.getGysId()}">
						   ${gys.getGysName() }
		                  </c:if>
		                </c:forEach>
					</td>
					<td>
					<c:forEach items="${cplist}" var="cp">
		                  <c:if test="${inout.getCpId() eq cp.getCpId()}">
						   ${cp.getCpName() }
		                  </c:if>
		                </c:forEach>				
					</td>
					<td>${inout.getXckId() }</td>	
					<td>${inout.getCpNumber() }</td>	
					<td>${inout.getPrice() }</td>	
					<td><fmt:formatDate  value="${inout.getInTime() }"  pattern="yyyy-MM-dd"/></td>	
					<td><fmt:formatDate  value="${inout.getOutTime() }"  pattern="yyyy-MM-dd"/></td>	
					<td>${inout.getStorageTime() }</td>	
				</tr>
		 </c:forEach>      
	</tbody>
  </table>
   <!--endprint-->
  <script>
  layui.use('table', function(){
	  var table = layui.table;
	  table.init('test',{
	    page:true
	  });
	});   

  function search(){
		var kucunSearch=document.getElementById("kucunSearch").value;	
		var state=document.getElementById("state").value;	
		if(kucunSearch=="请输入查询内容")
			kucunSearch="";
	    window.location.href = "kucunSearch.do?kucunSearch="+kucunSearch+"&state="+state;		  	
   }
  
  function doPrint() {
      bdhtml=window.document.body.innerHTML;
      sprnstr="<!--startprint-->"; //开始打印标识字符串有17个字符
      eprnstr="<!--endprint-->"; //结束打印标识字符串
      prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17); //从开始打印标识之后的内容
      prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr)); //截取开始标识和结束标识之间的内容
      window.document.body.innerHTML=prnhtml; //把需要打印的指定内容赋给body.innerHTML
      window.print(); //调用浏览器的打印功能打印指定区域
      location = location; // 最后还原页面
  }
  </script>
  </body>
  

</html>

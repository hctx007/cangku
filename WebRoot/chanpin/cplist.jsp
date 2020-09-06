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
    <input id="cpSearch" type="text"  value="请输入查询内容" onclick="JavaScript:this.value=''" style="height:25px;;margin-top:20px;"/>
    <input id="submit" type="button" onclick="search()"  value="开始查询" style="background: #317ef3;border: 2px solid #317ef3;margin-top:20px;">
  </div>
  <table class="layui-table" id="demo" lay-filter="test">
    <thead>
    <tr> 
        <th lay-data="{field:'ID'}">产品编号</th>
        <th lay-data="{field:'cpName'}">产品名称</th>
        <th lay-data="{field:'gysName'}">供应商名称</th>
        <th lay-data="{field:'price'}">存储价格</th>
		<th lay-data="{field:'caozuo'}">操作</th>
    </tr>
	</thead>
	<tbody>
         <c:forEach items="${cplist}" var="cp">
				<tr>				  
					<td>${cp.getCpId() }</td>
					<td>${cp.getCpName() }</td>
					<td>
					     <c:forEach items="${gyslist}" var="gys" >
					            <c:if test="${gys.getGysId() eq cp.getGysId()}">
					                ${gys.getGysName()}
					            </c:if>
					     </c:forEach>	
					</td>
					<td>${cp.getPrice() }元/天/个</td>	
					<td >
					     <a href="tocpEdit.do?id=${cp.getCpId() }">编辑</a>
					     <a href="javascript:checkDel(${cp.getCpId() })">删除</a>
					</td>
				</tr>
		 </c:forEach>      
	</tbody>
  </table>
  <script>
  layui.use('table', function(){
	  var table = layui.table;
	  table.init('test',{
	    page:true
	  });
	});   
  function checkDel(id){
		if(window.confirm("谨慎操作！ 是否删除该产品及其相关流水记录？")){
			window.location.href = "cpDel.do?id="+id;
		}
	}
  function search(){
		var cpSearch=document.getElementById("cpSearch").value;	
		if(cpSearch=="请输入查询内容" || cpSearch=="")
			window.alert("请输入查询内容");
		else	
	        window.location.href = "cpSearch.do?cpSearch="+cpSearch;		  	
   }
  </script>
  </body>
  

</html>

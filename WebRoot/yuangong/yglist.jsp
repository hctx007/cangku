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
    <input id="ygSearch" type="text"  value="请输入查询内容" onclick="JavaScript:this.value=''" style="height:25px;;margin-top:20px;"/>
    <input id="submit" type="button" onclick="search()"  value="开始查询" style="background: #317ef3;border: 2px solid #317ef3;margin-top:20px;">
  </div>
  <table class="layui-table" id="demo" lay-filter="test">
    <thead>
    <tr> 
        <th lay-data="{field:'ID'}">员工编号</th>
        <th lay-data="{field:'ygName'}">员工姓名</th>
        <th lay-data="{field:'ygSex'}">员工性别</th>
       <th lay-data="{field:'ygAge'}">员工年龄</th>     
		<th lay-data="{field:'caozuo'}">操作</th>
    </tr>
	</thead>
	<tbody>
         <c:forEach items="${yglist}" var="yg">
				<tr>				  
					<td>${yg.getYgId() }</td>
					<td>${yg.getYgName() }</td>
					<td>${yg.getYgSex() }</td>
					<td>${yg.getYgAge() }</td>	
					<td >
					     <a href="toygEdit.do?id=${yg.getYgId() }">编辑</a>
					     <a href="javascript:checkDel(${yg.getYgId() })">删除</a>
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
		if(window.confirm("是否删除该员工？")){
			window.location.href = "ygDel.do?id="+id;
		}
	}
  function search(){
		var ygSearch=document.getElementById("ygSearch").value;	
		if(ygSearch=="请输入查询内容" || ygSearch=="")
			window.alert("请输入查询内容");
		else	
	        window.location.href = "ygSearch.do?ygSearch="+ygSearch;		  	
   }
  </script>
  </body>
  

</html>

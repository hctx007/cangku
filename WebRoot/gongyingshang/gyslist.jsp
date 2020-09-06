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
    <input id="gysSearch" type="text"  value="请输入查询内容" onclick="JavaScript:this.value=''" style="height:25px;;margin-top:20px;"/>
    <input id="submit" type="button" onclick="search()"  value="开始查询" style="background: #317ef3;border: 2px solid #317ef3;margin-top:20px;">
  </div>
  <table class="layui-table" id="demo" lay-filter="test">
    <thead>
    <tr> 
        <th lay-data="{field:'ID'}">供应商编号</th>
        <th lay-data="{field:'gysName'}">供应商名称</th>
        <th lay-data="{field:'Phone'}">供应商电话</th>
		<th lay-data="{field:'caozuo'}">操作</th>
    </tr>
	</thead>
	<tbody>
         <c:forEach items="${gyslist}" var="gys">
				<tr>				  
					<td>${gys.getGysId() }</td>
					<td>${gys.getGysName() }</td>
					<td>${gys.getPhone() }</td>
					<td >
					     <a href="togysEdit.do?id=${gys.getGysId() }">编辑</a>
					     <a href="javascript:checkDel(${gys.getGysId() })">删除</a>
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
		if(window.confirm("是否删除该供应商及其相关产品和流水记录？")){
			window.location.href = "gysDel.do?id="+id;
		}
	}
  function search(){
		var gysSearch=document.getElementById("gysSearch").value;	
		if(gysSearch=="请输入查询内容" || gysSearch=="")
			window.alert("请输入查询内容");
		else	
	        window.location.href = "gysSearch.do?gysSearch="+gysSearch;		  	
   }
  </script>
  </body>
  

</html>

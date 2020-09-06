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
    <input id="chukuYesSearch" type="text"  value="请输入查询内容" onclick="JavaScript:this.value=''" style="height:25px;;margin-top:20px;"/>
    <input id="submit" type="button" onclick="search()"  value="开始查询" style="background: #317ef3;border: 2px solid #317ef3;margin-top:20px;">
  </div>
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
		<th lay-data="{field:'caozuo'}">操作</th>
    </tr>
	</thead>
	<tbody>
         <c:forEach items="${chukuYeslist}" var="inout">
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
					<td >					     
					     
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
		if(window.confirm("是否删除该新闻？")){
			window.location.href = "newsDel.do?id="+id;
		}
	}
  function search(){
		var chukuYesSearch=document.getElementById("chukuYesSearch").value;	
		if(chukuYesSearch=="请输入查询内容" || chukuYesSearch=="")
			window.alert("请输入查询内容");
		else	
	        window.location.href = "chukuYesSearch.do?chukuYesSearch="+chukuYesSearch;		  	
   }
  </script>
  </body>
  

</html>

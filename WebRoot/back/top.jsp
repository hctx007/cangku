<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">  
    <title>家电城仓库管理后台</title>   
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
    <script language="JavaScript" src="${ pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
    <script language="JavaScript" src="${ pageContext.request.contextPath}/layui/layui.all.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
   
  </head>
  
  <body style="width: 100%;height: 60px;background-color: #00bfff;" >
<%--      <div >
        <h1 style="float:left;margin-top:10px;margin-left:20px;">电器城仓库管理后台</h1>        
        <a href="javascript:exit()"  style="float:right;margin-top:25px;margin-right:15px;text-decoration:none;">退出</a>
        <span style="float:right;margin-top:25px;margin-right:45px;">欢迎您，${cgy.getCgyName()}</span>   
    </div> --%>
  <div class="layui-layout layui-layout-admin">
	  <div class="layui-header">
	    <div class="layui-logo"><h3>电器城仓库管理系统</h3></div>

	    <ul class="layui-nav layui-layout-right">
	      <li class="layui-nav-item">
	        
	          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
	          ${cgy.getCgyName()}
	        
<!-- 	        <dl class="layui-nav-child">
	          <dd><a href="">基本资料</a></dd>
	          <dd><a href="">安全设置</a></dd>
	        </dl> -->
	      </li>
	      <li class="layui-nav-item"><a href="javascript:exit()">安全退出</a></li>
	    </ul>
	   </div>
  </div>
  </body>
  <script type="text/javascript">
  function exit(){
		if(window.confirm("是否退出？")){
			window.location.href = "exit.do";
		}
	}
  layui.use('element', function(){
	  var element = layui.element;
	  element.init();
	});
  </script>

</html>

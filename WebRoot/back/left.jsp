<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>无标题文档</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="JavaScript" src="${ pageContext.request.contextPath}/js/jquery.js"></script>
<script language="JavaScript" src="${ pageContext.request.contextPath}/layui/layui.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
</head>

<body >
	<ul class="layui-nav layui-nav-tree layui-nav-side lay-unselect" lay-shrink="all" lay-filter="test">
	<li class="layui-nav-item"><a href="right.jsp" target="rightFrame">首页</a></li>
    <li class="layui-nav-item ">
    <a >入库管理</a>
    <dl class="layui-nav-child">
      <dd><a href="${ pageContext.request.contextPath}/rukuApply.do"  target="rightFrame">入库申请</a></dd>
      <dd><a href="${ pageContext.request.contextPath}/rukuApplyPrinting.do"  target="rightFrame">入库表单打印</a></dd>
    </dl>
    </li>
    <li class="layui-nav-item ">
    <a >出库管理</a>
    <dl class="layui-nav-child">
      <dd><a href="${ pageContext.request.contextPath}/chukuApply.do"  target="rightFrame">出库申请</a></dd>
      <dd><a href="${ pageContext.request.contextPath}/chukuApplyPrinting.do"  target="rightFrame">出库表单打印</a></dd>
    </dl>
    </li>   
    <li class="layui-nav-item ">
    <a >库存管理</a>
    <dl class="layui-nav-child">
      <dd><a href="${ pageContext.request.contextPath}/rukuNolist.do"  target="rightFrame">未入库</a></dd>
      <dd><a href="${ pageContext.request.contextPath}/rukuYeslist.do"  target="rightFrame">已入库</a></dd>
      <dd><a href="${ pageContext.request.contextPath}/chukuYeslist.do"  target="rightFrame">已出库</a></dd>
    </dl>
    </li>   
    <li class="layui-nav-item ">
    <a >供应商管理</a>
    <dl class="layui-nav-child">
      <dd><a href="${ pageContext.request.contextPath}/gyslist.do"  target="rightFrame">管理供应商</a></dd>
      <dd><a href="${ pageContext.request.contextPath}/togysAdd.do"  target="rightFrame">添加供应商</a></dd>
    </dl>
    </li>   
    <li class="layui-nav-item ">
    <a >产品管理</a>
    <dl class="layui-nav-child">
      <dd><a href="${ pageContext.request.contextPath}/cplist.do"  target="rightFrame">管理产品</a></dd>
      <dd><a href="${ pageContext.request.contextPath}/tocpAdd.do"  target="rightFrame">添加产品</a></dd>
    </dl>
    </li>  
    <li class="layui-nav-item ">
    <a >员工管理</a>
    <dl class="layui-nav-child">
      <dd><a href="${ pageContext.request.contextPath}/yglist.do"  target="rightFrame">管理员工</a></dd>
      <dd><a href="${ pageContext.request.contextPath}/toygAdd.do"  target="rightFrame">添加员工</a></dd>
    </dl>
    </li>   
    <li class="layui-nav-item ">
    <a >仓管员管理</a>
    <dl class="layui-nav-child">
      <dd><a href="${ pageContext.request.contextPath}/cgylist.do"  target="rightFrame">管理仓管员</a></dd>
      <dd><a href="${ pageContext.request.contextPath}/tocgyAdd.do"  target="rightFrame">添加仓管员</a></dd>
    </dl>
    </li>   
    <li class="layui-nav-item ">
    <a >报表管理</a>
    <dl class="layui-nav-child">
      <dd><a href="${ pageContext.request.contextPath}/kucuntable.do"  target="rightFrame">库存报表</a></dd>
      <dd><a href="${ pageContext.request.contextPath}/moneytable.do"  target="rightFrame">财务报表</a></dd>
    </dl>
    </li>  
    <li class="layui-nav-item ">
    <a >小仓库管理</a>
    <dl class="layui-nav-child">
      <dd><a href="${ pageContext.request.contextPath}/xcklist.do"  target="rightFrame">管理小仓库</a></dd>
      <dd><a href="${ pageContext.request.contextPath}/toxckAdd.do"  target="rightFrame">添加小仓库</a></dd>
    </dl>
    </li>
    <li class="layui-nav-item ">
    <a >基本设置</a>
    <dl class="layui-nav-child">
      <dd><a href="${ pageContext.request.contextPath}/dcksetup.do"  target="rightFrame">基本设置</a></dd>
    </dl>
    </li>  
    </ul>
</body>

<script>
layui.use('element', function(){
var element = layui.element;
  
});
</script>
</html>

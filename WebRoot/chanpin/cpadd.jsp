<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<script language="JavaScript"
	src="${ pageContext.request.contextPath}/layui/layui.all.js"
	charset="utf-8"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/layui/css/layui.css"
	media="all">
<script type="text/javascript"
	src="${ pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>

<style>
.layui-form-item .layui-input-inline {
	width: 300px;
}
</style>
<body>


    <div style="margin-top:20px;margin-left:10px;">
		 <span><h2>添加产品</h2></span>
    </div>
    
    <div  style="width: 100%; position: relative; left:25%;margin-top:30px;">
	<form:form  method="post" action="cpAdd.do" class="layui-form" style="white-space:nowrap;">
		<div>
			
			<div style="margin-top:20px;">
			
			   <div class="layui-form-item">
					<label class="layui-form-label"><h3>供应商名称</h3></label>
					<div class="layui-input-inline">
					   <select name="gysId" >
					       <c:forEach items="${gyslist}" var="gys" >
					            <option value="${gys.getGysId()}" >${gys.getGysName()}</option>
					       </c:forEach>					
				       <select>	
					</div>
					<div class="layui-form-mid layui-word-aux"></div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label"><h3>产品名称</h3></label>
					<div class="layui-input-inline">
						<input name="cpName"  class="layui-input" maxlength="15" required="required"/>
					</div>
					<div class="layui-form-mid layui-word-aux"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>产品价格</h3></label>
					<div class="layui-input-inline">
						<input name="price"  class="layui-input" maxlength="15" required="required"/>
					</div>
					<div class="layui-form-mid layui-word-aux"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>产品大小</h3></label>
					<div class="layui-input-inline">
						<input name="size"  class="layui-input" maxlength="15" required="required"/>
					</div>
					<div class="layui-form-mid layui-word-aux"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>产品高度</h3></label>
					<div class="layui-input-inline">
						<input name="cpHeight"  class="layui-input" maxlength="15" required="required"/>
					</div>
					<div class="layui-form-mid layui-word-aux"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>是否可堆叠</h3></label>
					<div class="layui-input-inline">
						<select name="cpId" >
						   <option value="0" >不可堆叠</option>
						   <option value="1" >可堆叠</option>
						<select>					
					</div>
				</div>

				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="formDemo">确认添加</button>
					</div>
				</div>
				
			</div>
		</div>
	</form:form>
	</div>

	<script>
		layui.use('form', function() {
			var form = layui.form;
			form.render();
		});
	</script>
</body>
</html>

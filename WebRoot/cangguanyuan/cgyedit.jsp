<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
			<span><h2>修改仓管员基本信息</h2></span>
	</div>
	
	<div  style="width: 100%; position: relative; left:25%;margin-top:30px;">
	<form:form modelAttribute="cgy" method="post" action="cgyEdit.do" class="layui-form" style="white-space:nowrap;">
		<div>
			
			<div style="margin-top:20px;">

				<div class="layui-form-item">
					<label class="layui-form-label"><h3>仓管员编号</h3></label>
					<div class="layui-input-inline">
						<form:input path="cgyId" class="layui-input" maxlength="12" readonly="true" />
					</div>
					<div class="layui-form-mid layui-word-aux">不可编辑</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>姓名</h3></label>
					<div class="layui-input-inline">
						<form:input path="cgyName" class="layui-input" required="required"/>
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>性别</h3></label>
					<div class="layui-input-inline">
						<form:select path="cgySex" >
						   <option value="男" >男</option>
						   <option value="女" >女</option>
						</form:select>					
					</div>
				</div>
				
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>年龄</h3></label>
					<div class="layui-input-inline">
						<form:input path="cgyAge" class="layui-input" required="required"/>
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>密码</h3></label>
					<div class="layui-input-inline">
						<form:input path="password" class="layui-input" maxlength="12" required="required"/>
					</div>
					<div class="layui-form-mid layui-word-aux">密码不能超过12个字符</div>
				</div>

				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="formDemo">确认修改</button>
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

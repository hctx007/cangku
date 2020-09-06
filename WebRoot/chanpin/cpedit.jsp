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
	<form:form modelAttribute="cp" method="post" action="cpEdit.do" class="layui-form" style="white-space:nowrap;">
		<div>
			
			<div style="margin-top:20px;">

				<div class="layui-form-item">
					<label class="layui-form-label"><h3>产品编号</h3></label>
					<div class="layui-input-inline">
						<form:input path="cpId" class="layui-input" maxlength="12" readonly="true" />
					</div>
					<div class="layui-form-mid layui-word-aux">不可编辑</div>
				</div>
				
				
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>产品供应商</h3></label>
					<div class="layui-input-inline">
						<form:select path="gysId" >
						   <c:forEach items="${gyslist}" var="gys" >
					            <c:choose>
                                   <c:when test="${gys.getGysId() eq cp.getGysId()}">
                              			 <option value="${gys.getGysId()}" selected='selected'>${gys.getGysName()}</option>                          
                                   </c:when>
                                   <c:otherwise>
                                         <option value="${gys.getGysId()}" >${gys.getGysName()}</option>
                                   </c:otherwise>
                                </c:choose>
					       </c:forEach>							   
						</form:select>					
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>产品名称</h3></label>
					<div class="layui-input-inline">
						<form:input path="cpName" class="layui-input" required="required"/>
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>价格</h3></label>
					<div class="layui-input-inline">
						<form:input path="price" class="layui-input" required="required"/>
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>大小</h3></label>
					<div class="layui-input-inline">
						<form:input path="size" class="layui-input" maxlength="12" required="required"/>
					</div>
					<div class="layui-form-mid layui-word-aux"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>高度</h3></label>
					<div class="layui-input-inline">
						<form:input path="cpHeight" class="layui-input" maxlength="12" required="required"/>
					</div>
					<div class="layui-form-mid layui-word-aux"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>是否可堆叠</h3></label>
					<div class="layui-input-inline">
						<form:select path="stackable" >
						   <option value="0" ${cp.getStackable()==0?"selected='selected'":""}>不可堆叠</option>
						   <option value="1" ${cp.getStackable()==1?"selected='selected'":""}>可堆叠</option>
						</form:select>					
					</div>
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

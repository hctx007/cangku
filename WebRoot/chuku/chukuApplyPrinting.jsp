<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
		 <span><h2>出库表单打印</h2></span>
	</div>
	
    <!--startprint-->
    <div  style="width: 100%; position: relative; left:25%;margin-top:30px;">
	<form:form  method="post" action="" class="layui-form" style="white-space:nowrap;">
		<div >	
			<div style="margin-top:20px;">

				<div class="layui-form-item">
					<label class="layui-form-label"><h3>流水编号</h3></label>
					<div class="layui-input-inline">
						<input name="id"  class="layui-input" maxlength="15" required="required" readonly="true" value="<c:if test="${not empty inout.getOutTime() }">${inout.getId() }</c:if>"/>
					</div>
					<div class="layui-form-mid layui-word-aux"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>供应商</h3></label>
					<div class="layui-input-inline">
					    <c:forEach items="${gyslist}" var="gys">
		                  <c:if test="${inout.getGysId() eq gys.getGysId()}">
						     <input name="gysName"   class="layui-input" maxlength="15" required="required" readonly="true" value="<c:if test="${not empty inout.getOutTime() }">${gys.getGysName() }</c:if>"/>
		                  </c:if>
		                </c:forEach>
		                  <c:if test="${empty inout.getGysId()}">
						     <input name="gysName"   class="layui-input" maxlength="15" required="required" readonly="true" value="<c:if test="${not empty inout.getOutTime() }">${gys.getGysName() }</c:if>"/>
		                  </c:if>
					</div>
					<div class="layui-form-mid layui-word-aux"></div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label"><h3>产品</h3></label>
					<div class="layui-input-inline">
					    <c:forEach items="${cplist}" var="cp">
		                  <c:if test="${inout.getCpId() eq cp.getCpId()}">
						     <input name="cpName"   class="layui-input" maxlength="15" required="required" readonly="true" value="<c:if test="${not empty inout.getOutTime() }">${cp.getCpName() }</c:if>"/>
		                  </c:if>
		                </c:forEach>
		                  <c:if test="${empty inout.getCpId()}">
						     <input name="cpName"   class="layui-input" maxlength="15" required="required" readonly="true" value="<c:if test="${not empty inout.getOutTime() }">${cp.getCpName() }</c:if>"/>
		                  </c:if>
					</div>
					<div class="layui-form-mid layui-word-aux"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>仓库编号</h3></label>
					<div class="layui-input-inline">
						<input name="xckId"  class="layui-input" maxlength="15" required="required" readonly="true" value="<c:if test="${not empty inout.getOutTime() }">${inout.getXckId() }</c:if>"/>
					</div>
					<div class="layui-form-mid layui-word-aux"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>数量</h3></label>
					<div class="layui-input-inline">
						<input name="cpNumber"  class="layui-input" maxlength="15" required="required" readonly="true" value="<c:if test="${not empty inout.getOutTime() }">${inout.getCpNumber() }</c:if>"/>
					</div>
					<div class="layui-form-mid layui-word-aux"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>存储价格</h3></label>
					<div class="layui-input-inline">
						<input name="price"  class="layui-input" maxlength="15" required="required" readonly="true" value="<c:if test="${not empty inout.getOutTime() }">${inout.getPrice() }</c:if>"/>
					</div>
					<div class="layui-form-mid layui-word-aux"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>入库时间</h3></label>
					<div class="layui-input-inline">
						<input name="inTime"  class="layui-input" maxlength="15" required="required" readonly="true" value="<c:if test="${not empty inout.getOutTime() }"><fmt:formatDate  value="${inout.getInTime() }"  pattern="yyyy-MM-dd"/></c:if>"/>
					</div>
					<div class="layui-form-mid layui-word-aux"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>出库时间</h3></label>
					<div class="layui-input-inline">
						<input name="outTime"  class="layui-input" maxlength="15" required="required" readonly="true" value="<c:if test="${not empty inout.getOutTime() }"><fmt:formatDate  value="${inout.getOutTime() }"  pattern="yyyy-MM-dd"/></c:if>"/>
					</div>
					<div class="layui-form-mid layui-word-aux"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>存储时间</h3></label>
					<div class="layui-input-inline">
						<input name="storageTime"  class="layui-input" maxlength="15" required="required" readonly="true" value="<c:if test="${not empty inout.getOutTime() }">${inout.getStorageTime() }</c:if>"/>
					</div>
					<div class="layui-form-mid layui-word-aux"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>是否付款签字:</h3></label>
					<label class="layui-form-label" style="margin-left:100px;"><h3>是否入库签字:</h3></label>
				</div>
                <!--endprint-->
				
				<div class="layui-form-item">
					<div class="layui-input-block" style="margin-left:13%;">
						<button class="layui-btn" onclick="doPrint()">打印出库申请通过单</button>
					</div>
				</div>
				
			</div>
		</div>
	</form:form>
	</div>

	<script>
		layui.use('form', function() {
			var $ = layui.$
			,form = layui.form;
			
			/* <c:forEach items="${gyslist}" var="gys">
		     <c:if test="${inout.getGysId() eq gys.getGysId()}">
		         $("#gysName").val("${gys.getGysName() }");
		     </c:if>
		    </c:forEach> */
		    
		    /* <c:forEach items="${cplist}" var="cp">
		     <c:if test="${inout.getCpId() eq cp.getCpId()}">
		         $("#cpName").val("${cp.getCpName() }");
		     </c:if>
		    </c:forEach> */
			
			form.render();
		});
		
		function doPrint() {
	        bdhtml=window.document.body.innerHTML;
	        sprnstr="<!--startprint-->"; //开始打印标识字符串有17个字符
	        eprnstr="<!--endprint-->"; //结束打印标识字符串
	        prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17); //从开始打印标识之后的内容
	        prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr)); //截取开始标识和结束标识之间的内容
	        window.document.body.innerHTML=prnhtml; //把需要打印的指定内容赋给body.innerHTML
	        window.print(); //调用浏览器的打印功能打印指定区域
	        window.document.body.innerHTML=bdhtml; // 最后还原页面
	    }
	</script>
</body>
</html>

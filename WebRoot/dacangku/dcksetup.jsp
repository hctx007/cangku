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
		<span><h2>大仓库设置</h2></span>
	</div>
	<div  style="width: 100%; position: relative; left:25%;margin-top:30px;">
	<form:form  method="post" action="dckEdit.do" class="layui-form" style="white-space:nowrap;">
		<div >
			<div style="margin-top:20px;">
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>大仓库id</h3></label>
					<c:if test="${dck.getDckId()!=null}">
					<div class="layui-input-inline"> 
						<input name="dckId"  class="layui-input" maxlength="15" required="required" value="${dck.getDckId()}"  readonly="true"/> 
					</div>	
					<div class="layui-form-mid layui-word-aux">不可编辑</div>
					</c:if>
					<c:if test="${dck.getDckId()==null}">
					<div class="layui-input-inline"> 
						<input name="dckId"  class="layui-input" maxlength="15" required="required" value="${dck.getDckId()}"  /> 
					</div>	
					</c:if>
					
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>大仓库名称</h3></label>
					<div class="layui-input-inline">
						<input name="dckName"  class="layui-input" maxlength="15" required="required" value="${dck.getDckName() }"/>
					</div>	
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>大仓库地址</h3></label>
					<div class="layui-input-inline">
						<input name="dckLocation"  class="layui-input" maxlength="15" required="required" value="${dck.getDckLocation() }"/>
					</div>	
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>建立时间</h3></label>
					<div class="layui-input-inline">
						<input name="buildTime" id="demo1" autocomplete="off" class="layui-input" maxlength="15" required="required"  value="<fmt:formatDate  value="${dck.getBuildTime() }"  pattern="yyyy-MM-dd"/>"/>
					</div>	
				</div>
				
				
				<div class="layui-form-item">
					<label class="layui-form-label"><h3>大仓库老板</h3></label>
					<div class="layui-input-inline">
						<input name="dckBoss"  class="layui-input" maxlength="15" required="required" value="${dck.getDckBoss() }"/>					
					</div>	
				</div>

				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="formDemo">确认保存</button>
					</div>
				</div>
			</div>
		</div>
	</form:form>
	<script type="text/javascript" src="${ pageContext.request.contextPath}/js/calendar/laydate.js"></script>
	<script>
		layui.use('form', function() {
			var form = layui.form;
			form.render();
		});
		 !function(){
	            laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
	            laydate({elem: '#demo1'});//绑定元素
	            laydate({elem: '#demo2'});//绑定元素
	            laydate({elem: '#demo3'});//绑定元素
	            laydate({elem: '#demo4'});//绑定元素
	            laydate({elem: '#demo5'});//绑定元素
	            laydate({elem: '#demo6'});//绑定元素
	        }();
	        //日期范围限制
	        var start = {
	            elem: '#start',
	            format: 'YYYY-MM-DD',
	            min: laydate.now(), //设定最小日期为当前日期
	            max: '2199-06-16', //最大日期
	            istime: true,
	            istoday: false,
	            choose: function(datas){
	                end.min = datas; //开始日选好后，重置结束日的最小日期
	                end.start = datas //将结束日的初始值设定为开始日
	            }
	        };
	        var end = {
	            elem: '#end',
	            format: 'YYYY-MM-DD',
	            min: laydate.now(),
	            max: '2199-06-16',
	            istime: true,
	            istoday: false,
	            choose: function(datas){
	                start.max = datas; //结束日选好后， 开始日的最大日期
	            }
	        };
	        laydate(start);
	        laydate(end);
	        //自定义日期格式
	        laydate({
	            elem: '#test1',
	            format: 'YYYY年MM月DD日',
	            festival: true, //显示节日
	            choose: function(datas){ //选择日期完毕的回调
	                alert('得到：'+datas);
	            }
	        });
	        //日期范围限定在昨天到明天
	        laydate({
	            elem: '#hello3',
	            min: laydate.now(-1), //-1代表昨天，-2代表前天，以此类推
	            max: laydate.now(+1) //+1代表明天，+2代表后天，以此类推
	        });
	</script>
</body>
</html>

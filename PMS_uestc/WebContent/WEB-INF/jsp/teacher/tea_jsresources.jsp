<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!-- teacher model jQuery -->
<script src="<%=basePath%>js/teacher/mystu.js"></script>
<script src="<%=basePath%>js/teacher/blindjudge.js"></script>
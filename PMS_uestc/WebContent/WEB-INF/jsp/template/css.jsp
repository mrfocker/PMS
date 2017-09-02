<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link rel="shortcut icon" href="favicon.gif">
<!---CSS Files-->
<link rel="stylesheet" href="<%=basePath%>css/master.css">
<link rel="stylesheet" href="<%=basePath%>css/tables.css">
<link rel="stylesheet" href="<%=basePath%>css/iphone-check.css">
<link rel="stylesheet" href="<%=basePath%>css/icons.css">
<!--bootstrap CSS-->
<link rel="stylesheet" href="<%=basePath%>pages/bootstrap-fileinput/css/fileinput.min.css">
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">

<link href="<%=basePath%>js/sh/shThemeDefault.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>js/sh/shCore.css" rel="stylesheet" type="text/css" />
<!---Fonts-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'>

<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page import="cn.pms.ssm.vo.DownloadVo" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>研究生论文管理系统 - 文件下载</title>
<link rel="shortcut icon" href="favicon.gif">
<link rel="shortcut icon" href="favicon.gif">
<!---CSS Files-->
<link rel="stylesheet" href="css/master.css">
<link rel="stylesheet" href="css/tables.css">
<!---jQuery Files-->
<script src="js/jquery-1.7.1.min.js"></script>
<script src="js/jquery-ui-1.8.17.min.js"></script>
<script src="js/styler.js"></script>
<script src="js/jquery.tipTip.js"></script>
<script src="js/colorpicker.js"></script>
<script src="js/sticky.full.js"></script>
<script src="js/global.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<!-- <script src="js/beforeUnload.js"></script> -->
<!---Fonts-->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600"
	rel="stylesheet" type="text/css">

<!-- <script type="text/javascript">
$(window).bind('beforeunload',function(){
	window.location.href = "${pageContext.request.contextPath }/pages/exitLogin.action";
    return '您输入的内容尚未保存，确定离开此页面吗？';
});
</script> -->
</head>
<body>
	<div class="header">
		<a href="${pageContext.request.contextPath }/pages/login.action"><img
			src="img/logo.png" alt="Logo" /></a>
		<div class="styler">
			<ul class="styler-show">
				<li><div id="colorSelector-top-bar"></div></li>
				<li><div id="colorSelector-box-head"></div></li>
			</ul>
		</div>
	</div>

	<div class="top-bar">
		<ul id="nav">
			<li id="user-panel"><img src="img/nav/usr-avatar.jpg"
				id="usr-avatar" alt="" />
				<div id="usr-info">
					<p id="usr-name">Welcome back, Michael.</p>
					<p id="usr-notif">
						You have 6 notifications. <a href="#">View</a>
					</p>
					<p>
						<a href="#">Preferences</a><a href="#">Profile</a><a
							href="${pageContext.request.contextPath }/pages/exitLogin.action">Log out</a>
					</p>
				</div></li>
			<li>
				<ul id="top-nav">
					<li class="nav-item"><a href="dashboard.html"><img
							src="img/nav/dash.png" alt="" />
							<p>Dashboard</p></a></li>
					<li class="nav-item"><a href="analytics.html"><img
							src="img/nav/anlt.png" alt="" />
							<p>Analytics</p></a></li>
					<li class="nav-item"><a href="tables.html"><img
							src="img/nav/tb.png" alt="" />
							<p>Tables</p></a></li>
					<li class="nav-item"><a href="calendar.html"><img
							src="img/nav/cal.png" alt="" />
							<p>Calendar</p></a></li>
					<li class="nav-item"><a href="#"><img
							src="img/nav/widgets-active.png" alt="" />
							<p>Widgets</p></a></li>
					<li class="nav-item"><a href="grid.html"><img
							src="img/nav/grid.png" alt="" />
							<p>Grid</p></a>
						<ul class="sub-nav">
							<li><a href="#">12 Columns</a></li>
							<li><a href="#">16 Columns</a></li>
						</ul></li>
					<li class="nav-item"><a href="filemanager.html"><img
							src="img/nav/flm.png" alt="" />
							<p>File Manager</p></a></li>
					<li class="nav-item"><a href="gallery.html"><img
							src="img/nav/gal.png" alt="" />
							<p>Gallery</p></a></li>
					<li class="nav-item"><a href="icons.html"><img
							src="img/nav/icn.png" alt="" />
							<p>Icons</p></a></li>
					<li class="nav-item"><a href="#"><img
							src="img/nav/err.png" alt="" />
							<p>Error Pages</p></a>
						<ul class="sub-nav">
							<li><a href="403.html">403 Page</a></li>
							<li><a href="404.html">404 Page</a></li>
							<li><a href="503.html">503 Page</a></li>
						</ul></li>
					<li class="nav-item"><a href="typography.html"><img
							src="img/nav/typ.png" alt="" />
							<p>Typography</p></a></li>
				</ul>
			</li>
		</ul>
	</div>

	<div class="content container_12">

		<div class="box grid_12">
			<input type="text" value="${downloadList}" id="downloadList" style="display: none">
			<div class="box-head">
				<h2>论文批量下载</h2>
			</div>
			<div class="box-content no-pad">
				<ul class="table-toolbar">
					<li><a
						href="${pageContext.request.contextPath }/pages/searchAll.action"><img
							src="img/icons/basic/plus.png" alt="" /> 查询</a></li>
					<li><a href="#"><img src="img/icons/basic/delete.png"
							alt="" /> Remove</a></li>
					<li><a href="javascript:;;" class="down"><img
							src="img/icons/basic/save.png" alt="" /> 一键下载</a></li>
					<li><a href="#"><img src="img/icons/basic/print.png"
							alt="" /> Print</a></li>
					<li><a href="#"><img src="img/icons/basic/up.png" alt="" />
							Ascending</a></li>
					<li><a href="#"><img src="img/icons/basic/down.png" alt="" />
							Descending</a></li>
				</ul>
				<table class="display" id="dt2">
					<thead>
						<tr>
							<th>序号</th>
							<th>学号</th>
							<th>姓名</th>
							<th>论文题目</th>
							<th>论文版本</th>
							<th></th>
							<th></th>
							<th style="display: none;"></th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${downloadList}" var="downloadVo"
							varStatus="status">
							<tr class="trye">
								<td>${status.index + 1 }</td>
								<td>${downloadVo.paper_stuId }</td>
								<td>${downloadVo.stu_name }</td>
								<td>${downloadVo.paper_title}</td>
								<td>${downloadVo.file_type }</td>
								<td><input type="checkbox" /></td>
							<%-- 	<td><a
									href="${pageContext.request.contextPath }/pages/downloadSingleAdmin.action?id=${downloadVo.paper_stuId}&name=${downloadVo.paper_name}/">下载</a></td> --%>
								<td><a
									href="/resources/PaperFile/${time}/${downloadVo.file_name}" download="${downloadVo.paper_stuId}_论文.docx" class="link">下载</a></td>
								<td class="pname" style="display: none;">${downloadVo.file_name }</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		/* SCRIPTS */
		$(function() {
			$('#dt2').dataTable({
				"bJQueryUI" : true
			});
			
			 $(".down").click(function() {  
					
					var result = new Array();
					
					$(".trye").find(".pname").each(function(index, String) {
						result[index] = $(this).text();
						console.log(result[index]);
					});
					
					var str =  JSON.stringify(result);
					console.log(str);
					window.location.href="${pageContext.request.contextPath }/pages/downloadMulti.action?str="+str;
			}); 
			 
			$(".link").click(function(){
				  var now= new Date();
				  var year=now.getFullYear();
			});
		});
	</script>
</html>
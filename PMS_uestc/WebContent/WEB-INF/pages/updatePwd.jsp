<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>研究生论文管理系统 - 修改密码</title>
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
  <!---Fonts-->
  <link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600"
	rel="stylesheet" type="text/css">
<!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
</head>
<body>
	<div class="header">
		<a href="${pageContext.request.contextPath }/pages/login.action"><img src="img/logo.png" alt="Logo" /></a>
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
							href="index.html">Log out</a>
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
		<div class="box grid_6">
			<div class="box-head">
				<h2>修改密码</h2>
			</div>
			<div class="box-content">
				<div class="form-row">
					<p class="form-label" id="userOldPwd">当前密码：</p>
					<div class="form-item">
						<input type="password" />
					</div>
				</div>
				<div class="form-row">
					<p class="form-label" id="userNewPwd">新密码：</p>
					<div class="form-item">
						<input type="password" />
					</div>
				</div>
				<div class="form-row">
					<p class="form-label" id="checkPwd">确认密码：</p>
					<div class="form-item">
						<input type="password" />
					</div>
				</div>
				<div class="form-row"></div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
</body>
</html>
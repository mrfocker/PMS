<!-- <!doctype html> -->
<!-- <html lang="en"> -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("userId");
	String userPwd = request.getParameter("userPwd");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta charset="utf-8">
<title>研究生论文管理系统 - 登录</title>
<link rel="shortcut icon" href="favicon.gif">
<!---CSS Files-->
<link rel="stylesheet" href="css/master.css">
<link rel="stylesheet" href="css/login.css">
<!---jQuery Files-->
<script src="js/jquery-1.7.1.min.js"></script>
<script src="js/jquery.spinner.js"></script>
<script type="text/javascript" src="js/forms/jquery.validate.min.js"></script>

<!---Fonts-->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600"
	rel="stylesheet" type="text/css">
<!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
<!---FadeIn Effect, Validation and Spinner-->
<!-- Cookie插件 -->
<script
	src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script type="text/javascript">
	/* var url = ${pageContext.request.contextPath }; */
	$(document).ready(function() {
		$('div.wrapper').hide();
		$('div.wrapper').fadeIn(1200);
		$('#lg-form').validate();
		$('.submit').click(function() {
			var $this = $(this);
			$this.spinner();
			setTimeout(function() {
				$this.spinner('remove');
			}, 1000); 
			console.log("id = " + $("#userId").val()); //TODO
			$.cookie('userId', $("#userId").val(), {
				expires : 1
			});
			$.cookie('userPwd', $("#userPwd").val(), {
				expires : 1
			});
		});
	});
</script>
</head>
<body>
	<div class="wrapper">
		<div class="logo">
			<h1>LOGIN PAGE</h1>
		</div>
		<div class="lg-body">
			<div class="inner">
				<div id="lg-head">
					<p>
						<span class="font-bold">登录</span>:研究生论文管理系统
					</p>
					<div class="separator"></div>
				</div>
				<div class="login">
					<form id="lg-form" method="post"
						action="${pageContext.request.contextPath }/pages/login.action">
						<fieldset>
							<ul>
								<li id="usr-field"><input id="userId" class="input required"
									name="userId" type="text" size="26" minlength="1"
									placeholder="用户名..." /></li>
								<li id="psw-field"><input id="userPwd" class="input required"
									name="userPwd" type="password" size="26" minlength="1"
									placeholder="密码..." /></li>
								<li class="checkbox"><input class="checkbox"
									type="checkbox" id="remember-me" value="remember" /> <label
									for="remember-me" class="checkbox-text">记住密码</label></li>
								<li><input class="submit" type="submit" value="" /></li>
							</ul>
						</fieldset>
					</form>
					<span id="lost-psw"> <a href="#">密码修改</a>
					</span>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
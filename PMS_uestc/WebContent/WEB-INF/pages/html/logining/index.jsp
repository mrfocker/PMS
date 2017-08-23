<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<!---CSS Files-->
<link rel="stylesheet" href="css/master.css">
<link rel="stylesheet" href="css/iphone-check.css">
<link href="js/sh/shThemeDefault.css" rel="stylesheet" type="text/css" />
<link href="js/sh/shCore.css" rel="stylesheet" type="text/css" />
<!---jQuery Files-->
<script src="js/jquery-1.7.1.min.js"></script>
<script src="js/jquery-ui-1.8.17.min.js"></script>
<script src="js/styler.js"></script>
<script src="js/jquery.tipTip.js"></script>
<script src="js/colorpicker.js"></script>
<script src="js/sticky.full.js"></script>
<script src="js/global.js"></script>
<script src="js/forms/fileinput.js"></script>
<script src="js/forms/iphone-check.js"></script>
<script src="js/forms/jquery.validate.min.js"></script>
<script src="js/sh/shCore.js" type="text/javascript"></script>
<script src="js/sh/shBrushXml.js" type="text/javascript"></script>
<!---Fonts-->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700'
	rel='stylesheet' type='text/css'>
<title>登录</title>

<script type="text/javascript">
	
</script>
</head>
<body>

	<form
		action="${pageContext.request.contextPath }/logining/login.action"
		method="post">
		<label>id:</label><input type="text" name="userId" /> <br /> <label>password:</label><input
			type="password" name="userPwd" /> <br /> <label>用户类型：</label><input
			type="text" name="userType" /> <input type="submit" value="登录" /> <input
			type="reset" value="重置" />
	</form>
	<input type="text" value="${error}" />
	<!-- value="${paper.Paper_stuId}" value="${paper.Paper_researchOne}" value="${paper.Paper_researchTwo}"
	 -->
	<form
		action="${pageContext.request.contextPath }/pages/downloadSingle.action"
		method="post" enctype="multipart/form-data">
		id:<input type="text" name="Paper_stuId" /><br /> researchOne:<input
			type="text" name="Paper_researchOne" /><br /> researchTwo:<input
			type="text" name="Paper_researchTwo" /><br /> type:<input
			type="text" name="paperType" /><br /> <input type="file"
			name="file" /><br /> <input type="submit" value="ok" />
	</form>

	<div class="box grid_6">
		<div class="box-head">
			<h2>Select Inputs</h2>
		</div>
		<div class="box-content">
			<div class="form-row">
				<label class="form-label">File Upload</label>
				<div class="form-item file-upload">
					<form action="${pageContext.request.contextPath }/pages/upload.action"
						method="post" enctype="multipart/form-data">
						id:<input type="text" name="Paper_stuId" /><br /> 
						researchOne:<input
							type="text" name="Paper_researchOne" /><br /> 
						researchTwo:<input
							type="text" name="Paper_researchTwo" /><br /> 
						type:<input
							type="text" name="File_type" /><br /> <br /> <br /> <br /> <br /> <input /> <input
							class="filebase" type="file" name="file" /> <span
							class="form-icon fugue-2 control-eject"></span> <span
							class="filetext" aria-hidden="true">Select a file to
							upload...</span> <br />
						<input type="submit" value="提交" />
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
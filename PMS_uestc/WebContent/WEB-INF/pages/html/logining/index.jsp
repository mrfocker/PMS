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
<title>登录</title>
</head>
<body>

	<form action="${pageContext.request.contextPath }/logining/login.action" method="post">
		<label>id:</label><input type="text" name="userId" /> <br /> 
		<label>password:</label><input
			type="password" name="userPwd" /> <br /> 
		<label>用户类型：</label><input type="text" name="userType"/>
			<input type="submit" value="登录" />
		<input type="reset" value="重置" />
	</form>
	<input type="text" value="${error}" />
	<!-- value="${paper.Paper_stuId}" value="${paper.Paper_researchOne}" value="${paper.Paper_researchTwo}"
	 -->
	<form action="${pageContext.request.contextPath }/load/uploadfile.action" method="post" enctype="multipart/form-data">
		id:<input type="text" name="Paper_stuId"/><br/>
		researchOne:<input type="text" name="Paper_researchOne"/><br/>
		researchTwo:<input type="text" name="Paper_researchTwo"/><br/>
		type:<input type="text" name="paperType"/><br/>
		<input type="file" name="file"/><br/>
		<input type="submit" value="ok"/>
	</form>
</body>
</html>
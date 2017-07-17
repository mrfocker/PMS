<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>json交互测试</title>
</head>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.7.1.min.js"></script>

<script type="text/javascript">
//请求json 输出json
function requestJson(){
  
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath }/pages/requestJson',
		contentType:'application/json;charset=utf-8',
		data:'{"paper_stuId":"201621220101","paper_title":"大数据安全设计平台","paper_researchOne":"大数据"}',
		success:function(data){
			alert(data.paper_stuId);
		}
		
	});
	
	
}

//请求key/value 输出json
function responseJson(){
	
}
</script>
<body>

	<input type="button" onclick="requestJson()" value="请求json 输出json" />
	<input type="button" onclick="responseJson()"
		value="请求key/value 输出json" />

</body>
</html>
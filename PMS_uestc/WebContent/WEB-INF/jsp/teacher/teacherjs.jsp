<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!---jQuery Files-->
<script src="<%=basePath%>js/jquery-2.1.1.min.js"></script>
<script src="<%=basePath%>js/jquery-ui-1.8.17.min.js"></script>
<script src="<%=basePath%>js/styler.js"></script>
<script src="<%=basePath%>js/jquery.tipTip.js"></script>
<script src="<%=basePath%>js/colorpicker.js"></script>
<script src="<%=basePath%>js/sticky.full.js"></script>
<script src="<%=basePath%>js/global.js"></script>
<script src="<%=basePath%>js/jquery.dataTables.min.js"></script>
<script src="<%=basePath%>js/forms/fileinput.js"></script>
<script src="<%=basePath%>js/forms/jquery.validate.min.js"></script>
<script src="<%=basePath%>js/sh/shCore.js"></script>
<script src="<%=basePath%>js/sh/shBrushXml.js"></script>
<!--bootstrap Files-->
<script src="<%=basePath%>pages/bootstrap-fileinput/js/fileinput.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>

<!-- teacher model jQuery -->
<script src="<%=basePath%>js/teacher/mystu.js"></script>
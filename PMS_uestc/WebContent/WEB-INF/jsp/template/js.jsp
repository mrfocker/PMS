<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!---jQuery Files-->
<script src="<%=basePath%>js/jquery-1.7.1.min.js"></script>
<script src="<%=basePath%>js/jquery-ui-1.8.17.min.js"></script>
<script src="<%=basePath%>js/styler.js"></script>
<script src="<%=basePath%>js/jquery.tipTip.js"></script>
<script src="<%=basePath%>js/colorpicker.js"></script>
<script src="<%=basePath%>js/sticky.full.js"></script>
<script src="<%=basePath%>js/global.js"></script>
<script src="<%=basePath%>js/jquery.dataTables.min.js"></script>
<script src="<%=basePath%>js/admin/adminUserinfo.js"></script>
<script src="<%=basePath%>js/admin/adminUpdateResult.js"></script>
<script src="<%=basePath%>js/admin/adminVertification.js"></script>
<script src="<%=basePath%>js/admin/adminReplyTime.js"></script>
<script src="<%=basePath%>js/admin/adminChangePwd.js"></script>
<script src="<%=basePath%>js/forms/fileinput.js"></script>
<script src="<%=basePath%>js/forms/iphone-check.js"></script>
<script src="<%=basePath%>js/forms/jquery.validate.min.js"></script>
<script src="<%=basePath%>js/sh/shCore.js"></script>
<script src="<%=basePath%>js/sh/shBrushXml.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>毕业论文管理系统--管理员</title>
    <link rel="shortcut icon" href="favicon.gif">
    <!---CSS Files-->
    <link rel="stylesheet" href="<%=basePath %>/css/master.css">
    <link rel="stylesheet" href="<%=basePath %>/css/tables.css">
    <link rel="stylesheet" href="<%=basePath %>/css/iphone-check.css">
    <link href="<%=basePath %>/js/sh/shThemeDefault.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath %>/js/sh/shCore.css" rel="stylesheet" type="text/css" />
    <!---jQuery Files-->
    <script src="<%=basePath %>/js/jquery-1.7.1.min.js"></script>
    <script src="<%=basePath %>/js/jquery-ui-1.8.17.min.js"></script>
    <script src="<%=basePath %>/js/styler.js"></script>
    <script src="<%=basePath %>/js/jquery.tipTip.js"></script>
    <script src="<%=basePath %>/js/colorpicker.js"></script>
    <script src="<%=basePath %>/js/sticky.full.js"></script>
    <script src="<%=basePath %>/js/global.js"></script>
    <script src="<%=basePath %>/js/jquery.dataTables.min.js"></script>
    <!---Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'>
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>
<body>

<!--- HEADER -->
<div class="top-bar">
    <ul id="nav">
        <li id="user-panel">
            <img src="<%=basePath %>/img/nav/usr-avatar.jpg" id="usr-avatar" alt="" />
            <div id="usr-info">
                <p id="usr-name">管理员，欢迎您</p>
                <a>工号：${admin.su_id}</a>
            </div>
        </li>
        <li>
            <ul id="top-nav" style="z-index: 999">
                <li class="nav-item">
                    <a href="<%=basePath%>/admin/userInfo.action"><img src="<%=basePath%>/img/nav/info.png" alt="" /><p>用户信息</p></a>
                </li>
                <li class="nav-item">
                    <a href="<%=basePath%>/admin/verifyPaper.action"><img src="<%=basePath%>/img/nav/folder.png" alt="" /><p>论文审核</p></a>
                </li>
                <li class="nav-item">
                    <a href="calendar.html"><img src="<%=basePath%>/img/nav/group.png" alt="" /><p>评审分配</p></a>
                    <ul class="sub-nav">
                        <li><a href="#">评审小组分配</a></li>
                        <li><a href="#">答辩小组分配</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a href="analytics.html"><img src="<%=basePath%>/img/nav/down.png" alt="" /><p>信息导入</p></a>
                    <ul class="sub-nav">
                        <li><a href="#">学生基本信息</a></li>
                        <li><a href="#">老师基本信息</a></li>
                        <li><a href="#">论文重复率</a></li>
                        <li><a href="#">学业成绩导入</a></li>
                        <li><a href="#">答辩成绩导入</a></li>
                        <li><a href="#">授位结果导入</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a href="dashboard.html"><img src="<%=basePath%>/img/nav/up.png" alt="" /><p>信息导出</p></a>
                    <ul class="sub-nav">
                        <li><a href="#">导师审核结果</a></li>
                        <li><a href="#">学院审核结果</a></li>
                        <li><a href="#">评审分配结果</a></li>
                        <li><a href="#">答辩分配结果</a></li>
                        <li><a href="#">授位结果导出</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a href="#"><img src="<%=basePath%>/img/nav/redo.png" alt="" /><p>数据备份</p></a>
                </li>
                <li class="nav-item">
                    <a href="dashboard.html"><img src="<%=basePath%>/img/nav/setting.png" alt="" /><p>密码修改</p></a>
                </li>
                <li class="nav-item">
                    <a href="grid.html"><img src="<%=basePath%>/img/nav/exit.png" alt="" /><p>退出系统</p></a>
                </li>
            </ul>
        </li>
    </ul>
</div>

<div class="content container_12">
    <div class="box grid_12">
        <div id="tabs">
            <ul>
                <li><a href="#tabs-1">学生信息</a></li>
                <li><a href="#tabs-2">老师信息</a></li>
            </ul>
            <div id="tabs-1">
                <div class="content container_12" style="height:800px">
                    <input type="button" class="button green" value="数据导入" style="margin-bottom: 20px">
                    <div class="box grid_12">
                        <div class="box-content no-pad">
                            <table class="display" id="dt1">
                                <thead>
                                <tr>
                                    <th>学号</th>
                                    <th>姓名</th>
                                    <th>专业及方向</th>
                                    <th>学术类型</th>
                                    <th>指导老师</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="student" items="${students}">
                                <tr class="odd gradeX">
                                    <td class="center">${student.stu_id}</td>
                                    <td class="center">${student.stu_name}</td>
                                    <td class="center">${student.stu_major}</td>
                                    <td class="center">${student.stu_degreeType}</td>
                                    <td class="center">${student.stu_teacherId}</td>
                                </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div id="tabs-2">
                <div class="content container_12" style="height:800px">
                    <input type="button" class="button green" value="数据导入" style="margin-bottom: 20px">
                    <div class="box grid_12">
                        <div class="box-content no-pad">
                            <table class="display" id="dt2">
                                <thead>
                                <tr>
                                    <th>教工号</th>
                                    <th>姓名</th>
                                    <th>邮件</th>
                                    <th>电话</th>
                                    <th>职称</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="teacher" items="${teachers}">
                                <tr class="odd gradeX">
                                    <td class="center">${teacher.teacher_id}</td>
                                    <td class="center">${teacher.teacher_name}</td>
                                    <td class="center">${teacher.teacher_email}</td>
                                    <td class="center">${teacher.teacher_tel}</td>
                                    <td class="center">${teacher.teacher_proTitle}</td>
                                </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="footer container_12">
    <p class="grid_12">电子科技大学信息与软件工程学院</p>
</div>

<script  type="text/javascript"> /* SCRIPTS */
$(function() {
    $("#tabs").tabs();
    $('#dt1').dataTable( {
        "sPaginationType": "full_numbers"
    });
    $('#dt2').dataTable( {
        "sPaginationType": "full_numbers"
    });
});

</script>

</body>
</html>
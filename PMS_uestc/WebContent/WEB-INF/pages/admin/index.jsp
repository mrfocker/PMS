<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="css/master.css">
    <link rel="stylesheet" href="css/tables.css">
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
    <script src="js/jquery.dataTables.min.js"></script>
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
            <img src="img/nav/usr-avatar.jpg" id="usr-avatar" alt="" />
            <div id="usr-info">
                <p id="usr-name">管理员，欢迎您</p>
                <a>工号：${admin.su_id}</a>
            </div>
        </li>
        <li>
            <ul id="top-nav" style="z-index: 999">
                <li class="nav-item">
                    <a href="<%=basePath%>/admin/userInfo.action"><img src="img/nav/info.png" alt="" /><p>用户信息</p></a>
                </li>
                <li class="nav-item">
                    <a href="<%=basePath%>/admin/verifyPaper.action"><img src="img/nav/folder.png" alt="" /><p>论文审核</p></a>
                </li>
                <li class="nav-item">
                    <a href="calendar.html"><img src="img/nav/group.png" alt="" /><p>评审分配</p></a>
                    <ul class="sub-nav">
                        <li><a href="#">评审小组分配</a></li>
                        <li><a href="#">答辩小组分配</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a href="analytics.html"><img src="img/nav/down.png" alt="" /><p>信息导入</p></a>
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
                    <a href="dashboard.html"><img src="img/nav/up.png" alt="" /><p>信息导出</p></a>
                    <ul class="sub-nav">
                        <li><a href="#">导师审核结果</a></li>
                        <li><a href="#">学院审核结果</a></li>
                        <li><a href="#">评审分配结果</a></li>
                        <li><a href="#">答辩分配结果</a></li>
                        <li><a href="#">授位结果导出</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a href="#"><img src="img/nav/redo.png" alt="" /><p>数据备份</p></a>
                </li>
                <li class="nav-item">
                    <a href="<%=basePath%>/admin/changePwd.action"><img src="img/nav/setting.png" alt="" /><p>密码修改</p></a>
                </li>
                <li class="nav-item">
                    <a href="grid.html"><img src="img/nav/exit.png" alt="" /><p>退出系统</p></a>
                </li>
            </ul>
        </li>
    </ul>
</div>

<div class="content container_12">
    <div class="box grid_12">
        <div class="box-head"><h2>管理员操作指南</h2></div>
        <div class="box-content textsh">
            <div style="text-align:center">
                <h6>系统使用步骤说明</h6><br><br><br>
            </div>
            <div style="margin-left: 60px">
                <h7>1、导入学生及老师信息</h7><br><br>
                <h7>2、查看学生论文是否通过本导师审核，可导出导师审核结果</h7><br><br>
                <h7>3、管理员对审核通过的所有论文进行审核，手动点击下载并点击切换审核状态，可导出学院审核结果</h7><br><br>
                <h7>4、导入论文重复率</h7><br><br>
                <h7>5、分配评审组进行盲审，可导出分配结果及盲审结果</h7><br><br>
                <h7>6、导入学生学业成绩</h7><br><br>
                <h7>7、核对成绩及各项指标合格后分配答辩组，组织答辩，可导出分配结果</h7><br><br>
                <h7>8、导入答辩成绩</h7><br><br>
                <h7>9、导入授位信息</h7><br><br>
                <h7>10、导出最终授位结果</h7><br><br>
            </div>
        </div>
    </div>
</div>

<div class="footer container_12">
    <p class="grid_12">电子科技大学信息与软件工程学院</p>
</div>

</body>
</html>
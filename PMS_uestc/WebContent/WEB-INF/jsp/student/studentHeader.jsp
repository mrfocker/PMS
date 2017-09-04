<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!--- HEADER -->
<div class="top-bar">
    <ul id="nav">
        <li id="user-panel">
            <img src="<%=basePath%>/img/nav/uestc.jpg" id="usr-avatar" alt="" />
            <div id="usr-info">
                <p id="usr-name">${student.stu_name}同学，欢迎您</p>
                <a>工号：${student.stu_id}</a>
            </div>
        </li>
        <li>
            <ul id="top-nav" style="z-index: 999">
                <li class="nav-item">
                    <a href="<%=basePath%>/pages/teacherQueryStu"><img src="<%=basePath%>/img/nav/group.png" alt="" /><p>我的论文</p></a>
                </li>
                <li class="nav-item">
                    <a href="<%=basePath%>/"><img src="<%=basePath%>/img/nav/setting.png" alt="" /><p>密码修改</p></a>
                </li>
                <li class="nav-item">
                    <a href="<%=basePath%>/"><img src="<%=basePath%>/img/nav/exit.png" alt="" /><p>退出系统</p></a>
                </li>
            </ul>
        </li>
    </ul>
</div>

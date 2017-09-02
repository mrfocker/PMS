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
                <p id="usr-name">${admin.su_name}管理员，欢迎您</p>
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
                    <ul class="sub-nav">
                        <li><a href="<%=basePath%>/download.action">下载</a></li>
                    </ul>
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
                        <li><a href="<%=basePath%>/admin/toUpdateDegreeResult.action">授位结果</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a href="#"><img src="<%=basePath%>/img/nav/clip.png" alt="" /><p>数据修改</p></a>
                    <ul class="sub-nav">
                        <li><a href="<%=basePath%>/admin/setDeadline.action">提交期限设置</a></li>
                        <li><a href="<%=basePath%>/admin/toUpdateResult.action">审核结果修改</a></li>
                        <li><a href="<%=basePath%>/admin/toRequestReplyTime.action">答辩申请时间</a></li>
                        <li><a href="<%=basePath%>/admin/toUpdateReplyTime.action">答辩时间设置</a></li>
                        <li><a href="<%=basePath%>/admin/toUpdateTeacherOperation.action">导师操作设置</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a href="<%=basePath%>/admin/changePwd.action"><img src="<%=basePath%>/img/nav/setting.png" alt="" /><p>密码修改</p></a>
                </li>
                <li class="nav-item">
                    <a href="<%=basePath%>/admin/exitLogin.action"><img src="<%=basePath%>/img/nav/exit.png" alt="" /><p>退出系统</p></a>
                </li>
            </ul>
        </li>
    </ul>
</div>

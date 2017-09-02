<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<div class="content container_12">
    <div class="box grid_12">
        <div class="box-head"><h2>导师能否操作本学生论文</h2></div>
        <div class="box-content no-pad">
            <table class="display" id="dtTeacherOperation">
                <thead>
                <tr>
                    <th><input type="checkbox" name="check" onclick="checkAll();"/>全选</th>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>论文标题</th>
                    <th>导师姓名</th>
                    <th>导师能否操作该论文</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="stupaper" items="${stupaper}">
                <tr class="odd gradeX" id="to${stupaper.stu_id}">
                    <td class="center">
                    	<input type="checkbox" value='checkbox' />
                    </td>
                    <td class="center">${stupaper.stu_id}</td>
                    <td class="center">${stupaper.stu_name}</td>
                    <td class="center">${stupaper.paper_title}</td>
                    <td class="center">${stupaper.teacher_name}</td>
                    <c:if test="${stupaper.paper_ifAdvice == 0}">
                    <td class="center">
                    	<input checked="checked" type="radio" name="to${stupaper.stu_id}" value="0" />是
                    	<input type="radio" name="to${stupaper.stu_id}" value="1" />否
                    </td>
                    </c:if>
                    <c:if test="${stupaper.paper_ifAdvice == 1}">
                    <td class="center">
                    	<input type="radio" name="to${stupaper.stu_id}" value="0" />是
                    	<input checked="checked" type="radio" name="to${stupaper.stu_id}" value="1" />否
                    </td>
                    </c:if>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
	<input type="button" id="saveStates" class="button green" value="保存" style="float: right;margin-right: 10px">
	<p>注：点击“全选”时需要在每一页都点击“全选”按钮框</p>
</div>

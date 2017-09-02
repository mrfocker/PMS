<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<div class="content container_12" style="height:800px">
	<div class="box grid_12">
		<div class="box-head"><h2>学生申请的答辩时间</h2></div>
		<div class="box-content no-pad">
			<table class="display" id="dtStuRequest">
				<thead>
					<tr>
						<th>学号</th>
						<th>姓名</th>
						<th>申请答辩时间</th>
						<th>修改</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="student" items="${students}">
					<tr class="odd gradeX" id="${student.stu_id}">
						<td class="center">${student.stu_id}</td>
						<td class="center">${student.stu_name}</td>
						<td class="center">${student.stu_requestReplyTime}</td>
						<td align="center">
							<p onclick="editStuRequestModal(${student.stu_id})" class="silk pencil"></p>
                        </td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
		<div id="request-modal" title="修改学生的答辩申请时间">
		<div class="form-row">
			<p class="form-label">学号：</p>
			<div class="form-item">
				<input style="font-size: 12px" type="text" id="stuId" name="stuId" value="" readonly="readonly"/>
			</div>
		</div>
		<div class="form-row">
			<p class="form-label">姓名：</p>
			<div class="form-item">
				<input style="font-size: 12px" type="text" id="stuName" name="stuName" value="" readonly="readonly"/>
			</div>
		</div>
		<div class="form-row">
			<p class="form-label">申请答辩时间：</p>
			<div class="form-item">
              	<select id="requestSelector" style="font-size: 12px">
                	<option value='一月'>一月</option>
                	<option value='二月'>二月</option>
                	<option value='三月'>三月</option>
                	<option value='四月'>四月</option>
                	<option value='五月'>五月</option>
                	<option value='六月'>六月</option>
                	<option value='七月'>七月</option>
                	<option value='八月'>八月</option>
                	<option value='九月'>九月</option>
                	<option value='十月'>十月</option>
                	<option value='十一月'>十一月</option>
                	<option value='十二月'>十二月</option>
              	</select>
			</div>
		</div>
	</div>
</div>
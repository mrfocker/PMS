<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<div class="content container_12" style="height:800px">
	<div class="box grid_12">
		<div class="box-head"><h2>学生的授位结果</h2></div>
		<div class="box-content no-pad">
			<table class="display" id="dtStuDegree">
				<thead>
					<tr>
						<th>学号</th>
						<th>姓名</th>
						<th>论文标题</th>
						<th>是否授位</th>
						<th>修改</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="degreeResult" items="${degreeResult}">
					<tr class="odd gradeX" id="${degreeResult.stu_id}">
						<td align="center">${degreeResult.stu_id}</td>
						<td align="center">${degreeResult.stu_name}</td>
						<td align="center">${degreeResult.paper_title}</td>
						<td align="center">${degreeResult.stu_ifdegree}</td>
						<td align="center">
							<p onclick="editDegreeModal(${degreeResult.stu_id})" class="silk pencil"></p>
                        </td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div id="degree-modal" title="修改学生的授位结果">
		<div class="form-row">
			<p class="form-label">学号：</p>
			<div class="form-item">
				<input style="font-size: 12px" type="text" id="dstuId" name="dstuId" value="" readonly="readonly"/>
			</div>
		</div>
		<div class="form-row">
			<p class="form-label">姓名：</p>
			<div class="form-item">
				<input style="font-size: 12px" type="text" id="dstuName" name="dstuName" value="" readonly="readonly"/>
			</div>
		</div>
		<div class="form-row">
			<p class="form-label">是否授位：</p>
			<div class="form-item">
              	<select id="stuIfDegree" style="font-size: 12px">
                	<option value='是'>是</option>
                	<option value='否'>否</option>
              	</select>
			</div>
		</div>
	</div>
</div>
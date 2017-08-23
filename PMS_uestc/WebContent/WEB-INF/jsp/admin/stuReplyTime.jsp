<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<div class="content container_12" style="height:800px">
	<div class="box grid_12">
        <input type="button" class="button green" onclick="replyTimeSetting()" value="统一设置答辩时间" style="margin-bottom: 20px">
		<div class="box-head"><h2>学生的答辩时间</h2></div>
		<div class="box-content no-pad">
			<table class="display" id="dtStuReply">
				<thead>
					<tr>
						<th>学号</th>
						<th>姓名</th>
						<th>答辩时间</th>
						<th>修改</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="stuReplyTime" items="${stuReplyTime}">
					<tr class="odd gradeX" id="${stuReplyTime.stu_id}">
						<td align="center">${stuReplyTime.stu_id}</td>
						<td align="center">${stuReplyTime.stu_name}</td>
						<td align="center">${stuReplyTime.reply_time}</td>
						<td align="center" style="font-size: 12px">
							<p onclick="editStuReplyModal(${stuReplyTime.stu_id})" class="silk pencil"></p>
                        </td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div id="replytime-modal" title="修改学生的答辩时间">
		<div class="form-row">
			<p class="form-label">学号：</p>
			<div class="form-item">
				<input style="font-size: 12px" type="text" id="restuId" name="restuId" value="" readonly="readonly"/>
			</div>
		</div>
		<div class="form-row">
			<p class="form-label">姓名：</p>
			<div class="form-item">
				<input style="font-size: 12px" type="text" id="restuName" name="restuName" value="" readonly="readonly"/>
			</div>
		</div>
		<div class="form-row">
			<p class="form-label">答辩时间：</p>
            <div class="form-item" style="font-size: 12px">
              	<input type="text" id="replyTime" name="replyTime" value=""/>
              	<span class="form-icon fugue-2 calendar-day"></span>
            </div>
		</div>
	</div>
	<div id="replytime-setting" title="统一设置答辩时间">
		<div class="form-row">
			<p class="form-label">答辩时间：</p>
            <div class="form-item" style="font-size: 12px">
              	<input type="text" id="currentDate" name="currentDate" value=""/>
              	<span class="form-icon fugue-2 calendar-day"></span>
            </div>
		</div>
	</div>
</div>
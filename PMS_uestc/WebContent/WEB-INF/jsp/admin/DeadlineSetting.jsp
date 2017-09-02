<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<div class="content container_12">
	<form action = "<%=basePath%>/admin/updateDeadline.action" method="post">
		<div class="box grid_6" style="margin-left:350px">
			<div class="box-head">
				<h2>修改最后期限</h2>
			</div>
			
			<div class="box-content">
				<div class="form-row">
            		<label class="form-label">导师审核最后期限：</label>
            		<div class="form-item">
              			<input type="text" id="paperPassDeadline" name="paperPassDeadline" value="${paperPassDeadline}"/>
              			<span class="form-icon fugue-2 calendar-day"></span>
            		</div>
          		</div>
          		<div class="form-row">
            		<label class="form-label">盲审成绩录入期限：</label>
            		<div class="form-item">
              			<input type="text" id="blindJudgeDeadline" name="blindJudgeDeadline" value="${blindJudgeDeadline}"/>
              			<span class="form-icon fugue-2 calendar-day"></span>
            		</div>
          		</div>
          		<div class="form-row">
            		<label class="form-label">答辩成绩录入期限：</label>
            		<div class="form-item">
              			<input type="text" id="replyDeadline" name="replyDeadline" value="${replyDeadline}"/>
              			<span class="form-icon fugue-2 calendar-day"></span>
            		</div>
          		</div>
				<div class="form-row">
					<input class="button green" type="submit" value="确定" id="submitButton" style="float:right"/>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		</form>
</div>
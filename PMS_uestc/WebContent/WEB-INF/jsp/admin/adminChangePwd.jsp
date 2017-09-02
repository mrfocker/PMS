<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<div class="content container_12">
	<form action = "<%=basePath%>/pages/updatePwd.action" method="post">
		<div class="box grid_6" style="margin-left:350px">
			<div class="box-head">
				<h2>修改密码</h2>
			</div>
			
			<div class="box-content">
				<div class="form-row">
					<p class="form-label">用户名：</p>
					<div class="form-item">
						<input type="text" id="userId" name="userId" value="${admin.su_id}" readonly="readonly"/>
					</div>
				</div>
				<div class="form-row">
					<p class="form-label">身份证：</p>
					<div class="form-item">
						<input type="text" id="userIdNum" name="userIdNum"/>
						<div class="form-item" style="margin-top:10px">
							<span id = "userIdNumInfo"></span>
						</div>
					</div>
				</div>
				<div class="form-row">
					<p class="form-label">新密码：</p>
					<div class="form-item">
						<input type="password" id="userNewPwd" name="userNewPwd"/>
					</div>
				</div>
				<div class="form-row">
					<p class="form-label">确认密码：</p>
					<div class="form-item">
						<input type="password" id="checkNewPwd" name="checkNewPwd"/>
						<div class="form-item" style="margin-top:10px">
							<span id = "newPwdInfo"></span>
						</div>
					</div>
					<div class="form-item" style="margin-top:10px">
						<span id = "wrongInfo"></span>
					</div>
				</div>
				<div class="form-row">
					<input class="button green" type="submit" value="确定" id="formButton" style="float:right"/>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		</form>
</div>
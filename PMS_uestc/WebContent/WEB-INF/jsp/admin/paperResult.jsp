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
                <li><a href="#tabs-paperResult">导师审核结果</a></li>
                <li><a href="#tabs-blindResult">盲审结果</a></li>
                <li><a href="#tabs-replyResult">答辩结果</a></li>
            </ul>
            <div id="tabs-paperResult">
                <div class="content container_12" style="height:800px">
                    <div class="box grid_12">
                        <div class="box-content no-pad">
                            <table class="display" id="dtPaperResult">
                                <thead>
                                <tr>
                                    <th>学号</th>
                                    <th>姓名</th>
                                    <th>论文标题</th>
                                    <th>导师审核结果</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="paperResult" items="${paperResult}">
                                <tr class="odd gradeX" id="${paperResult.stu_id}">
                                    <td class="center">${paperResult.stu_id}</td>
                                    <td class="center">${paperResult.stu_name}</td>
                                    <td class="center">${paperResult.paper_title}</td>
                                    <td class="center">${paperResult.paper_ifPass}</td>
                                    <td align="center">
                                    	<p onclick="editPaperModal(${paperResult.stu_id})" class="silk pencil"></p>
                                    </td>
                                </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div id="paper-modal" title="修改成绩及状态">
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
					<p class="form-label">论文标题：</p>
					<div class="form-item">
						<input style="font-size: 12px" type="text" id="paperTitle" name="paperTitle" value="" readonly="readonly"/>
					</div>
				</div>
				<div class="form-row">
					<p class="form-label">审核结果：</p>
					<div class="form-item">
              			<select id="paperSelector" style="font-size: 12px">
                			<option value='通过'>通过</option>
                			<option value='不通过'>不通过</option>
                			<option value='修改'>修改</option>
              			</select>
					</div>
				</div>
            </div>
            <div id="tabs-blindResult">
                <div class="content container_12" style="height:800px">
                    <div class="box grid_12">
                        <div class="box-content no-pad">
                            <table class="display" id="dtBlindResult">
                                <thead>
                                <tr>
                                    <th>学号</th>
                                    <th>姓名</th>
                                    <th style="display:none;">教工号</th>
                                    <th>评审老师</th>
                                    <th>盲审成绩</th>
                                    <th>盲审结果</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="blindReslut" items="${blindReslut}">
                                <tr class="odd gradeX" id="${blindReslut.stu_id}${blindReslut.teacher_id}">
                                    <td class="center">${blindReslut.stu_id}</td>
                                    <td class="center">${blindReslut.stu_name}</td>
                                    <td class="center" style="display:none;">${blindReslut.teacher_id}</td>
                                    <td class="center">${blindReslut.teacher_name}</td>
                                    <td class="center">${blindReslut.teacher_Grade}</td>
                                    <td class="center">${blindReslut.teacher_Result}</td>
                                    <td align="center">
                                    	<p onclick="editBlindModal(${blindReslut.stu_id}${blindReslut.teacher_id})" class="silk pencil"></p>
                                    </td>
                                </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div id="blind-modal" title="修改成绩及状态">
            	<div class="form-row">
					<p class="form-label">学号：</p>
					<div class="form-item">
						<input style="font-size: 12px" type="text" id="bstuId" name="bstuId" value="" readonly="readonly"/>
					</div>
				</div>
				<div class="form-row">
					<p class="form-label">姓名：</p>
					<div class="form-item">
						<input style="font-size: 12px" type="text" id="bstuName" name="bstuName" value="" readonly="readonly"/>
					</div>
				</div>
				<div class="form-row" style="display:none">
					<p class="form-label">教工号：</p>
					<div class="form-item">
						<input style="font-size: 12px" type="text" id="teacherId" name="teacherId" value="" readonly="readonly"/>
					</div>
				</div>
				<div class="form-row">
					<p class="form-label">评审老师：</p>
					<div class="form-item">
						<input style="font-size: 12px" type="text" id="teacherName" name="teacherName" value="" readonly="readonly"/>
					</div>
				</div>
				<div class="form-row">
					<p class="form-label">盲审成绩：</p>
					<div class="form-item">
						<input style="font-size: 12px" type="text" id="teacherGrade" name="teacherGrade" value=""/>
					</div>
				</div>
				<div class="form-row">
					<p class="form-label">盲审结果：</p>
					<div class="form-item">
						<input style="font-size: 12px" type="text" id="teacherResult" name="teacherResult" value="" readonly="readonly"/>
					</div>
				</div>
            </div>
            <div id="tabs-replyResult">
                <div class="content container_12" style="height:800px">
                    <div class="box grid_12">
                        <div class="box-content no-pad">
                            <table class="display" id="dtReplyResult">
                                <thead>
                                <tr>
                                    <th>学号</th>
                                    <th>姓名</th>
                                    <th style="display:none;">答辩组号</th>
                                    <th style="display:none;">教工号</th>
                                    <th>答辩老师</th>
                                    <th>答辩成绩</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="replyReslut" items="${replyReslut}">
                                <tr class="odd gradeX" id="${replyReslut.stu_id}${replyReslut.group_id}${replyReslut.teacher_id}">
                                    <td class="center">${replyReslut.stu_id}</td>
                                    <td class="center">${replyReslut.stu_name}</td>
                                    <td class="center" style="display:none;">${replyReslut.group_id}</td>
                                    <td class="center" style="display:none;">${replyReslut.teacher_id}</td>
                                    <td class="center">${replyReslut.teacher_name}</td>
                                    <td class="center">${replyReslut.reply_grade}</td>
                                    <td align="center">
                                    	<p onclick="editReplyModal(${replyReslut.stu_id}${replyReslut.group_id}${replyReslut.teacher_id})" class="silk pencil"></p>
                                    </td>
                                </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div id="reply-modal" title="修改成绩及状态">
            	<div class="form-row">
					<p class="form-label">学号：</p>
					<div class="form-item">
						<input style="font-size: 12px" type="text" id="rstuId" name="rstuId" value="" readonly="readonly"/>
					</div>
				</div>
				<div class="form-row">
					<p class="form-label">姓名：</p>
					<div class="form-item">
						<input style="font-size: 12px" type="text" id="rstuName" name="rstuName" value="" readonly="readonly"/>
					</div>
				</div>
				<div class="form-row" style="display:none">
					<p class="form-label">答辩组号：</p>
					<div class="form-item">
						<input style="font-size: 12px" type="text" id="groupId" name="groupId" value="" readonly="readonly"/>
					</div>
				</div>
				<div class="form-row" style="display:none">
					<p class="form-label">教工号：</p>
					<div class="form-item">
						<input style="font-size: 12px" type="text" id="rteacherId" name="rteacherId" value="" readonly="readonly"/>
					</div>
				</div>
				<div class="form-row">
					<p class="form-label">答辩老师：</p>
					<div class="form-item">
						<input style="font-size: 12px" type="text" id="rteacherName" name="rteacherName" value="" readonly="readonly"/>
					</div>
				</div>
				<div class="form-row">
					<p class="form-label">答辩成绩：</p>
					<div class="form-item">
						<input style="font-size: 12px" type="text" id="replyGrade" name="replyGrade" value=""/>
					</div>
				</div>
            </div>
        </div>
    </div>
</div>
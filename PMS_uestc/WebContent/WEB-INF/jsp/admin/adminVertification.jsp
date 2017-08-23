<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<div class="content container_12">
    <input type="button" id="open-modal-dialog" class="button green" value="批量下载" style="float: right;margin-bottom: 20px;margin-right: 50px">
    <input type="button" onclick="departVertify()" class="button grey" value="保存" style="float: right;margin-bottom: 20px">
    <div id="modal-dialog" title="批量下载论文">
        <div class="form-row">
            <label class="form-label">请选择下载类别：</label>
            <div class="form-item">
                <select style="font-size: 12px">
                    <option value='option1'>类别1</option>
                    <option value='option2'>类别2</option>
                    <option value='option3'>类别3</option>
                    <option value='option4'>类别4</option>
                </select>
            </div>
        </div>
    </div>
    <div class="box grid_12">
        <div class="box-head"><h2>论文审核</h2></div>
        <div class="box-content no-pad">
            <table class="display" id="dtVertify">
                <thead>
                <tr>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>论文标题</th>
                    <th>下载</th>
                    <th>审核状态</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="stupaper" items="${stupaper}">
                <tr class="odd gradeX">
                    <td class="center">${stupaper.stu_id}</td>
                    <td class="center">${stupaper.stu_name}</td>
                    <td class="center">${stupaper.paper_title}</td>
                    <td class="center"><a href="#"><img src="<%=basePath%>/img/icons/basic/down.png" alt="" /> 下载</a></td>
                    <c:if test="${stupaper.paper_ifPass == '通过' && stupaper.paper_ifAdvice == 1}">
                    <td class="center">
              			<select id="${stupaper.stu_id}" style="font-size: 12px">
                			<option value='通过'>通过</option>
                			<option value='不通过'>不通过</option>
                			<option value='修改'>修改</option>
              			</select>                    
              		</td>
                    </c:if>
                    <c:if test="${stupaper.paper_ifPass != '通过' || stupaper.paper_idAdvice != 1}">
                    <td class="center">无法审核</td>
                    </c:if>
                </tr>
                </c:forEach>
              </tbody>
            </table>
        </div>
    </div>
</div>
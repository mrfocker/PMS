<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>Adminity - Dashboard</title>
  <link rel="shortcut icon" href="favicon.gif">
  <!---CSS Files-->
  <link rel="stylesheet" href="css/master.css">
  <link rel="stylesheet" href="css/tables.css">
  <!---jQuery Files-->
  <script src="js/jquery-1.7.1.min.js"></script>
  <script src="js/jquery-ui-1.8.17.min.js"></script>
  <script src="js/styler.js"></script>
  <script src="js/jquery.tipTip.js"></script>
  <script src="js/colorpicker.js"></script>
  <script src="js/sticky.full.js"></script>
  <script src="js/global.js"></script>
  <script src="js/flot/jquery.flot.min.js"></script>
  <script src="js/flot/jquery.flot.resize.min.js"></script>
  <script src="js/jquery.dataTables.min.js"></script>
  <!---Fonts-->
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Ubuntu:500' rel='stylesheet' type='text/css'>
  <!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
  <!--[if lte IE 8]>
  <script language="javascript" type="text/javascript" src="js/flot/excanvas.min.js"></script>
  <![endif]-->
<title>分配老师</title>
</head>
<body>

    <table>
     <thead>
            <tr>
              <th>选择</th>
              <th>老师ID</th>
              <th>老师姓名</th>
              <th>老师总计</th>
              <th>老师上限</th>
              <th>老师方向1</th>
              <th>老师方向2</th>
              <th>老师方向3</th>
             
            </tr>
          </thead>
     <tbody>
   
     
 		<c:forEach items = "${list}" var = "item">
           <tr>
           	  <td><input TYPE="checkbox" name="" VALUE=""> <BR></td>
              <td>${item.getTeacher_id() }</td> 	
              <td>${item.getTeacher_name() }</td>
              <td>${item.getTeacher_count() }</td>
              <td>${item.getTeacher_limit() }</td>
              <td>${item.getTeacher_researchOne() }</td>
              <td>${item.getTeacher_researchTwo() }</td>
              <td>${item.getTeacher_researchThree() }</td>
            </tr>
		</c:forEach>
		<input  type="submit" onclick="submitChoose()" value="提交" />
		<input 	type="reset" value="取消" />
		</tbody>
     </table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
-->
<!doctype html>
<html>


<head>
<meta charset="utf-8">
<title>Adminity - Tables</title>
<link rel="shortcut icon" href="favicon.gif">
<!---CSS Files-->
<link rel="stylesheet" href="css/master.css">
<link rel="stylesheet" href="css/tables.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<!---jQuery Files-->
<script src="js/jquery-1.7.1.min.js"></script>
<script src="js/jquery-ui-1.8.17.min.js"></script>
<script src="js/styler.js"></script>
<script src="js/jquery.tipTip.js"></script>
<script src="js/colorpicker.js"></script>
<script src="js/sticky.full.js"></script>
<script src="js/global.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/bootstrap.js"></script>
<!---Fonts-->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700'
	rel='stylesheet' type='text/css'>
<!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
<!--[if lte IE 8]>
  <script language="javascript" type="text/javascript" src="js/flot/excanvas.min.js"></script>
  <![endif]-->

<!-- 点击分配传入后台Paper_stuId,返回能够选择的老师。弹出dialog显示 -->

<script type="text/javascript">
  	$(function(){
  		$(".btn_distribute").on("click",function(){
  			
  			var paper_stuId=$(this).parent().parent().find(".disPaper_stuId").text();
  			$.ajax({
  				type:'post',
  				url:"${pageContext.request.contextPath }/pages/Testdistribute",
  				contentType:'application/text;charset=utf-8',
  				data:paper_stuId,
  				success:function(data){			
  					$("#Data").empty();//先清空tbody  
  		            var strHTML = "";  
  		            $.each(data,function(InfoIndex,Info){//遍历json里的数据  
  		            	InfoIndex++;
  		                strHTML += "<tr>";  
  		                strHTML +="<td><input type=\"checkbox\" name=\"chooseTea\"/></td>";
  		                strHTML += "<td>"+InfoIndex+"</td>";  
		                strHTML += "<td>"+Info["paper_stuId"]+"</td>";  
  		                strHTML += "<td>"+Info["teacher_id"]+"</td>";  
  		                strHTML += "<td>"+Info["teacher_name"]+"</td>";  	
  		                strHTML += "<td>"+Info["teacher_count"]+"</td>";  
		                strHTML += "<td>"+Info["teacher_limit"]+"</td>";  	
		                strHTML += "<td>"+Info["teacher_researchOne"]+"</td>";  	
  		                strHTML += "<td>"+Info["teacher_researchTwo"]+"</td>";  
		                strHTML += "<td>"+Info["teacher_researchThree"]+"</td>";  	
  		                strHTML += "</tr>";  
  		            });  
  		            $("#Data").html(strHTML);//显示到tbody中  
  		            
  					$("#dialogTable").dialog({
  						autoOpen:true,
  						modal:true,
  					},"open");          
  				}				
  			});
  			
  		});
  	})
  
  </script>

<script type="text/javascript">
  $(function(){
  	$("#upchoose").on("click",function(){
  		alert("run btn");
  		
  		var tot=0;
  		var check = document.getElementsByName("chooseTea");
  		for(var i = 0; i<check.length; i++){
  		  if(check[i].checked == true){
  		    tot=tot+1;
  		  }
  		}
  		if (tot!=2){
  			alert("选择出错,tot="+tot);
  			return false;
  		}
 		var str=[];
  		$("#table_choose").find(":checkbox:checked").each(function(){
  			var p_stuId=$(this).parent().next().next().text();
  			var c_teaId=$(this).parent().next().next().next().text();
  			str.push({
  				paper_stuId:p_stuId,
  				choose_teaId:c_teaId
  			});
 
  			});
  		
  		str=JSON.stringify(str);
  		
  		alert(str);
  		//将封装的str[]用ajax传递回后台
  		$.ajax({
  			type:'post',
			url:"${pageContext.request.contextPath }/pages/getchoose",
			contentType:'application/json;charset=utf-8',
			data:str,
			success:function(data){
				alert(data);  	
			}
			
  		})
  		
  	})
  			
  })
  </script>
</head>
<body>

	<!--- HEADER -->

	<div class="header">
		<a href="dashboard.html"><img src="img/logo.png" alt="Logo" /></a>
		<div class="styler">
			<ul class="styler-show">
				<li><div id="colorSelector-top-bar"></div></li>
				<li><div id="colorSelector-box-head"></div></li>
			</ul>
		</div>
	</div>

	<div class="top-bar">
		<ul id="nav">
			<li id="user-panel"><img src="img/nav/usr-avatar.jpg"
				id="usr-avatar" alt="" />
				<div id="usr-info">
					<p id="usr-name">Welcome back, Michael.</p>
					<p id="usr-notif">
						You have 6 notifications. <a href="#">View</a>
					</p>
					<p>
						<a href="#">Preferences</a><a href="#">Profile</a><a
							href="index.html">Log out</a>
					</p>
				</div></li>
			<li>
				<ul id="top-nav">
					<li class="nav-item"><a href="dashboard.html"><img
							src="../img/nav/dash.png" alt="" />
						<p>Dashboard</p></a></li>
					<li class="nav-item"><a href="analytics.html"><img
							src="../img/nav/anlt.png" alt="" />
						<p>Analytics</p></a></li>
					<li class="nav-item"><a href="#"><img
							src="img/nav/tb-active.png" alt="" />
						<p>Tables</p></a></li>
					<li class="nav-item"><a href="calendar.html"><img
							src="img/nav/cal.png" alt="" />
						<p>Calendar</p></a></li>
					<li class="nav-item"><a href="widgets.html"><img
							src="img/nav/widgets.png" alt="" />
						<p>Widgets</p></a></li>
					<li class="nav-item"><a href="grid.html"><img
							src="img/nav/grid.png" alt="" />
						<p>Grid</p></a>
						<ul class="sub-nav">
							<li><a href="#">12 Columns</a></li>
							<li><a href="#">16 Columns</a></li>
						</ul></li>
					<li class="nav-item"><a href="filemanager.html"><img
							src="img/nav/flm.png" alt="" />
						<p>File Manager</p></a></li>
					<li class="nav-item"><a href="gallery.html"><img
							src="img/nav/gal.png" alt="" />
						<p>Gallery</p></a></li>
					<li class="nav-item"><a href="icons.html"><img
							src="img/nav/icn.png" alt="" />
						<p>Icons</p></a></li>
					<li class="nav-item"><a href="#"><img
							src="img/nav/err.png" alt="" />
						<p>Error Pages</p></a>
						<ul class="sub-nav">
							<li><a href="403.html">403 Page</a></li>
							<li><a href="404.html">404 Page</a></li>
							<li><a href="503.html">503 Page</a></li>
						</ul></li>
					<li class="nav-item"><a href="typography.html"><img
							src="img/nav/typ.png" alt="" />
						<p>Typography</p></a></li>
				</ul>
			</li>
		</ul>
	</div>

	<!--- CONTENT AREA -->
	<!-- 

   -->





	<div id="dialogTable" title="信息" style="display: none;">
		<p>弹出对话框</p>
		<table id="table_choose">

			<tr>
				<th>选择</th>
				<th>序号</th>
				<th>学生学号</th>
				<th>老师ID</th>
				<th>老师姓名</th>
				<th>老师总计</th>
				<th>老师上限</th>
				<th>老师方向1</th>
				<th>老师方向2</th>
				<th>老师方向3</th>
			</tr>
			<tbody id="Data"></tbody>
		</table>

		<button id="upchoose">确定</button>
	</div>


	<div class="content container_12">
		<div class="box grid_12">
			<div class="box-head">
				<h2>毕业论文盲审分配信息</h2>
			</div>
			<div class="box-content no-pad">
				<table class="display">
					<thead>
						<tr>
							<th>学号</th>
							<th>论文题目</th>
							<th>研究方向1</th>
							<th>研究方向2</th>
							<th>盲审老师1</th>
							<th>盲审老师2</th>
							<th>分配</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="item">
							<tr class="trye">
								<td class="disPaper_stuId">${item.getPaper_stuId() }</td>
								<td>${item.getPaper_title() }</td>
								<td>${item.getPaper_researchOne() }</td>
								<td>${item.getPaper_researchTwo() }</td>
								<td class="teacher_One">${item.getJudge_teacherIdOne()}</td>
								<td class="teacher_two">${item.getJudge_teacherIdTwo()}</td>
								<td><input type="button" class="btn_distribute" value="分配" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>



	<div class="footer">
		<p>Powered by Adminity Administration Interface</p>
	</div>


	<script> /* SCRIPTS */
  $(function () {
    $('#dt1').dataTable( {
        "bJQueryUI": true   
    });
    $('#dt2').dataTable( {
        "bJQueryUI": true     
    });
    $('#dt3').dataTable( {
        "bJQueryUI": true,
        "sPaginationType": "full_numbers"   
    }); /* For the data tables */
  });
</script>


</body>
</html>
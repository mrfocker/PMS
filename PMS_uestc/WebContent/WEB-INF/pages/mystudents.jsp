<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
  <meta charset="utf-8">
  <title>Adminity - Tables</title>
  <link rel="shortcut icon" href="favicon.gif">
  <!---CSS Files-->
  <link rel="stylesheet" href="css/master.css">
  <link rel="stylesheet" href="css/tables.css">
  <!---jQuery Files-->
  <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
  <!--  <script src="js/jquery-1.7.1.min.js"></script> -->
  <script src="js/jquery-ui-1.8.17.min.js"></script>
  <script src="js/styler.js"></script>
  <script src="js/jquery.tipTip.js"></script>
  <script src="js/colorpicker.js"></script>
  <script src="js/sticky.full.js"></script>
  <script src="js/global.js"></script>
  <script src="js/jquery.dataTables.min.js"></script>
  <!--bootstrap Files-->
  <link rel="stylesheet" href="bootstrap-fileinput/css/fileinput.min.css">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="bootstrap-fileinput/js/fileinput.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <!---Fonts-->
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'>
  <!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
  <!--[if lte IE 8]>
  <script language="javascript" type="text/javascript" src="js/flot/excanvas.min.js"></script>
  <![endif]-->
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
        <li id="user-panel">
          <img src="img/nav/usr-avatar.jpg" id="usr-avatar" alt="" />
          <div id="usr-info">
            <p id="usr-name">Welcome back, Michael.</p>
            <p id="usr-notif">You have 6 notifications. <a href="#">View</a></p>
            <p><a href="#">Preferences</a><a href="#">Profile</a><a href="index.html">Log out</a></p>
          </div>
        </li>
        <li>
        <ul id="top-nav">
         <li class="nav-item">
           <a href="dashboard.html"><img src="../img/nav/dash.png" alt="" /><p>Dashboard</p></a>
         </li>
         <li class="nav-item">
           <a href="analytics.html"><img src="../img/nav/anlt.png" alt="" /><p>Analytics</p></a>
         </li>
         <li class="nav-item">
           <a href="#"><img src="img/nav/tb-active.png" alt="" /><p>Tables</p></a>
         </li>
         <li class="nav-item">
           <a href="calendar.html"><img src="img/nav/cal.png" alt="" /><p>Calendar</p></a>
         </li>
         <li class="nav-item">
           <a href="widgets.html"><img src="img/nav/widgets.png" alt="" /><p>Widgets</p></a>
         </li>
         <li class="nav-item">
           <a href="grid.html"><img src="img/nav/grid.png" alt="" /><p>Grid</p></a>
           <ul class="sub-nav">
            <li><a href="#">12 Columns</a></li>
            <li><a href="#">16 Columns</a></li>
          </ul>
         </li>
         <li class="nav-item">
           <a href="filemanager.html"><img src="img/nav/flm.png" alt="" /><p>File Manager</p></a>
         </li>
         <li class="nav-item">
           <a href="gallery.html"><img src="img/nav/gal.png" alt="" /><p>Gallery</p></a>
         </li>
         <li class="nav-item">
           <a href="icons.html"><img src="img/nav/icn.png" alt="" /><p>Icons</p></a>
         </li>
         <li class="nav-item">
           <a href="#"><img src="img/nav/err.png" alt="" /><p>Error Pages</p></a>
           <ul class="sub-nav">
            <li><a href="403.html">403 Page</a></li>
            <li><a href="404.html">404 Page</a></li>
            <li><a href="503.html">503 Page</a></li>
          </ul>
         </li>
         <li class="nav-item">
           <a href="typography.html"><img src="img/nav/typ.png" alt="" /><p>Typography</p></a>
         </li>
       </ul>
      </li>
     </ul>
  </div> 

  <!--- CONTENT AREA -->

  <div class="content container_12">
      <div class="box grid_12">
        <div class="box-head"><h2>毕业论文信息</h2></div>
        <div class="box-content no-pad">
          <table class="display">
          <thead>
            <tr>
              <th style="text-align:center;">学生姓名</th>
              <th style="text-align:center;">学生学号</th>
              <th style="text-align:center;">论文题目</th>
              <th style="text-align:center;">研究方向1</th>
              <th style="text-align:center;">研究方向2</th>
              <th style="text-align:center;">研究方向3</th>
              <th style="text-align:center;">论文下载</th>
              <th style="text-align:center;">导师审核</th>
            </tr>
          </thead>
          <tbody>
           <c:forEach items="${mystulist }" var="item">
            <tr class="odd gradeX">
              <td style="text-align:center;">${item.stu_name}</td>
              <td style="text-align:center;">${item.stu_id}</td>
              <td style="text-align:center;">${item.paper_title}</td>
              <td style="text-align:center;">${item.paper_researchOne}</td>
              <td style="text-align:center;">${item.paper_researchTwo}</td>
              <td style="text-align:center;">${item.paper_researchThree}</td>
              <td style="text-align:center;"><button>下载</button></td>
              <td style="text-align:center;"><button class="fa fa-child" data-toggle="modal" data-target="#myModal1" onclick='show_judgedetails(${item.paper_stuId});'>评审</button></td> 
            </tr>
           </c:forEach>
          </tbody>
         </table>
        </div>
      </div>
  </div>
  
  <!-- 模态框（Modal） -->
<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidde="true">
          <div class="modal-dialog">
            <div class="col-md-11 col-xs-22">                      
             <div class="modal-content">
                <div class="x_panel">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                     &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                    	导师审核
                    </h4>
                </div>
                  <div class="x_content">
                    <br />
                    <form class="form-horizontal form-label-left">
                    
                      <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-10">审核结果<span class="required"></span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                           <select name='organization' class="form-control" id ="result_select" onchange="getvalue(this)">
                             <option value="0"></option>
                             <option value='1'>通过</option>
                             <option value='2'>修改</option>
                             <option value='3'>不通过</option>
                           </select>
                        </div>
                      </div>

                      <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-10">修改意见 <span class="required"></span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                          <textarea class="form-control" rows="10" placeholder='' id='return_cont'></textarea>
                        </div>
                      </div>
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                         <div class="modal-footer" id = "submit_result">
                         
                          <!-- <button type="button" class="btn btn-primary" onclick="do_blindjudge(val);">提交</button> -->
                      
                          <!-- <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> -->
                         </div>
                        </div>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
              </div>
             </div>
         </div>
 <!-- 模态框（Modal）完 -->     

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
<!-- <script type = "text/javascript">
function requestJson(){
	
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath }/pages/requestJson',
		contentType: 'application/json;charset=UTF-8',
		success: function(data){
	          
	          data = $.parseJSON(data);
	          console.log("ok");
	          console.log(data);},
	         
	    error: function(data){
	          console.log('failed')
	            }
		
	});
	
}
</script> -->

<!--将导师审核自己学生论文得信息映射倒模态框-->
<script type="text/javascript">
function show_judgedetails(val){
	var str = {paper_stuId:val};
	str = JSON.stringify(str);
	$.ajax({
	      url:'${pageContext.request.contextPath }/pages/teacherQueryAdvise',
	      type:'post',
	      contentType:'application/json;charset=utf-8',
	      data:str,
	      success: function(data){
	          console.log(data);
	          console.log("ok");
	          
	          $('#score').val(data.teacher_Grade);
	          $('#return_cont').val(data.paper_advise);
	          $("#submit_result").empty();
	          $("#submit_result").append("<button type='button' class='btn btn-primary' onclick='+do_teacherjudge("+val+");'>提交</button>");
	          $("#submit_result").append("<button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>");
	          $("#result_select").empty();
	          $("#result_select").append("<option value='"+data.result_code+"'>"+data.paper_ifPass+"</option>");
	          $("#result_select").append("<option value='1'>通过</option>");
	          $("#result_select").append("<option value='2'>修改</option>");
	          $("#result_select").append("<option value='3'>不通过</option>");
	          },
	         
	    error: function(data){
	          console.log('failed')
	            }
		
	    });
}
</script>

<!--导师提交对自己学生论文审核的结果-->
<script type="text/javascript">
  function do_teacherjudge(val1){
    var return_cont = $('#return_cont').val();
    var select_val = $('#result_select').val();
    var str = {paper_stuId:val1,paper_advise:return_cont,result_code:select_val};
    /* var str = []; */
    /* str.push({teacher_Grade:score,teacher_description:return_cont}); */
    str = JSON.stringify(str);
    console.log(str);
    $.ajax({
      url:'${pageContext.request.contextPath }/pages/submitteacheradvise',
      type:'post',
      contentType:'application/json;charset=utf-8',
      data:str,
      /* data:'{teacher_Grade:score,teacher_description:return_cont}', */
      success: function(){      
          console.log("ok");
          alert("提交审核成功")
          },
         
    error: function(data){
          console.log('failed');
          alert("提交审核失败")
            }
	
    });
  }
</script>
</body>
</html>
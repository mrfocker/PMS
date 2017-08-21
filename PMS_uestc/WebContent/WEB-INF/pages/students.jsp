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
  <!--jquery流程图css文件-->
  <link rel="stylesheet" href="css/stu_progress.css">
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
  <!--jquery流程图JS文件-->
  <!-- <script src="js/stuinfo.js"></script> -->
   <script src="js/stu_progress.js"></script>
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
<body onload = "load()">

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

    <div class="formbox">
            <div class="flow_steps">
                <ul>
                    <li id="grxx" class="current">提交论文</li>
                    <li id="zjxx">导师审核</li>
                    <li id="qzxx">学院审核</li>
                    <li id="lwcc">论文查重</li>
                    <li id="lwms">论文盲审</li>
                    <li id="lwdb">论文答辩</li>
                    <li id="qzfs" class="last">学位授予</li>
                </ul>
            </div>
    <!--论文信息-->
    <div class="content container_12">
      <div class="box grid_12">
        <div class="box-head"><h2>毕业论文信息</h2></div>
        <div class="box-content no-pad">
          <table class="display">
          <thead>
            <tr id = "paperlistname">
              <th>学生姓名</th>
              <th>学生学号</th>
              <th>论文题目</th>
              <th>研究方向1</th>
              <th>研究方向2</th>
              <th>研究方向3</th>
              <th>上传论文</th>
            </tr>
          </thead>
          <tbody>
           <c:forEach items="${studentPaperInfoList}" var="item">
            <tr class="odd gradeX" id = "paperlist">
              <td>${item.stu_name}</td>
              <td>${item.stu_id}</td>
              <td>${item.paper_title}</td>
              <td>${item.paper_researchOne}</td>
              <td>${item.paper_researchTwo}</td>
              <td>${item.paper_researchThree}</td>
              <td><button>上传</button></td>
            </tr>
           </c:forEach>
          </tbody>
         </table>
        </div>
      </div>
  </div>
   <!--论文信息完-->
            <div class="formcon">
                <div id="one">
                    <table align="center">
                        <tr>
                            <td></td>
                            <td><button type="button" onclick="one()">提交</button></td>
                        </tr>
                    </table>
                </div>
                <div id="two" style="display:none">
                    <table align="center">
                        <tr id= "two1">
                            <!-- <td>您的论文需要修改，请点击“确认”按钮查看导师意见并重新上传修改后的论文！</td> 
                            <td><button type="button" onclick="two_one()">确认</button></td> -->
                        </tr>
                    </table>
                </div>
                <div id="three" style="display:none">
                    <table align="center">
                        <tr>
                            <td></td> 
                            <td><button type="button" onclick="three()">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" onclick="retwo()">上一步</button></td>
                        </tr>
                    </table>
                </div>
                <div id="four" style="display:none">
                    <table align="center">
                        <tr>
                            <td></td> 
                            <td><button type="button" onclick="">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" onclick="rethree()">上一步</button></td>
                        </tr>
                    </table>
                </div>
            </div>
              <div id="five" style="display:none">
                    <table align="center">
                        <tr>
                            <td></td> 
                            <td><button type="button" onclick="">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" onclick="refour()">上一步</button></td>
                        </tr>
                    </table>
                </div>
                <div id="six" style="display:none">
                    <table align="center">
                        <tr>
                            <td></td> 
                            <td><button type="button" onclick="">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" onclick="refive()">上一步</button></td>
                        </tr>
                    </table>
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
                        <label class="control-label col-md-2 col-sm-2 col-xs-10">审核结果<span class="required">*</span>
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
                        <label class="control-label col-md-2 col-sm-2 col-xs-10">修改意见 <span class="required">*</span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                          <textarea class="form-control" rows="5" placeholder='' id='return_cont'></textarea>
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

<!--根据论文评审信息更新论文流程栏目-->
<script type="text/javascript">
function load(){
	var str = {stu_id:"201522220299"};
	str = JSON.stringify(str);
	console.log(str);
	$.ajax({
	      url:'${pageContext.request.contextPath }/pages/getPaperAllInfo',
	      type:'post',
	      contentType:'application/json;charset=utf-8',
	      data:str,
	      /* data:'{teacher_Grade:score,teacher_description:return_cont}', */
	      success: function(data){      
	    	  console.log(data);
	          console.log("ok");
	       
	       /*提交论文*/
	       if(data.paper_ifSubmit == 1 && (data.file_id != null) && (data.paper_ifPass == null || data.paper_ifPass == "" )){
	    	      console.log("go to 2");
	              step2(data);
	          	}
	       /*导师审核ok*/
	       if(data.paper_ifSubmit == 0 && data.paper_ifPass == "修改" ){
	    	      console.log("2 go to 1");
	    	      step2(data);
	    	      $("#two1").append("<td>您的论文需要修改，请点击“确认”按钮查看导师意见并重新上传修改后的论文！</td> ");
	    	      /*添加确认按钮,回到第一步点击以后出发一个AJAX路由重新从后台拉数据*/
	    	      $("#two1").append("<button type='button' onclick='two_one();'>确认</button>");
	    	   	  
	       }
	       if(data.paper_ifSubmit == 0 && data.paper_ifPass == "不通过" ){
	    	      console.log("wait in 2");
	    	   	  step2(data);
	    	   	  /*不通过的原因*/
	       }
	       /*学院审核*/
	       if(data.paper_ifSubmit == 1 && data.paper_ifPass == "通过" && (data.paper_departPass == null || data.paper_departPass == "")){
	    	      console.log("go to 3");
	    	   	  step3(data);
	       }
	       if(data.paper_ifSubmit == 0 && data.paper_departPass == "修改"){
	    	      console.log("3 go to 1");
	    	   	  step1(data);
	       }
	       if(data.paper_ifSubmit == 0 && data.paper_departPass == "不通过"){
	    	      console.log("wait in 3");
	    	   	  step3(data);
	    	   	/*不通过的原因*/
	       }
	       /*论文查重*/
	       if(data.paper_ifSubmit == 1 && data.paper_departPass == "通过" && (data.paper_ifPaperRepetitiveRatePass == null || data.paper_ifPaperRepetitiveRatePass == "")){
	    	      console.log("go to 4");
	    	      step4(data);
	       }
	       if(data.paper_ifSubmit == 0 && data.Paper_ifPaperRepetitiveRatePass == "修改"){
	    	      console.log("4 go to 1");
	    	      step1(data);
	       }
	       if(data.paper_ifSubmit == 0 && data.Paper_ifPaperRepetitiveRatePass == "修改"){
	    	      console.log("wait in 4");
	    	      step4(data);
	    	      /*不通过的原因*/
	       }
	       /*论文盲审*/
	       if(data.paper_ifSubmit == 1 && data.paper_ifPaperRepetitiveRatePass == "通过" && (data.teacher_Result == null || data.teacher_Result == "")){
	    	      console.log("go to 5");
	    	      step5(data);
	       }
	       if(data.paper_ifSubmit == 1 && data.paper_ifPaperRepetitiveRatePass == "不通过" && (data.teacher_Result == null || data.teacher_Result == "")){
	    	      console.log("wait in 5");
	    	      step5(data);
	    	      /*不通过的原因*/
	       }
	       /*论文答辩*/
	       if(data.paper_ifSubmit == 1 && data.teacher_Result == "通过" && (data.reply_result == null || data.reply_result == "")){
	    	      console.log("go to 6");
	    	      step6(data);
	       }
	       if(data.paper_ifSubmit == 1 && data.teacher_Result == "不通过" && (data.reply_result == null || data.reply_result == "")){
	    	      console.log("wait in 6");
	    	      step6(data);
	    	      /*不通过的原因*/
	       }
	       /*学位授予*/
	       if(data.paper_ifSubmit == 1 && data.reply_result == "通过" && (data.stu_ifdegree == null || data.stu_ifdegree == "")){
	    	   	  console.log("go to 7");
	    	   	  step7(data);
	       }
	       if(data.paper_ifSubmit == 1 && data.reply_result == "不通过"){
	    	   	  console.log("wait in 7");
	    	   	  step7(data);
	    	   	  /*不通过原因*/
	       }
	          },
	      
	         
	    error: function(data){
	          console.log('failed');
	          alert("提交审核失败")
	            }
		
	    });
}

function two_one(val){
	
	var str = {Stu_id:val};
	str = JSON.stringify(str);
	$.ajax({
	      url:'${pageContext.request.contextPath }/pages/requeryPaperInfo',
	      type:'post',
	      contentType:'application/json;charset=utf-8',
	      data:str,
	      success: function(data){
	    	  
	          console.log("two_one ok");
	          
	          $("#one").show();
	          $("#two").hide();
	          $("#grxx").attr("class","current");
	          $("#zjxx").attr("class","");
	          
	          $("#paperlistname").empty();
	          $("#paperlistname").append("<th>学生姓名</th>");
	          $("#paperlistname").append("<th>学生学号</th>");
	          $("#paperlistname").append("<th>论文题目</th>");
	          $("#paperlistname").append("<th>研究方向一</th>");
	          $("#paperlistname").append("<th>研究方向二</th>");
	          $("#paperlistname").append("<th>研究方向三</th>");
	          $("#paperlistname").append("<th>导师审核</th>");
	      	  $("#paperlistname").append("<th>修改意见</th>");
	          $("#paperlistname").append("<th>上传论文</th>");
	          
	          $("#paperlist").empty();
	          $("#paperlist").append("<td>"+data.stu_name+"</td>");
	          $("#paperlist").append("<td>"+data.stu_id+"</td>");
	          $("#paperlist").append("<td>"+data.paper_title+"</td>");
	          $("#paperlist").append("<td>"+data.paper_researchOne+"</td>");
	          $("#paperlist").append("<td>"+data.paper_researchTwo+"</td>");
	          $("#paperlist").append("<td>"+data.paper_researchThree+"</td>");
	          $("#paperlist").append("<td>"+data.paper_ifPass+"</td>");
	          $("#paperlist").append("<button class='fa fa-child' data-toggle='modal' data-target='#myModal1' onclick='show_judgedetails("+data.stu_id+");'>评审</button></td>");
	         // $("#paperlist").append("<td>"+data.paper_advise+"</td>");
	          $("#paperlist").append("<td><button>上传</button></td>");	          
	          },
	         
	    error: function(data){
	          console.log('failed');
	          alert("提交审核失败")
	            }
		
	    });
}

function step1(data){
	
	$("#one").show();
    $("#two").hide();
    $("#grxx").attr("class","current");
    $("#zjxx").attr("class","");
    
    $("#paperlistname").empty();
    $("#paperlistname").append("<th>学生姓名</th>");
    $("#paperlistname").append("<th>学生学号</th>");
    $("#paperlistname").append("<th>论文题目</th>");
    $("#paperlistname").append("<th>研究方向一</th>");
    $("#paperlistname").append("<th>研究方向二</th>");
    $("#paperlistname").append("<th>研究方向三</th>");
    $("#paperlistname").append("<th>上传论文</th>");
    
    $("#paperlist").empty();
    $("#paperlist").append("<td>"+data.stu_name+"</td>");
    $("#paperlist").append("<td>"+data.stu_Id+"</td>");
    $("#paperlist").append("<td>"+data.paper_title+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchOne+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchTwo+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchThree+"</td>");
    $("#paperlist").append("<td><button>上传</button></td>")
    
}

function step2(data){
	$("#one").hide();
    $("#two").show();
    $("#grxx").attr("class","current_prev");
    $("#zjxx").attr("class","current");
    
    $("#paperlistname").empty();
    $("#paperlistname").append("<th>学生姓名</th>");
    $("#paperlistname").append("<th>学生学号</th>");
    $("#paperlistname").append("<th>论文题目</th>");
    $("#paperlistname").append("<th>研究方向一</th>");
    $("#paperlistname").append("<th>研究方向二</th>");
    $("#paperlistname").append("<th>研究方向三</th>");
    $("#paperlistname").append("<th>导师评审</th>");
    
    $("#paperlist").empty();
    $("#paperlist").append("<td>"+data.stu_name+"</td>");
    $("#paperlist").append("<td>"+data.stu_Id+"</td>");
    $("#paperlist").append("<td>"+data.paper_title+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchOne+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchTwo+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchThree+"</td>");
    $("#paperlist").append("<td>"+data.paper_ifPass+"</td>")
	
}

function step3(data){
	
	 $("#two").hide();
     $("#three").show();
     $("#grxx").attr("class","done");
     $("#zjxx").attr("class","current_prev");
     $("#qzxx").attr("class","current");
     
     $("#paperlistname").empty();
     $("#paperlistname").append("<th>学生姓名</th>");
     $("#paperlistname").append("<th>学生学号</th>");
     $("#paperlistname").append("<th>研究方向一</th>");
     $("#paperlistname").append("<th>研究方向二</th>");
     $("#paperlistname").append("<th>研究方向三</th>");
     $("#paperlistname").append("<th>学院评审</th>");
     
     $("#paperlist").empty();
     $("#paperlist").append("<td>"+data.stu_name+"</td>");
     $("#paperlist").append("<td>"+data.stu_Id+"</td>");
     $("#paperlist").append("<td>"+data.paper_researchOne+"</td>");
     $("#paperlist").append("<td>"+data.paper_researchTwo+"</td>");
     $("#paperlist").append("<td>"+data.paper_researchThree+"</td>");
     $("#paperlist").append("<td>"+data.paper_departPass+"</td>")
}

function step4(data){
	
	$("#three").hide();
    $("#four").show();
    $("#grxx").attr("class","done");
    $("#zjxx").attr("class","done");
    $("#qzxx").attr("class","current_prev");
    $("#lwcc").attr("class","current");
    
    $("#paperlistname").empty();
    $("#paperlistname").append("<th>学生姓名</th>");
    $("#paperlistname").append("<th>学生学号</th>");
    $("#paperlistname").append("<th>研究方向一</th>");
    $("#paperlistname").append("<th>研究方向二</th>");
    $("#paperlistname").append("<th>研究方向三</th>");
    $("#paperlistname").append("<th>全篇重复率</th>");
    $("#paperlistname").append("<th>单章重复率</th>");
    
    $("#paperlist").empty();
    $("#paperlist").append("<td>"+data.stu_name+"</td>");
    $("#paperlist").append("<td>"+data.stu_Id+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchOne+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchTwo+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchThree+"</td>");
    $("#paperlist").append("<td>"+data.paper_repetitiveRateAll+"</td>")
    $("#paperlist").append("<td>"+data.paper_repetitiveRateSingle+"</td>")
}

function step5(data){
	
	$("#four").hide();
    $("#five").show();
	
    $("#grxx").attr("class","done");
    $("#zjxx").attr("class","done");
    $("#qzxx").attr("class","done");
    $("#lwcc").attr("class","current_prev");
    $("#lwms").attr("class","current");
}

function step6(data){
	
	$("#five").hide();
    $("#six").show();
	
    $("#grxx").attr("class","done");
    $("#zjxx").attr("class","done");
    $("#qzxx").attr("class","done");
    $("#lwcc").attr("class","done");
    $("#lwms").attr("class","current_prev");
    $("#lwdb").attr("class","current");
}

function step7(data){
	
	$("#five").hide();
    $("#six").show();
	
    $("#grxx").attr("class","done");
    $("#zjxx").attr("class","done");
    $("#qzxx").attr("class","done");
    $("#lwcc").attr("class","done");
    $("#lwms").attr("class","done");
    $("#lwdb").attr("class","current_prev");
    $("#qzfs").attr("class","current");
}


</script>
</body>
</html>
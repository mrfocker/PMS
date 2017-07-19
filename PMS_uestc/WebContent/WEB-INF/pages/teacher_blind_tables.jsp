<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Adminity - Tables</title>
  <link rel="shortcut icon" href="favicon.gif">
  <!---CSS Files-->
  <link rel="stylesheet" href="css/master.css">
  <link rel="stylesheet" href="css/tables.css">
  <link rel="stylesheet" href="bootstrap-fileinput/css/fileinput.min.css">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <!---jQuery Files-->
  
  <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
  <!--<script src="js/jquery-1.7.1.min.js"></script>-->
  <!-- <script src="js/jquery-ui-1.8.17.min.js"></script> -->
  <script src="js/styler.js"></script>
  <script src="js/jquery.tipTip.js"></script>
  <script src="js/colorpicker.js"></script>
  <script src="js/sticky.full.js"></script>
  <script src="js/global.js"></script>
  <script src="js/jquery.dataTables.min.js"></script>
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
            <p id="usr-name">欢迎光临, 张三.</p>
            <p id="usr-name">工号：</p>
          </div>
        </li>
        <li>
        <ul id="top-nav">
         <li class="nav-item">
           <a href="dashboard.html"><img src="img/nav/dash.png" alt="" /><p>我的学生</p></a>
         </li>
         <li class="nav-item">
           <a href="analytics.html"><img src="img/nav/anlt.png" alt="" /><p>论文盲审</p></a>
         </li>
         <li class="nav-item">
           <a href="#"><img src="img/nav/tb-active.png" alt="" /><p>论文答辩</p></a>
         </li>
         <li class="nav-item">
           <a href="#"><img src="img/nav/tb-active.png" alt="" /><p>修改密码</p></a>
         </li>
         <li class="nav-item">
           <a href="index.html"><img src="img/nav/typ.png" alt="" /><p>退出登录</p></a>
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
              <th>论文题目</th>
              <th>研究方向1</th>
              <th>研究方向2</th>
              <th>研究方向3</th>
              <th>论文下载</th>
              <th>论文评审</th>
            </tr>
          </thead>
          <tbody>
           <c:forEach items="${blindJudgelist }" var="item">
            <tr class="odd gradeX">
              <td>${item.paper_title}</td>
              <td>${item.paper_researchOne}</td>
              <td>${item.paper_researchTwo}</td>
              <td>${item.paper_researchThree}</td>
              <td><button>下载</button></td>
              <td><button class="fa fa-child" data-toggle="modal" data-target="#myModal1" onclick='show_blinddetails(${item.getStu_id()});'>评审</button><td> 
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
                    论文盲审
                    </h4>
                </div>
                  <div class="x_content">
                    <br />
                    <form class="form-horizontal form-label-left">
                      <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-10">评分</label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                          <input type="text" class="form-control" placeholder="评分范围0-100分" id='score'>
                        </div>
                      </div>


                      <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-10">审核结果<span class="required">*</span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                          <select name='organization' class="form-control">
                          {% for val, item in choices%}
                            <option value="{{val}}">同意答辩</option>
                            <option value="{{val}}">论文修改</option>
                            <option value="{{val}}">不能答辩</option>
                            {%endfor%}
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
                         <div class="modal-footer">
                          <button type="button" class="btn btn-primary" onclick="do_blindjudge();">提交</button>
                          <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
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
  <p>电子科技大学信息与软件工程学院</p>
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

<!--导师提交盲审结果-->
<script type="text/javascript">
  function do_blindjudge(){
    var score = $('#score').val();
    var return_cont = $('#return_cont').val();
    var str = {teacher_Grade:score,teacher_description:return_cont};
    /* var str = []; */
    /* str.push({teacher_Grade:score,teacher_description:return_cont}); */
    str = JSON.stringify(str);
    console.log(str);
    $.ajax({
      url:'${pageContext.request.contextPath }/pages/submitblindjudge',
      type:'post',
      contentType:'application/json;charset=utf-8',
      data:str,
      /* data:'{teacher_Grade:score,teacher_description:return_cont}', */
      success: function(data){
          
          
          console.log("ok");
          },
         
    error: function(data){
          console.log('failed')
            }
	
    });
  }
</script>

<!--将论文盲审信息映射倒模态框-->
<script type="text/javascript">
function 


</script>

<!-- <script type="text/javascript">
  function do_blindjudge(){
    var score = $('#score').val();
    var return_cont = $('#return_cont').val();
    var str = {teacher_Grade:score,teacher_description:return_cont};
    /* var str = []; */
    /* str.push({teacher_Grade:score,teacher_description:return_cont}); */
    str = JSON.stringify(str);
    console.log(str);
    $.ajax({
      url:'${pageContext.request.contextPath }/requestJson',
      type:'post',
      contentType:'application/json;charset=utf-8',
      data:str,
      /* data:'{teacher_Grade:score,teacher_description:return_cont}', */
      success: function(data){
          
          
          console.log("ok");
          console.log(data);},
         
    error: function(data){
          console.log('failed')
            }
	
    });
  }
</script>> -->

</body>
</html>
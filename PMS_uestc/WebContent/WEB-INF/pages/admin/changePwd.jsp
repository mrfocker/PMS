<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>毕业论文管理系统--管理员</title>
    <link rel="shortcut icon" href="favicon.gif">
    <!---CSS Files-->
    <link rel="stylesheet" href="<%=basePath%>/css/master.css">
    <link rel="stylesheet" href="<%=basePath%>/css/tables.css">
    <link rel="stylesheet" href="<%=basePath%>/css/iphone-check.css">
    <link href="<%=basePath%>/js/sh/shThemeDefault.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>/js/sh/shCore.css" rel="stylesheet" type="text/css" />
    <!---jQuery Files-->
    <script src="<%=basePath%>/js/jquery-1.7.1.min.js"></script>
    <script src="<%=basePath%>/js/jquery-ui-1.8.17.min.js"></script>
    <script src="<%=basePath%>/js/styler.js"></script>
    <script src="<%=basePath%>/js/jquery.tipTip.js"></script>
    <script src="<%=basePath%>/js/colorpicker.js"></script>
    <script src="<%=basePath%>/js/sticky.full.js"></script>
    <script src="<%=basePath%>/js/global.js"></script>
    <script src="<%=basePath%>/js/jquery.dataTables.min.js"></script>
    <!---Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'>
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>

<!--- HEADER -->
<div class="top-bar">
    <ul id="nav">
        <li id="user-panel">
            <img src="<%=basePath%>/img/nav/usr-avatar.jpg" id="usr-avatar" alt="" />
            <div id="usr-info">
                <p id="usr-name">管理员，欢迎您</p>
                <a>工号：${admin.su_id}</a>
            </div>
        </li>
        <li>
            <ul id="top-nav" style="z-index: 999">
                <li class="nav-item">
                    <a href="<%=basePath%>/admin/userInfo.action"><img src="<%=basePath%>/img/nav/info.png" alt="" /><p>用户信息</p></a>
                </li>
                <li class="nav-item">
                    <a href="<%=basePath%>/admin/verifyPaper.action"><img src="<%=basePath%>/img/nav/folder.png" alt="" /><p>论文审核</p></a>
                </li>
                <li class="nav-item">
                    <a href="calendar.html"><img src="<%=basePath%>/img/nav/group.png" alt="" /><p>评审分配</p></a>
                    <ul class="sub-nav">
                        <li><a href="#">评审小组分配</a></li>
                        <li><a href="#">答辩小组分配</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a href="analytics.html"><img src="<%=basePath%>/img/nav/down.png" alt="" /><p>信息导入</p></a>
                    <ul class="sub-nav">
                        <li><a href="#">学生基本信息</a></li>
                        <li><a href="#">老师基本信息</a></li>
                        <li><a href="#">论文重复率</a></li>
                        <li><a href="#">学业成绩导入</a></li>
                        <li><a href="#">答辩成绩导入</a></li>
                        <li><a href="#">授位结果导入</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a href="dashboard.html"><img src="<%=basePath%>/img/nav/up.png" alt="" /><p>信息导出</p></a>
                    <ul class="sub-nav">
                        <li><a href="#">导师审核结果</a></li>
                        <li><a href="#">学院审核结果</a></li>
                        <li><a href="#">评审分配结果</a></li>
                        <li><a href="#">答辩分配结果</a></li>
                        <li><a href="#">授位结果导出</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a href="#"><img src="<%=basePath%>/img/nav/redo.png" alt="" /><p>数据备份</p></a>
                </li>
                <li class="nav-item">
                    <a href="<%=basePath%>/admin/changePwd.action"><img src="<%=basePath%>/img/nav/setting.png" alt="" /><p>密码修改</p></a>
                </li>
                <li class="nav-item">
                    <a href="grid.html"><img src="<%=basePath%>/img/nav/exit.png" alt="" /><p>退出系统</p></a>
                </li>
            </ul>
        </li>
    </ul>
</div>

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
					<input type="submit" value="确定" id="formButton"/>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		</form>
</div>

<div class="footer container_12">
    <p class="grid_12">电子科技大学信息与软件工程学院</p>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/pages/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
    $(function(){

    	var flag1 = false;
    	var flag2 = false;
    	
        //调用blur方法，失去焦点时触发事件
        $("#userIdNum").blur(function(){
        	var userId = $("#userId").val();
        	var userIdNum = $("#userIdNum").val();
        	$.ajax({
        		type:"POST",
        		url:"${pageContext.request.contextPath}/pages/validateUser.action",
        		data:{userId:$.trim(userId),userIdNum:$.trim(userIdNum)},
        		success:function(data){
        			if($.trim(data) == "error"){
        				$("#userIdNumInfo").html("用户名和身份证号码不匹配").css({"color":'red',"font-size":'12px'});
        			}else if($.trim(data) == "success"){
        				$("#userIdNumInfo").html("验证用户成功").css({"color":'green',"font-size":'12px'});
        				flag1 = true;
        			}
        		},
        		error:function(){
        			alert("出现异常");
        		}
        	});
        })
        $("#checkNewPwd").blur(function(){
        	var userNewPwd = $("#userNewPwd").val();
        	var checkNewPwd = $("#checkNewPwd").val();
        	if(userNewPwd != checkNewPwd){
        		$("#newPwdInfo").html("两次密码输入不一致").css({"color":'red',"font-size":'12px'});
        	}else{
        		flag2 = true;
        	}
        })
        $("#formButton").click(function(check){ 
        	//alert("flag1="+flag1+",flag2="+flag2);
            if(flag1 == false || flag2 == false){
                alert("请填写完整信息！"); 
                $("#wrongInfo").html("请填写完整信息！").css({"color":'red',"font-size":'12px'});
                check.preventDefault();//此处阻止提交表单  
            }
        }); 
    });
</script>

</body>
</html>
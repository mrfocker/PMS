    $(function(){

    	var flag1 = false;
    	var flag2 = false;
    	
        //调用blur方法，失去焦点时触发事件
        $("#userIdNum").blur(function(){
        	var userId = $("#userId").val();
        	var userIdNum = $("#userIdNum").val();
        	$.ajax({
        		type:"POST",
        		url:"http://localhost:8080/PMS_uestc/pages/validateUser.action",
        		data:{userId:$.trim(userId),userIdNum:$.trim(userIdNum)},
        		success:function(data){
        			if($.trim(data) == "error"){
        				$("#userIdNumInfo").html("用户名和身份证号码不匹配").css({"color":'red',"font-size":'12px'});
        				out.clear();
        				out = pageContext.pushBody();
        			}else if($.trim(data) == "success"){
        				$("#userIdNumInfo").html("验证用户成功").css({"color":'green',"font-size":'12px'});
        				out.clear();
        				out = pageContext.pushBody();
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

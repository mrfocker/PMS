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



//将导师审核自己学生论文得信息映射倒模态框
function show_teacherAdvise(val){
	var str = {stu_id:val};
	str = JSON.stringify(str);
	console.log(str);
	$.ajax({
	      url:'http://localhost:8080/PMS_uestc/pages/queryTeacherDepartAdvise',
	      type:'post',
	      contentType:'application/json;charset=utf-8',
	      data:str,
	      success: function(data){
	          console.log(data);
	          console.log("teacher ok"); 
	          $('#return_cont').val(data.paper_advise);        
	          },
	         
	    error: function(data){
	          console.log('failed')
	            }
		
	    });
}

//将学院审核自己学生论文得信息映射倒模态框
function show_departAdvise(val){
	var str = {stu_id:val};
	str = JSON.stringify(str);
	console.log(str);
	$.ajax({
	      url:'http://localhost:8080/PMS_uestc/pages/queryTeacherDepartAdvise',
	      type:'post',
	      contentType:'application/json;charset=utf-8',
	      data:str,
	      success: function(data){
	          console.log(data);
	          console.log("depart ok"); 
	          $('#return_cont2').val(data.paper_departadvise);        
	          },
	         
	    error: function(data){
	          console.log('failed')
	            }
		
	    });
}
//将盲审信息映射倒模态框
function show_blindjudgeAdvise(val){
	var str = {stu_id:val};
	str = JSON.stringify(str);
	console.log(str);
	$.ajax({
		     url:'http://localhost:8080/PMS_uestc/pages/queryBlindJudgeAdvise',
		     type:'post',
		     contentType:'application/json;charset=utf-8',
		     data:str,
		     success: function(data){
		         console.log(data);
		         console.log("blindjudge ok"); 
		         $('#return_cont3').val(data.teacher_description);        
		         },
		         
		    error: function(data){
		          console.log('failed')
		            }
			
		    });
}

//将答辩信息映射倒模态框
function show_replyAdvise(val){
	var str = {stu_id:val};
	str = JSON.stringify(str);
	console.log(str);
	$.ajax({
		     url:'http://localhost:8080/PMS_uestc/pages/queryReplyAdvise',
		     type:'post',
		     contentType:'application/json;charset=utf-8',
		     data:str,
		     success: function(data){
		         console.log(data);
		         console.log("replyjudge ok"); 
		         $('#return_cont4').val(data.reply_advise);        
		         },
		         
		    error: function(data){
		          console.log('failed')
		            }
			
		    });
}


//根据论文评审信息更新论文流程栏目
function load(){
	console.log("sys start");
	var str = {stu_id:"201522220299"};
	str = JSON.stringify(str);
	console.log(str);
	$.ajax({
	      url:'http://localhost:8080/PMS_uestc/pages/getPaperAllInfo',
	      type:'post',
	      contentType:'application/json;charset=utf-8',
	      data:str,
	      /* data:'{teacher_Grade:score,teacher_description:return_cont}', */
	      success: function(data){      
	    	  console.log(data);
	          console.log("ok");
	        /*系统起始状态*/
	        /* if(data.paper_ifSubmit == 0 && data.paper_ifAdvise == 1 && (data.paper_blindjudgePass == null || data.paper_blindjudgePass == "")
	        		&& (data.reply_Result == null || data.reply_Result == "")){
	        	console.log("system start or wait 1");
	        	$("#submit_button").append("<button type='button' onclick='one_two("+data.stu_id+")'>提交</button>");
	
	        } */
	        /*2到1*/
	    	if(data.paper_ifSubmit == 0 && data.paper_ifPass == "修改" && (data.paper_departPass == null || data.paper_departPass == "") && (data.paper_ifPaperRepetitiveRatePass == null || data.paper_ifPaperRepetitiveRatePass == "")){
	    		  
	    		  console.log("2，1，1 wait,ok");
		          step21(data);
	    	  }
	    	  
	    	else if(data.paper_ifSubmit == 0 && data.paper_ifPass == "修改" && data.paper_departPass == "修改" && (data.paper_ifPaperRepetitiveRatePass == null || data.paper_ifPaperRepetitiveRatePass == "")){
	    		 
	    		  console.log("3,1,2,1 1 wait ok");
		          step3121(data);
	    	 }
	    	 
	    	else if(data.paper_ifSubmit == 0 && data.paper_ifPass == "修改" && data.paper_ifPaperRepetitiveRatePass == "修改" && (data.paper_departPass == null || data.paper_departPass == "")){
	    		 
	    		  console.log("4,1,2,1 wait ok");
		          step4121(data);
	    	 } 
	    	 
	    	else if(data.paper_ifSubmit == 0 && data.paper_ifPass == "修改" && data.paper_ifPaperRepetitiveRatePass == "修改" && data.paper_departPass == "修改"){
	    		 
	    		  console.log("4,1,3,1,2,1 wait ok");
		          step4231(data);
	    	 }
		    
		    /*3到1*/
		    else if(data.paper_ifSubmit == 0 && (data.paper_ifPass == "" || data.paper_ifPass == null) && data.paper_departPass == "修改" && (data.paper_ifPaperRepetitiveRatePass == null || data.paper_ifPaperRepetitiveRatePass == "")){
	    		 
	    		  console.log("3,1, 1 wait ok");
		          step31(data);
	    	 }
		    
		    else if(data.paper_ifSubmit == 0 && (data.paper_ifPass == "" || data.paper_ifPass == null) && data.paper_departPass == "修改" && data.paper_ifPaperRepetitiveRatePass == "修改"){
	    		 
	    		  console.log("4,1,3,1 1 wait ok");
		          step4131(data);
	    	 }
		    
		    /*4到1*/
		   else if(data.paper_ifSubmit == 0 && (data.paper_ifPass == "" || data.paper_ifPass == null) && (data.paper_departPass == "" || data.paper_departPass == null) && data.paper_ifPaperRepetitiveRatePass == "修改"){
	    		 
	    		  console.log("4,1 1 wait ok");
		          step41(data);
	    	 }
	      /*提交论文*/
	      else if(data.paper_ifSubmit == 1 && data.paper_ifAdvise == 0 && (data.paper_ifPass == "修改" || data.paper_ifPass == null || data.paper_ifPass == "")){
	    	  console.log("1 go to 2,wait 2 +");
              step2(data);
	      }
	      /*导师审核ok*/
	      else if(data.paper_ifSubmit == 1 && data.paper_ifAdvise == 1 && (data.paper_ifPass == "修改" || data.paper_ifPass == "不通过")){
	    	     console.log("2 go to 1 ,wait 2 -");
	    	     step2(data);
	    	     $("#two1").append("<td>您的论文在该审核阶段的评审结果已经完成，请点击确认查看结果详情</td> ");
	    	     $("#two1").append("<button type='button' onclick='return_one("+data.stu_id+");'>确认</button>");
	       }
	      
	       /*学院审核*/
	       else if(data.paper_ifSubmit == 1 && data.paper_ifPass == "通过" && (data.paper_departPass == "修改" || (data.paper_departPass == null || data.paper_departPass == ""))){
	    	      console.log("2 go to 3,wait 3 +");
	    	   	  step3(data);
	       }
	       else if(data.paper_ifSubmit == 1 && data.paper_ifAdvise == 1 && (data.paper_ifPass == "" || data.paper_ifPass == null)&& (data.paper_departPass == "修改" || data.paper_departPass == "不通过")){
	    	      console.log("3 go to 1,wait 3 -");
	    	   	  step3(data);
	    	   	  $("#three1").append("<td>您的论文需要修改，请点击“确认”按钮查看学院意见并重新上传修改后的论文！</td> ");
	    	      /*添加确认按钮,回到第一步点击以后出发一个AJAX路由重新从后台拉数据*/
	    	      $("#three1").append("<button type='button' onclick='return_one("+data.stu_id+");'>确认</button>");
	       }
	       /*论文查重*/
	       else if(data.paper_ifSubmit == 1 && data.paper_departPass == "通过" && (data.paper_ifPaperRepetitiveRatePass == "修改" || data.paper_ifPaperRepetitiveRatePass == null || data.data_ifPaperRepetitiveRatePass == "")){
	    	      console.log("go to 4,wait4 +");
	    	      step4(data);
	       }
	       else if(data.paper_ifSubmit == 1 && data.paper_ifAdvise == 1 && (data.paper_ifPass == null || data.paper_ifPass == "") && (data.paper_departPass == null || data.paper_departPass == "") 
    		   && (data.paper_ifPaperRepetitiveRatePass == "修改" || data.paper_ifPaperRepetitiveRatePass == "不通过")){
	    	      console.log("4 go to 1,wait 4 -");
	    	      step4(data);
	    	      $("#four1").append("<td>您的论文需要修改，请点击“确认”按钮查看导师意见并重新上传修改后的论文！</td> ");
	    	      /*添加确认按钮,回到第一步点击以后出发一个AJAX路由重新从后台拉数据*/
	    	      $("#four1").append("<button type='button' onclick='return_one("+data.stu_id+");'>确认</button>");
	       }
	       /*论文盲审*/
	       else if(data.paper_ifSubmit == 1 && data.paper_ifPaperRepetitiveRatePass == "通过" && (data.paper_blindjudgePass == null || data.paper_blindjudgePass == "")){
	    	      console.log("go to 5,wait 5 +");
	    	      step5(data);
	       }
	       else if(data.paper_ifSubmit == 1 && data.paper_blindjudgePass == "不通过"){
	    	   console.log("wait in 5,-");
	    	   step5(data);
	    	   $("#five1").append("<td>您的论文没有通过盲审考核。</td> ");	  
	    	   /*不通过的原因*/
	       }
	       else if(data.paper_ifSubmit == 0 && data.paper_ifAdvise == 1 && data.teacher_Result == "修改后答辩" && data.paper_blindjudgePass == "通过"
	    		   && (data.paper_ifReply == null || data.paper_ifReply == "")){
	    	      console.log("wait in 5,-");
	    	      step5_5(data);
	    	      $("#five1").append("<td>您的论文需要已经通过盲审考核，请查看盲审意见并修改论文，然后点击“提交”按钮！！！</td> ");
	    	      /*添加确认按钮,回到第一步点击以后出发一个AJAX路由重新从后台拉数据*/
	    	      $("#five1").append("<button type='button' onclick='five_six("+data.stu_id+")'>提交</button>");
	    	      /*不通过的原因*/
	       }
	      /*盲神修改版等待导师审核*/
	       else if(data.paper_ifSubmit == 0 && data.paper_ifAdvise == 1 && data.teacher_Result == "修改后答辩" && data.paper_blindjudgePass == "通过" && data.paper_ifReply == "修改"){
	    	      console.log("wait in 5 blind fix");
	    	      step5(data);
	       }
	      /* 导师要求盲审论文再修改*/
	       else if(data.paper_ifSubmit == 1 && data.paper_blindjudgePass == "通过" && (data.paper_ifReply == "" || data.paper_ifReply == null)){
	    	      console.log("wait in 5 blind fix");
	    	      console.log("wait in 5,--");
	    	      step5_5_2(data);
	    	      $("#five1").append("<td>您的论文需要已经通过盲审考核，请查看盲审意见并修改论文，然后点击“提交”按钮！！！</td> ");
	    	      /*添加确认按钮,回到第一步点击以后出发一个AJAX路由重新从后台拉数据*/
	    	      $("#five1").append("<button type='button' onclick='five_six("+data.stu_id+")'>提交</button>");
	       }
	      
	       /*论文答辩*/
	       else if(data.paper_ifSubmit == 1 && data.paper_blindjudgePass == "通过" && paper_ifReply == "通过"){
	    	      console.log("go to 6,wait 6 +");
	    	      step6(data);
	       }
	       else if(data.paper_ifSubmit == 1 && paper_replyPass == "不通过"){
	    	      console.log("go to 6,wait 6 -");
	    	      $("#six1").append("<td>您的论文未通过答辩考核！</td> ");
	    	      step6(data);
	    	      
	       }
	       else if(data.paper_ifSubmit == 0 && data.paper_ifAdvise == 1 && data.paper_replyPass == "通过"){
	    	      console.log("wait 6 -");
	    	      step6_6(data);
	    	      $("#six1").append("<td>您的论文需要已经通过答辩考核，请查看盲审意见并修改论文，然后点击“提交”按钮！！！</td> ");
	    	      /*添加确认按钮,回到第一步点击以后出发一个AJAX路由重新从后台拉数据*/
	    	      $("#six1").append("<button type='button' onclick='six_seven("+data.stu_id+")'>提交</button>");
	    	      /*不通过的原因*/
	       }
	       /*学位授予*/
	       else if((data.stu_ifdegree == null || data.stu_ifdegree == "" || data.stu_ifdegree == "否") && data.data.paper_replyPass == "通过" && data.paper_ifSubmit == 1){
	    	   	  console.log("go to 7,wait 7");
	    	   	  step7(data);
	       }
	       /*同意授位*/
	       else if(data.stu_ifdegree == "是"){
	    	   	  console.log("授位");
	    	   	  step8(data);
	       }
	       else{
	    	   
	    	   console.log("system start or wait 1");
	    	   $("#submit_button").append("<td>请先上传论文，然后点击提交！！！</td>");
	           $("#submit_button").append("<button type='button' onclick='one_two("+data.stu_id+")'>提交</button>");
	       }
	          },
	      
	         
	    error: function(data){
	          console.log('failed');
	          alert("提交审核失败")
	            }
		
	    });
}

function one_two(val){
	
	var str = {stu_id:val};
	str = JSON.stringify(str);
	$.ajax({
	      url:'http://localhost:8080/PMS_uestc/pages/onejumptwo',
	      type:'post',
	      contentType:'application/json;charset=utf-8',
	      data:str,
	      success: function(data){
	    	  
	          console.log("one_two ok");
	          console.log(data);
	          
	          if (confirm("确定提交？")) {
	              $("#one").hide();
	              $("#two").show();
	              $("#grxx").attr("class","current_prev");
	              $("#zjxx").attr("class","current");
	          }
	          
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
	          $("#paperlist").append("<td>"+data.stu_id+"</td>");
	          $("#paperlist").append("<td>"+data.paper_title+"</td>");
	          $("#paperlist").append("<td>"+data.paper_researchOne+"</td>");
	          $("#paperlist").append("<td>"+data.paper_researchTwo+"</td>");
	          $("#paperlist").append("<td>"+data.paper_researchThree+"</td>");
	          $("#paperlist").append("<td>"+data.paper_ifPass+"</td>");
	          $("#two1").empty();
	          },
	         
	    error: function(data){
	          console.log('failed');
	          alert("提交审核失败")
	            }
		
	    });
}

function five_six(val){
	
	var str = {stu_id:val};
	str = JSON.stringify(str);
	$.ajax({
	      url:'http://localhost:8080/PMS_uestc/pages/onejumptwo',
	      type:'post',
	      contentType:'application/json;charset=utf-8',
	      data:str,
	      success: function(data){
	    	  
	          console.log("one_two ok");
	          console.log(data);
	          
	          if (confirm("确定提交？")) {
	             step6(data);
	          }
	          
	         
	          },
	         
	    error: function(data){
	          console.log('failed');
	          alert("提交审核失败")
	            }
		
	    });
}

function six_seven(val){
	
	var str = {stu_id:val};
	str = JSON.stringify(str);
	$.ajax({
	      url:'http://localhost:8080/PMS_uestc/pages/sixjumpseven',
	      type:'post',
	      contentType:'application/json;charset=utf-8',
	      data:str,
	      success: function(data){
	    	  
	          console.log("six_seven ok");
	          console.log(data);
	          
	          if (confirm("确定提交？")) {
	             step7(data);
	          }
	          
	         
	          },
	         
	    error: function(data){
	          console.log('failed');
	          alert("提交审核失败")
	            }
		
	    });
}

///////////////////////////
function return_one(val){
	
	var str = {stu_id:val};
	str = JSON.stringify(str);
	  console.log("adf");
	$.ajax({
	      url:'http://localhost:8080/PMS_uestc/pages/requeryPaperInfo',
	      type:'post',
	      contentType:'application/json;charset=utf-8',
	      data:str,
	      success: function(data){
	    	  /*2到1*/
	    	  if(data.paper_ifSubmit == 0 && data.paper_ifPass == "修改" && (data.paper_departPass == null || data.paper_departPass == "") && (data.paper_ifPaperRepetitiveRatePass == null || data.paper_ifPaperRepetitiveRatePass == "")){
	    		  
		          step21(data);
	    	  }
	    	  
	    	 if(data.paper_ifSubmit == 0 && data.paper_ifPass == "修改" && data.paper_departPass == "修改" && (data.paper_ifPaperRepetitiveRatePass == null || data.paper_ifPaperRepetitiveRatePass == "")){
	    		 
		          step3121(data);
	    	 }
	    	 
	    	 if(data.paper_ifSubmit == 0 && data.paper_ifPass == "修改" && data.paper_ifPaperRepetitiveRatePass == "修改" && (data.paper_departPass == null || data.paper_departPass == "")){
	    		 
		          step4121(data);
	    	 } 
	    	 
		    if(data.paper_ifSubmit == 0 && data.paper_ifPass == "修改" && data.paper_ifPaperRepetitiveRatePass == "修改" && data.paper_departPass == "修改"){
	    		 
		          step4231(data);
	    	 }
		    
		    /*3到1*/
		    if(data.paper_ifSubmit == 0 && (data.paper_ifPass == "" || data.paper_ifPass == null) && data.paper_departPass == "修改" && (data.paper_ifPaperRepetitiveRatePass == null || data.paper_ifPaperRepetitiveRatePass == "")){
	    		 
		          step31(data);
	    	 }
		    
		    if(data.paper_ifSubmit == 0 && (data.paper_ifPass == "" || data.paper_ifPass == null) && data.paper_departPass == "修改" && data.paper_ifPaperRepetitiveRatePass == "修改"){
	    		 
		          step4131(data);
	    	 }
		    
		    /*4到1*/
		    if(data.paper_ifSubmit == 0 && (data.paper_ifPass == "" || data.paper_ifPass == null) && (data.paper_departPass == "" || data.paper_departPass == null) && data.paper_ifPaperRepetitiveRatePass == "修改"){
	    		 
		          step41(data);
	    	 }
	          },
	    error: function(data){
	          console.log('failed');
	          alert("提交审核失败")
	            }
		
	    });
}

///////////////////////////////////////////////////////

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
    $("#paperlist").append("<td><button>上传</button></td>");
    
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
    $("#paperlist").append("<td>"+data.stu_id+"</td>");
    $("#paperlist").append("<td>"+data.paper_title+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchOne+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchTwo+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchThree+"</td>");
    $("#paperlist").append("<td>"+data.paper_ifPass+"</td>");
	
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
     $("#paperlist").append("<td>"+data.stu_id+"</td>");
     $("#paperlist").append("<td>"+data.paper_researchOne+"</td>");
     $("#paperlist").append("<td>"+data.paper_researchTwo+"</td>");
     $("#paperlist").append("<td>"+data.paper_researchThree+"</td>");
     $("#paperlist").append("<td>"+data.paper_departPass+"</td>");
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
    $("#paperlist").append("<td>"+data.paper_repetitiveRateAll+"</td>");
    $("#paperlist").append("<td>"+data.paper_repetitiveRateSingle+"</td>");
}

function step5(data){
	
	$("#four").hide();
    $("#five").show();
	
    $("#grxx").attr("class","done");
    $("#zjxx").attr("class","done");
    $("#qzxx").attr("class","done");
    $("#lwcc").attr("class","current_prev");
    $("#lwms").attr("class","current");
    
    $("#paperlistname").empty();
    $("#paperlistname").append("<th>学生姓名</th>");
    $("#paperlistname").append("<th>学生学号</th>");
    $("#paperlistname").append("<th>研究方向一</th>");
    $("#paperlistname").append("<th>研究方向二</th>");
    $("#paperlistname").append("<th>研究方向三</th>");
    $("#paperlistname").append("<th>盲审核结果</th>");
   
    $("#paperlist").empty();
    $("#paperlist").append("<td>"+data.stu_name+"</td>");
    $("#paperlist").append("<td>"+data.stu_id+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchOne+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchTwo+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchThree+"</td>");
    $("#paperlist").append("<td>"+data.paper_blindjudgePass+"</td>");
    
    
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
    
    $("#paperlistname").empty();
    $("#paperlistname").append("<th>学生姓名</th>");
    $("#paperlistname").append("<th>学生学号</th>");
    $("#paperlistname").append("<th>研究方向一</th>");
    $("#paperlistname").append("<th>研究方向二</th>");
    $("#paperlistname").append("<th>研究方向三</th>");
    $("#paperlistname").append("<th>答辩审核结果</th>");
   
    $("#paperlist").empty();
    $("#paperlist").append("<td>"+data.stu_name+"</td>");
    $("#paperlist").append("<td>"+data.stu_id+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchOne+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchTwo+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchThree+"</td>");
    $("#paperlist").append("<td>"+data.reply_result+"</td>");
}

function step7(data){
	
	$("#six").hide();
    $("#seven").show();
	
    $("#grxx").attr("class","done");
    $("#zjxx").attr("class","done");
    $("#qzxx").attr("class","done");
    $("#lwcc").attr("class","done");
    $("#lwms").attr("class","done");
    $("#lwdb").attr("class","current_prev");
    $("#qzfs").attr("class","current");
    
    $("#paperlistname").empty();
    $("#paperlistname").append("<th>学生姓名</th>");
    $("#paperlistname").append("<th>学生学号</th>");
    $("#paperlistname").append("<th>研究方向一</th>");
    $("#paperlistname").append("<th>研究方向二</th>");
    $("#paperlistname").append("<th>研究方向三</th>");
    $("#paperlistname").append("<th>是否授位</th>");
   
    $("#paperlist").empty();
    $("#paperlist").append("<td>"+data.stu_name+"</td>");
    $("#paperlist").append("<td>"+data.stu_id+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchOne+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchTwo+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchThree+"</td>");
    $("#paperlist").append("<td>"+data.stu_ifdegree+"</td>");
    
}

function step8(data){
	
	 $("#seven").hide();
	
	 $("#grxx").attr("class","done");
	 $("#zjxx").attr("class","done");
	 $("#qzxx").attr("class","done");
	 $("#lwcc").attr("class","done");
	 $("#lwms").attr("class","done");
	 $("#lwdb").attr("class","done");
	 $("#qzfs").attr("class","done");
    
    $("#paperlistname").empty();
    $("#paperlistname").append("<th>学生姓名</th>");
    $("#paperlistname").append("<th>学生学号</th>");
    $("#paperlistname").append("<th>研究方向一</th>");
    $("#paperlistname").append("<th>研究方向二</th>");
    $("#paperlistname").append("<th>研究方向三</th>");
    $("#paperlistname").append("<th>是否授位</th>");
   
    $("#paperlist").empty();
    $("#paperlist").append("<td>"+data.stu_name+"</td>");
    $("#paperlist").append("<td>"+data.stu_id+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchOne+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchTwo+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchThree+"</td>");
    $("#paperlist").append("<td>"+data.stu_ifdegree+"</td>");
    
}
///////////////////////////////////////////////////////
/*wait 1*/
function step21(data){
	 console.log("2，1，1 wait,ok");
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
     $("#paperlistname").append("<th>导师意见</th>");
     $("#paperlistname").append("<th>上传论文</th>");
     
     $("#paperlist").empty();
     $("#paperlist").append("<td>"+data.stu_name+"</td>");
     $("#paperlist").append("<td>"+data.stu_id+"</td>");
     $("#paperlist").append("<td>"+data.paper_title+"</td>");
     $("#paperlist").append("<td>"+data.paper_researchOne+"</td>");
     $("#paperlist").append("<td>"+data.paper_researchTwo+"</td>");
     $("#paperlist").append("<td>"+data.paper_researchThree+"</td>");
     $("#paperlist").append("<td><button class='fa fa-child' data-toggle='modal' data-target='#myModal1' onclick='show_teacherAdvise("+data.stu_id+");'>评审</button></td>");
     $("#paperlist").append("<td><button>上传</button></td>");
     $("#submit_button").append("<td>请先上传论文，然后点击提交！！！</td>");
     $("#submit_button").append("<button type='button' onclick='one_two("+data.stu_id+")'>提交</button>");
} 

function step31(data){
	
	console.log("3,1, 1 wait ok");
	$("#one").show();
    $("#two").hide();
    $("#three").hide();
    $("#grxx").attr("class","current");
    $("#zjxx").attr("class","");
    $("#qzxx").attr("class","");
    
    $("#paperlistname").empty();
    $("#paperlistname").append("<th>学生姓名</th>");
    $("#paperlistname").append("<th>学生学号</th>");
    $("#paperlistname").append("<th>论文题目</th>");
    $("#paperlistname").append("<th>研究方向一</th>");
    $("#paperlistname").append("<th>研究方向二</th>");
    $("#paperlistname").append("<th>研究方向三</th>");
    $("#paperlistname").append("<th>学院意见</th>");
    $("#paperlistname").append("<th>上传论文</th>");
    
    $("#paperlist").empty();
    $("#paperlist").append("<td>"+data.stu_name+"</td>");
    $("#paperlist").append("<td>"+data.stu_id+"</td>");
    $("#paperlist").append("<td>"+data.paper_title+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchOne+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchTwo+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchThree+"</td>");
    $("#paperlist").append("<td><button class='fa fa-child' data-toggle='modal' data-target='#myModal2' onclick='show_departAdvise("+data.stu_id+");'>评审</button></td>");
    $("#paperlist").append("<td><button>上传</button></td>");
    $("#submit_button").append("<td>请先上传论文，然后点击提交！！！</td>");
    $("#submit_button").append("<button type='button' onclick='one_two("+data.stu_id+")'>提交</button>"); 
}

function step3121(data){
	console.log("3,1,2,1 1 wait ok");
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
    $("#paperlistname").append("<th>导师意见</th>");
    $("#paperlistname").append("<th>学院意见</th>");
    $("#paperlistname").append("<th>上传论文</th>");
    
    $("#paperlist").empty();
    $("#paperlist").append("<td>"+data.stu_name+"</td>");
    $("#paperlist").append("<td>"+data.stu_id+"</td>");
    $("#paperlist").append("<td>"+data.paper_title+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchOne+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchTwo+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchThree+"</td>");
    $("#paperlist").append("<td><button class='fa fa-child' data-toggle='modal' data-target='#myModal1' onclick='show_teacherAdvise("+data.stu_id+");'>评审</button></td>");
    $("#paperlist").append("<td><button class='fa fa-child' data-toggle='modal' data-target='#myModal2' onclick='show_departAdvise("+data.stu_id+");'>评审</button></td>");
    $("#paperlist").append("<td><button>上传</button></td>");
    $("#submit_button").append("<td>请先上传论文，然后点击提交！！！</td>");
    $("#submit_button").append("<button type='button' onclick='one_two("+data.stu_id+")'>提交</button>"); 
}

function step4121(data){
	
	 console.log("4,1,2,1 wait ok");
	 
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
     $("#paperlistname").append("<th>导师意见</th>");
     $("#paperlistname").append("<th>单章查重</th>");
     $("#paperlistname").append("<th>全篇查重</th>");
     $("#paperlistname").append("<th>上传论文</th>");
     
     $("#paperlist").empty();
     $("#paperlist").append("<td>"+data.stu_name+"</td>");
     $("#paperlist").append("<td>"+data.stu_id+"</td>");
     $("#paperlist").append("<td>"+data.paper_title+"</td>");
     $("#paperlist").append("<td>"+data.paper_researchOne+"</td>");
     $("#paperlist").append("<td>"+data.paper_researchTwo+"</td>");
     $("#paperlist").append("<td>"+data.paper_researchThree+"</td>");
     $("#paperlist").append("<td><button class='fa fa-child' data-toggle='modal' data-target='#myModal1' onclick='show_teacherAdvise("+data.stu_id+");'>评审</button></td>");
     $("#paperlist").append("<td>"+data.paper_repetitiveRateSingle+"</td>");
     $("#paperlist").append("<td>"+data.paper_repetitiveRateAll+"</td>");
     $("#paperlist").append("<td><button>上传</button></td>");
     $("#submit_button").append("<td>请先上传论文，然后点击提交！！！</td>");
     $("#submit_button").append("<button type='button' onclick='one_two("+data.stu_id+")'>提交</button>"); 
}

function step4131(data){
	
	console.log("4,1,3,1 1 wait ok");
	$("#one").show();
    $("#two").hide();
    $("#three").hide();
    $("#grxx").attr("class","current");
    $("#zjxx").attr("class","");
    $("#qzxx").attr("class","");
    
    $("#paperlistname").empty();
    $("#paperlistname").append("<th>学生姓名</th>");
    $("#paperlistname").append("<th>学生学号</th>");
    $("#paperlistname").append("<th>论文题目</th>");
    $("#paperlistname").append("<th>研究方向一</th>");
    $("#paperlistname").append("<th>研究方向二</th>");
    $("#paperlistname").append("<th>研究方向三</th>");
    $("#paperlistname").append("<th>学院意见</th>");
    $("#paperlistname").append("<th>单章重复率</th>");
    $("#paperlistname").append("<th>全篇重复率</th>");
    $("#paperlistname").append("<th>上传论文</th>");
    
    $("#paperlist").empty();
    $("#paperlist").append("<td>"+data.stu_name+"</td>");
    $("#paperlist").append("<td>"+data.stu_id+"</td>");
    $("#paperlist").append("<td>"+data.paper_title+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchOne+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchTwo+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchThree+"</td>");
    $("#paperlist").append("<td><button class='fa fa-child' data-toggle='modal' data-target='#myModal2' onclick='show_departAdvise("+data.stu_id+");'>评审</button></td>");
    $("#paperlist").append("<td>"+data.paper_repetitiveRateSingle+"</td>");
    $("#paperlist").append("<td>"+data.paper_repetitiveRateAll+"</td>");
    $("#paperlist").append("<td><button>上传</button></td>");
    $("#submit_button").append("<td>请先上传论文，然后点击提交！！！</td>");
    $("#submit_button").append("<button type='button' onclick='one_two("+data.stu_id+")'>提交</button>");
	
}

function step413121(data){
	
	console.log("4,1,3,1,2,1 wait ok");
	 
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
    $("#paperlistname").append("<th>导师意见</th>");
    $("#paperlistname").append("<th>学院意见</th>");
    $("#paperlistname").append("<th>单章查重</th>");
    $("#paperlistname").append("<th>全篇查重</th>");
    $("#paperlistname").append("<th>上传论文</th>");
    
    $("#paperlist").empty();
    $("#paperlist").append("<td>"+data.stu_name+"</td>");
    $("#paperlist").append("<td>"+data.stu_id+"</td>");
    $("#paperlist").append("<td>"+data.paper_title+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchOne+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchTwo+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchThree+"</td>");
    $("#paperlist").append("<td><button class='fa fa-child' data-toggle='modal' data-target='#myModal1' onclick='show_teacherAdvise("+data.stu_id+");'>评审</button></td>");
    $("#paperlist").append("<td><button class='fa fa-child' data-toggle='modal' data-target='#myModal2' onclick='show_departAdvise("+data.stu_id+");'>评审</button></td>");
    $("#paperlist").append("<td>"+data.paper_repetitiveRateSingle+"</td>");
    $("#paperlist").append("<td>"+data.paper_repetitiveRateAll+"</td>");
    $("#paperlist").append("<td><button>上传</button></td>");
    $("#submit_button").append("<td>请先上传论文，然后点击提交！！！</td>");
    $("#submit_button").append("<button type='button' onclick='one_two("+data.stu_id+")'>提交</button>"); 
}

function step41(data){
	
	console.log("4,1 1 wait ok");
	$("#one").show();
    $("#two").hide();
    $("#three").hide();
    $("#four").hide();
    $("#grxx").attr("class","current");
    $("#zjxx").attr("class","");
    $("#qzxx").attr("class","");
    $("#lwcc").attr("class","");
    
    $("#paperlistname").empty();
    $("#paperlistname").append("<th>学生姓名</th>");
    $("#paperlistname").append("<th>学生学号</th>");
    $("#paperlistname").append("<th>论文题目</th>");
    $("#paperlistname").append("<th>研究方向一</th>");
    $("#paperlistname").append("<th>研究方向二</th>");
    $("#paperlistname").append("<th>研究方向三</th>");
    $("#paperlistname").append("<th>单章重复率</th>");
    $("#paperlistname").append("<th>全篇重复率</th>");
    $("#paperlistname").append("<th>上传论文</th>");
    
    $("#paperlist").empty();
    $("#paperlist").append("<td>"+data.stu_name+"</td>");
    $("#paperlist").append("<td>"+data.stu_id+"</td>");
    $("#paperlist").append("<td>"+data.paper_title+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchOne+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchTwo+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchThree+"</td>");
    $("#paperlist").append("<td>"+data.paper_repetitiveRateSingle+"</td>");
    $("#paperlist").append("<td>"+data.paper_repetitiveRateAll+"</td>");
    $("#paperlist").append("<td><button>上传</button></td>");
    $("#submit_button").append("<td>请先上传论文，然后点击提交！！！</td>");
    $("#submit_button").append("<button type='button' onclick='one_two("+data.stu_id+")'>提交</button>"); 
}

function step5_5(data){
	
	console.log("wait 5 -");
	$("#four").hide();
    $("#five").show();
	
    $("#grxx").attr("class","done");
    $("#zjxx").attr("class","done");
    $("#qzxx").attr("class","done");
    $("#lwcc").attr("class","current_prev");
    $("#lwms").attr("class","current");
    
    $("#paperlistname").empty();
    $("#paperlistname").append("<th>学生姓名</th>");
    $("#paperlistname").append("<th>学生学号</th>");
    $("#paperlistname").append("<th>研究方向一</th>");
    $("#paperlistname").append("<th>研究方向二</th>");
    $("#paperlistname").append("<th>研究方向三</th>");
    $("#paperlistname").append("<th>盲审意见</th>");
    $("#paperlistname").append("<th>盲审结果</th>");
   
    $("#paperlist").empty();
    $("#paperlist").append("<td>"+data.stu_name+"</td>");
    $("#paperlist").append("<td>"+data.stu_id+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchOne+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchTwo+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchThree+"</td>");
    $("#paperlist").append("<td><button class='fa fa-child' data-toggle='modal' data-target='#myModal3' onclick='show_blindjudgeAdvise("+data.stu_id+");'>评审</button></td>");
    $("#paperlist").append("<td>"+data.paper_blindjudgePass+"</td>")
}

function  step5(data){
	
	console.log("wait 5, wait for teacher answer");
	$("#four").hide();
    $("#five").show();
	
    $("#grxx").attr("class","done");
    $("#zjxx").attr("class","done");
    $("#qzxx").attr("class","done");
    $("#lwcc").attr("class","current_prev");
    $("#lwms").attr("class","current");
    
    $("#paperlistname").empty();
    $("#paperlistname").append("<th>学生姓名</th>");
    $("#paperlistname").append("<th>学生学号</th>");
    $("#paperlistname").append("<th>研究方向一</th>");
    $("#paperlistname").append("<th>研究方向二</th>");
    $("#paperlistname").append("<th>研究方向三</th>");
    $("#paperlistname").append("<th>导师意见</th>");
    $("#paperlistname").append("<th>盲审结果</th>");
   
    $("#paperlist").empty();
    $("#paperlist").append("<td>"+data.stu_name+"</td>");
    $("#paperlist").append("<td>"+data.stu_id+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchOne+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchTwo+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchThree+"</td>");
    $("#paperlist").append("<td>导师未审核</td>");
    $("#paperlist").append("<td>"+data.paper_blindjudgePass+"</td>")
}

step5_5_2(data){
	
	console.log("wait 5, teacher answer is fix");
	$("#four").hide();
    $("#five").show();
	
    $("#grxx").attr("class","done");
    $("#zjxx").attr("class","done");
    $("#qzxx").attr("class","done");
    $("#lwcc").attr("class","current_prev");
    $("#lwms").attr("class","current");
    
    $("#paperlistname").empty();
    $("#paperlistname").append("<th>学生姓名</th>");
    $("#paperlistname").append("<th>学生学号</th>");
    $("#paperlistname").append("<th>研究方向一</th>");
    $("#paperlistname").append("<th>研究方向二</th>");
    $("#paperlistname").append("<th>研究方向三</th>");
    $("#paperlistname").append("<th>导师意见</th>");
    $("#paperlistname").append("<th>盲审结果</th>");
   
    $("#paperlist").empty();
    $("#paperlist").append("<td>"+data.stu_name+"</td>");
    $("#paperlist").append("<td>"+data.stu_id+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchOne+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchTwo+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchThree+"</td>");
    $("#paperlist").append("<td>修改</td>");
    $("#paperlist").append("<td>"+data.paper_blindjudgePass+"</td>")
}

function step6_6(data){
	
	console.log("wait 6 -");
	$("#five").hide();
    $("#six").show();
	
    $("#grxx").attr("class","done");
    $("#zjxx").attr("class","done");
    $("#qzxx").attr("class","done");
    $("#lwcc").attr("class","done");
    $("#lwms").attr("class","current_prev");
    $("#lwdb").attr("class","current");
    
    $("#paperlistname").empty();
    $("#paperlistname").append("<th>学生姓名</th>");
    $("#paperlistname").append("<th>学生学号</th>");
    $("#paperlistname").append("<th>研究方向一</th>");
    $("#paperlistname").append("<th>研究方向二</th>");
    $("#paperlistname").append("<th>研究方向三</th>");
    $("#paperlistname").append("<th>答辩结果</th>");
   
    $("#paperlist").empty();
    $("#paperlist").append("<td>"+data.stu_name+"</td>");
    $("#paperlist").append("<td>"+data.stu_id+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchOne+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchTwo+"</td>");
    $("#paperlist").append("<td>"+data.paper_researchThree+"</td>");
    $("#paperlist").append("<td>"+data.paper_blindjudgePass+"</td>")
}

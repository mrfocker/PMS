//导师提交盲审结果
  function do_blindjudge(val1){
    var score = $('#score').val();
    var select_val = $('#result_select').val();
    var return_cont = $('#return_cont').val(); 
    var str = {stu_id:val1,teacher_Grade:score,teacher_description:return_cont,result_code:select_val};
    /* var str = []; */
    /* str.push({teacher_Grade:score,teacher_description:return_cont}); */
    str = JSON.stringify(str);
    console.log(str);
    $.ajax({
      url:'http://localhost:8080/PMS_uestc/pages/submitblindjudge',
      type:'post',
      contentType:'application/json;charset=utf-8',
      data:str,
      /* data:'{teacher_Grade:score,teacher_description:return_cont}', */
      success: function(){      
          console.log("ok");
          confirm("提交后不能修改，确定提交？");
          $("#submit_result").empty()
          },
         
    error: function(data){
          console.log('failed');
          alert("提交审核失败")
            }
	
    });
  }

//将论文盲审信息映射倒模态框
function show_blinddetails(val){
	var str = {stu_id:val};
	str = JSON.stringify(str);
	$.ajax({
	      url:'http://localhost:8080/PMS_uestc/pages/bingjudgeResult',
	      type:'post',
	      contentType:'application/json;charset=utf-8',
	      data:str,
	      success: function(data){
	    	  console.log(data.teacher_Grade);
	          console.log(data);
	          console.log("ok");
	          
	          $('#score').val(data.teacher_Grade);
	          $('#return_cont').val(data.teacher_description);
	          $("#submit_result").empty();
	          if(data.paper_ifAdvise == 0){
	        	  $("#submit_result").append("<button type='button' class='btn btn-primary' onclick='+do_blindjudge("+val+");'>提交</button>");
		          $("#submit_result").append("<button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>");
	          }
	          $("#result_select").empty();
	          $("#result_select").append("<option value='"+data.result_code+"'>"+data.teacher_Result+"</option>");
	          $("#result_select").append("<option value='1'>同意答辩</option>");
	          $("#result_select").append("<option value='2'>修改后答辩</option>");
	          $("#result_select").append("<option value='3'>修改后重审</option>");
	          $("#result_select").append("<option value='4'>不同意答辩</option>");
	          
	          },
	         
	    error: function(data){
	          console.log('failed')
	            }
		
	    });
}


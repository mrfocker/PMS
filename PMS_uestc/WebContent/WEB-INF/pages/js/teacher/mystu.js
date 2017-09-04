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
function show_judgedetails(val){
	console.log('ok');
	console.log(val);
	var str = {paper_stuId:val};
	str = JSON.stringify(str);
	$.ajax({
	      url:'http://localhost:8080/PMS_uestc/pages/teacherQueryAdvise',
	      type:'post',
	      contentType:'application/json;charset=utf-8',
	      data:str,
	      success: function(data){
	          console.log(data);
	          console.log("ok");
	          
	          $('#score').val(data.teacher_Grade);
	          $('#return_cont').val(data.paper_advise);
	          $("#submit_result").empty();
	          if(data.paper_ifAdvise == 0 && data.paper_ifPass != "通过" && data.paper_ifPass != "不通过"){
	        	  $("#submit_result").append("<button type='button' class='btn btn-primary' onclick='+do_teacherjudge("+val+");'>提交</button>");
		          $("#submit_result").append("<button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>"); 
	          }
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


//导师提交对自己学生论文审核的结果
  function do_teacherjudge(val1){
    var return_cont = $('#return_cont').val();
    var select_val = $('#result_select').val();
    var str = {paper_stuId:val1,paper_advise:return_cont,result_code:select_val};
    /* var str = []; */
    /* str.push({teacher_Grade:score,teacher_description:return_cont}); */
    str = JSON.stringify(str);
    console.log(str);
    $.ajax({
      url:'http://localhost:8080/PMS_uestc/pages/submitteacheradvise',
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

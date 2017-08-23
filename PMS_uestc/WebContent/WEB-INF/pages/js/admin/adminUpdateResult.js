function editPaperModal(id){
	//获取表格中的一行数据
	var stuId = document.getElementById(id).children[0].innerHTML;
	var stuName = document.getElementById(id).children[1].innerHTML;
	var paperTitle = document.getElementById(id).children[2].innerHTML;
	var paperIfPass = document.getElementById(id).children[3].innerHTML;
	//填充至模态框中
    $('#stuId').val(stuId);  
    $('#stuName').val(stuName);  
    $('#paperTitle').val(paperTitle); 
    $('#paperSelector').val(paperIfPass);
    $( "#paper-modal" ).dialog( "open" );
    return false;
}

function editBlindModal(id){
	alert(id);
	//获取表格中的一行数据
	var bstuId = document.getElementById(id).children[0].innerHTML;
	var bstuName = document.getElementById(id).children[1].innerHTML;
	var teacherId = document.getElementById(id).children[2].innerHTML;
	var teacherName = document.getElementById(id).children[3].innerHTML;
	var teacherGrade = document.getElementById(id).children[4].innerHTML;
	var teacherResult = document.getElementById(id).children[5].innerHTML;
	//填充至模态框中
    $('#bstuId').val(bstuId);  
    $('#bstuName').val(bstuName); 
    $('#teacherId').val(teacherId); 
    $('#teacherName').val(teacherName); 
    $('#teacherGrade').val(teacherGrade);
    $('#teacherResult').val(teacherResult);
    $( "#blind-modal" ).dialog("open");
    return false;
}

function editReplyModal(id){
	alert(id);
	//获取表格中的一行数据
	var rstuId = document.getElementById(id).children[0].innerHTML;
	var rstuName = document.getElementById(id).children[1].innerHTML;
	var groupId = document.getElementById(id).children[2].innerHTML;
	var rteacherId = document.getElementById(id).children[3].innerHTML;
	var rteacherName = document.getElementById(id).children[4].innerHTML;
	var replyGrade = document.getElementById(id).children[5].innerHTML;
	//填充至模态框中
    $('#rstuId').val(rstuId);  
    $('#rstuName').val(rstuName); 
    $('#groupId').val(groupId); 
    $('#rteacherId').val(rteacherId); 
    $('#rteacherName').val(rteacherName);
    $('#replyGrade').val(replyGrade);
    $( "#reply-modal" ).dialog("open");
    return false;
}

$(function() {
   $( "#paper-modal" ).dialog({
        autoOpen: false,
        resizable: false,
        modal: true,
        buttons: {
            确定: function () {
                var stuId = $('#stuId').val();
                var paperIfPass = $('#paperSelector').val();
                $.ajax({
                	type:"POST",
                	url:"http://localhost:8080/PMS_uestc/admin/UpdatePaperResult.action",
                	data:{stuId:$.trim(stuId),paperIfPass:$.trim(paperIfPass)},
                	success:function(data){
            			if($.trim(data) == "error"){
            				alert("修改失败！");
            				out.clear();
            				out = pageContext.pushBody();
            			}else if($.trim(data) == "success"){
            				alert("修改成功！");
            				window.location="http://localhost:8080/PMS_uestc/admin/toUpdateResult.action"
            				out.clear();
            				out = pageContext.pushBody();
            			}
                	},
            		error:function(){
            			alert("出现异常");
            		}
                });
                $(this).dialog("close");
            },
            取消: function() {
                $( this ).dialog( "close" );
            }
        }
    });
   $( "#blind-modal" ).dialog({
       autoOpen: false,
       resizable: false,
       modal: true,
       buttons: {
           确定: function () {
               var stuId = $('#bstuId').val();
               var teacherId = $('#teacherId').val();
               var teacherGrade = parseInt($('#teacherGrade').val());
               $.ajax({
               	type:"POST",
               	url:"http://localhost:8080/PMS_uestc/admin/UpdateBlindResult.action",
               	data:{stuId:$.trim(stuId),teacherId:$.trim(teacherId),teacherGrade:$.trim(teacherGrade)},
               	success:function(data){
           			if($.trim(data) == "error"){
           				alert("修改失败！");
           				out.clear();
           				out = pageContext.pushBody();
           			}else if($.trim(data) == "success"){
           				alert("修改成功！");
           				window.location="http://localhost:8080/PMS_uestc/admin/toUpdateResult.action"
           				out.clear();
           				out = pageContext.pushBody();
           			}
               	},
           		error:function(){
           			alert("出现异常");
           		}
               });
               $(this).dialog("close");
           },
           取消: function() {
               $( this ).dialog( "close" );
           }
       }
   });
   $( "#reply-modal" ).dialog({
       autoOpen: false,
       resizable: false,
       modal: true,
       buttons: {
           确定: function () {
               var stuId = $('#rstuId').val();
               var groupId = $('#groupId').val();
               var teacherId = $('#rteacherId').val();
               var replyGrade = parseInt($('#replyGrade').val());
               $.ajax({
               	type:"POST",
               	url:"http://localhost:8080/PMS_uestc/admin/UpdateReplyResult.action",
               	data:{stuId:$.trim(stuId),groupId:$.trim(groupId),teacherId:$.trim(teacherId),replyGrade:$.trim(replyGrade)},
               	success:function(data){
           			if($.trim(data) == "error"){
           				alert("修改失败！");
           				out.clear();
           				out = pageContext.pushBody();
           			}else if($.trim(data) == "success"){
           				alert("修改成功！");
           				window.location="http://localhost:8080/PMS_uestc/admin/toUpdateResult.action"
           				out.clear();
           				out = pageContext.pushBody();
           			}
               	},
           		error:function(){
           			alert("出现异常");
           		}
               });
               $(this).dialog("close");
           },
           取消: function() {
               $( this ).dialog( "close" );
           }
       }
   });
});

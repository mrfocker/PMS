function editStuRequestModal(id){
	//获取表格中的一行数据
	var stuId = document.getElementById(id).children[0].innerHTML;
	var stuName = document.getElementById(id).children[1].innerHTML;
	var stuRequestReplyTime = document.getElementById(id).children[2].innerHTML;
	//填充至模态框中
    $('#stuId').val(stuId);  
    $('#stuName').val(stuName);  
    $('#requestSelector').val(stuRequestReplyTime);
    $( "#request-modal" ).dialog( "open" );
    return false;
}

function editStuReplyModal(id){
	//获取表格中的一行数据
	var restuId = document.getElementById(id).children[0].innerHTML;
	var restuName = document.getElementById(id).children[1].innerHTML;
	var replyTime = document.getElementById(id).children[2].innerHTML;
	//填充至模态框中
    $('#restuId').val(restuId);  
    $('#restuName').val(restuName);  
    $('#replyTime').val(replyTime);
    $("#replyTime").datepicker();
    $( "#replytime-modal" ).dialog( "open" );
    return false;
}

function replyTimeSetting(){
    var date = new Date();
    var seperator1 = "-";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
    
    $("#currentDate").val(currentdate);
    $("#currentDate").datepicker();
    $("#replytime-setting").dialog("open");
    return false;
}


$(function() {
	$( "#request-modal" ).dialog({
		autoOpen: false,
	    resizable: false,
	    modal: true,
	    buttons: {
	    	确定: function () {
	    		var stuId = $('#stuId').val();
	            var stuRequestReplyTime = $('#requestSelector').val();
	            $.ajax({
	            	type:"POST",
	                url:"http://localhost:8080/PMS_uestc/admin/UpdateRequestReplyTime.action",
	                data:{stuId:$.trim(stuId),stuRequestReplyTime:$.trim(stuRequestReplyTime)},
	                success:function(data){
	            		if($.trim(data) == "error"){
	            			alert("修改失败！");
	            			out.clear();
	            			out = pageContext.pushBody();
	            		}else if($.trim(data) == "success"){
	            			alert("修改成功！");
	            			window.location="http://localhost:8080/PMS_uestc/admin/toRequestReplyTime.action"
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

	$( "#replytime-modal" ).dialog({
		autoOpen: false,
	    resizable: false,
	    modal: true,
	    buttons: {
	    	确定: function () {
	    		var restuId = $('#restuId').val();
	            var replyTime = $('#replyTime').val();
	            $.ajax({
	            	type:"POST",
	                url:"http://localhost:8080/PMS_uestc/admin/UpdateReplyTime.action",
	                data:{stuId:$.trim(restuId),stuReplyTime:$.trim(replyTime)},
	                success:function(data){
	            		if($.trim(data) == "error"){
	            			alert("修改失败！");
	            			out.clear();
	            			out = pageContext.pushBody();
	            		}else if($.trim(data) == "success"){
	            			alert("修改成功！");
	            			window.location="http://localhost:8080/PMS_uestc/admin/toUpdateReplyTime.action"
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
	
	$( "#replytime-setting" ).dialog({
		autoOpen: false,
	    resizable: false,
	    modal: true,
	    buttons: {
	    	确定: function () {
	            var replyTime = $('#currentDate').val();
	            $.ajax({
	            	type:"POST",
	                url:"http://localhost:8080/PMS_uestc/admin/ReplyTimeSetting.action",
	                data:{replyTime:$.trim(replyTime)},
	                success:function(data){
	            		if($.trim(data) == "error"){
	            			alert("修改失败！");
	            			out.clear();
	            			out = pageContext.pushBody();
	            		}else if($.trim(data) == "success"){
	            			alert("修改成功！");
	            			window.location="http://localhost:8080/PMS_uestc/admin/toUpdateReplyTime.action"
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

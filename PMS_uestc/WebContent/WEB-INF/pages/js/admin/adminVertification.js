function departVertify(){
	//封装数据的对象
	var StuDepartPass = {
		stuId:"",paperTitle:"",paperDepartPass:""
	}
	
	var saveData = [];
	//封装表格中的数据
    var rows = document.getElementById("dtVertify").rows.length; //获得行数(包括thead)
    var colums = document.getElementById("dtVertify").rows[0].cells.length; //获得列数 
    if(rows > 1){
    	for(var i = 1; i <rows; i++){
    		var StuDepartPass = new Object();
    		var selectorId = document.getElementById("dtVertify").rows[i].cells[0].innerHTML;
    		StuDepartPass.stuId = selectorId;
    		StuDepartPass.paperTitle = document.getElementById("dtVertify").rows[i].cells[2].innerHTML;
    		if(document.getElementById("dtVertify").rows[i].cells[4].innerHTML == "无法审核"){
    			StuDepartPass.paperDepartPass = "";
    		}else{
    			StuDepartPass.paperDepartPass = document.getElementById(selectorId).value;
    		}
    		saveData.push(StuDepartPass);//向JSON数组添加JSON对象的方法
    	}
    }
    
    ///格式化数据
    var obj=JSON.stringify(saveData);
    alert(obj);
    
    //异步提交数据
    $.ajax({
    	url: "http://localhost:8080/PMS_uestc/admin/UpdateDepartResult.action",
        type: "post",
        data: obj,
        contentType: 'application/json', 
        datatype: "json",
        success: function (data) {
        	window.location="http://localhost:8080/PMS_uestc/admin/verifyPaper.action"
        }
    });
}

$(function() {

    $('#dtVertify').dataTable( {
    	"bJQueryUI": true,
        "sPaginationType": "full_numbers"
    });
	
    $( "#modal-dialog" ).dialog({
        autoOpen: false,
        resizable: false,
        modal: true,
        buttons: {
            确定: function () {
                alert("进行批量下载");
                $(this).dialog("close");
            },
            取消: function() {
                $( this ).dialog( "close" );
            }
        }
    });

    $( "#open-modal-dialog" ).click(function() {
        $( "#modal-dialog" ).dialog( "open" );
        return false;
    });
});


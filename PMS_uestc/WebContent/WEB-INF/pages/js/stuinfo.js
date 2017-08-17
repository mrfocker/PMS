/*papaper process, there are 6 steps here*/
function load(){
	
	var str = {stu_id:"201522220299"};
	str = JSON.stringify(str);
	console.log(str);
	$.ajax({
	      url:'${pageContext.request.contextPath }/pages/getPaperAllInfo',
	      type:'get',
	     contentType:'application/json;charset=utf-8',
	      data:str,
	      /* data:'{teacher_Grade:score,teacher_description:return_cont}', */
	      success: function(data){      
	    	  console.log(data);
	          console.log("ok");
	          
	          if(data.paper_ifPass != null){
	        	  
	        	  $("#one").hide();
	              $("#two").show();
	              $("#grxx").attr("class","current_prev");
	              $("#zjxx").attr("class","current");
	              
	              $("#paperlistname").append("<th>学生姓名</th>");
	              $("#paperlist").append("<th>学生学号</th>");
	              $("#paperlist").append("<th>研究方向一</th>");
	              $("#paperlist").append("<th>研究方向二</th>");
	              $("#paperlist").append("<th>研究方向三</th>");
	              $("#paperlist").append("<th>导师评审</th>");
	              
	              $("#paperlist").append("<td>"+info.stu_name+"</td>");
	              $("#paperlist").append("<td>"+info.stu_Id+"</td>");
	              $("#paperlist").append("<td>"+info.paper_researchOne+"</td>");
	              $("#paperlist").append("<td>"+info.paper_researchTwo+"</td>");
	              $("#paperlist").append("<td>"+info.paper_researchThree+"</td>");
	              $("#paperlist").append("<td>"+info.paper_ifPass+"</td>")
	 
	          } 
	          },
	         
	    error: function(data){
	          console.log('failed');
	          alert("提交审核失败")
	            }
		
	    });
}

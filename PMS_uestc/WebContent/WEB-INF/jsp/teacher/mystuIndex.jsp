<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

 <div class="content container_12">
      <div class="box grid_12">
        <div class="box-head"><h2>毕业论文信息</h2></div>
        <div class="box-content no-pad">
          <table class="display">
          <thead>
            <tr>
              <th style="text-align:center;">学生姓名</th>
              <th style="text-align:center;">学生学号</th>
              <th style="text-align:center;">论文题目</th>
              <th style="text-align:center;">研究方向1</th>
              <th style="text-align:center;">研究方向2</th>
              <th style="text-align:center;">研究方向3</th>
              <th style="text-align:center;">论文状态</th>
              <th style="text-align:center;">论文下载</th>
              <th style="text-align:center;">导师审核</th>
            </tr>
          </thead>
          <tbody>
           <c:forEach items="${mystulist }" var="item">
            <tr class="odd gradeX">
              <td style="text-align:center;">${item.stu_name}</td>
              <td style="text-align:center;">${item.stu_id}</td>
              <td style="text-align:center;">${item.paper_title}</td>
              <td style="text-align:center;">${item.paper_researchOne}</td>
              <td style="text-align:center;">${item.paper_researchTwo}</td>
              <td style="text-align:center;">${item.paper_researchThree}</td>
              <c:choose>
              	<c:when test="${item.paper_blindjudgePass == null || item.paper_blindjudgePass == ''}">
                  <td style="text-align:center;">初审</td>
              	  <td style="text-align:center;"><button>下载</button></td>
                  <td style="text-align:center;"><button class="fa fa-child" data-toggle="modal" data-target="#myModal1" onclick='show_judgedetails(${item.paper_stuId});'>评审</button></td>
              	</c:when >
              	<c:when test="${item.paper_blindjudgePass == '通过' && (item.paper_replyPass == null || item.paper_replyPass == '')}">
                  <td style="text-align:center;">盲审</td>
              	  <td style="text-align:center;"><button>下载</button></td>
                  <td style="text-align:center;"><button class="fa fa-child" data-toggle="modal" data-target="#myModal2" onclick='show_blindjudgedetails(${item.paper_stuId});'>评审</button></td>
              	</c:when>
              	<c:when test="${item.paper_blindjudgePass == '通过' && item.paper_replyPass == '通过'}">
                  <td style="text-align:center;">答辩</td>
              	  <td style="text-align:center;"><button>下载</button></td>
                  <td style="text-align:center;"><button class="fa fa-child" data-toggle="modal" data-target="#myModal3" onclick='show_replyjudgedetails(${item.paper_stuId});'>评审</button></td>
              	</c:when>
              	<c:otherwise>   
  				  <td style="text-align:center;">论文未上传</td>
              	  <td style="text-align:center;">论文未上传</td>
                  <td style="text-align:center;">论文未上传</td>
                </c:otherwise>
              </c:choose> 
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
                    	论文初审
                    </h4>
                </div>
                  <div class="x_content">
                    <br />
                    <form class="form-horizontal form-label-left">
                    
                      <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-10">审核结果<span class="required"></span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                           <select name='organization' class="form-control" id ="result_select">
                             <option value="0"></option>
                             <option value='1'>通过</option>
                             <option value='2'>修改</option>
                             <option value='3'>不通过</option>
                           </select>
                        </div>
                      </div>

                      <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-10">修改意见 <span class="required"></span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                          <textarea class="form-control" rows="10" placeholder='' id='return_cont'></textarea>
                        </div>
                      </div>
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                         <div class="modal-footer" id = "submit_result">
                         
                          <!-- <button type="button" class="btn btn-primary" onclick="do_blindjudge(val);">提交</button> -->
                      
                          <!-- <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> -->
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
 
 <!-- 模态框（Modal） -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidde="true">
          <div class="modal-dialog">
            <div class="col-md-11 col-xs-22">                      
             <div class="modal-content">
                <div class="x_panel">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                     &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                    	盲审修改
                    </h4>
                </div>
                  <div class="x_content">
                    <br />
                    <form class="form-horizontal form-label-left">
                    
                      <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-10">审核结果<span class="required"></span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                           <select name='organization' class="form-control" id ="result_select2">
                             <option value="0"></option>
                             <option value='1'>通过</option>
                             <option value='2'>修改</option>
                             <option value='3'>不通过</option>
                           </select>
                        </div>
                      </div>

                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                         <div class="modal-footer" id = "submit_result2">
                         
                          <!-- <button type="button" class="btn btn-primary" onclick="do_blindjudge(val);">提交</button> -->
                      
                          <!-- <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> -->
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
 
 <!-- 模态框（Modal） -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidde="true">
          <div class="modal-dialog">
            <div class="col-md-11 col-xs-22">                      
             <div class="modal-content">
                <div class="x_panel">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                     &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                    	答辩修改
                    </h4>
                </div>
                  <div class="x_content">
                    <br />
                    <form class="form-horizontal form-label-left">
                    
                      <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-10">审核结果<span class="required"></span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                           <select name='organization' class="form-control" id ="result_select3">
                             <option value="0"></option>
                             <option value='1'>通过</option>
                             <option value='2'>修改</option>
                             <option value='3'>不通过</option>
                           </select>
                        </div>
                      </div>

                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                         <div class="modal-footer" id = "submit_result3">
                         
                          <!-- <button type="button" class="btn btn-primary" onclick="do_blindjudge(val);">提交</button> -->
                      
                          <!-- <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> -->
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
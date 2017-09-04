<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <!--- CONTENT AREA -->

    <div class="formbox">
            <div class="flow_steps">
                <ul>
                    <li id="grxx" class="current">提交论文</li>
                    <li id="zjxx">导师审核</li>
                    <li id="qzxx">学院审核</li>
                    <li id="lwcc">论文查重</li>
                    <li id="lwms">论文盲审</li>
                    <li id="lwdb">论文答辩</li>
                    <li id="qzfs" class="last">学位授予</li>
                </ul>
            </div>
    <!--论文信息-->
    <div class="content container_12">
      <div class="box grid_12">
        <div class="box-head"><h2>毕业论文信息</h2></div>
        <div class="box-content no-pad">
          <table class="display">
          <thead>
            <tr id = "paperlistname">
              <th>学生姓名</th>
              <th>学生学号</th>
              <th>论文题目</th>
              <th>研究方向1</th>
              <th>研究方向2</th>
              <th>研究方向3</th>
              <th>上传论文</th>
            </tr>
          </thead>
          <tbody>
           <c:forEach items="${studentPaperInfoList}" var="item">
            <tr class="odd gradeX" id = "paperlist">
              <td>${item.stu_name}</td>
              <td>${item.stu_id}</td>
              <td>${item.paper_title}</td>
              <td>${item.paper_researchOne}</td>
              <td>${item.paper_researchTwo}</td>
              <td>${item.paper_researchThree}</td>
              <td><button>上传</button></td>
            </tr>
           </c:forEach>
          </tbody>
         </table>
        </div>
      </div>
  </div>
   <!--论文信息完-->
            <div class="formcon">
                <div id="one">
                    <table align="center">
                        <tr id = "submit_button">
                            <!-- <td></td>
                            <td id = "submit_button"><button type="button" onclick="one_two('201522220299')">提交</button></td> -->
                        </tr>
                    </table>
                </div>
                <div id="two" style="display:none">
                    <table align="center">
                        <tr id= "two1">
                            <!-- <td>您的论文需要修改，请点击“确认”按钮查看导师意见并重新上传修改后的论文！</td> 
                            <td><button type="button" onclick="two_one()">确认</button></td> -->
                        </tr>
                    </table>
                </div>
                <div id="three" style="display:none">
                    <table align="center">
                        <tr id = "three1">
                            <!-- <td></td> 
                            <td><button type="button" onclick="three()">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" onclick="retwo()">上一步</button></td> -->
                        </tr>
                    </table>
                </div>
                <div id="four" style="display:none">
                    <table align="center">
                        <tr id = "four1">
                            <!-- <td></td> 
                            <td><button type="button" onclick="">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" onclick="rethree()">上一步</button></td> -->
                        </tr>
                    </table>
                </div>
            </div>
              <div id="five" style="display:none">
                    <table align="center" id = "five1">
                        <tr>
                            <!-- <td></td> 
                            <td><button type="button" onclick="">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" onclick="refour()">上一步</button></td> -->
                        </tr>
                    </table>
                </div>
                <div id="six" style="display:none">
                    <table align="center" id = "six1">
                        <tr>
                            <!-- <td></td> 
                            <td><button type="button" onclick="">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" onclick="refive()">上一步</button></td> -->
                        </tr>
                    </table>
                </div>
                <div id="seven" style="display:none">
                    <table align="center" id = "seven">
                        <tr>
                            <!-- <td></td> 
                            <td><button type="button" onclick="">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" onclick="refive()">上一步</button></td> -->
                        </tr>
                    </table>
                </div>
            </div>

        
        
 
<!-- 模态框 导师意见（Modal） -->
<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidde="true">
          <div class="modal-dialog">
            <div class="col-md-11 col-xs-22">                      
             <div class="modal-content">
                <div class="x_panel">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                     &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel" style="width:100%;text-align:center;font-weight:bold;">
                    	导师意见
                    </h4>
                </div>
                  <div class="x_content">
                    <br />
                    <form class="form-horizontal form-label-left">
                    
                      <!-- <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-10">审核结果<span class="required">*</span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                           <select name='organization' class="form-control" id ="result_select" onchange="getvalue(this)">
                             <option value="0"></option>
                             <option value='1'>通过</option>
                             <option value='2'>修改</option>
                             <option value='3'>不通过</option>
                           </select>
                        </div>
                      </div> -->

                      <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-10"><span class="required"></span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                          <textarea class="form-control" rows="20" placeholder='' id='return_cont' readonly="readonly" style="position:relative;right:55px;width:450px"></textarea>
                        </div>
                      </div>
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <!-- <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                         <div class="modal-footer" id = "submit_result">
                         
                         <button type="button" class="btn btn-primary" onclick="do_blindjudge(val);">提交</button>
                      
                          <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> 
                         </div>
                        </div> -->
                      </div>
                    </form>
                  </div>
                </div>
              </div>
              </div>
             </div>
         </div>
 <!-- 模态框导师意见（Modal）完 -->
 
 <!-- 模态框 学院意见（Modal） -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidde="true">
          <div class="modal-dialog">
            <div class="col-md-11 col-xs-22">                      
             <div class="modal-content">
                <div class="x_panel">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                     &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel" style="width:100%;text-align:center;font-weight:bold;">
                    	学院意见
                    </h4>
                </div>
                  <div class="x_content">
                    <br />
                    <form class="form-horizontal form-label-left">
                    
                      <!-- <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-10">审核结果<span class="required">*</span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                           <select name='organization' class="form-control" id ="result_select" onchange="getvalue(this)">
                             <option value="0"></option>
                             <option value='1'>通过</option>
                             <option value='2'>修改</option>
                             <option value='3'>不通过</option>
                           </select>
                        </div>
                      </div> -->

                      <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-10"><span class="required"></span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                          <textarea class="form-control" rows="20" placeholder='' id='return_cont2' readonly="readonly" style="position:relative;right:55px;width:450px"></textarea>
                        </div>
                      </div>
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <!-- <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                         <div class="modal-footer" id = "submit_result">
                         
                         <button type="button" class="btn btn-primary" onclick="do_blindjudge(val);">提交</button>
                      
                          <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> 
                         </div>
                        </div> -->
                      </div>
                    </form>
                  </div>
                </div>
              </div>
              </div>
             </div>
         </div>
 <!-- 模态框学院意见（Modal）完 -->
 
 <!-- 模态框盲审意见（Modal） -->
<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidde="true">
          <div class="modal-dialog">
            <div class="col-md-11 col-xs-22">                      
             <div class="modal-content">
                <div class="x_panel">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                     &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel" style="width:100%;text-align:center;font-weight:bold;">
                    	盲审组意见
                    </h4>
                </div>
                  <div class="x_content">
                    <br />
                    <form class="form-horizontal form-label-left">
                    
                      <!-- <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-10">审核结果<span class="required">*</span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                           <select name='organization' class="form-control" id ="result_select" onchange="getvalue(this)">
                             <option value="0"></option>
                             <option value='1'>通过</option>
                             <option value='2'>修改</option>
                             <option value='3'>不通过</option>
                           </select>
                        </div>
                      </div> -->

                      <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-10"><span class="required"></span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                          <textarea class="form-control" rows="20" placeholder='' id='return_cont3' readonly="readonly" style="position:relative;right:55px;width:450px"></textarea>
                        </div>
                      </div>
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <!-- <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                         <div class="modal-footer" id = "submit_result">
                         
                         <button type="button" class="btn btn-primary" onclick="do_blindjudge(val);">提交</button>
                      
                          <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> 
                         </div>
                        </div> -->
                      </div>
                    </form>
                  </div>
                </div>
              </div>
              </div>
             </div>
         </div>
 <!-- 模态框盲审（Modal）完 -->
 
 <!-- 模态框 答辩意见（Modal） -->
<div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidde="true">
          <div class="modal-dialog">
            <div class="col-md-11 col-xs-22">                      
             <div class="modal-content">
                <div class="x_panel">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                     &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel" style="width:100%;text-align:center;font-weight:bold;">
                    	答辩组意见
                    </h4>
                </div>
                  <div class="x_content">
                    <br />
                    <form class="form-horizontal form-label-left">
                    
                      <!-- <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-10">审核结果<span class="required">*</span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                           <select name='organization' class="form-control" id ="result_select" onchange="getvalue(this)">
                             <option value="0"></option>
                             <option value='1'>通过</option>
                             <option value='2'>修改</option>
                             <option value='3'>不通过</option>
                           </select>
                        </div>
                      </div> -->

                      <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-10"><span class="required"></span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                          <textarea class="form-control" rows="20" placeholder='' id='return_cont4' readonly="readonly" style="position:relative;right:55px;width:450px"></textarea>
                        </div>
                      </div>
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <!-- <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                         <div class="modal-footer" id = "submit_result">
                         
                         <button type="button" class="btn btn-primary" onclick="do_blindjudge(val);">提交</button>
                      
                          <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> 
                         </div>
                        </div> -->
                      </div>
                    </form>
                  </div>
                </div>
              </div>
              </div>
             </div>
         </div>
 <!-- 模态框答辩（Modal）完 -->
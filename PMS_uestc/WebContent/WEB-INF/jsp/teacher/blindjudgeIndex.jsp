<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--- CONTENT AREA -->
  <div class="content container_12">
      <div class="box grid_12">
        <div class="box-head"><h2>毕业论文信息</h2></div>
        <div class="box-content no-pad">
          <table class="display">
          <thead>
            <tr>
              <th style="text-align:center;">论文题目</th>
              <th style="text-align:center;">研究方向1</th>
              <th style="text-align:center;">研究方向2</th>
              <th style="text-align:center;">研究方向3</th>
              <th style="text-align:center;">论文下载</th>
              <th style="text-align:center;">论文评审</th>         
            </tr>
          </thead>
          <tbody>
           <c:forEach items="${blindJudgelist }" var="item">
            <tr class="odd gradeX">
              <td style="text-align:center;">${item.paper_title}</td>
              <td style="text-align:center;">${item.paper_researchOne}</td>
              <td style="text-align:center;">${item.paper_researchTwo}</td>
              <td style="text-align:center;">${item.paper_researchThree}</td>
              <td style="text-align:center;"><button>下载</button></td>
              <td style="text-align:center;"><button class="fa fa-child" data-toggle="modal" data-target="#myModal1" onclick='show_blinddetails(${item.stu_id});'>评审</button></td> 
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
                    	论文盲审
                    </h4>
                </div>
                  <div class="x_content">
                    <br />
                    <form class="form-horizontal form-label-left">
                      <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-10">评分</label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                          <input type="text" class="form-control" placeholder="评分范围0-100分" id='score'>
                        </div>
                      </div>


                      <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-10">审核结果<span class="required"></span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                           <select name='organization' class="form-control" id ="result_select">
                             <option value='0'></option>
                             <option value='1'>同意答辩</option>
                             <option value='2'>修改后重审</option>
                             <option value='3'>不同意答辩</option>
                             <option value='4'>不同意答辩</option>
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
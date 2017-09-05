package cn.pms.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.pms.ssm.po.TeacherQueryVo;
import cn.pms.ssm.service.PaperService;
import cn.pms.ssm.service.TeacherQueryService;

/** 
 * <p>Title: TeacherQueryController</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  liuxiang 
 * @date 创建时间：2017年7月12日 上午11:05:58 
 * @version 1.0 
*/

@Controller
@RequestMapping("/pages")
public class TeacherQueryController {
	 
	@Autowired
	private TeacherQueryService teacherQueryService;
	
	@RequestMapping("/teacherQueryStu")
	public @ResponseBody ModelAndView teacherQueryStu(HttpServletRequest request, TeacherQueryVo teacherQueryVo) throws Exception{
		
		List<TeacherQueryVo> mystulist = teacherQueryService.do_findMyStuInfo(teacherQueryVo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("mystulist",mystulist);
		modelAndView.setViewName("mystuIndex");
		System.out.println(modelAndView);
		return modelAndView;
		}
	
	//论文初审阶段
	@RequestMapping("/teacherQueryAdvise")
	public @ResponseBody TeacherQueryVo teacherQueryAdvise(@RequestBody TeacherQueryVo teacherQueryVo) throws Exception{
		
		TeacherQueryVo teacherQueryVo1 = null;
		teacherQueryVo1 = teacherQueryService.do_findTeacherAdvise(teacherQueryVo);
		
		if(teacherQueryVo1.getPaper_ifPass() == null || teacherQueryVo1.getPaper_ifPass().equals("")){
			teacherQueryVo1.setResult_code(0);
			teacherQueryVo1.setPaper_advise(" ");
		}
		else{
			if(teacherQueryVo1.getPaper_ifPass().equals("通过")){
				teacherQueryVo1.setResult_code(1);
			}
			if(teacherQueryVo1.getPaper_ifPass().equals("修改")){
				teacherQueryVo1.setResult_code(2);
			}
			if(teacherQueryVo1.getPaper_ifPass().equals("不通过")){
				teacherQueryVo1.setResult_code(3);
			}
		}
		return teacherQueryVo1;
	}
	
	@RequestMapping("/submitteacheradvise")
	public @ResponseBody void submit_teacheradvise(@RequestBody TeacherQueryVo teacherQueryVo) throws Exception{
		
		if(teacherQueryVo.getResult_code() == 0){
			teacherQueryVo.setPaper_ifPass(null);
		}
		if(teacherQueryVo.getResult_code() == 1){
			teacherQueryVo.setPaper_ifPass("通过");
		}
		if(teacherQueryVo.getResult_code() == 2){
			teacherQueryVo.setPaper_ifPass("修改");
			teacherQueryVo.setPaper_ifSubmit(0);
		}
		if(teacherQueryVo.getResult_code() == 3){
			teacherQueryVo.setPaper_ifPass("不通过");
		}
		System.out.println(teacherQueryVo.getResult_code());
		teacherQueryService.do_updateTeacherAdvise(teacherQueryVo);
		teacherQueryService.do_updateAdvise_1(teacherQueryVo);
	}
	
	//论文盲审阶段
	@RequestMapping("/teacherQueryblindAdvise")
	public @ResponseBody TeacherQueryVo teacherQueryblindAdvise(@RequestBody TeacherQueryVo teacherQueryVo) throws Exception{
		
		TeacherQueryVo teacherQueryVo1 = null;
		teacherQueryVo1 = teacherQueryService.do_findTeacherAdvise(teacherQueryVo);
		
		if(teacherQueryVo1.getPaper_ifReply() == null || teacherQueryVo1.getPaper_ifReply().equals("")){
			teacherQueryVo1.setResult_code(0);
		}
		else{
			if(teacherQueryVo1.getPaper_ifReply().equals("通过")){
				teacherQueryVo1.setResult_code(1);
			}
			if(teacherQueryVo1.getPaper_ifReply().equals("修改")){
				teacherQueryVo1.setResult_code(2);
			}
			if(teacherQueryVo1.getPaper_ifReply().equals("不通过")){
				teacherQueryVo1.setResult_code(3);
			}
		}
		return teacherQueryVo1;
	}
	
	@RequestMapping("/submitblindfixadvise")
	public @ResponseBody void submit_blindfixadvise(@RequestBody TeacherQueryVo teacherQueryVo) throws Exception{
		
		if(teacherQueryVo.getResult_code() == 0){
			teacherQueryVo.setPaper_ifReply(null);
		}
		if(teacherQueryVo.getResult_code() == 1){
			teacherQueryVo.setPaper_ifReply("通过");
		}
		if(teacherQueryVo.getResult_code() == 2){
			teacherQueryVo.setPaper_ifReply("修改");
			teacherQueryVo.setPaper_ifSubmit(0);
		}
		if(teacherQueryVo.getResult_code() == 3){
			teacherQueryVo.setPaper_ifReply("不通过");
		}
		System.out.println(teacherQueryVo.getResult_code());
		teacherQueryService.do_updateblindfixAdvise(teacherQueryVo);
		teacherQueryService.do_updateAdvise_1(teacherQueryVo);
	}
	
	//论文答辩阶段
		@RequestMapping("/teacherQueryreplyfixAdvise")
		public @ResponseBody TeacherQueryVo teacherQueryreplyfixAdvise(@RequestBody TeacherQueryVo teacherQueryVo) throws Exception{
			
			TeacherQueryVo teacherQueryVo1 = null;
			teacherQueryVo1 = teacherQueryService.do_findTeacherAdvise(teacherQueryVo);
			
			if(teacherQueryVo1.getPaper_over() == null || teacherQueryVo1.getPaper_over().equals("")){
				teacherQueryVo1.setResult_code(0);
			}
			else{
				if(teacherQueryVo1.getPaper_over().equals("通过")){
					teacherQueryVo1.setResult_code(1);
				}
				if(teacherQueryVo1.getPaper_over().equals("修改")){
					teacherQueryVo1.setResult_code(2);
				}
				if(teacherQueryVo1.getPaper_over().equals("不通过")){
					teacherQueryVo1.setResult_code(3);
				}
			}
			return teacherQueryVo1;
		}
		
		@RequestMapping("/submitreplyfixadvise")
		public @ResponseBody void submitblindfixadvise(@RequestBody TeacherQueryVo teacherQueryVo) throws Exception{
			
			if(teacherQueryVo.getResult_code() == 0){
				teacherQueryVo.setPaper_over(null);
			}
			if(teacherQueryVo.getResult_code() == 1){
				teacherQueryVo.setPaper_over("通过");
			}
			if(teacherQueryVo.getResult_code() == 2){
				teacherQueryVo.setPaper_over("修改");
				teacherQueryVo.setPaper_ifSubmit(0);
			}
			if(teacherQueryVo.getResult_code() == 3){
				teacherQueryVo.setPaper_over("不通过");
			}
			System.out.println(teacherQueryVo.getResult_code());
			teacherQueryService.do_updatereplyfixAdvise(teacherQueryVo);
			teacherQueryService.do_updateAdvise_1(teacherQueryVo);
		}
}

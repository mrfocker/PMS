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
		modelAndView.setViewName("/mystudents");
		System.out.println(modelAndView);
		return modelAndView;
		}
	
	@RequestMapping("/teacherQueryAdvise")
	public @ResponseBody ModelAndView teacherQueryAdvise(@RequestBody TeacherQueryVo teacherQueryVo) throws Exception{
		
		TeacherQueryVo teacherQueryVo1 = null;
		teacherQueryVo1 = teacherQueryService.do_findTeacherAdvise(teacherQueryVo);
		
		/*if(teacherQueryVo1.getPaper_ifPass().equals(null)){
			teacherQueryVo1.setResult_code(0);
		}*/
		if(teacherQueryVo1.getPaper_ifPass().equals("通过")){
			teacherQueryVo1.setResult_code(1);
		}
		if(teacherQueryVo1.getPaper_ifPass().equals("修改")){
			teacherQueryVo1.setResult_code(2);
		}
		if(teacherQueryVo1.getPaper_ifPass().equals("不通过")){
			teacherQueryVo1.setResult_code(3);
		}
		return null;
		}
	
	@RequestMapping("/submitteacheradvise")
	public @ResponseBody void submit_teacheradvise(@RequestBody TeacherQueryVo teacherQueryVo) throws Exception{
		
		if(teacherQueryVo.getResult_code() == 0){
			teacherQueryVo.setPaper_ifPass("无");
		}
		if(teacherQueryVo.getResult_code() == 1){
			teacherQueryVo.setPaper_ifPass("通过");
		}
		if(teacherQueryVo.getResult_code() == 2){
			teacherQueryVo.setPaper_ifPass("修改");
		}
		if(teacherQueryVo.getResult_code() == 3){
			teacherQueryVo.setPaper_ifPass("不通过");
		}
		System.out.println(teacherQueryVo.getResult_code());
		//调用提交评价接口
		teacherQueryService.do_updateTeacherAdvise(teacherQueryVo);
	}
	
	
}

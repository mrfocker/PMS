package cn.pms.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		
		List<TeacherQueryVo> mystulist = teacherQueryService.findMyStuInfo(teacherQueryVo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("mystulist",mystulist);
		modelAndView.setViewName("/teachertables");
		System.out.println(modelAndView);
		return modelAndView;
		}
	
	

}

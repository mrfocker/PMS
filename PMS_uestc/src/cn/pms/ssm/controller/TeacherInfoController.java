package cn.pms.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.pms.ssm.service.impl.TeacherInfoService;

/** 
 * <p>Title: TeacherInfoController</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  gpan 
 * @date 创建时间：2017年6月28日 下午6:59:13 
 * @version 1.0 
*/
@Controller
public class TeacherInfoController {
	
	@Autowired
	private TeacherInfoService teacherInfoService;
	
	@RequestMapping("/teacherInfo")
	public ModelAndView teacherInfo() throws Exception{
		
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("controller run");
		String string=teacherInfoService.selectTeacherRearch("10010");
		System.out.println(string);
		modelAndView.addObject("str", string);
		modelAndView.setViewName("test");
		return modelAndView;
		
	}
}


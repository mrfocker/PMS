package cn.pms.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.pms.ssm.po.Student;

/** 
 * <p>Title: </p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author:  liuxiang 
 * @date:2017年8月12日
 * @version 1.0 
*/

@Controller
@RequestMapping("/pages")
public class StudentsInfoController {
	
	@RequestMapping("/studentinfo")
	public @ResponseBody ModelAndView find_studentinfo(Student student) throws Exception{
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/students");
		System.out.println(modelAndView);
		return modelAndView;
		
	}

}

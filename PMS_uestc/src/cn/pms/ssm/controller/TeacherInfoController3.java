package cn.pms.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/** 
 * <p>Title: </p> 
 * <p>Description:注解的Handler </p> 
 * <p>Company: uestc_xr</p> 
 * @author:  liuxiang 
 * @date:2017年6月24日
 * @version 1.0 
*/

@Controller
public class TeacherInfoController3 {
	
	//查询列表
	@RequestMapping("/queryTeacherInfo.action")
	public ModelAndView queryItems()throws Exception{
		//返回ModelAndView
		ModelAndView modelAndView =  new ModelAndView();
		//相当 于request的setAttribut，在jsp页面中通过itemsList取数据
		//modelAndView.addObject("itemsList", itemsList);
		
		//指定视图
		modelAndView.setViewName("/WEB-INF/pages/html/index.jsp");

		return modelAndView;
	}

}

package cn.pms.ssm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.pms.ssm.po.PaperVo;
import cn.pms.ssm.po.TeacherVo;
import cn.pms.ssm.service.impl.GetStuPaperService;
import cn.pms.ssm.service.impl.TeacherInfoService;

/** 
 * <p>Title: testMatchController</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  gpan 
 * @date 创建时间：2017年6月30日 下午4:10:02 
 * @version 1.0 
*/

public class testMatchController {
	
	@Autowired
	private  TeacherInfoService teacherInfoService;
	@Autowired
	private  GetStuPaperService getStuPaperService;
	
	@RequestMapping("/testMatch1")
	public ModelAndView math()throws Exception{
		
		System.out.println("run controller");
		ModelAndView modelAndView = new ModelAndView();
		
	
		
		modelAndView.setViewName("test");
		return modelAndView;		
	}
	
	
	
	
}


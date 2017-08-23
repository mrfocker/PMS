package cn.pms.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.pms.ssm.po.Administrator;
import cn.pms.ssm.po.Student;
import cn.pms.ssm.po.Teacher;
import cn.pms.ssm.service.AdminService;
import cn.pms.ssm.vo.StudentPaperVo;

/**
 * 用户点击上方导航栏时触发的Controller
 * @author HeXi
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminClickNavigationController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/userInfo")
	public ModelAndView userInfo(HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView();
		
		Administrator admin = (Administrator) httpSession.getAttribute("current_user");
		modelAndView.addObject("admin",admin);
		
		List<Student> students = adminService.selectAllStudents();
		modelAndView.addObject("students",students);
		
		List<Teacher> teachers = adminService.selectAllTeachers();
		modelAndView.addObject("teachers",teachers);
		
		modelAndView.setViewName("adminUserinfo");
		return modelAndView;
	}
	
	@RequestMapping(value = "/verifyPaper")
	public @ResponseBody ModelAndView vertifyPaper(HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView();
		
		Administrator admin = (Administrator) httpSession.getAttribute("current_user");
		modelAndView.addObject("admin",admin);
		
		List<StudentPaperVo> stupaper = adminService.getStudentPaper();
		modelAndView.addObject("stupaper",stupaper);
		
		modelAndView.setViewName("adminVertification");
		return modelAndView;
	}
	
	@RequestMapping(value = "/changePwd")
	public @ResponseBody ModelAndView changePwd(HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView();
		
		Administrator admin = (Administrator) httpSession.getAttribute("current_user");
		modelAndView.addObject("admin",admin);
		
    	modelAndView.setViewName("adminChangePwd");
    	return modelAndView;
	}
}

/**
 * 
 */
package cn.pms.ssm.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;

import cn.pms.ssm.po.Administrator;
import cn.pms.ssm.po.Student;
import cn.pms.ssm.po.Teacher;
import cn.pms.ssm.service.LoginService;

/** 
 * <p>Title: LoginController</p> 
 * <p>Description:登录的Controller </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年6月8日 上午11:16:03 
 * @version 1.0 
*/
@Controller
@Scope("prototype")
@RequestMapping("/pages")
public class LoginController{

	private static final int ADMIN = 9;
	private static final int TEACHER = 1;
	private static final int STUDENT = 2;
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LoginService loginService;
	
	private Integer result;
	private Logger log = Logger.getLogger(LoginController.class);
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@RequestMapping(value="/login", method={RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody ModelAndView login(HttpSession httpSession, @RequestParam("userId") String userId, 
			@RequestParam("userPwd") String userPwd) throws Exception {
//		 TODO Auto-generated method stub
		
		int userTypes = 1;
		ModelAndView modelAndView = new ModelAndView();
		
		if(null != userId){
			userTypes = Integer.parseInt(userId.substring(0, 1));
		}
//		Map<String, Object> model = new HashMap<String, Object>();
//		httpSession.setAttribute("id", userId);
//		httpSession.setAttribute("userTypes", userTypes);
		
//		System.out.println("-------------------------------------->LoginController");
		switch (userTypes) {
			case ADMIN:
				Administrator administrator = new Administrator();
				administrator.setSu_id(Float.parseFloat(userId));
				administrator.setSu_password(userPwd);
				
				if (loginService.selectadminlogin(administrator) != null) {
					result = loginService.selectadminlogin(administrator);
					log.debug("logintest================>"+result);
					
					if (0 ==result) {
						administrator.setSu_isonline(true);
						loginService.updateAdminStatus(administrator);
						modelAndView.addObject("success", "success");
						modelAndView.setViewName("/tables");
						return modelAndView;
					} else {
						modelAndView.addObject("error", "当前用户已登录");
						modelAndView.setViewName("/html/logining/index");
						return modelAndView;
					}
				} else {
					modelAndView.addObject("error", "用户名或密码错误");
					modelAndView.setViewName("/html/logining/index");
					return modelAndView;
				}
				
		case TEACHER:
				Teacher teacher = new Teacher();
				teacher.setTeacher_id(userId);
				teacher.setTeacher_password(userPwd);
				
				if (loginService.selectteacherlogin(teacher) != null) {
					result = loginService.selectteacherlogin(teacher);
					log.debug("logintest================>"+result);
					
					if (0 ==result) {
						teacher.setTeacher_isonline(true);
						loginService.updateTeacherStatus(teacher);
						modelAndView.addObject("success", "success");
						modelAndView.setViewName("/tables");
						return modelAndView;
					} else {
						modelAndView.addObject("error", "当前用户已登录");
						modelAndView.setViewName("/html/logining/index");
						return modelAndView;
					}
				} else {
					modelAndView.addObject("error", "用户名或密码错误");
					modelAndView.setViewName("/html/logining/index");
					return modelAndView;
				}
				
			case STUDENT:
				Student student = new Student();
				student.setStu_id(userId);
				student.setStu_password(userPwd);
				
				if (loginService.selectstudentlogin(student) != null) {
					result = loginService.selectstudentlogin(student);
					log.debug("logintest================>"+result);
					
					if (0 ==result) {
						student.setStu_isonline(true);
						loginService.updateStudentStatus(student);
						modelAndView.addObject("success", "success");
						modelAndView.setViewName("/logining/tables");
						return modelAndView;
					} else {
						modelAndView.addObject("error", "当前用户已登录");
						modelAndView.setViewName("/html/logining/index");
						return modelAndView;
					}
				} else {
					modelAndView.addObject("error", "用户名或密码错误");
					modelAndView.setViewName("/html/logining/index");
					return modelAndView;
				}
	
			default:
				break;
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/exitLogin", method={RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody ModelAndView exitLogin() {
		ModelAndView modelAndView = new  ModelAndView();
		
		return modelAndView;
	}
}


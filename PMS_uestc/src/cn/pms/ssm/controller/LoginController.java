/**
 * 
 */
package cn.pms.ssm.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.mvc.Controller;

import cn.pms.ssm.po.Administrator;
import cn.pms.ssm.po.Student;
import cn.pms.ssm.po.Teacher;
import cn.pms.ssm.service.LoginService;

/** 
 * <p>Title: LoginController</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年6月8日 上午11:16:03 
 * @version 1.0 
*/
@Controller
@RequestMapping("/logining")
public class LoginController{

	private static final int ADMIN = 0;
	private static final int TEACHER = 1;
	private static final int STUDENT = 2;
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LoginService loginService;
	
	private Integer result;
	private Logger log;
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
//	@ResponseBody
	public String login(@RequestParam("userId") String userId, 
			@RequestParam("userPwd") String userPwd, 
			@RequestParam("userType") String userType, Model model) throws Exception {
//		 TODO Auto-generated method stub
//		String userId = request.getParameter("userId");
//		String userPwd = request.getParameter("userPwd");
		int userTypes = Integer.parseInt(userType);
//		Map<String, Object> model = new HashMap<String, Object>();
		
		System.out.println("-------------------------------------->Controller");
		System.out.println("-------------------------------------->LoginController");
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
						model.addAttribute("success", "success");
						return "/test";
					} else {
						model.addAttribute("error", "当前用户已登录");
						return "/index";
					}
					
				} else {
					model.addAttribute("error", "用户名或密码错误");
					return "/index";
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
						model.addAttribute("success", "success");
						return "/test";
					} else {
						model.addAttribute("error", "当前用户已登录");
						return "/index";
					}
					
				} else {
					model.addAttribute("error", "用户名或密码错误");
					return "/index";
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
						model.addAttribute("success", "success");
						return "/test";
					} else {
						model.addAttribute("error", "当前用户已登录");
						return "/index";
					}
					
				} else {
					model.addAttribute("error", "用户名或密码错误");
					return "/index";
				}
	
			default:
				break;
		}
		return null;
	}
}

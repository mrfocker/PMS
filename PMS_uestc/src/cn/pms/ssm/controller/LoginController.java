/**
 * 
 */
package cn.pms.ssm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

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
//@RequestMapping("/login.do")
public class LoginController implements Controller{

	private static final int ADMIN = 0;
	private static final int TEACHER = 1;
	private static final int STUDENT = 2;
	
	private LoginService loginService;
	private Integer result;
	private Logger log;
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
//	@RequestMapping(params = "handleRequest") 
	public @ResponseBody ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		int userType = Integer.parseInt(request.getParameter("userType"));
		Map<String, Object> model = new HashMap<String, Object>();
		
		switch (userType) {
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
						model.put("success", "success");
						return new ModelAndView("WEB-INF/pages/html/test.jsp", model);
					} else {
						model.put("error", "当前用户已登录");
						return new ModelAndView("WEB-INF/pages/html/index.jsp", model);
					}
					
				} else {
					model.put("error", "用户名或密码错误");
					return new ModelAndView("WEB-INF/pages/html/index.jsp", model);
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
						model.put("success", "success");
						return new ModelAndView("WEB-INF/pages/html/test.jsp", model);
					} else {
						model.put("error", "当前用户已登录");
						return new ModelAndView("WEB-INF/pages/html/index.jsp", model);
					}
					
				} else {
					model.put("error", "用户名或密码错误");
					return new ModelAndView("WEB-INF/pages/html/index.jsp", model);
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
						model.put("success", "success");
						return new ModelAndView("WEB-INF/pages/html/test.jsp", model);
					} else {
						model.put("error", "当前用户已登录");
						return new ModelAndView("WEB-INF/pages/html/index.jsp", model);
					}
					
				} else {
					model.put("error", "用户名或密码错误");
					return new ModelAndView("WEB-INF/pages/html/index.jsp", model);
				}
	
			default:
				break;
		}
		return null;
	}
	/**
	 * @return the loginService
	 */
	public LoginService getLoginService() {
		return loginService;
	}
	/**
	 * @param loginService the loginService to set
	 */
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

}

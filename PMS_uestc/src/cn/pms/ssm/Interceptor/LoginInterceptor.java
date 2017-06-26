/**
 * 
 */
package cn.pms.ssm.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.pms.ssm.service.LoginService;

/** 
 * <p>Title: LoginInterceptor</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年6月23日 下午12:56:39 
 * @version 1.0 
*/
public class LoginInterceptor implements HandlerInterceptor {

	private static final int ADMIN = 0;
	private static final int TEACHER = 1;
	private static final int STUDENT = 2;
	
	@Autowired
	private LoginService loginService;
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		String url = request.getRequestURI();
		Boolean status = true;
		
		if (url.indexOf("login.action") >= 0) {
			return true;
		}
		
		HttpSession httpSession = request.getSession();
		
		String id = (String) httpSession.getAttribute("id");
		int userTypes = (int) httpSession.getAttribute("userTypes");
		
		switch (userTypes) {
		case ADMIN:
			status = loginService.selectAdminStatus(id);
			break;
			
		case STUDENT:
			status = loginService.selectStudentStatus(id);
			break;
			
		case TEACHER:
			status = loginService.selectTeacherStatus(id);
			break;

		default:
			break;
		}
		
		if (status == false) {
			return true;
		}else {
			request.getRequestDispatcher("/WEB-INF/pages/html/logining/index.jsp").forward(request, response);
			return false;
		}
		
	}

}

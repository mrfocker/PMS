package cn.pms.ssm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.pms.ssm.po.Administrator;
import cn.pms.ssm.service.UpdatePwdService;
import cn.pms.ssm.util.MD5Util;

/**
 * 修改密码的Controller
 * @author HeXi
 *
 */
@Controller
@RequestMapping("/pages")
public class UpdatePwdController {
	
	private static final int ADMIN = 9;
	private static final int TEACHER = 1;
	private static final int STUDENT = 2;

	@Autowired
	private UpdatePwdService updatePwdService;

    @RequestMapping(value = "/toUpdatePwd")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception {
    	ModelAndView modelAndView = new ModelAndView();
    	//视图名
    	modelAndView.setViewName("updatePwd");
    	return modelAndView;
    }
    
    @RequestMapping(value = "/validateUser",method={RequestMethod.POST, RequestMethod.GET})
    public void validateUser(@RequestParam("userId") String userId,@RequestParam("userIdNum") String userIdNumber,HttpServletResponse response) throws IOException{
    	
    	int userTypes = 1;
    	PrintWriter out = response.getWriter();
    	
		if (userId != null) {
			userTypes = Integer.parseInt(userId.substring(0, 1));
		}
		
		System.out.println("加密前："+userIdNumber);
		String userIdNum = MD5Util.md5Password(userIdNumber);
		System.out.println("加密后："+userIdNum);
		
		switch (userTypes) {
		case ADMIN:
			if(updatePwdService.selectByAdminIdAndAdminIdNum(userId, userIdNum) != null){
				out.write("success");
				out.flush();
				out.close();
			}else{
				out.write("error");
				out.flush();
				out.close();
			}
			break;

		case TEACHER:
			if(updatePwdService.selectByTeacherIdAndTeacherIdNum(userId, userIdNum) != null){
				out.write("success");
				out.flush();
				out.close();
			}else{
				out.write("error");
				out.flush();
				out.close();
			}
			break;

		case STUDENT:
			if(updatePwdService.selectByStuIdAndStudNum(userId, userIdNum) != null){
				out.write("success");
				out.flush();
				out.close();
			}else{
				out.write("error");
				out.flush();
				out.close();
			}
			break;

		default:
			out.write("error");
			out.flush();
			out.close();
			break;
		}
    }
    @RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
    public @ResponseBody ModelAndView updatePwd(HttpSession httpSession,@RequestParam("userId") String userId,@RequestParam("userNewPwd") String userNewPwd) throws IOException{
    	
    	System.out.println("updatePwd执行了");
    	System.out.println(userId);
    	System.out.println(userNewPwd);
		
    	int userTypes = 1;
		ModelAndView modelAndView = new ModelAndView();

		if (null != userId) {
			userTypes = Integer.parseInt(userId.substring(0, 1));
		}

		switch (userTypes) {
		case ADMIN:
			updatePwdService.updatePwdAdmin(userId,userNewPwd);
			Administrator admin = (Administrator) httpSession.getAttribute("current_user");
			modelAndView.addObject("admin", admin);
			modelAndView.setViewName("adminIndex");
			break;
			
		case STUDENT:
			updatePwdService.updatePwdStudent(userId,userNewPwd);
			modelAndView.setViewName("tables");
			break;
			
		case TEACHER:
			updatePwdService.updatePwdTeacher(userId,userNewPwd);
			modelAndView.setViewName("tables");
			break;
		default:
			break;
		}

    	return modelAndView;
    }

}

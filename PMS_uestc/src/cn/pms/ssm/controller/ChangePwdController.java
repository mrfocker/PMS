/**
 * 
 */
package cn.pms.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.pms.ssm.po.Administrator;
import cn.pms.ssm.po.Student;
import cn.pms.ssm.po.Teacher;
import cn.pms.ssm.service.ChangePwdService;
import net.sf.cglib.transform.AbstractClassLoader;

/**
 * <p>
 * Title: ChangePwdController
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: uestc_xr
 * </p>
 * 
 * @author Xiaozhe
 * @date 创建时间：2017年6月30日 下午2:00:20
 * @version 1.0
 */
@Controller
@RequestMapping("/pages")
public class ChangePwdController {

	private static final int ADMIN = 9;
	private static final int TEACHER = 1;
	private static final int STUDENT = 2;

	@Autowired
	private ChangePwdService changePwdService;

	// 从Cookie中获取ID，从页面上获取用户填写的当前密码,AJAX刷新页面,成功才能修改密码
	@RequestMapping(value = "/checkPwd", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView checkPwd(@RequestParam("userId") String userId, @RequestParam("userPwd") String userPwd) {
		int userTypes = 1;
		ModelAndView modelAndView = new ModelAndView();

		if (null != userId) {
			userTypes = Integer.parseInt(userId.substring(0, 1));
		}

		switch (userTypes) {
		case ADMIN:
			Administrator administrator = new Administrator();
			administrator.setSu_id(Float.parseFloat(userId));
			if (userPwd == changePwdService.selectPwdByAdminId(administrator)) {
				modelAndView.addObject("success", "success");
			} else {
				modelAndView.addObject("failed", "failed");
			}
			break;

		case TEACHER:
			Teacher teacher = new Teacher();
			teacher.setTeacher_id(userId);
			if (userPwd == changePwdService.selectPwdByTeacherId(teacher)) {
				modelAndView.addObject("success", "success");
			} else {
				modelAndView.addObject("failed", "failed");
			}
			break;

		case STUDENT:
			Student student = new Student();
			student.setStu_id(userId);
			if (userPwd == changePwdService.selectPwdByStudentId(student)) {
				modelAndView.addObject("success", "success");
			} else {
				modelAndView.addObject("failed", "failed");
			}
			break;

		default:
			break;
		}
		
		modelAndView.setViewName("/");
		return modelAndView;
	}

//	修改密码操作
	@RequestMapping(value = "/changePwd", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody ModelAndView changePwd(@RequestParam("userId") String userId,
			@RequestParam("userPwd") String userPwd) {

		int userTypes = 1;
		ModelAndView modelAndView = new ModelAndView();

		if (null != userId) {
			userTypes = Integer.parseInt(userId.substring(0, 1));
		}

		switch (userTypes) {
		case ADMIN:
			Administrator administrator = new Administrator();
			administrator.setSu_id(Float.parseFloat(userId));
			administrator.setSu_password(userPwd);
			changePwdService.updatePwdAdmin(administrator);
			break;
			
		case STUDENT:
			Student student = new Student();
			student.setStu_id(userId);
			student.setStu_password(userPwd);
			changePwdService.updatePwdStudent(student);
			break;
			
		case TEACHER:
			Teacher teacher = new Teacher();
			teacher.setTeacher_id(userId);
			teacher.setTeacher_password(userPwd);
			changePwdService.updatePwdTeacher(teacher);
			break;
		default:
			break;
		}

		modelAndView.addObject("success", "success");
		modelAndView.setViewName("/");
		return modelAndView;
	}
}

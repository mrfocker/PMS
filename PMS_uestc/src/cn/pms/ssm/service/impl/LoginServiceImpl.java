/**
 * 
 */
package cn.pms.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pms.ssm.mapper.LoginMapper;
import cn.pms.ssm.po.Administrator;
import cn.pms.ssm.po.Student;
import cn.pms.ssm.po.Teacher;
import cn.pms.ssm.service.LoginService;

/** 
 * <p>Title: LoginServiceImpl</p> 
 * <p>Description:登录Service </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年6月8日 上午11:25:22 
 * @version 1.0 
*/
@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper; 
	/* (non-Javadoc)
	 * @see cn.pms.ssm.service.LoginService#selectstudentlogin(cn.pms.ssm.po.Student)
	 */
	@Override
	public Integer selectstudentlogin(Student student) {
		// TODO Auto-generated method stub
		return loginMapper.selectstudentlogin(student);
	}

	/* (non-Javadoc)
	 * @see cn.pms.ssm.service.LoginService#selectteacherlogin(cn.pms.ssm.po.Teacher)
	 */
	@Override
	public Integer selectteacherlogin(Teacher teacher) {
		// TODO Auto-generated method stub
		return loginMapper.selectteacherlogin(teacher);
	}

	/* (non-Javadoc)
	 * @see cn.pms.ssm.service.LoginService#selectadminlogin(cn.pms.ssm.po.Administrator)
	 */
	@Override
	public Integer selectadminlogin(Administrator administrator) {
		// TODO Auto-generated method stub
		return loginMapper.selectadminlogin(administrator);
	}

	/* (non-Javadoc)
	 * @see cn.pms.ssm.service.LoginService#updateStudentStatus(cn.pms.ssm.po.Student)
	 */
	@Override
	public void updateStudentStatus(Student student) {
		// TODO Auto-generated method stub
		loginMapper.updateStudentStatus(student);
	}

	/* (non-Javadoc)
	 * @see cn.pms.ssm.service.LoginService#updateTeacherStatus(cn.pms.ssm.po.Teacher)
	 */
	@Override
	public void updateTeacherStatus(Teacher teacher) {
		// TODO Auto-generated method stub
		loginMapper.updateTeacherStatus(teacher);
	}

	/* (non-Javadoc)
	 * @see cn.pms.ssm.service.LoginService#updateAdminStatus(cn.pms.ssm.po.Administrator)
	 */
	@Override
	public void updateAdminStatus(Administrator administrator) {
		// TODO Auto-generated method stub
		loginMapper.updateAdminStatus(administrator);
	}


}

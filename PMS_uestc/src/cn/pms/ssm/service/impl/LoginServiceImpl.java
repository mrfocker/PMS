/**
 * 
 */
package cn.pms.ssm.service.impl;

import org.springframework.stereotype.Service;

import cn.pms.ssm.mapper.LoginDAO;
import cn.pms.ssm.mapper.impl.LoginDAOImpl;
import cn.pms.ssm.po.Administrator;
import cn.pms.ssm.po.Student;
import cn.pms.ssm.po.Teacher;
import cn.pms.ssm.service.LoginService;

/** 
 * <p>Title: LoginServiceImpl</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年6月8日 上午11:25:22 
 * @version 1.0 
*/
@Service
public class LoginServiceImpl implements LoginService {

	private LoginDAOImpl loginDAOImpl; 
	/* (non-Javadoc)
	 * @see cn.pms.ssm.service.LoginService#selectstudentlogin(cn.pms.ssm.po.Student)
	 */
	@Override
	public Integer selectstudentlogin(Student student) {
		// TODO Auto-generated method stub
		return loginDAOImpl.selectstudentlogin(student);
	}

	/* (non-Javadoc)
	 * @see cn.pms.ssm.service.LoginService#selectteacherlogin(cn.pms.ssm.po.Teacher)
	 */
	@Override
	public Integer selectteacherlogin(Teacher teacher) {
		// TODO Auto-generated method stub
		return loginDAOImpl.selectteacherlogin(teacher);
	}

	/* (non-Javadoc)
	 * @see cn.pms.ssm.service.LoginService#selectadminlogin(cn.pms.ssm.po.Administrator)
	 */
	@Override
	public Integer selectadminlogin(Administrator administrator) {
		// TODO Auto-generated method stub
		return loginDAOImpl.selectadminlogin(administrator);
	}

	/**
	 * @return the loginDAOImpl
	 */
	public LoginDAOImpl getLoginDAOImpl() {
		return loginDAOImpl;
	}

	/**
	 * @param loginDAOImpl the loginDAOImpl to set
	 */
	public void setLoginDAOImpl(LoginDAOImpl loginDAOImpl) {
		this.loginDAOImpl = loginDAOImpl;
	}


}

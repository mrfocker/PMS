/**
 * 
 */
package cn.pms.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pms.ssm.mapper.ChangePwdMapper;
import cn.pms.ssm.po.Administrator;
import cn.pms.ssm.po.Student;
import cn.pms.ssm.po.Teacher;
import cn.pms.ssm.service.ChangePwdService;

/** 
 * <p>Title: ChangePwdServiceImpl</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年6月30日 下午1:55:35 
 * @version 1.0 
*/
@Service("changePwdService")
public class ChangePwdServiceImpl implements ChangePwdService {

	@Autowired
	private ChangePwdMapper changePwdMapper;
	/* (non-Javadoc)
	 * @see cn.pms.ssm.service.ChangePwdService#updatePwdStudent(cn.pms.ssm.po.Student)
	 */
	@Override
	public void updatePwdStudent(Student student) {
		// TODO Auto-generated method stub
		changePwdMapper.updatePwdStudent(student);
	}

	/* (non-Javadoc)
	 * @see cn.pms.ssm.service.ChangePwdService#updatePwdTeacher(cn.pms.ssm.po.Teacher)
	 */
	@Override
	public void updatePwdTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		changePwdMapper.updatePwdTeacher(teacher);
	}

	/* (non-Javadoc)
	 * @see cn.pms.ssm.service.ChangePwdService#updatePwdAdmin(cn.pms.ssm.po.Administrator)
	 */
	@Override
	public void updatePwdAdmin(Administrator administrator) {
		// TODO Auto-generated method stub
		changePwdMapper.updatePwdAdmin(administrator);
	}

	/* (non-Javadoc)
	 * @see cn.pms.ssm.service.ChangePwdService#selectPwdByStudentId(cn.pms.ssm.po.Student)
	 */
	@Override
	public String selectPwdByStudentId(Student student) {
		// TODO Auto-generated method stub
		return changePwdMapper.selectPwdByStudentId(student);
	}

	/* (non-Javadoc)
	 * @see cn.pms.ssm.service.ChangePwdService#selectPwdByTeacherId(cn.pms.ssm.po.Teacher)
	 */
	@Override
	public String selectPwdByTeacherId(Teacher teacher) {
		// TODO Auto-generated method stub
		return changePwdMapper.selectPwdByTeacherId(teacher);
	}

	/* (non-Javadoc)
	 * @see cn.pms.ssm.service.ChangePwdService#selectPwdByAdminId(cn.pms.ssm.po.Administrator)
	 */
	@Override
	public String selectPwdByAdminId(Administrator administrator) {
		// TODO Auto-generated method stub
		return changePwdMapper.selectPwdByAdminId(administrator);
	}

}

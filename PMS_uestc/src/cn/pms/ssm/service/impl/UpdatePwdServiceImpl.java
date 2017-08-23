package cn.pms.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pms.ssm.mapper.UpdatePwdMapper;
import cn.pms.ssm.po.Administrator;
import cn.pms.ssm.po.Student;
import cn.pms.ssm.po.Teacher;
import cn.pms.ssm.service.UpdatePwdService;

/**
 * 修改密码的Service实现类
 * @author HeXi
 *
 */
@Service("updatePwdService")
public class UpdatePwdServiceImpl implements UpdatePwdService {
	
	@Autowired
	private UpdatePwdMapper updatePwdMapper;

	@Override
	public Student selectByStuIdAndStudNum(String userId, String userIdNum) {
		return updatePwdMapper.selectByStuIdAndStuNum(userId,userIdNum);
	}

	@Override
	public Teacher selectByTeacherIdAndTeacherIdNum(String userId, String userIdNum) {
		return updatePwdMapper.selectByTeacherIdAndTeacherNum(userId,userIdNum);
	}

	@Override
	public Administrator selectByAdminIdAndAdminIdNum(String userId, String userIdNum) {
		return updatePwdMapper.selectByAdminIdAndAdminNum(userId,userIdNum);
	}

	@Override
	public void updatePwdAdmin(String userId, String userNewPwd) {
		updatePwdMapper.updatePwdAdmin(userId,userNewPwd);
	}

	@Override
	public void updatePwdStudent(String userId, String userNewPwd) {
		updatePwdMapper.updatePwdStudent(userId,userNewPwd);
	}

	@Override
	public void updatePwdTeacher(String userId, String userNewPwd) {
		updatePwdMapper.updatePwdTeacher(userId,userNewPwd);
	}

}

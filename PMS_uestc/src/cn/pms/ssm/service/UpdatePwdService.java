package cn.pms.ssm.service;

import org.springframework.stereotype.Service;

import cn.pms.ssm.po.Administrator;
import cn.pms.ssm.po.Student;
import cn.pms.ssm.po.Teacher;

/**
 * 修改密码的Service接口
 * @author HeXi
 *
 */
@Service
public interface UpdatePwdService {
	
	//检查用户名和身份证号码是否匹配
	public Student selectByStuIdAndStudNum(String userId,String userIdNum);
	
	public Teacher selectByTeacherIdAndTeacherIdNum(String userId,String userIdNum);
	
	public Administrator selectByAdminIdAndAdminIdNum(String userId,String userIdNum);

	//修改密码
	public void updatePwdAdmin(String userId, String userNewPwd);

	public void updatePwdStudent(String userId, String userNewPwd);

	public void updatePwdTeacher(String userId, String userNewPwd);

}

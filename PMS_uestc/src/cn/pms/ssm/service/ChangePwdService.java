/**
 * 
 */
package cn.pms.ssm.service;

import org.springframework.stereotype.Service;

import cn.pms.ssm.po.Administrator;
import cn.pms.ssm.po.Student;
import cn.pms.ssm.po.Teacher;

/** 
 * <p>Title: ChangePwdService</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年6月30日 下午1:54:35 
 * @version 1.0 
*/
@Service
public interface ChangePwdService {
	
	//检查当前密码是否正确
	public String selectPwdByStudentId(Student student);
	
	public String selectPwdByTeacherId(Teacher teacher);
	
	public String selectPwdByAdminId(Administrator administrator);
	
	//修改密码
	
	public void updatePwdStudent(Student student);
	
	public void updatePwdTeacher(Teacher teacher);
	
	public void updatePwdAdmin(Administrator administrator);
}

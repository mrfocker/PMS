/**
 * 
 */
package cn.pms.ssm.mapper;

import cn.pms.ssm.po.Administrator;
import cn.pms.ssm.po.Student;
import cn.pms.ssm.po.Teacher;

/** 
 * <p>Title: ChangePwdMapper</p> 
 * <p>Description:修改密码 </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年6月30日 下午1:21:33 
 * @version 1.0 
*/
public interface ChangePwdMapper {

	//检查当前密码是否正确
	public String selectPwdByStudentId(Student student);
	
	public String selectPwdByTeacherId(Teacher teacher);
	
	public String selectPwdByAdminId(Administrator administrator);
	
	//修改密码
	public void updatePwdStudent(Student student);
	
	public void updatePwdTeacher(Teacher teacher);
	
	public void updatePwdAdmin(Administrator administrator);
	
	
}

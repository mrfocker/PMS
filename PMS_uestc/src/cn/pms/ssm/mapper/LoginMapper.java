/**
 * 
 */
package cn.pms.ssm.mapper;

import org.springframework.stereotype.Repository;

import cn.pms.ssm.po.Administrator;
import cn.pms.ssm.po.Student;
import cn.pms.ssm.po.Teacher;

/** 
 * <p>Title: LoginStudentDAO</p> 
 * <p>Description:student login mapper interface </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年6月7日 下午3:32:57 
 * @version 1.0 
*/
public interface LoginMapper {
	
	public Integer selectstudentlogin(Student student);
	
	public Integer selectteacherlogin(Teacher teacher);
	
	public Integer selectadminlogin(Administrator administrator);
	
	public void updateStudentStatus(Student student);
	
	public void updateTeacherStatus(Teacher teacher);
	
	public void updateAdminStatus(Administrator administrator);

}

/**
 * 
 */
package cn.pms.ssm.mapper;

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
public interface LoginDAO {
	
	public Integer selectstudentlogin(Student student);
	
	public Integer selectteacherlogin(Teacher teacher);
	
	public Integer selectadminlogin(Administrator administrator);
	
	public void updateStudentStatus(Boolean isonline);
	
	public void updateTeacherStatus(Boolean isonline);
	
	public void updateAdminStatus(Boolean isonline);

}

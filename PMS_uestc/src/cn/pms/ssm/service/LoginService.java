/**
 * 
 */
package cn.pms.ssm.service;

import org.springframework.stereotype.Service;

import cn.pms.ssm.po.Administrator;
import cn.pms.ssm.po.Student;
import cn.pms.ssm.po.Teacher;

/**
 * <p>
 * Title: LoginService
 * </p>
 * <p>
 * Description:TODO
 * </p>
 * <p>
 * Company: uestc_xr
 * </p>
 * 
 * @author Xiaozhe
 * @date 创建时间：2017年6月8日 上午11:23:47
 * @version 1.0
 */

@Service
public interface LoginService {
	public Integer selectstudentlogin(Student student);

	public Integer selectteacherlogin(Teacher teacher);

	public Integer selectadminlogin(Administrator administrator);

	public void updateStudentStatus(Student student);

	public void updateTeacherStatus(Teacher teacher);

	public void updateAdminStatus(Administrator administrator);
}

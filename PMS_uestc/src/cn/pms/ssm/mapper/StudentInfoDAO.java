/**
 * 
 */
package cn.pms.ssm.mapper;

import java.util.List;

import javax.annotation.Resource;

import cn.pms.ssm.po.Student;
/**
 * @author Xiaozhe
 *
 */
public interface StudentInfoDAO {
	public List<Student> getStudentInfo();
}

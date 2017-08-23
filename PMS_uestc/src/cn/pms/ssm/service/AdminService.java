package cn.pms.ssm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.pms.ssm.po.Student;
import cn.pms.ssm.po.Teacher;
import cn.pms.ssm.vo.StudentPaperVo;

/**
 * 管理员的Service
 * @author Administrator
 *
 */
@Service
public interface AdminService {

	//查找所有的学生信息
	List<Student> selectAllStudents();

	//查找所有的老师信息
	List<Teacher> selectAllTeachers();

	//查询所有学生的论文
	List<StudentPaperVo> getStudentPaper();


}

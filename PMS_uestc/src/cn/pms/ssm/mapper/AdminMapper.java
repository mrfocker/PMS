package cn.pms.ssm.mapper;

import java.util.List;

import cn.pms.ssm.po.Student;
import cn.pms.ssm.po.Teacher;
import cn.pms.ssm.vo.StudentPaperVo;

/**
 * 管理员的Mapper
 * @author HeXi
 *
 */
public interface AdminMapper {

	List<Student> selectAllStudents();

	List<Teacher> selectAllTeachers();

	List<StudentPaperVo> getStudentPaper();

}

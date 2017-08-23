package cn.pms.ssm.mapper;

import org.apache.ibatis.annotations.Param;

import cn.pms.ssm.po.Administrator;
import cn.pms.ssm.po.Student;
import cn.pms.ssm.po.Teacher;

/**
 * 
 * @author HeXi
 *
 */
public interface UpdatePwdMapper {

	Student selectByStuIdAndStuNum(@Param("stuId")String stuId,@Param("stuIdNum") String stuIdNum);

	Teacher selectByTeacherIdAndTeacherNum(@Param("teacherId")String teacherId,@Param("teacherIdNum") String teacherIdNum);

	Administrator selectByAdminIdAndAdminNum(@Param("adminId")String adminId,@Param("adminIdNum") String adminIdNum);

	void updatePwdAdmin(@Param("adminId")String adminId,@Param("adminNewPwd") String adminNewPwd);

	void updatePwdStudent(@Param("stuId")String stuId,@Param("stuNewPwd") String stuNewPwd);

	void updatePwdTeacher(@Param("teacherId")String teacherId,@Param("teacherNewPwd") String teacherNewPwd);

}

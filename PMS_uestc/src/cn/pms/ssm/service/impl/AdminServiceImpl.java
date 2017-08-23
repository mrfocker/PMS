package cn.pms.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pms.ssm.mapper.AdminMapper;
import cn.pms.ssm.po.Student;
import cn.pms.ssm.po.Teacher;
import cn.pms.ssm.service.AdminService;
import cn.pms.ssm.vo.StudentPaperVo;

/**
 * 管理员的Service实现类
 * @author HeXi
 *
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;
	
	//查找所有的学生信息
	@Override
	public List<Student> selectAllStudents() {
		return adminMapper.selectAllStudents();
	}
	
	@Override
	public List<Teacher> selectAllTeachers() {
		return adminMapper.selectAllTeachers();
	}

	@Override
	public List<StudentPaperVo> getStudentPaper() {
		return adminMapper.getStudentPaper();
	}

}

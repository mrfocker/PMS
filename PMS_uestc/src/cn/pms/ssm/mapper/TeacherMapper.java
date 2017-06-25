package cn.pms.ssm.mapper;

import java.util.List;
import java.util.Map;

import cn.pms.ssm.po.Teacher;

/**
 * 
 * <p>Title: TeacherMapper</p>
 * <p>Description: mapper数据映射</p>
 * @author	liuxiang
 * @date	
 * @version 1.0
 */
public interface TeacherMapper {
	
	
	//根据ID查找
	public Teacher FindTeacherById(int id) throws Exception;
	
	//批量教师信息导入
	public void insertTeacherList(Teacher teacher) throws Exception;
	
	//excel学生测试
	public int insertTeacherInfo(Teacher teacher) throws Exception;
	//
	public List<Map> getTeacherList() throws Exception;
	public Map getStudentById(Map studentMap) throws Exception;
	public int deleteById(Map studentMap) throws Exception;
	public int insertStuent(Map studentMap) throws Exception;


}

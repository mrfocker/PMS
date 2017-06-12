package cn.pms.ssm.mapper;

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
	
	
	
		

}

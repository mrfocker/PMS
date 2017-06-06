package cn.pms.ssm.dao;

import java.util.List;

import cn.pms.ssm.po.Teacher;

/** 
 * <p>Title: TeacherDao</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  liuxiang 
 * @date 创建时间：2017年6月6日 上午11:26:58 
 * @version 1.0 
*/

public interface TeacherDao {
	
	//根据id查询用户信息
	public Teacher findTeacherById(int id) throws Exception;
	
	//根据用户名列查询用户列表
	public List<Teacher> findTeacherByName(String name) throws Exception;
	
	//添加用户信息
	public void inserTeacher(Teacher teacher) throws Exception;
	
	//删除用户信息
	public void deleteTeacher(int id) throws Exception;
	
	

}
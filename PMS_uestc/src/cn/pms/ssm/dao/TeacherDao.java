package cn.pms.ssm.dao;

import java.util.List;

import cn.pms.ssm.po.Teacher;

/** 
 * <p>Title: TeacherDao</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  liuxiang 
 * @date ����ʱ�䣺2017��6��6�� ����11:26:58 
 * @version 1.0 
*/

public interface TeacherDao {
	
	//����id��ѯ�û���Ϣ
	public Teacher findTeacherById(int id) throws Exception;
	
	//�����û����в�ѯ�û��б�
	public List<Teacher> findTeacherByName(String name) throws Exception;
	
	//����û���Ϣ
	public void inserTeacher(Teacher teacher) throws Exception;
	
	//ɾ���û���Ϣ
	public void deleteTeacher(int id) throws Exception;
	
	

}
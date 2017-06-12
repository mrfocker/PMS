package cn.pms.ssm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.pms.ssm.dao.TeacherDao;
import cn.pms.ssm.po.Teacher;

/** 
 * <p>Title: TeacherDaoImpl</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  liuxiang 
 * @date ����ʱ�䣺2017��6��6�� ����11:28:03 
 * @version 1.0 
*/

public class TeacherDaoImpl extends SqlSessionDaoSupport implements TeacherDao {

	@Override
	public Teacher findTeacherById(int id) throws Exception {
		//�̳�SqlSessionDaoSupport,ͨ��this��getSqlSession�����õ�sqlSession
		SqlSession sqlSession = this.getSqlSession();

		Teacher teacher = sqlSession.selectOne("test.findTeacherById", id);

		return teacher;

	}

	@Override
	public List<Teacher> findTeacherByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserTeacher(Teacher teacher) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTeacher(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
//	@Override
//	public List<Teacher> findTeacherByName(String name) throws Exception {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//
//		List<Teacher> list = sqlSession.selectList("test.findUserByName", name);
//
//		// �ͷ���Դ
//		sqlSession.close();
//
//		return list;
//	}
//	
//
//	@Override
//	public void inserTeacher(Teacher teacher) throws Exception {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//
//		//ִ�в������
//		sqlSession.insert("test.insertUser", teacher);
//
//		// �ύ����
//		sqlSession.commit();
//
//		// �ͷ���Դ
//		sqlSession.close();
//
//	}
//
//	@Override
//	public void deleteTeacher(int id) throws Exception {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//
//		//ִ�в������
//		sqlSession.delete("test.deleteUser", id);
//
//		// �ύ����
//		sqlSession.commit();
//
//		// �ͷ���Դ
//		sqlSession.close();
//
//	}
}	
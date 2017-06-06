package cn.pms.ssm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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

public class TeacherDaoImpl implements TeacherDao {

	// ��Ҫ��daoʵ������ע��SqlSessionFactory
	// ����ͨ�����췽��ע��
	private SqlSessionFactory sqlSessionFactory;

	public TeacherDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public Teacher findTeacherById(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		Teacher teacher = sqlSession.selectOne("test.findUserById", id);

		// �ͷ���Դ
		sqlSession.close();

		return teacher;

	}
	
	@Override
	public List<Teacher> findTeacherByName(String name) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		List<Teacher> list = sqlSession.selectList("test.findUserByName", name);

		// �ͷ���Դ
		sqlSession.close();

		return list;
	}
	

	@Override
	public void insertTeacher(Teacher teacher) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//ִ�в������
		sqlSession.insert("test.insertUser", teacher);

		// �ύ����
		sqlSession.commit();

		// �ͷ���Դ
		sqlSession.close();

	}

	@Override
	public void deleteTeacher(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//ִ�в������
		sqlSession.delete("test.deleteUser", id);

		// �ύ����
		sqlSession.commit();

		// �ͷ���Դ
		sqlSession.close();

	}
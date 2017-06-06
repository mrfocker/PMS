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
 * @date 创建时间：2017年6月6日 上午11:28:03 
 * @version 1.0 
*/

public class TeacherDaoImpl implements TeacherDao {

	// 需要向dao实现类中注入SqlSessionFactory
	// 这里通过构造方法注入
	private SqlSessionFactory sqlSessionFactory;

	public TeacherDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public Teacher findTeacherById(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		Teacher teacher = sqlSession.selectOne("test.findUserById", id);

		// 释放资源
		sqlSession.close();

		return teacher;

	}
	
	@Override
	public List<Teacher> findTeacherByName(String name) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		List<Teacher> list = sqlSession.selectList("test.findUserByName", name);

		// 释放资源
		sqlSession.close();

		return list;
	}
	

	@Override
	public void insertTeacher(Teacher teacher) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//执行插入操作
		sqlSession.insert("test.insertUser", teacher);

		// 提交事务
		sqlSession.commit();

		// 释放资源
		sqlSession.close();

	}

	@Override
	public void deleteTeacher(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//执行插入操作
		sqlSession.delete("test.deleteUser", id);

		// 提交事务
		sqlSession.commit();

		// 释放资源
		sqlSession.close();

	}
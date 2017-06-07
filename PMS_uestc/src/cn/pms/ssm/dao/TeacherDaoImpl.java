package cn.pms.ssm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

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

public class TeacherDaoImpl extends SqlSessionDaoSupport implements TeacherDao {

	@Override
	public Teacher findTeacherById(int id) throws Exception {
		//继承SqlSessionDaoSupport,通过this。getSqlSession（）得到sqlSession
		SqlSession sqlSession = this.getSqlSession();

		Teacher teacher = sqlSession.selectOne("test.findUserById", id);

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
//		// 释放资源
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
//		//执行插入操作
//		sqlSession.insert("test.insertUser", teacher);
//
//		// 提交事务
//		sqlSession.commit();
//
//		// 释放资源
//		sqlSession.close();
//
//	}
//
//	@Override
//	public void deleteTeacher(int id) throws Exception {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//
//		//执行插入操作
//		sqlSession.delete("test.deleteUser", id);
//
//		// 提交事务
//		sqlSession.commit();
//
//		// 释放资源
//		sqlSession.close();
//
//	}
}	
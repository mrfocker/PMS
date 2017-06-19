/**
 * 
 */
package cn.pms.ssm.mapper.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

import cn.pms.ssm.mapper.StudentInfoDAO;
import cn.pms.ssm.po.Student;


/**
 * @author Xiaozhe
 *
 */
public class StudentInfoDAOImpl implements StudentInfoDAO {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	/**
	 * @return the sqlSession
	 */
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	/**
	 * @param sqlSession the sqlSession to set
	 */
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	/* (non-Javadoc)
	 * @see cn.pms.ssm.po.StudentInfoDAO#getStudentInfo()
	 */
	public List<Student> getStudentInfo() {
		// TODO Auto-generated method stub
		List<Student> list = sqlSession.selectList("cn.pms.ssm.mapper.StudentInfoDAO.getStudentInfo"); //namespace
		return list;
	}

}

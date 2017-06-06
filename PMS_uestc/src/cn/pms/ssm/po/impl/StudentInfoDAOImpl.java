/**
 * 
 */
package cn.pms.ssm.po.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.pms.ssm.model.Student;
import cn.pms.ssm.po.StudentInfoDAO;

/**
 * @author Xiaozhe
 *
 */
public class StudentInfoDAOImpl implements StudentInfoDAO {
	
	private SqlSession sqlSession;
	
	/**
	 * @param sqlSession the sqlSession to set
	 */
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	/* (non-Javadoc)
	 * @see cn.pms.ssm.po.StudentInfoDAO#getStudentInfo()
	 */
	@Override
	public List<Student> getStudentInfo() {
		// TODO Auto-generated method stub
		List<Student> list = sqlSession.selectList("cn.pms.ssm.mapper.studentInfoMapper.getStudentInfo");
		return list;
	}

}

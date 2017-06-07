/**
 * 
 */
package cn.pms.ssm.mapper.impl;


import org.apache.ibatis.session.SqlSession;

import cn.pms.ssm.mapper.LoginStudentDAO;
import cn.pms.ssm.po.Student;

/** 
 * <p>Title: LoginStudentDAOImpl</p> 
 * <p>Description:impl LoginStudentDAO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年6月7日 下午3:39:38 
 * @version 1.0 
*/

public class LoginStudentDAOImpl implements LoginStudentDAO {


	private SqlSession sqlSession;
	/**
	 * @param sqlSession the sqlSession to set
	 */
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	/* (non-Javadoc)
	 * @see cn.pms.ssm.mapper.LoginStudentDAO#login(java.lang.String, java.lang.String, int)
	 */
	@Override
	public Integer selectstudentlogin(Student student) {
		// TODO Auto-generated method stub
		Integer result = sqlSession.selectOne("cn.pms.ssm.mapper.LoginStudentDAO.selectstudentlogin",student);
		return result;
	}

}

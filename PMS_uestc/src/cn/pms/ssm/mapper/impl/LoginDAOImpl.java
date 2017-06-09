/**
 * 
 */
package cn.pms.ssm.mapper.impl;


import org.apache.ibatis.session.SqlSession;

import cn.pms.ssm.mapper.LoginDAO;
import cn.pms.ssm.po.Administrator;
import cn.pms.ssm.po.Student;
import cn.pms.ssm.po.Teacher;

/** 
 * <p>Title: LoginStudentDAOImpl</p> 
 * <p>Description:impl LoginStudentDAO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年6月7日 下午3:39:38 
 * @version 1.0 
*/

public class LoginDAOImpl implements LoginDAO {


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
		Integer result = sqlSession.selectOne("cn.pms.ssm.mapper.LoginDAO.selectstudentlogin",student);
		return result;
	}
	/* (non-Javadoc)
	 * @see cn.pms.ssm.mapper.LoginStudentDAO#selectteacherlogin(cn.pms.ssm.po.Teacher)
	 */
	@Override
	public Integer selectteacherlogin(Teacher teacher) {
		// TODO Auto-generated method stub
		Integer result = sqlSession.selectOne("cn.pms.ssm.mapper.LoginDAO.selectteacherlogin", teacher);
		return result;
	}
	/* (non-Javadoc)
	 * @see cn.pms.ssm.mapper.LoginStudentDAO#selectadminlogin(cn.pms.ssm.po.Administrator)
	 */
	@Override
	public Integer selectadminlogin(Administrator administrator) {
		// TODO Auto-generated method stub
		Integer result = sqlSession.selectOne("cn.pms.ssm.mapper.LoginDAO.selectadminlogin", administrator);
		return result;
	}
	/* (non-Javadoc)
	 * @see cn.pms.ssm.mapper.LoginDAO#updateStudentStatus(java.lang.Boolean)
	 */
	@Override
	public void updateStudentStatus(Student student) {
		// TODO Auto-generated method stub
		sqlSession.update("cn.pms.ssm.mapper.LoginDAO.updateStudentStatus", student);
	}
	/* (non-Javadoc)
	 * @see cn.pms.ssm.mapper.LoginDAO#updateTeacherStatus(java.lang.Boolean)
	 */
	@Override
	public void updateTeacherStatus(Teacher teacher) {
		// TODO Auto-generated method stub
		sqlSession.update("cn.pms.ssm.mapper.LoginDAO.updateTeacherStatus", teacher);
	}
	/* (non-Javadoc)
	 * @see cn.pms.ssm.mapper.LoginDAO#updateAdminStatus(java.lang.Boolean)
	 */
	@Override
	public void updateAdminStatus(Administrator administrator) {
		// TODO Auto-generated method stub
		sqlSession.update("cn.pms.ssm.mapper.LoginDAO.updateAdminStatus", administrator);
	}

}

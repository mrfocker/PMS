/**
 * 
 */
package test.java;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.pms.ssm.mapper.LoginStudentDAO;
import cn.pms.ssm.mapper.impl.LoginStudentDAOImpl;
import cn.pms.ssm.po.Student;

/** 
 * <p>Title: TestLoginStudentDAOImpl</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年6月7日 下午4:39:22 
 * @version 1.0 
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml"})
public class TestLoginStudentDAOImpl {

	@Test
	public void test() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		Student s = new Student();
		s.setStu_id("201621220160");
		s.setStu_password("123");
		LoginStudentDAO loginStudentDAO = (LoginStudentDAO) ctx.getBean("loginStudentDAOImpl", LoginStudentDAOImpl.class);
		Integer s1 = loginStudentDAO.selectstudentlogin(s);
		System.out.println(s1);
	}
}

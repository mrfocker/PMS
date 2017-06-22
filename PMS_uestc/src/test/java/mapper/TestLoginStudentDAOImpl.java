/**
 * 
 */
package test.java.mapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.pms.ssm.mapper.LoginMapper;
import cn.pms.ssm.po.Student;
import cn.pms.ssm.po.Teacher;
import cn.pms.ssm.service.LoginService;
import cn.pms.ssm.service.impl.LoginServiceImpl;

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

//	Login DAO层测试
	@Test
	public void test() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		//Student s = new Student();
		Teacher s = new Teacher();
//		s.setStu_id("201621220160");
//		s.setStu_password("123");
		s.setTeacher_id("111111111111");
		s.setTeacher_password("123");
		LoginMapper loginStudentDAO = ctx.getBean("loginMapper", LoginMapper.class);
		//Integer s1 = loginStudentDAO.selectstudentlogin(s);
		Integer s1 = loginStudentDAO.selectteacherlogin(s);
		System.out.println(s1);
	}
	
	@Test
	public void testLoginService() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		Teacher s = new Teacher();
//		s.setStu_id("201621220160");
//		s.setStu_password("123");
		s.setTeacher_id("111111111111");
		s.setTeacher_password("123");
		LoginService loginService = ctx.getBean("loginService",LoginService.class);
		Integer s1 = loginService.selectteacherlogin(s);
		System.out.println(s1);
	}
}

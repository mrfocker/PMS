/**
 * 
 */
package test.java;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.pms.ssm.mapper.StudentInfoDAO;
import cn.pms.ssm.mapper.impl.StudentInfoDAOImpl;
import cn.pms.ssm.po.Student;

/** 
 * <p>Title: TestMapper</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年6月6日 下午3:35:01 
 * @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml"})
public class TestMapper {

	private static StudentInfoDAO studentInfoDAO;
	
	@BeforeClass
	public static void BeforeClass() {
		// TODO Auto-generated method stub
		studentInfoDAO = new StudentInfoDAOImpl();
	}
	
	@Test
	public void test() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		studentInfoDAO = ctx.getBean("studentInfoDAO",StudentInfoDAO.class);
		List<Student> list = studentInfoDAO.getStudentInfo();
		for(Student student:list){
			System.out.println(student);
		}
		assertNotNull(list);
		fail("Not yet implemented");
	}

}

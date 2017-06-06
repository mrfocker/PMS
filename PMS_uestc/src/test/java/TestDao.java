/**
 * 
 */
package test.java;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.pms.ssm.model.Student;
import cn.pms.ssm.po.StudentInfoDAO;

/**
 * @author Xiaozhe
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml"})
public class TestDao {

	@Resource
	private StudentInfoDAO studentInfoDAO;
	@Test
	public void test() {
//		StudentInfoDAO studentInfoDAO = new StudentInfoDAOImpl();
		List<Student> list = studentInfoDAO.getStudentInfo();
		for(Student student:list){
			System.out.println(student);
		}
		assertNotNull(list);
		fail("Not yet implemented");
	}

}

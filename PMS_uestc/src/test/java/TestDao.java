/**
 * 
 */
package test.java;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


import cn.pms.ssm.model.Student;
import cn.pms.ssm.po.StudentInfoDAO;
import cn.pms.ssm.po.impl.StudentInfoDAOImpl;

/**
 * @author Xiaozhe
 *
 */
public class TestDao {

	@Test
	public void test() {
		StudentInfoDAO studentInfoDAO = new StudentInfoDAOImpl();
		List<Student> list = studentInfoDAO.getStudentInfo();
		for(Student student:list){
			System.out.println(student);
		}
		assertNotNull(list);
		fail("Not yet implemented");
	}

}

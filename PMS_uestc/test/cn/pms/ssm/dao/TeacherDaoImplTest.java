package cn.pms.ssm.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.pms.ssm.po.Teacher;

/** 
 * <p>Title: TeacherDaoImplTest</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  liuxiang 
 * @date ����ʱ�䣺2017��6��7�� ����4:49:01 
 * @version 1.0 
*/

public class TeacherDaoImplTest {
	private ApplicationContext applicationContext;
	
	//��setUp��������õ�spring����
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		
	}

	@Test
	public void testFindTeacherById() throws Exception {
		
		TeacherDao teacherDao = (TeacherDao) applicationContext.getBean("TeacherDao");
		
		//����teacherDao�ķ���
		Teacher teacher = teacherDao.findTeacherById(1);
		
		System.out.println(teacher);
	}

}

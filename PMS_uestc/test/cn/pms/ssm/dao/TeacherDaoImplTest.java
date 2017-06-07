package cn.pms.ssm.dao;

import static org.junit.Assert.*;

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
 * @date 创建时间：2017年6月7日 下午4:49:01 
 * @version 1.0 
*/

public class TeacherDaoImplTest {
	private ApplicationContext applicationContext;
	
	//在setUp这个方法得到spring容器
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		
	}

	@Test
	public void testFindTeacherById() throws Exception {
		
		TeacherDao teacherDao = (TeacherDao) applicationContext.getBean("TeacherDao");
		
		//调用teacherDao的方法
		Teacher teacher = teacherDao.findTeacherById(1);
		
		System.out.println(teacher);
	}

}

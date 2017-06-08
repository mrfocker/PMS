package cn.pms.ssm.mapper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.pms.ssm.po.Teacher;

/** 
 * <p>Title: UserMapperTest</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  liuxiang 
 * @date 创建时间：2017年6月8日 下午3:16:30 
 * @version 1.0 
*/

public class TeacherMapperTest {
	private ApplicationContext applicationContext;

	//在setUp这个方法得到spring容器
	@Before
	public void setUp() throws Exception{
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml ");
	}

	@Test
	public void testFindTeacherById() throws Exception {
		TeacherMapper teacherMapper = (TeacherMapper) applicationContext.getBean("teacherMapper");
		Teacher teacher =  teacherMapper.FindTeacherById(1);
		System.out.println(teacher);
		
	}

}

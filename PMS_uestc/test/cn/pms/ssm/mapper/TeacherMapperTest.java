package cn.pms.ssm.mapper;

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
 * @date ����ʱ�䣺2017��6��8�� ����3:16:30 
 * @version 1.0 
*/

public class TeacherMapperTest {
	private ApplicationContext applicationContext;

	//��setUp��������õ�spring����
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
	
	@Test
	public void testinsertTeacherList() throws Exception{
		
		TeacherMapper teacherMapper = (TeacherMapper) applicationContext.getBean("teacherMapper");
		Teacher teacher = new Teacher();
		teacher.setTeacher_id("00001");
		teacher.setTeacher_name("张三");
		teacher.setTeacher_password("123456");
		teacher.setTeacher_proTitle("网络技术");
		teacher.setTeacher_researchOne("大数据");
		teacher.setTeacher_researchTwo("分布式");
		teacher.setTeacher_researchThree("嵌入式");
		teacher.setTeacher_tel("1355555555");
		teacher.setTeacher_email("123456@qq.com");
		
		teacherMapper.insertTeacherList(teacher);
		
	}
	
	
	

}

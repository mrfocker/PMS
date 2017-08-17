package cn.pms.ssm.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.pms.ssm.po.StudentPaperInfoVo;
import cn.pms.ssm.po.Teacher;

/** 
 * <p>Title: </p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author:  liuxiang 
 * @date:2017年8月16日
 * @version 1.0 
*/
public class StudentPaperInfoMapperTest {
	private ApplicationContext applicationContext;

	//��setUp��������õ�spring����
	@Before
	public void setUp() throws Exception{
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml ");
	}

	
	/*@Test
	public void test_getStudentPaperInfo() throws Exception{
		StudentPaperInfoMapper studentPaperInfoMapper = (StudentPaperInfoMapper) applicationContext.getBean("studentPaperInfoMapper");
		StudentPaperInfoVo list = new StudentPaperInfoVo();
		list.setStu_id("201621220161");
		System.out.println(list.getStu_id());
		StudentPaperInfoVo studentPaperInfoVo1 = studentPaperInfoMapper.getStudentPaperInfo(list);
		System.out.println(studentPaperInfoVo1);
		System.out.println(studentPaperInfoVo1.getPaper_ifPass());
		System.out.println(studentPaperInfoVo1.getPaper_title());
	}*/
	
	@Test
	public void test_getPaperInfo() throws Exception{
		StudentPaperInfoMapper studentPaperInfoMapper = (StudentPaperInfoMapper) applicationContext.getBean("studentPaperInfoMapper");
		StudentPaperInfoVo list = new StudentPaperInfoVo();
		list.setStu_id("201522220299");
		StudentPaperInfoVo studentPaperInfoVo1 = studentPaperInfoMapper.getPaperInfo(list);
		System.out.println(studentPaperInfoVo1.getPaper_ifPass());
		System.out.println(studentPaperInfoVo1.getPaper_ifPass());
	}
	
	@Test
	public void test_getFileInfo() throws Exception{
		StudentPaperInfoMapper studentPaperInfoMapper = (StudentPaperInfoMapper) applicationContext.getBean("studentPaperInfoMapper");
		StudentPaperInfoVo list = new StudentPaperInfoVo();
		StudentPaperInfoVo list2 = new StudentPaperInfoVo();
		list.setStu_id("201522220299");
		StudentPaperInfoVo studentPaperInfoVo1 = studentPaperInfoMapper.getFileInfo(list);
		list2.setTeacher_Result(studentPaperInfoVo1.getTeacher_Result());
		System.out.println(list2.getTeacher_Result());
		System.out.println(studentPaperInfoVo1.getFile_id());
	}
}

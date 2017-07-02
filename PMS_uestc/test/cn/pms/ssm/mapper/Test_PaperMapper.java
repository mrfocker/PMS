package cn.pms.ssm.mapper;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.pms.ssm.po.PaperInfoExtend;
import cn.pms.ssm.po.PaperQueryVo;
import cn.pms.ssm.po.Teacher;

/** 
 * <p>Title: </p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author:  liuxiang 
 * @date:2017年6月29日
 * @version 1.0 
*/
public class Test_PaperMapper {
	private ApplicationContext applicationContext;
	
	@Before
	public void setUp() throws Exception{
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml ");
	}
	
	@Test
	public void test_findpaperlist() throws Exception{
		Test_PaperMapper test_PaperMapper = (Test_PaperMapper) applicationContext.getBean("papaerMapper");
		
		
		
	}

}

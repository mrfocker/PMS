/**
 * 
 */
package test.java.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.pms.ssm.po.Paper;
import cn.pms.ssm.service.UploadService;

/** 
 * <p>Title: UploadServiceImplTest</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年6月21日 下午7:45:29 
 * @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml"})
public class UploadServiceImplTest {

	@Test
	public void test() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		Paper paper = new Paper();
		paper.setPaper_stuId("121");
		paper.setPaper_title("CCNA");
		paper.setPaper_researchOne("MINE");
		paper.setPaper_researchTwo("IEEE");
		UploadService uploadService = ctx.getBean("uploadService", UploadService.class);
		uploadService.insertPaperItem(paper);
		System.out.println("------------------end------------------");
	}

}

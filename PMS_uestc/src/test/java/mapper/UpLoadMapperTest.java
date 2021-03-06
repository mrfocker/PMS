/**
 * 
 */
package test.java.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.pms.ssm.mapper.DownloadMapper;
import cn.pms.ssm.mapper.UpLoadMapper;
import cn.pms.ssm.po.Paper;
import cn.pms.ssm.vo.UploadVo;

/** 
 * <p>Title: UpLoadMapperTest</p> 
 * <p>Description:test UpLoadMapper </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年6月21日 上午10:45:29 
 * @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml"})
public class UpLoadMapperTest {
	
	@Test
	public void test() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		UploadVo paper = new UploadVo();
		paper.setPaper_stuId("122");
		paper.setPaper_title("CCNA");
		paper.setPaper_researchOne("MINE");
		paper.setPaper_researchTwo("IEEE");
		paper.setFile_name("999.docx");
		paper.setFile_type(1);
		UpLoadMapper upLoadMapper = ctx.getBean("upLoadMapper", UpLoadMapper.class);
		upLoadMapper.insertPaperItem(paper);
		upLoadMapper.insertFileItem(paper);
		System.out.println("------------------end------------------");
	}
	
	@Test
	public void testUpdatePaperItem() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		UploadVo paper = new UploadVo();
		paper.setPaper_stuId("121");
		paper.setFile_name("999.docx");
		UpLoadMapper upLoadMapper = ctx.getBean("upLoadMapper", UpLoadMapper.class);
		upLoadMapper.updatePaperItem(paper);
		System.out.println("------------------end------------------");
	}
	
	@Test
	public void testSelectPaperItem() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		UploadVo paper = new UploadVo();
		paper.setPaper_stuId("121");
		UpLoadMapper upLoadMapper = ctx.getBean("upLoadMapper", UpLoadMapper.class);
		upLoadMapper.selectPaperItem(paper);
//		DownloadMapper downloadMapper = ctx.getBean("downloadMapper", DownloadMapper.class);
//		downloadMapper.selectPaperItem(paper);
		System.out.println("------------------end------------------");
	}

}

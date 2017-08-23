/**
 * 
 */
package test.java.mapper;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.pms.ssm.mapper.DownloadMapper;
import cn.pms.ssm.mapper.UpLoadMapper;
import cn.pms.ssm.po.Paper;
import cn.pms.ssm.vo.DownloadVo;

/** 
 * <p>Title: DownloadMapperTest</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年7月6日 上午11:29:02 
 * @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml"})
public class DownloadMapperTest {

	@Test
	public void test() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");

		DownloadMapper downloadMapper = ctx.getBean("downloadMapper", DownloadMapper.class);
		ArrayList<DownloadVo> list = downloadMapper.selectAllItem();
		for (DownloadVo downloadVo : list) {
			System.out.println(downloadVo.getFile_name());
		}
		
		//fail("Not yet implemented");
	}

}

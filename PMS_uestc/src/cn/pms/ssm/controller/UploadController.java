/**
 * 
 */
package cn.pms.ssm.controller;

import java.io.File;
import java.io.IOException;

import javax.xml.ws.Action;

import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.pms.ssm.po.Paper;
import cn.pms.ssm.service.UploadService;

/** 
 * <p>Title: UploadController</p> 
 * <p>Description:上传的Controller </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年6月21日 下午7:59:44 
 * @version 1.0 
*/
@Controller
@RequestMapping("/load")
public class UploadController {

	@Autowired
	private UploadService uploadService;
	
	private static Logger logger = Logger.getLogger(UploadController.class);
	
	@RequestMapping(value="/uploadfile", method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String upload(Paper paper,
			@RequestParam("paperType") String paperType, 
			@RequestParam("file") MultipartFile file) throws IOException{
		
		
		String newFileName = paper.getPaper_stuId()+"#"+paperType;
		
		if ( !file.isEmpty() ) {
			logger.debug("Process file: "+file.getOriginalFilename());
			
//			文件路径？
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(".\resources/PaperFile", newFileName));
			
			paper.setPaper_title(newFileName);
			
			uploadService.insertPaperItem(paper);
		}
		return "logining/index";
	}
}

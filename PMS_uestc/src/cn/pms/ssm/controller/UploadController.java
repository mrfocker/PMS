/**
 * 
 */
package cn.pms.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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
import org.springframework.web.servlet.ModelAndView;

import cn.pms.ssm.service.UploadService;
import cn.pms.ssm.vo.UploadVo;

/**
 * <p>
 * name: UploadController
 * </p>
 * <p>
 * Description:上传的Controller
 * </p>
 * <p>
 * Company: uestc_xr
 * </p>
 * 
 * @author Xiaozhe
 * @date 创建时间：2017年6月21日 下午7:59:44
 * @version 1.0
 */
@Controller
@RequestMapping("/pages")
public class UploadController {

	@Autowired
	private UploadService uploadService;

	private static Logger logger = Logger.getLogger(UploadController.class);

	@RequestMapping(value = "/upload", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody ModelAndView upload(UploadVo uploadVo, @RequestParam("file") MultipartFile file)
			throws IOException {

		Date date = new Date();
		Random random = new Random();
		ModelAndView modelAndView = new ModelAndView();
		int num = random.nextInt(99999 - 0) + 1;
		// 文件重命名
		String newFileName = date.getTime() + "0" + num + ".docx";
		logger.info(newFileName);
		
		int year =  date.getYear()+1900;  //有问题！待讨论！
	
		// 绝对路径
		String filepath = File.separator + "Users" + File.separator + "JJ" + File.separator + "Downloads" + File.separator
				+ "resources" + File.separator + "PaperFile" + File.separator + year;
		File dir = new File(filepath);
		File newfile = null;
		if (dir.exists()) {
			if (dir.isDirectory()) {
				System.out.println("dir exists");
				newfile = new File(filepath, newFileName);
			} else {
				System.out.println("the same name file exists, can not create dir");
			}
		} else {
			System.out.println("dir not exists, create it ...");
			dir.mkdir();
			newfile = new File(filepath, newFileName);
		}
		
		if (!file.isEmpty()) {
			logger.error("Process file: " + file.getOriginalFilename());
			logger.error("Process file path: " + filepath);

			FileUtils.copyInputStreamToFile(file.getInputStream(), newfile);

			uploadVo.setFile_name(newFileName);
			if (null != uploadService.selectPaperIfExist(uploadVo)) {
				logger.error("-------------->exist");
				// 删除已存在文件
				File temp = new File(filepath + uploadVo.getFile_name());
				temp.delete();
				uploadService.updatePaperItem(uploadVo);
			} else {
				uploadService.insertPaperItem(uploadVo);
				uploadService.insertFileItem(uploadVo);
			}
		}

		modelAndView.addObject("success", "success");
		modelAndView.setViewName("/tables");
		return modelAndView;
	}
}

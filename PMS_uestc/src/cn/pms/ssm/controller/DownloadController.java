package cn.pms.ssm.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.pms.ssm.po.Paper;
import cn.pms.ssm.service.DownloadService;

/** 
 * <p>Title: DownloadController</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年7月3日 下午3:03:30 
 * @version 1.0 
*/
@Controller
@RequestMapping("/pages")
public class DownloadController {
	
	@Autowired
	private DownloadService downloadService;
	
	@RequestMapping(value="/downloadSingle", method={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView downloadSingle(Paper paper, HttpServletResponse response){
		
//		ModelAndView modelAndView = new ModelAndView();
		Paper paperTemp = downloadService.downloadSingle(paper);
		  //目标文件名 
        String fileName = File.separator + "Users" + File.separator + "JJ" + File.separator + "PMS" + File.separator
				+ "PMS_uestc" + File.separator + "resources" + File.separator + "PaperFile" + File.separator + paperTemp.getPaper_name();  
        //获取输入流  
        InputStream bis;
		try {
			bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
			//假如以中文名下载的话  
	        String filename = paperTemp.getPaper_stuId()+"_论文.docx";  
	        //转码，免得文件名中文乱码  
	        filename = URLEncoder.encode(filename,"UTF-8");  
	        //设置文件下载头  
	        response.addHeader("Content-Disposition", "attachment;filename=" + filename);    
	        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型    
	        response.setContentType("multipart/form-data");   
	        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());  
	        int len = 0;  
	        while((len = bis.read()) != -1){  
	            out.write(len);  
	            out.flush();
	        }  
	        out.close();  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
//        modelAndView.setViewName("/index");
//		return modelAndView;
		return null;
	}
	
	@RequestMapping(value="/downloadMulti", method={RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody ModelAndView downloadMulti() {
		return null;
		
	}
}

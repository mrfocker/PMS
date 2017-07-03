/**
 * 
 */
package cn.pms.ssm.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ModelAndView download(Paper paper, HttpServletResponse response) throws IOException {
		
		ModelAndView modelAndView = new ModelAndView();
		downloadService.downloadFile(paper, response);
        modelAndView.setViewName("/index");
		return modelAndView;
	}
}

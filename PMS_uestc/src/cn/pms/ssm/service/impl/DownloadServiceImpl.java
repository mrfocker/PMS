/**
 * 
 */
package cn.pms.ssm.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pms.ssm.mapper.UpLoadMapper;
import cn.pms.ssm.po.Paper;
import cn.pms.ssm.service.DownloadService;

/** 
 * <p>Title: DownloadServiceImpl</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年7月3日 下午4:43:35 
 * @version 1.0 
*/
@Service("downloadService")
public class DownloadServiceImpl implements DownloadService {

	@Autowired
	private UpLoadMapper upLoadMapper;
	/* (non-Javadoc)
	 * @see cn.pms.ssm.service.DownloadService#downloadFile(cn.pms.ssm.po.Paper)
	 */
	@Override
	public void downloadFile(Paper paper, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ArrayList<String> paperItemList = upLoadMapper.selectPaperItem(paper);
		paper.setPaper_name(paperItemList.get(paperItemList.size()-1));
		
		  //目标文件名 
        String fileName = File.separator + "Users" + File.separator + "JJ" + File.separator + "PMS" + File.separator
				+ "PMS_uestc" + File.separator + "resources" + File.separator + "PaperFile"+paper.getPaper_name();  
        //获取输入流  
        InputStream bis;
		try {
			bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
			//假如以中文名下载的话  
	        String filename = "下载文件.txt";  
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
        
	}

}

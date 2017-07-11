package cn.pms.ssm.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.pms.ssm.po.Paper;
import cn.pms.ssm.service.DownloadService;
import cn.pms.ssm.vo.DownloadVo;
import sun.org.mozilla.javascript.internal.regexp.SubString;

/**
 * <p>
 * Title: DownloadController
 * </p>
 * <p>
 * Description:TODO
 * </p>
 * <p>
 * Company: uestc_xr
 * </p>
 * 
 * @author Xiaozhe
 * @date 创建时间：2017年7月3日 下午3:03:30
 * @version 1.0
 */
@Controller
@RequestMapping("/pages")
public class DownloadController {

	@Autowired
	private DownloadService downloadService;
	
	private Logger Log = Logger.getLogger(DownloadController.class);
	
	private static final String FilePath = File.separator + "Users" + File.separator + "JJ" + File.separator + "PMS" + File.separator
			+ "PMS_uestc" + File.separator + "resources" + File.separator + "PaperFile" + File.separator;  

	//师生单个
	@RequestMapping(value = "/downloadSingle.action", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView downloadSingle(Paper paper, HttpServletResponse response) {

		// ModelAndView modelAndView = new ModelAndView();
		Paper paperTemp = downloadService.downloadSingle(paper);
		// 目标文件名
		String fileName = File.separator + "Users" + File.separator + "JJ" + File.separator + "PMS" + File.separator
				+ "PMS_uestc" + File.separator + "resources" + File.separator + "PaperFile" + File.separator
				+ paperTemp.getPaper_name();
		// 获取输入流
		InputStream bis;
		try {
			bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
			// 假如以中文名下载的话
			String filename = paperTemp.getPaper_stuId() + "_论文.docx";
			// 转码，免得文件名中文乱码
			filename = URLEncoder.encode(filename, "UTF-8");
			// 设置文件下载头
			response.addHeader("Content-Disposition", "attachment;filename=" + filename);
			// 1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
			response.setContentType("multipart/form-data");
			BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
			int len = 0;
			while ((len = bis.read()) != -1) {
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
		// modelAndView.setViewName("/index");
		// return modelAndView;
		return null;
	}

	@RequestMapping(value = "/downloadSingleAdmin.action", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView downloadSingleAdmin(@RequestParam("name") String paperName, @RequestParam("id") String stuId, HttpServletResponse response) {

		// 目标文件名
		String fileName = FilePath + paperName;
		// 获取输入流
		InputStream bis;
		try {
			bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
			// 假如以中文名下载的话
			String filename = stuId + "_Paper.docx";
			// 转码，免得文件名中文乱码
			filename = URLEncoder.encode(filename, "UTF-8");
			// 设置文件下载头
			response.addHeader("Content-Disposition", "attachment;filename=" + filename);
			// 1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
			response.setContentType("multipart/form-data");
			
			BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
			int len = 0;
			while ((len = bis.read()) != -1) {
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
		// modelAndView.setViewName("/index");
		// return modelAndView;
		return null;
	}
	
	@RequestMapping(value = "/searchAll", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody ModelAndView getDownloadList() {
		ModelAndView modelAndView = new ModelAndView();
		ArrayList<DownloadVo> list = downloadService.selectAllItem();

		// DownloadVo downloadVo = new DownloadVo();
		// downloadVo.setPaper_stuId(list.get(0).getPaper_stuId());
		// String s = list.get(3).getStu_name();
		// downloadVo.setStu_name(s);
		String s = null;

		for (int i = 0; i < list.size(); i++) {
			if (null != list.get(i)) {
				s = list.get(i).getPaper_name();
				if (null != s) {
					list.get(i).setPaper_reason(s.substring(s.lastIndexOf("a") + 1, s.lastIndexOf("a") + 2));
				} else {
					System.out.println("error");
				}
			} else {
				System.out.println("error");
			}
		}

		modelAndView.addObject("downloadList", list);
		// modelAndView.addObject("type", arr);
		modelAndView.setViewName("/adminDownload");// adminDownload
		return modelAndView;
	}

	@RequestMapping(value = "/downloadMulti", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody ModelAndView downloadMulti(@RequestBody ArrayList<String> list, HttpServletResponse response) {
		//生成的ZIP文件名为Demo.zip    
        String tmpFileName = "selectedFile.zip";    
        byte[] buffer = new byte[1024];    
        String strZipPath = FilePath + tmpFileName;    
        try {    
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(    
                    strZipPath));    
            // 需要同时下载的两个文件result.txt ，source.txt    
            ArrayList<File> files = new ArrayList<File>();
            for(int index = 0; index < list.size(); index++){
            	files.set(index, new File(FilePath+list.get(index)));
            }
            
            for (int i = 0; i < files.size(); i++) {    
                FileInputStream fis = new FileInputStream(files.get(i));    
                out.putNextEntry(new ZipEntry(files.get(i).getName()));    
                //设置压缩文件内的字符编码，不然会变成乱码    
                out.setEncoding("GBK");    
                int len;    
                // 读入需要下载的文件的内容，打包到zip文件    
                while ((len = fis.read(buffer)) > 0) {    
                    out.write(buffer, 0, len);    
                }    
                out.closeEntry();    
                fis.close();    
            }    
            out.close();    
            this.downFile(response, tmpFileName);    
        } catch (Exception e) {    
            Log.error("文件下载出错", e);    
        }    
		
		return null;

	}
	
	private void downFile(HttpServletResponse response, String str) {    
        try {    
            String path = FilePath + str;    
            File file = new File(path);    
            if (file.exists()) {    
                InputStream ins = new FileInputStream(path);    
                BufferedInputStream bins = new BufferedInputStream(ins);// 放到缓冲流里面    
                OutputStream outs = response.getOutputStream();// 获取文件输出IO流    
                BufferedOutputStream bouts = new BufferedOutputStream(outs);    
                response.setContentType("application/x-download");// 设置response内容的类型    
                response.setHeader(    
                        "Content-disposition",    
                        "attachment;filename="    
                                + URLEncoder.encode(str, "UTF-8"));// 设置头部信息    
                int bytesRead = 0;    
                byte[] buffer = new byte[8192];    
                // 开始向网络传输文件流    
                while ((bytesRead = bins.read(buffer, 0, 8192)) != -1) {    
                    bouts.write(buffer, 0, bytesRead);    
                }    
                bouts.flush();// 这里一定要调用flush()方法    
                ins.close();    
                bins.close();    
                outs.close();    
                bouts.close();    
            } else {    
                response.sendRedirect("../error.jsp");    
            }    
        } catch (IOException e) {    
            Log.error("文件下载出错", e);    
        }    
    }    
}

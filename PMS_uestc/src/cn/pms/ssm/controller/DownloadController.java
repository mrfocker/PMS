package cn.pms.ssm.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.pms.ssm.service.DownloadService;
import cn.pms.ssm.vo.DownloadVo;
import net.sf.json.JSONArray;

/**
 * <p>
 * Title: DownloadController
 * </p>
 * <p>
 * Description:批量下载Controller，getDownloadList()获取可下载列表， downloadMulti()批量下载-压缩后下载
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

	private static final String FilePath = File.separator + "Users" + File.separator + "JJ" + File.separator + "Downloads"
			+ File.separator + "resources" + File.separator + "PaperFile" + File.separator;

	@RequestMapping(value = "/searchAll", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody ModelAndView getDownloadList() {
		ModelAndView modelAndView = new ModelAndView();
		Date date = new Date();
		ArrayList<DownloadVo> list = downloadService.selectAllItem();

		// DownloadVo downloadVo = new DownloadVo();
		// downloadVo.setPaper_stuId(list.get(0).getPaper_stuId());
		// String s = list.get(3).getStu_name();
		// downloadVo.setStu_name(s);
		String s = null;
		int year = date.getYear()+1900;
		modelAndView.addObject("downloadList", list);
		modelAndView.addObject("time", year);
		modelAndView.setViewName("/adminDownload");// adminDownload
		return modelAndView;
	}

	@RequestMapping(value = "/downloadMulti", method = { RequestMethod.POST, RequestMethod.GET }) 
	public ModelAndView downloadMulti(@RequestParam("str") String str, HttpServletResponse response) {

		// 生成的ZIP文件名为selectedFile.zip
		Date date = new Date();
		String tmpFileName = "selectedFile.zip";
		byte[] buffer = new byte[1024];
		int year = date.getYear()+1900;
		String strZipPath = FilePath + File.separator + year + File.separator + tmpFileName;
		
		//URL中的JSON不能被@Requestbody解析，所以手动解析
		ArrayList<String> namelist = new ArrayList<String>();
		JSONArray jsonArray = JSONArray.fromObject(str);
		namelist = (ArrayList<String>) JSONArray.toList(jsonArray);
		
		try {
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(strZipPath));
			// 需要同时下载的两个文件result.txt ，source.txt
			File[] files = new File[1024];
			for (int index = 0; index < namelist.size(); index++) {
				if (null != namelist.get(index)) {
					files[index] = new File(FilePath + File.separator + year + File.separator + namelist.get(index));
				}
			}

			for (int i = 0; i < files.length; i++) {
				if (null != files[i]) {
					FileInputStream fis = new FileInputStream(files[i]);
					out.putNextEntry(new ZipEntry(files[i].getName()));
					// 设置压缩文件内的字符编码，不然会变成乱码
					out.setEncoding("GBK");
					int len;
					// 读入需要下载的文件的内容，打包到zip文件
					while ((len = fis.read(buffer)) > 0) {
						out.write(buffer, 0, len);
					}
					out.closeEntry();
					fis.close();
				}
			}
			out.close();
			
			File file = new File(strZipPath);

			if (file.exists()) {
				BufferedInputStream bins = new BufferedInputStream(new FileInputStream(file));// 放到缓冲流里面
				BufferedOutputStream bouts = new BufferedOutputStream(response.getOutputStream()); // 获取文件输出IO流
				response.setContentType("multipart/form-data");// 设置response内容的类型
																// application/x-download
				response.setHeader("Content-disposition",
						"attachment;filename=" + URLEncoder.encode(tmpFileName, "UTF-8"));// 设置头部信息
				int bytesRead = 0;
				byte[] buffer1 = new byte[8192];
				// 开始向网络传输文件流
				while ((bytesRead = bins.read(buffer1, 0, 8192)) != -1) {
					
					bouts.write(buffer1, 0, bytesRead);

				}
				bouts.flush();// 这里一定要调用flush()方法
				bins.close();
				bouts.close();
			} else {
				response.sendRedirect("/index");
			}
		} catch (Exception e) {
			Log.error("文件下载出错", e);
		}

		return null;

	}

}

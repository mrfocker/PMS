/**
 * 
 */
package cn.pms.ssm.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import cn.pms.ssm.po.Paper;

/** 
 * <p>Title: DownloadService</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年7月3日 下午4:41:11 
 * @version 1.0 
*/
@Service
public interface DownloadService {

	public void downloadFile(Paper paper, HttpServletResponse response);
}

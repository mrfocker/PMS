/**
 * 
 */
package cn.pms.ssm.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import cn.pms.ssm.po.Paper;
import cn.pms.ssm.vo.DownloadVo;

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

	//下载单个文件（学生老师用）
	public Paper downloadSingle(Paper paper);
	
	//查询所有可下载项
	public 	ArrayList<DownloadVo> selectAllItem();
}

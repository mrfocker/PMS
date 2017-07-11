/**
 * 
 */
package cn.pms.ssm.mapper;

import java.util.ArrayList;

import cn.pms.ssm.po.Paper;
import cn.pms.ssm.vo.DownloadVo;

/** 
 * <p>Title: DownloadMapper</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年7月6日 上午10:52:32 
 * @version 1.0 
*/
public interface DownloadMapper {
	//查找已有论文版本(下载也用这个),学生和老师下载最新版论文
	public ArrayList<String> selectPaperItem(Paper paper);
		
	//查询所有可下载项
	public 	ArrayList<DownloadVo> selectAllItem();
	
}

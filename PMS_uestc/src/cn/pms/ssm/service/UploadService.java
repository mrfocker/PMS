/**
 * 
 */
package cn.pms.ssm.service;

import org.springframework.stereotype.Service;

import cn.pms.ssm.po.Paper;

/** 
 * <p>Title: UploadService</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年6月21日 下午7:40:06 
 * @version 1.0 
*/
@Service
public interface UploadService {
	
	public void insertPaperItem(Paper paper);
	
}

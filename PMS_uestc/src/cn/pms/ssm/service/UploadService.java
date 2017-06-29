/**
 * 
 */
package cn.pms.ssm.service;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
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
@Scope("property")
public interface UploadService {
	
	public void insertPaperItem(Paper paper);
	
	//覆盖老版本论文
	public void updatePaperItem(Paper paper);
	
	//查找已有论文版本
	public ArrayList<String> selectPaperItem(Paper paper);
	
}

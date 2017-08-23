/**
 * 
 */
package cn.pms.ssm.service;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import cn.pms.ssm.po.Paper;
import cn.pms.ssm.vo.UploadVo;

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
	
	//上传论文
	public void insertPaperItem(UploadVo uploadVo);
	public void insertFileItem(UploadVo uploadVo);
	
	//添加新版本论文
	public UploadVo selectPaperIfExist(UploadVo uploadVo);
	
	//覆盖老版本论文
	public void updatePaperItem(UploadVo uploadVo);
	
	//查找已有论文版本
	public ArrayList<Integer> selectPaperItem(UploadVo uploadVo);
	
}

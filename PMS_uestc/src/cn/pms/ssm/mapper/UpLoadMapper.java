/**
 * 
 */
package cn.pms.ssm.mapper;

import java.util.ArrayList;

import cn.pms.ssm.po.Paper;
import cn.pms.ssm.vo.UploadVo;

/** 
 * <p>Title: UpLoadMapper</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年6月20日 下午7:58:08 
 * @version 1.0 
*/
public interface UpLoadMapper {
	
	//上传论文
	public void insertPaperItem(UploadVo uploadVo);
	public void insertFileItem(UploadVo uploadVo);
	
	//添加新版本论文
	public UploadVo selectPaperIfExist(UploadVo uploadVo);
	
	//覆盖老版本论文
	public void updatePaperItem(UploadVo uploadVo);
	
	//查找已有论文版本(下载也用这个)
	public ArrayList<Integer> selectPaperItem(UploadVo uploadVo);
	
}

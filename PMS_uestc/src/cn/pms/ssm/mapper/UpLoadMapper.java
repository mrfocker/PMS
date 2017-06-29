/**
 * 
 */
package cn.pms.ssm.mapper;

import java.util.ArrayList;

import cn.pms.ssm.po.Paper;

/** 
 * <p>Title: UpLoadMapper</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年6月20日 下午7:58:08 
 * @version 1.0 
*/
public interface UpLoadMapper {
	
	//添加新版本论文
	public void insertPaperItem(Paper paper); 
	
	//覆盖老版本论文
	public void updatePaperItem(Paper paper);
	
	//查找已有论文版本
	public ArrayList<String> selectPaperItem(Paper paper);
	
	
}

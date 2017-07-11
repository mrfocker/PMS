/**
 * 
 */
package cn.pms.ssm.vo;

import cn.pms.ssm.po.Paper;

/** 
 * <p>Title: DownloadVo</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年7月6日 上午11:21:13 
 * @version 1.0 
*/
public class DownloadVo extends Paper{
	private String Stu_name;

	/**
	 * @return the stu_name
	 */
	public String getStu_name() {
		return Stu_name;
	}

	/**
	 * @param stu_name the stu_name to set
	 */
	public void setStu_name(String stu_name) {
		Stu_name = stu_name;
	}
}

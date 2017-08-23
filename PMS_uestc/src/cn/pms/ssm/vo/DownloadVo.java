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
	private String File_name;
	private int File_type;

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

	/**
	 * @return the file_name
	 */
	public String getFile_name() {
		return File_name;
	}

	/**
	 * @param file_name the file_name to set
	 */
	public void setFile_name(String file_name) {
		File_name = file_name;
	}

	/**
	 * @return the file_type
	 */
	public int getFile_type() {
		return File_type;
	}

	/**
	 * @param file_type the file_type to set
	 */
	public void setFile_type(int file_type) {
		File_type = file_type;
	}
}

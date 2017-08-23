/**
 * 
 */
package cn.pms.ssm.vo;

import cn.pms.ssm.po.Paper;

/** 
 * <p>Title: UploadVo</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年7月14日 下午4:45:01 
 * @version 1.0 
*/
public class UploadVo extends Paper{
	private String File_name;
	private int File_type;

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

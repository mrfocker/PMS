/**
 * 
 */
package cn.pms.ssm.po;

/**
 * <p>
 * Title: Administrator
 * </p>
 * <p>
 * Description:Admin 实体
 * </p>
 * <p>
 * Company: uestc_xr
 * </p>
 * 
 * @author Xiaozhe
 * @date 创建时间：2017年6月8日 上午10:51:24
 * @version 1.0
 */
public class Administrator {

	private String su_id;
	private String su_password;
	private Boolean su_isonline;
	private String su_idnumber;
	/**
	 * @return the su_password
	 */
	public String getSu_password() {
		return su_password;
	}
	/**
	 * @param su_password the su_password to set
	 */
	public void setSu_password(String su_password) {
		this.su_password = su_password;
	}
	/**
	 * @return the su_isonline
	 */
	public Boolean getSu_isonline() {
		return su_isonline;
	}
	/**
	 * @param su_isonline the su_isonline to set
	 */
	public void setSu_isonline(Boolean su_isonline) {
		this.su_isonline = su_isonline;
	}
	/**
	 * @return the su_id
	 */
	public String getSu_id() {
		return su_id;
	}
	/**
	 * @param su_id the su_id to set
	 */
	public void setSu_id(String su_id) {
		this.su_id = su_id;
	}
	
	public String getSu_idnumber() {
		return su_idnumber;
	}
	
	public void setSu_idnumber(String su_idnumber) {
		this.su_idnumber = su_idnumber;
	}
	
}

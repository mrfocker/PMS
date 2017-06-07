/**
 * 
 */
package cn.pms.ssm.po;

import java.sql.Date;

/**
 * @author Xiaozhe
 *
 */
public class Student {
	private String Stu_id;
	private String Stu_password;
	private Boolean Stu_isonline;
	private String Stu_name;
	private String Stu_teacherId;
	private String Stu_major;
	private String Stu_stuType;
	private String Stu_degreeType;
	private String Stu_teacherCompany;
	private Date Stu_requestReplyTime;
	/**
	 * @return the stu_id
	 */
	public String getStu_id() {
		return Stu_id;
	}

	/**
	 * @param stu_id
	 *            the stu_id to set
	 */
	public void setStu_id(String stu_id) {
		Stu_id = stu_id;
	}

	/**
	 * @return the stu_name
	 */
	public String getStu_name() {
		return Stu_name;
	}

	/**
	 * @param stu_name
	 *            the stu_name to set
	 */
	public void setStu_name(String stu_name) {
		Stu_name = stu_name;
	}

	/**
	 * @return the stu_teacherId
	 */
	public String getStu_teacherId() {
		return Stu_teacherId;
	}

	/**
	 * @param stu_teacherId
	 *            the stu_teacherId to set
	 */
	public void setStu_teacherId(String stu_teacherId) {
		Stu_teacherId = stu_teacherId;
	}

	/**
	 * @return the stu_major
	 */
	public String getStu_major() {
		return Stu_major;
	}

	/**
	 * @param stu_major
	 *            the stu_major to set
	 */
	public void setStu_major(String stu_major) {
		Stu_major = stu_major;
	}

	/**
	 * @return the stu_stuType
	 */
	public String getStu_stuType() {
		return Stu_stuType;
	}

	/**
	 * @param stu_stuType
	 *            the stu_stuType to set
	 */
	public void setStu_stuType(String stu_stuType) {
		Stu_stuType = stu_stuType;
	}

	/**
	 * @return the stu_degreeType
	 */
	public String getStu_degreeType() {
		return Stu_degreeType;
	}

	/**
	 * @param stu_degreeType
	 *            the stu_degreeType to set
	 */
	public void setStu_degreeType(String stu_degreeType) {
		Stu_degreeType = stu_degreeType;
	}

	/**
	 * @return the stu_teacherCompany
	 */
	public String getStu_teacherCompany() {
		return Stu_teacherCompany;
	}

	/**
	 * @param stu_teacherCompany
	 *            the stu_teacherCompany to set
	 */
	public void setStu_teacherCompany(String stu_teacherCompany) {
		Stu_teacherCompany = stu_teacherCompany;
	}

	/**
	 * @return the stu_requestReplyTime
	 */
	public Date getStu_requestReplyTime() {
		return Stu_requestReplyTime;
	}

	/**
	 * @param stu_requestReplyTime
	 *            the stu_requestReplyTime to set
	 */
	public void setStu_requestReplyTime(Date stu_requestReplyTime) {
		Stu_requestReplyTime = stu_requestReplyTime;
	}

	/**
	 * @return the stu_isonline
	 */
	public Boolean getStu_isonline() {
		return Stu_isonline;
	}

	/**
	 * @param stu_isonline the stu_isonline to set
	 */
	public void setStu_isonline(Boolean stu_isonline) {
		Stu_isonline = stu_isonline;
	}

	/**
	 * @return the stu_password
	 */
	public String getStu_password() {
		return Stu_password;
	}

	/**
	 * @param stu_password the stu_password to set
	 */
	public void setStu_password(String stu_password) {
		Stu_password = stu_password;
	}

}

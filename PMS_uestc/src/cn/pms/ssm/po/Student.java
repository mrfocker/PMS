package cn.pms.ssm.po;

import java.sql.Date;

/** 
 * <p>Title:Student </p> 
 * <p>Description:student infomation </p> 
 * <p>Company: uestc_xr</p> 
 * @author:  liuxiang 
 * @date:2017年6月24日
 * @version 1.0 
*/
public class Student {
	
	private String Stu_id;
	private String Stu_password;
	private int isonline;
	private String Stu_name;
	private String Stu_teacherId;
	private String Stu_major;
	private String Stu_stuType;
	private String Stu_degreeType;
	private String Stu_teacherCompany;
	private Date Stu_requestReplyTime;
	public String getStu_id() {
		return Stu_id;
	}
	public void setStu_id(String stu_id) {
		Stu_id = stu_id;
	}
	public String getStu_password() {
		return Stu_password;
	}
	public void setStu_password(String stu_password) {
		Stu_password = stu_password;
	}
	public int getIsonline() {
		return isonline;
	}
	public void setIsonline(int isonline) {
		this.isonline = isonline;
	}
	public String getStu_name() {
		return Stu_name;
	}
	public void setStu_name(String stu_name) {
		Stu_name = stu_name;
	}
	public String getStu_teacherId() {
		return Stu_teacherId;
	}
	public void setStu_teacherId(String stu_teacherId) {
		Stu_teacherId = stu_teacherId;
	}
	public String getStu_major() {
		return Stu_major;
	}
	public void setStu_major(String stu_major) {
		Stu_major = stu_major;
	}
	public String getStu_stuType() {
		return Stu_stuType;
	}
	public void setStu_stuType(String stu_stuType) {
		Stu_stuType = stu_stuType;
	}
	public String getStu_degreeType() {
		return Stu_degreeType;
	}
	public void setStu_degreeType(String stu_degreeType) {
		Stu_degreeType = stu_degreeType;
	}
	public String getStu_teacherCompany() {
		return Stu_teacherCompany;
	}
	public void setStu_teacherCompany(String stu_teacherCompany) {
		Stu_teacherCompany = stu_teacherCompany;
	}
	public Date getStu_requestReplyTime() {
		return Stu_requestReplyTime;
	}
	public void setStu_requestReplyTime(Date stu_requestReplyTime) {
		Stu_requestReplyTime = stu_requestReplyTime;
	}
	@Override
	public String toString() {
		return "Student [Stu_id=" + Stu_id + ", Stu_password=" + Stu_password
				+ ", isonline=" + isonline + ", Stu_name=" + Stu_name
				+ ", Stu_teacherId=" + Stu_teacherId + ", Stu_major="
				+ Stu_major + ", Stu_stuType=" + Stu_stuType
				+ ", Stu_degreeType=" + Stu_degreeType + ", Stu_teacherCompany="
				+ Stu_teacherCompany + ", Stu_requestReplyTime="
				+ Stu_requestReplyTime + "]";
	}
	public Student(String stu_id, String stu_password, int isonline,
			String stu_name, String stu_teacherId, String stu_major,
			String stu_stuType, String stu_degreeType,
			String stu_teacherCompany, Date stu_requestReplyTime) {
		super();
		Stu_id = stu_id;
		Stu_password = stu_password;
		this.isonline = isonline;
		Stu_name = stu_name;
		Stu_teacherId = stu_teacherId;
		Stu_major = stu_major;
		Stu_stuType = stu_stuType;
		Stu_degreeType = stu_degreeType;
		Stu_teacherCompany = stu_teacherCompany;
		Stu_requestReplyTime = stu_requestReplyTime;
	}
	
	public Student(){
		
	}
	

}

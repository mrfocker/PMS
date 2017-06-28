package cn.pms.ssm.po;
/** 
 * <p>Title: Teacher</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  gpan 
 * @date 创建时间：2017年6月28日 下午6:24:08 
 * @version 1.0 
*/

public class Teacher {
	  private String Teacher_id;
	  private String Teacher_password;
	  private Boolean Teacher_isonline;
	  private String Teacher_name;
	  private String Teacher_proTitle; //职称
	  private String Teacher_researchOne;
	  private String Teacher_researchTwo;
	  private String Teacher_researchThree;
	  private String Teacher_email;
	  private String Teacher_tel;
	  private int Teacher_count;
	  private int Teacher_limit;
	  
	public String getTeacher_id() {
		return Teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		Teacher_id = teacher_id;
	}
	public String getTeacher_password() {
		return Teacher_password;
	}
	public void setTeacher_password(String teacher_password) {
		Teacher_password = teacher_password;
	}
	public Boolean getTeacher_isonline() {
		return Teacher_isonline;
	}
	public void setTeacher_isonline(Boolean teacher_isonline) {
		Teacher_isonline = teacher_isonline;
	}
	public String getTeacher_name() {
		return Teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		Teacher_name = teacher_name;
	}
	public String getTeacher_proTitle() {
		return Teacher_proTitle;
	}
	public void setTeacher_proTitle(String teacher_proTitle) {
		Teacher_proTitle = teacher_proTitle;
	}
	public String getTeacher_researchOne() {
		return Teacher_researchOne;
	}
	public void setTeacher_researchOne(String teacher_researchOne) {
		Teacher_researchOne = teacher_researchOne;
	}
	public String getTeacher_researchTwo() {
		return Teacher_researchTwo;
	}
	public void setTeacher_researchTwo(String teacher_researchTwo) {
		Teacher_researchTwo = teacher_researchTwo;
	}
	public String getTeacher_researchThree() {
		return Teacher_researchThree;
	}
	public void setTeacher_researchThree(String teacher_researchThree) {
		Teacher_researchThree = teacher_researchThree;
	}
	public String getTeacher_email() {
		return Teacher_email;
	}
	public void setTeacher_email(String teacher_email) {
		Teacher_email = teacher_email;
	}
	public String getTeacher_tel() {
		return Teacher_tel;
	}
	public void setTeacher_tel(String teacher_tel) {
		Teacher_tel = teacher_tel;
	}
	public int getTeacher_count() {
		return Teacher_count;
	}
	public void setTeacher_count(int teacher_count) {
		Teacher_count = teacher_count;
	}
	public int getTeacher_limit() {
		return Teacher_limit;
	}
	public void setTeacher_limit(int teacher_limit) {
		Teacher_limit = teacher_limit;
	}
	
}


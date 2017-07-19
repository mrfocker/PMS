package cn.pms.ssm.po;

/** 
 * <p>Title: TeacherQureryVo</p> 
 * <p>Description:vo包装教师登录后的各种查询信息</p> 
 * <p>Company: uestc_xr</p> 
 * @author  liuxiang 
 * @date : 2017-06-10
 * @version 1.0 
*/

public class TeacherQueryVo {
	//教师姓名
	private String Teacher_name;
	
	//教师工号
	private String Teacher_id;
	
	//学生ID
	private String Stu_id;
	
	//学生姓名
	private String Stu_name;
	
	//论文题目
	private String Paper_title;
	
	//论文研究方向
	private String Paper_researchOne;
	private String Paper_researchTwo;
	private String Paper_researchThree;
	public String getStu_id() {
		return Stu_id;
	}
	public void setStu_id(String stu_id) {
		Stu_id = stu_id;
	}
	public String getStu_name() {
		return Stu_name;
	}
	public void setStu_name(String stu_name) {
		Stu_name = stu_name;
	}
	public String getPaper_title() {
		return Paper_title;
	}
	public void setPaper_title(String paper_title) {
		Paper_title = paper_title;
	}
	public String getPaper_researchOne() {
		return Paper_researchOne;
	}
	public void setPaper_researchOne(String paper_researchOne) {
		Paper_researchOne = paper_researchOne;
	}
	public String getPaper_researchTwo() {
		return Paper_researchTwo;
	}
	public void setPaper_researchTwo(String paper_researchTwo) {
		Paper_researchTwo = paper_researchTwo;
	}
	public String getPaper_researchThree() {
		return Paper_researchThree;
	}
	public void setPaper_researchThree(String paper_researchThree) {
		Paper_researchThree = paper_researchThree;
	}
	public String getTeacher_name() {
		return Teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		Teacher_name = teacher_name;
	}
	public String getTeacher_id() {
		return Teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		Teacher_id = teacher_id;
	}
	
	
	
}

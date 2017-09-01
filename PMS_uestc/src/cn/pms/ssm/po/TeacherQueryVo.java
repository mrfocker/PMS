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
	
	private String Teacher_name;
	private String Teacher_id;
	private String Stu_id;
	private String Stu_name;
	private String Paper_title;
	private String Paper_researchOne;
	private String Paper_researchTwo;
	private String Paper_researchThree;
	private String Paper_advise;
	private String Paper_ifPass;
	private String Paper_stuId;
	private int Paper_ifSubmit;
	private int Paper_ifAdvise;
	
	
	public int getPaper_ifAdvise() {
		return Paper_ifAdvise;
	}
	public void setPaper_ifAdvise(int paper_ifAdvise) {
		Paper_ifAdvise = paper_ifAdvise;
	}
	public int getPaper_ifSubmit() {
		return Paper_ifSubmit;
	}
	public void setPaper_ifSubmit(int paper_ifSubmit) {
		Paper_ifSubmit = paper_ifSubmit;
	}
	public String getPaper_stuId() {
		return Paper_stuId;
	}
	public void setPaper_stuId(String paper_stuId) {
		Paper_stuId = paper_stuId;
	}
	private int result_code;
	
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
	public String getPaper_advise() {
		return Paper_advise;
	}
	public void setPaper_advise(String paper_advise) {
		Paper_advise = paper_advise;
	}
	public String getPaper_ifPass() {
		return Paper_ifPass;
	}
	public void setPaper_ifPass(String paper_ifPass) {
		Paper_ifPass = paper_ifPass;
	}
	public int getResult_code() {
		return result_code;
	}
	public void setResult_code(int result_code) {
		this.result_code = result_code;
	}
	
	
	
	
	
}

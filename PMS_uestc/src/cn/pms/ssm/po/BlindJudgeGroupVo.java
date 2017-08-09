package cn.pms.ssm.po;
/** 
 * <p>Title: BlindJudgeGroupVo</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  liuxiang 
 * @date 创建时间：2017年7月17日 上午10:44:30 
 * @version 1.0 
*/

public class BlindJudgeGroupVo {
	
	private String Teacher_id;
	private String Stu_id;
	private String Teacher_Result;
	private String Teacher_Grade;
	private String Teacher_description;
	private int result_code;
	
	private String Paper_stuId;
	private String Paper_title;
	private String Paper_researchOne;
	private String Paper_researchTwo;
	private String Paper_researchThree;
	
	public String getTeacher_Grade() {
		return Teacher_Grade;
	}
	public void setTeacher_Grade(String teacher_Grade) {
		Teacher_Grade = teacher_Grade;
	}
	public String getTeacher_description() {
		return Teacher_description;
	}
	public void setTeacher_description(String teacher_description) {
		Teacher_description = teacher_description;
	}
	public String getTeacher_id() {
		return Teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		Teacher_id = teacher_id;
	}
	public String getStu_id() {
		return Stu_id;
	}
	public void setStu_id(String stu_id) {
		Stu_id = stu_id;
	}
	public String getTeacher_Result() {
		return Teacher_Result;
	}
	public void setTeacher_Result(String teacher_Result) {
		Teacher_Result = teacher_Result;
	}
	public String getPaper_stuId() {
		return Paper_stuId;
	}
	public void setPaper_stuId(String paper_stuId) {
		Paper_stuId = paper_stuId;
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
	public int getResult_code() {
		return result_code;
	}
	public void setResult_code(int result_code) {
		this.result_code = result_code;
	}
	
	
	
	
	
	

}

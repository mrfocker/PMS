package cn.pms.ssm.vo;

/**
 * 盲审结果的实体
 * @author HeXi
 *
 */
public class BlindJudgeResultVo {

	private String Stu_id;
	private String Teacher_id;
	private String Stu_name;
	private String Teacher_name;
	private int Teacher_Grade;
	private String Teacher_Result;
	
	public String getStu_id() {
		return Stu_id;
	}
	
	public void setStu_id(String stu_id) {
		Stu_id = stu_id;
	}
	
	public String getTeacher_id() {
		return Teacher_id;
	}
	
	public void setTeacher_id(String teacher_id) {
		Teacher_id = teacher_id;
	}
	
	public String getStu_name() {
		return Stu_name;
	}
	
	public void setStu_name(String stu_name) {
		Stu_name = stu_name;
	}
	
	public String getTeacher_name() {
		return Teacher_name;
	}
	
	public void setTeacher_name(String teacher_name) {
		Teacher_name = teacher_name;
	}
	
	public int getTeacher_Grade() {
		return Teacher_Grade;
	}
	
	public void setTeacher_Grade(int teacher_Grade) {
		Teacher_Grade = teacher_Grade;
	}
	
	public String getTeacher_Result() {
		return Teacher_Result;
	}
	
	public void setTeacher_Result(String teacher_Result) {
		Teacher_Result = teacher_Result;
	}
	
}

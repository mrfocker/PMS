package cn.pms.ssm.po;
/** 
 * <p>Title: blindjudgegroup</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  liuxiang 
 * @date 创建时间：2017年7月17日 上午10:32:21 
 * @version 1.0 
*/

public class BlindJudgeGroup {
	
	private String Stu_id;
	private String Teacher_id;
	private int Teacher_Grade;
	private int Teacher_Result;
	private String Teacher_description;
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
	public int getTeacher_Grade() {
		return Teacher_Grade;
	}
	public void setTeacher_Grade(int teacher_Grade) {
		Teacher_Grade = teacher_Grade;
	}
	public int getTeacher_Result() {
		return Teacher_Result;
	}
	public void setTeacher_Result(int teacher_Result) {
		Teacher_Result = teacher_Result;
	}
	public String getTeacher_description() {
		return Teacher_description;
	}
	public void setTeacher_description(String teacher_description) {
		Teacher_description = teacher_description;
	}
	
	

}

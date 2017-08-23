package cn.pms.ssm.vo;

/**
 * 答辩结果的实体
 * @author HeXi
 *
 */
public class ReplyResultVo {

	private String Stu_id;
	private String Stu_name;
	private String Teacher_id;
	private String Teacher_name;
	private String Group_id;
	private int Reply_grade;
	private String Reply_result;
	
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
	
	public String getTeacher_id() {
		return Teacher_id;
	}
	
	public void setTeacher_id(String teacher_id) {
		Teacher_id = teacher_id;
	}
	
	public String getTeacher_name() {
		return Teacher_name;
	}
	
	public void setTeacher_name(String teacher_name) {
		Teacher_name = teacher_name;
	}
	
	public String getGroup_id() {
		return Group_id;
	}

	public void setGroup_id(String group_id) {
		Group_id = group_id;
	}

	public int getReply_grade() {
		return Reply_grade;
	}
	
	public void setReply_grade(int reply_grade) {
		Reply_grade = reply_grade;
	}
	
	public String getReply_result() {
		return Reply_result;
	}
	
	public void setReply_result(String reply_result) {
		Reply_result = reply_result;
	}

}

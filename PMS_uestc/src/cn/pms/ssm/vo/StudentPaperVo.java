package cn.pms.ssm.vo;

/**
 * 学生论文的实体类
 * @author HeXi
 *
 */
public class StudentPaperVo{
	
	private String Stu_id;//学生Id
	private String Stu_name;//学生姓名
	private String Teacher_id;//指导老师Id
	private String Teacher_name;//指导老师姓名
	private String Paper_title;//论文标题
	private String Paper_ifPass;//在本导师处是否通过
	private String Paper_departPass;//在学院是否通过
	private int Paper_ifAdvice;//导师是否能操作导师审核步骤
	
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

	public String getPaper_ifPass() {
		return Paper_ifPass;
	}

	public void setPaper_ifPass(String paper_ifPass) {
		Paper_ifPass = paper_ifPass;
	}

	public String getPaper_departPass() {
		return Paper_departPass;
	}

	public void setPaper_departPass(String paper_departPass) {
		Paper_departPass = paper_departPass;
	}

	public int getPaper_ifAdvice() {
		return Paper_ifAdvice;
	}

	public void setPaper_ifAdvice(int paper_ifAdvice) {
		Paper_ifAdvice = paper_ifAdvice;
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
	

}

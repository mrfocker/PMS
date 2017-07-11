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
	
	//导师信息
	private Teacher teacher;
	
	//学生论文信息
	private Paper paper;
	
	//导师的学生的信息
	private Student student;
	
	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}

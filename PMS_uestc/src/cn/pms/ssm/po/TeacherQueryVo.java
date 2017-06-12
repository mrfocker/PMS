package cn.pms.ssm.po;

/** 
 * <p>Title: TeacherQureryVo</p> 
 * <p>Description:vo用于系统扩展 </p> 
 * <p>Company: uestc_xr</p> 
 * @author  liuxiang 
 * @date : 2017-06-10
 * @version 1.0 
*/

public class TeacherQueryVo {
	
	//教师信息
	private Teacher teacher;
	
	//针对系统可扩展性，对po进行扩展
	private TeacherInfo TeacherInfo;

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public TeacherInfo getTeacherInfo() {
		return TeacherInfo;
	}

	public void setTeacherInfo(TeacherInfo teacherInfo) {
		TeacherInfo = teacherInfo;
	}
	
	

}

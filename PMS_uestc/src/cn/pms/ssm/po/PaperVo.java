package cn.pms.ssm.po;
/** 
 * <p>Title: PaperVo</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  gpan 
 * @date 创建时间：2017年6月29日 下午8:08:14 
 * @version 1.0 
*/

public class PaperVo extends Paper {

	
	private String Stu_teacherId;//该学生论文的导师
	private String Judge_teacherIdOne; //该论文第一盲审老师id
	private String Judge_teacherIdTwo;//该论文第二盲审老师id
	
	public String getJudge_teacherIdOne() {
		return Judge_teacherIdOne;
	}

	public void setJudge_teacherIdOne(String judge_teacherIdOne) {
		Judge_teacherIdOne = judge_teacherIdOne;
	}

	public String getJudge_teacherIdTwo() {
		return Judge_teacherIdTwo;
	}

	public void setJudge_teacherIdTwo(String judge_teacherIdTwo) {
		Judge_teacherIdTwo = judge_teacherIdTwo;
	}
	

	public String getStu_teacherId() {
		return Stu_teacherId;
	}

	public void setStu_teacherId(String stu_teacherId) {
		Stu_teacherId = stu_teacherId;
	}

	
}


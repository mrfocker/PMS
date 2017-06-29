package test;
/** 
 * <p>Title: teacherTest</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  gpan 
 * @date 创建时间：2017年6月28日 下午10:58:19 
 * @version 1.0 
*/

public class teacherTest {
	
	  private String Teacher_id;
	  private String Teacher_name;
	  private String Teacher_researchOne;
	  private String Teacher_researchTwo;
	  private String Teacher_researchThree;
	
	public teacherTest(String id,String name, String r1, String r2,String r3) {
		// TODO Auto-generated constructor stub
		this.Teacher_id = id;
		this.Teacher_name = name;
		this.Teacher_researchOne = r1;
		this.Teacher_researchTwo = r2;
		this.Teacher_researchThree = r3;
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
	public String getTeacher_researchOne() {
		return Teacher_researchOne;
	}
	public void setTeacher_researchOne(String teacher_researchOne) {
		Teacher_researchOne = teacher_researchOne;
	}
	public String getTeacher_researchTwo() {
		return Teacher_researchTwo;
	}
	public void setTeacher_researchTwo(String teacher_researchTwo) {
		Teacher_researchTwo = teacher_researchTwo;
	}
	public String getTeacher_researchThree() {
		return Teacher_researchThree;
	}
	public void setTeacher_researchThree(String teacher_researchThree) {
		Teacher_researchThree = teacher_researchThree;
	}
	 
}


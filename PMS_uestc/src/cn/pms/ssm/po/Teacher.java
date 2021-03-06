<<<<<<< HEAD
<<<<<<< HEAD
package cn.pms.ssm.po;

/**
 * 
 * <p>
 * Title: Teacher
 * </p>
 * <p>
 * Description: ��ʦ��Ϣ��ݳ־û�
 * </p>
 * <p>
 * Company: uestc_xr
 * </p>
 * 
 * @author liuxiang
 * @date 2017/06/06
 * @version 1.0
 */

public class Teacher {

	private String Teacher_id;
	private String Teacher_password;
	private int Teacher_isonline;
	private String Teacher_name;
	private String Teacher_proTitle;
	private String Teacher_researchOne;
	private String Teacher_researchTwo;
	private String Teacher_researchThree;
	private String Teacher_email;
	private String Teacher_tel;
	public String getTeacher_id() {
		return Teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		Teacher_id = teacher_id;
	}
	public String getTeacher_password() {
		return Teacher_password;
	}
	public void setTeacher_password(String teacher_password) {
		Teacher_password = teacher_password;
	}
	public int getTeacher_isonline() {
		return Teacher_isonline;
	}
	public void setTeacher_isonline(int teacher_isonline) {
		Teacher_isonline = teacher_isonline;
	}
	public String getTeacher_name() {
		return Teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		Teacher_name = teacher_name;
	}
	public String getTeacher_proTitle() {
		return Teacher_proTitle;
	}
	public void setTeacher_proTitle(String teacher_proTitle) {
		Teacher_proTitle = teacher_proTitle;
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
	public String getTeacher_email() {
		return Teacher_email;
	}
	public void setTeacher_email(String teacher_email) {
		Teacher_email = teacher_email;
	}
	public String getTeacher_tel() {
		return Teacher_tel;
	}
	public void setTeacher_tel(String teacher_tel) {
		Teacher_tel = teacher_tel;
	}


	

	@Override
	public String toString() {
		return "Teacher [Teacher_id=" + Teacher_id + ", Teacher_password="
				+ Teacher_password + ", Teacher_isonline=" + Teacher_isonline
				+ ", Teacher_name=" + Teacher_name + ", Teacher_proTitle="
				+ Teacher_proTitle + ", Teacher_researchOne="
				+ Teacher_researchOne + ", Teacher_researchTwo="
				+ Teacher_researchTwo + ", Teacher_researchThree="
				+ Teacher_researchThree + ", Teacher_email=" + Teacher_email
				+ ", Teacher_tel=" + Teacher_tel + "]";
	}
	
	public Teacher(String teacher_id, String teacher_password,
			int teacher_isonline, String teacher_name, String teacher_proTitle,
			String teacher_researchOne, String teacher_researchTwo,
			String teacher_researchThree, String teacher_email,
			String teacher_tel) {
		super();
		Teacher_id = teacher_id;
		Teacher_password = teacher_password;
		Teacher_isonline = teacher_isonline;
		Teacher_name = teacher_name;
		Teacher_proTitle = teacher_proTitle;
		Teacher_researchOne = teacher_researchOne;
		Teacher_researchTwo = teacher_researchTwo;
		Teacher_researchThree = teacher_researchThree;
		Teacher_email = teacher_email;
		Teacher_tel = teacher_tel;
	}
	public Teacher(){
		
	}
	

=======
/**
 * 
 */
=======
>>>>>>> jj_branch
package cn.pms.ssm.po;
/** 
 * <p>Title: Teacher</p> 
 * <p>Description:Teacher实体 </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年6月8日 上午10:24:14 
 * @version 1.0 
*/
public class Teacher {

	  private String Teacher_id;
	  private String Teacher_password;
	  private Boolean Teacher_isonline;
	  private String Teacher_name;
	  private String Teacher_proTitle; //职称
	  private String Teacher_researchOne;
	  private String Teacher_researchTwo;
	  private String Teacher_researchThree;
	  private String Teacher_email;
	  private String Teacher_tel;
	  private int Teacher_count;
	  private int Teacher_limit;
	  private String Teacher_idNumber;
	  /**
	 * @return the teacher_count
	 */
	public int getTeacher_count() {
		return Teacher_count;
	}
	/**
	 * @param teacher_count the teacher_count to set
	 */
	public void setTeacher_count(int teacher_count) {
		Teacher_count = teacher_count;
	}
	/**
	 * @return the teacher_limit
	 */
	public int getTeacher_limit() {
		return Teacher_limit;
	}
	/**
	 * @param teacher_limit the teacher_limit to set
	 */
	public void setTeacher_limit(int teacher_limit) {
		Teacher_limit = teacher_limit;
	}
	/**
	 * @return the teacher_id
	 */
	public String getTeacher_id() {
		return Teacher_id;
	}
	/**
	 * @param teacher_id the teacher_id to set
	 */
	public void setTeacher_id(String teacher_id) {
		Teacher_id = teacher_id;
	}
	/**
	 * @return the teacher_password
	 */
	public String getTeacher_password() {
		return Teacher_password;
	}
	/**
	 * @param teacher_password the teacher_password to set
	 */
	public void setTeacher_password(String teacher_password) {
		Teacher_password = teacher_password;
	}
	/**
	 * @return the teacher_isonline
	 */
	public Boolean getTeacher_isonline() {
		return Teacher_isonline;
	}
	/**
	 * @param teacher_isonline the teacher_isonline to set
	 */
	public void setTeacher_isonline(Boolean teacher_isonline) {
		Teacher_isonline = teacher_isonline;
	}
	/**
	 * @return the teacher_name
	 */
	public String getTeacher_name() {
		return Teacher_name;
	}
	/**
	 * @param teacher_name the teacher_name to set
	 */
	public void setTeacher_name(String teacher_name) {
		Teacher_name = teacher_name;
	}
	/**
	 * @return the teacher_proTitle
	 */
	public String getTeacher_proTitle() {
		return Teacher_proTitle;
	}
	/**
	 * @param teacher_proTitle the teacher_proTitle to set
	 */
	public void setTeacher_proTitle(String teacher_proTitle) {
		Teacher_proTitle = teacher_proTitle;
	}
	/**
	 * @return the teacher_researchOne
	 */
	public String getTeacher_researchOne() {
		return Teacher_researchOne;
	}
	/**
	 * @param teacher_researchOne the teacher_researchOne to set
	 */
	public void setTeacher_researchOne(String teacher_researchOne) {
		Teacher_researchOne = teacher_researchOne;
	}
	/**
	 * @return the teacher_researchTwo
	 */
	public String getTeacher_researchTwo() {
		return Teacher_researchTwo;
	}
	/**
	 * @param teacher_researchTwo the teacher_researchTwo to set
	 */
	public void setTeacher_researchTwo(String teacher_researchTwo) {
		Teacher_researchTwo = teacher_researchTwo;
	}
	/**
	 * @return the teacher_researchThree
	 */
	public String getTeacher_researchThree() {
		return Teacher_researchThree;
	}
	/**
	 * @param teacher_researchThree the teacher_researchThree to set
	 */
	public void setTeacher_researchThree(String teacher_researchThree) {
		Teacher_researchThree = teacher_researchThree;
	}
	/**
	 * @return the teacher_email
	 */
	public String getTeacher_email() {
		return Teacher_email;
	}
	/**
	 * @param teacher_email the teacher_email to set
	 */
	public void setTeacher_email(String teacher_email) {
		Teacher_email = teacher_email;
	}
	/**
	 * @return the teacher_tel
	 */
	public String getTeacher_tel() {
		return Teacher_tel;
	}
	/**
	 * @param teacher_tel the teacher_tel to set
	 */
	public void setTeacher_tel(String teacher_tel) {
		Teacher_tel = teacher_tel;
	}
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> jj_branch
=======
	@Override
	public String toString() {
		return "Teacher [Teacher_id=" + Teacher_id + ", Teacher_password="
				+ Teacher_password + ", Teacher_isonline=" + Teacher_isonline
				+ ", Teacher_name=" + Teacher_name + ", Teacher_proTitle="
				+ Teacher_proTitle + ", Teacher_researchOne="
				+ Teacher_researchOne + ", Teacher_researchTwo="
				+ Teacher_researchTwo + ", Teacher_researchThree="
				+ Teacher_researchThree + ", Teacher_email=" + Teacher_email
				+ ", Teacher_tel=" + Teacher_tel + "]";
	}
	
	public Teacher(String teacher_id, String teacher_password,
			Boolean teacher_isonline, String teacher_name, String teacher_proTitle,
			String teacher_researchOne, String teacher_researchTwo,
			String teacher_researchThree, String teacher_email,
			String teacher_tel) {
		super();
		Teacher_id = teacher_id;
		Teacher_password = teacher_password;
		Teacher_isonline = teacher_isonline;
		Teacher_name = teacher_name;
		Teacher_proTitle = teacher_proTitle;
		Teacher_researchOne = teacher_researchOne;
		Teacher_researchTwo = teacher_researchTwo;
		Teacher_researchThree = teacher_researchThree;
		Teacher_email = teacher_email;
		Teacher_tel = teacher_tel;
	}
	public Teacher(){
		
	}
>>>>>>> jj_branch
=======
	
	public String getTeacher_idNumber() {
		return Teacher_idNumber;
	}
	
	public void setTeacher_idNumber(String teacher_idNumber) {
		Teacher_idNumber = teacher_idNumber;
	}
	
	
>>>>>>> jj_branch
}

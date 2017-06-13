package cn.pms.ssm.po;
/** 
 * <p>Title: Student</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  liuxiang 
 * @date ����ʱ�䣺2017��6��6�� ����10:39:29 
 * @version 1.0 
*/

public class Students {
	private int id;
	private String username;
	private int age;
	private int salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", username=" + username + ", age=" + age
				+ ", salary=" + salary + "]";
	}
	public Students(int id, String username, int age, int salary) {
//		super();
		this.id = id;
		this.username = username;
		this.age = age;
		this.salary = salary;
	}
	public Students() {
//		super();
	}	
}


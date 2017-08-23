/**
 * 
 */
package test.java.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.pms.ssm.mapper.ChangePwdMapper;
import cn.pms.ssm.mapper.UpLoadMapper;
import cn.pms.ssm.po.Administrator;
import cn.pms.ssm.po.Paper;
import cn.pms.ssm.po.Student;
import cn.pms.ssm.po.Teacher;

/**
 * <p>
 * Title: ChangePwdMapperTest
 * </p>
 * <p>
 * Description:TODO
 * </p>
 * <p>
 * Company: uestc_xr
 * </p>
 * 
 * @author Xiaozhe
 * @date 创建时间：2017年6月30日 下午1:44:23
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/applicationContext-dao.xml" })
public class ChangePwdMapperTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		Student student = new Student();
		Teacher teacher = new Teacher();
		Administrator administrator = new Administrator();

		student.setStu_id("121");
		student.setStu_password("555");
		teacher.setTeacher_id("111111111111");
		teacher.setTeacher_password("122");
		administrator.setSu_id("9123");
		administrator.setSu_password("123");

		ChangePwdMapper changePwdMapper = ctx.getBean("changePwdMapper", ChangePwdMapper.class);
		changePwdMapper.updatePwdStudent(student);
		changePwdMapper.updatePwdTeacher(teacher);
		changePwdMapper.updatePwdAdmin(administrator);

		System.out.println("------------------end------------------");
	}

	@Test
	public void testSelect() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		Student student = new Student();
		Teacher teacher = new Teacher();
		Administrator administrator = new Administrator();

		student.setStu_id("121");
		teacher.setTeacher_id("111111111111");
		administrator.setSu_id("9123");

		ChangePwdMapper changePwdMapper = ctx.getBean("changePwdMapper", ChangePwdMapper.class);
		String result = "result------------------------------>Admin: "
				+ changePwdMapper.selectPwdByAdminId(administrator) + "\n" + "Student: "
				+ changePwdMapper.selectPwdByStudentId(student) + "\n" + "Teacher: "
				+ changePwdMapper.selectPwdByTeacherId(teacher);

		System.out.println(result);
	}
}

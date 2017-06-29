package cn.pms.ssm.import_export;
/** 
 * <p>Title: ExportDBToExcel</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  liuxiang 
 * @date 创建时间：2017年6月14日 下午3:38:15 
 * @version 1.0 
*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.pms.ssm.mapper.TeacherMapper;

public class ExportDBToExcel {

	private static ApplicationContext applicationContext;
	private static ExportExcelUtil eeu = new ExportExcelUtil();
	public static void main(String[] args) {
		
		String[] title = "序号,招生代码,姓名,职称,研究方向1,研究方向2,研究方向3,邮箱,电话".split(",");
		String[] column = "Teacher_id,Teacher_password,Teacher_name,Teacher_proTitle,Teacher_researchOne,Teacher_researchTwo,Teacher_researchThree,Teacher_email,Teacher_tel"
				.split(",");
		List<Map> data = selectAll();
		String fileName = "Export Excel By MyBatis";
		eeu.getOutputFile(title, column, data, fileName);

	}

	@SuppressWarnings("rawtypes")
	public static List<Map> selectAll() {
		applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext-dao.xml ");
		TeacherMapper teacherMapper = (TeacherMapper) applicationContext
				.getBean("teacherMapper");
		List<Map> studentList = null;
		try {
			studentList = teacherMapper.getTeacherList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(studentList);
		return studentList;
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public static void selectOneById() {
		applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext-dao.xml ");
		TeacherMapper teacherMapper = (TeacherMapper) applicationContext
				.getBean("teacherMapper");
		Map studentInfoMap = new HashMap();
		studentInfoMap.put("userId", "12");
		Map studentMap = null;
		try {
			studentMap = teacherMapper.getStudentById(studentInfoMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(studentMap);
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public static void deleteStudentById() {
		applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext-dao.xml ");
		TeacherMapper teacherMapper = (TeacherMapper) applicationContext
				.getBean("teacherMapper");
		Map studentInfoMap = new HashMap();
		studentInfoMap.put("userId", "12");
		int result = 0;
		try {
			result = teacherMapper.deleteById(studentInfoMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("删除" + result + "个学生");
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public static void insertStudent() {
		applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext-dao.xml ");
		TeacherMapper teacherMapper = (TeacherMapper) applicationContext
				.getBean("teacherMapper");
		Map studentInfoMap = new HashMap();
		studentInfoMap.put("username", "jack");
		studentInfoMap.put("age", "26");
		studentInfoMap.put("salary", "6000");
		int result = 0;
		try {
			result = teacherMapper.insertStuent(studentInfoMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("添加" + result + "个学生");
	}

}

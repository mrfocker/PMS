package cn.pms.ssm.import_export;
/** 
 * <p>Title: </p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author:  liuxiang 
 * @date:2017年6月13日
 * @version 1.0 
*/

import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import cn.pms.ssm.mapper.TeacherMapper;
import cn.pms.ssm.po.Students;
import cn.pms.ssm.po.Teacher;
//import com.test.util.SqlSessionUtil;

import cn.pms.ssm.BeanUtils.MyBeanUtils;;

public class ReaderExcelToDB {

	private static ApplicationContext applicationContext;
	private static ReaderExcelUtils reu = new ReaderExcelUtils();
	//private static SqlSessionUtil su = new SqlSessionUtil();
	//private static SqlSession session = su.getSqlSession();
	private static String className = ReaderExcelToDB.class.getName() + ".";
	
	public static void main(String[] args) throws Exception {
		InsertToDataBase();
	}

	/**
	 * 读取Excel文件,将数据存入数据库
	 * 
	 * @param data
	 *            数据
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "static-access" })
	public static void InsertToDataBase() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml ");
		
		TeacherMapper teacherMapper = (TeacherMapper) applicationContext.getBean("teacherMapper");
		
		Date date = new Date();
		long time = date.getTime();
		String excelFileName = "e:/teacher.xls";
		File file = new File(excelFileName);
		List<Map> dataListMap = reu.ReaderExcel(file);
		Iterator it = dataListMap.iterator();
		//Students students = new Students();
		Teacher teacher = new Teacher();
		MyBeanUtils mu = new MyBeanUtils();

		try {
			while (it.hasNext()) {
				Map oneMap = (Map) it.next();
				//从excel表读入
				teacher.setTeacher_id(oneMap.get("招生代码").toString());
				teacher.setTeacher_name(oneMap.get("姓名").toString());
				teacher.setTeacher_proTitle(oneMap.get("职称").toString());
				teacher.setTeacher_researchOne(oneMap.get("研究方向1").toString());
				teacher.setTeacher_researchTwo(oneMap.get("研究方向2").toString());
				teacher.setTeacher_researchThree(oneMap.get("研究方向3").toString());
				teacher.setTeacher_email(oneMap.get("邮箱").toString());
				teacher.setTeacher_tel(oneMap.get("电话").toString());
				//其余字段添加
				teacher.setTeacher_password(oneMap.get("招生代码").toString());
				
				
				
			/*	students.setAge(Integer.parseInt(oneMap.get("年龄").toString()));
				students.setSalary(Integer.parseInt(oneMap.get("工资").toString()));*/
				Map beanMap = mu.describe(teacher);

				//int result = 0;
				try {
					teacherMapper.insertStudent(beanMap);
					//result = session.insert(className + "insertStudent",beanMap);
					//if(result < 1){
						//System.out.println("插入数据库错误");
					//}
					//session.commit();
				} catch (Exception e) {
					e.printStackTrace();
					//session.rollback();
				}
			}
			System.out.println("全部插入数据库");
			Date date2 = new Date();
			long time2 = date2.getTime();
			long longs = time2 - time;
			System.out.println(longs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取Map中的key值
	 * 
	 * @param dataMap
	 * @return
	 */
	public static String[] getMapKey(Map dataMap) {
		String[] keyArr = new String[dataMap.size()];
		if (dataMap.size() < 0 || dataMap == null) {
			System.out.println("Map为空");
			return null;
		}
		String keyStr = "";
		Set set = dataMap.keySet();
		for (Object name : set) {
			keyStr += name + ",";
		}
		keyStr = keyStr.substring(0, keyStr.length() - 1);
		keyArr = keyStr.split(",");
		return keyArr;
	}

}

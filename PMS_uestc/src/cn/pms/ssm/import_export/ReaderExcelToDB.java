package cn.pms.ssm.import_export;
/** 
 * <p>Title: ReaderExcelToDB</p> 
 * <p>Description:read data from excel and insert to DB</p> 
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

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import cn.pms.ssm.mapper.TeacherMapper;
import cn.pms.ssm.po.Teacher;

import cn.pms.ssm.BeanUtils.MyBeanUtils;;

public class ReaderExcelToDB {

	private static ApplicationContext applicationContext;
	private static ReaderExcelUtils reu = new ReaderExcelUtils();
	private static String className = ReaderExcelToDB.class.getName() + ".";
	
	public static void main(String[] args) throws Exception {
		InsertToDataBase();
	}

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
		Teacher teacher = new Teacher();
		MyBeanUtils mu = new MyBeanUtils();

		try {
			while (it.hasNext()) {
				Map oneMap = (Map) it.next();
				//从excel表读入
				teacher.setTeacher_id(oneMap.get("招生代码").toString());
				teacher.setTeacher_password(oneMap.get("招生代码").toString()); 				//初始密码和招生代码相同
				teacher.setTeacher_name(oneMap.get("姓名").toString());
				teacher.setTeacher_proTitle(oneMap.get("职称").toString());
				teacher.setTeacher_researchOne(oneMap.get("研究方向1").toString());
				teacher.setTeacher_researchTwo(oneMap.get("研究方向2").toString());
				teacher.setTeacher_researchThree(oneMap.get("研究方向3").toString());
				teacher.setTeacher_email(oneMap.get("邮箱").toString());
				teacher.setTeacher_tel(oneMap.get("电话").toString());
				
				Map beanMap = mu.describe(teacher);
				System.out.println(beanMap);
				int result = 0;
				try {
					result = teacherMapper.insertTeacherInfo(teacher);
					System.out.println(result);
					if(result < 1){
						System.out.println("插入数据库错误");
					}
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

	// 获取Map中的key值
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

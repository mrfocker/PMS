/**
 * 
 */
package cn.pms.ssm.db;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Xiaozhe
 *
 */
public class DBConnect {
	public SqlSession sqlSession() {
		//通过配置文件获取数据库信息
//				Reader reader = Resources.getResourceAsReader("WEB-INF/configs/mybatis/Configuration.xml");
				ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext-dao.xml");
//				通过配置信息构建SqlSessionFactory
				SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) cxt.getBean("sqlSessionFactory");
//				通过SqlSessionFactory打开一个会话
				SqlSession session = (SqlSession) cxt.getBean("studentInfoDAOImpl");
		return null;
	}
}

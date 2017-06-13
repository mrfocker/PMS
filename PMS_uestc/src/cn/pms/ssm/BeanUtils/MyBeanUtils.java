package cn.pms.ssm.BeanUtils;
/** 
 * <p>Title: </p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author:  liuxiang 
 * @date:2017年6月13日
 * @version 1.0 
*/
import java.util.Map;


public class MyBeanUtils {
	
	/**
	 * 将JavaBean中的get属性转换到Map中
	 * 
	 * <pre>
	 * 符合拷贝条件的属性必须满足以下几点:
	 * 		1.源JavaBean中具有get方法的属性
	 * </pre>
	 * 
	 * @param bean
	 *            源对象JavaBean
	 * @return 转换后的Map
	 * @throws Exception
	 */
	public static Map describe(Object bean)throws Exception{
		return org.apache.commons.beanutils.BeanUtils.describe(bean);
	}
	
}

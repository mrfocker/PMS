package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javassist.bytecode.Descriptor.Iterator;




/** 
 * <p>Title: testMap</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  gpan 
 * @date 创建时间：2017年6月28日 下午10:41:36 
 * @version 1.0 
*/

public class testMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Map<String, ArrayList<String>> nm = new HashMap<String,ArrayList<String>>();
//		nm.put("网络技术","10001");
//		nm.put("网络安全","10021");
//		nm.put("机器学习","10031");
//		
//		Set<String> set = nm.keySet();
//		for(String key:set){
//			String value = nm.get(key);
//			System.out.println(key+"---"+value);
//		}
		System.out.println("run");
		teacherTest t1 = new teacherTest("001","张三","网络安全","网络技术","人工智能");
		teacherTest t2 = new teacherTest("002","李四","网络空间","网络技术","机器学习");
		teacherTest t3 = new teacherTest("003","王五","网络技术","大数据","机器学习");
		teacherTest t4 = new teacherTest("004","赵二","网络安全","网络技术","云计算");
		
		ArrayList<teacherTest> strList = new ArrayList<teacherTest>();
		
		strList.add(t1);
		strList.add(t2);
		strList.add(t3);
		strList.add(t4);
		
		Map<String, ArrayList<teacherTest>> map = new HashMap<String,ArrayList<teacherTest>>();
		
		Set<String> keys = map.keySet();
	
		java.util.Iterator<String> iterator = keys.iterator();
		
		while(iterator.hasNext()){
			String key = iterator.next();
			ArrayList arrayList = map.get(key);
			for(Object o:arrayList){
				System.out.println(o);
			}
		}
			
			
	
	}

}


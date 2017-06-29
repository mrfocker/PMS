package cn.pms.ssm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.swing.internal.plaf.metal.resources.metal;

import cn.pms.ssm.po.Teacher;
import cn.pms.ssm.po.TeacherVo;
import cn.pms.ssm.service.impl.TeacherInfoService;
import test.teacherTest;

/** 
 * <p>Title: TeacherInfoController</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  gpan 
 * @date 创建时间：2017年6月28日 下午6:59:13 
 * @version 1.0 
*/
@Controller
public class TeacherInfoController {
	
	@Autowired
	private  TeacherInfoService teacherInfoService;
	
	@RequestMapping("/teacherInfo")
	public ModelAndView teacherInfo() throws Exception{
		
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("controller run");
		List<TeacherVo> list = new ArrayList<TeacherVo>(); 
		list.addAll(teacherInfoService.selectTeacherInfo());
		//测试读取
		List<Map> listmap = new ArrayList<>();
		
		for(int i=0;i<list.size();i++){
			Map map1 = new HashMap<>();
			Map map2= new HashMap<>();
			Map map3 = new HashMap<>();
			map1.put(list.get(i).getTeacher_researchOne(), list.get(i));
			map2.put(list.get(i).getTeacher_researchTwo(), list.get(i));
			map3.put(list.get(i).getTeacher_researchThree(), list.get(i));
			listmap.add(map1);
			listmap.add(map2);
			listmap.add(map3);
		}
		
		Map m = mapCombine(listmap);
		String key = "网络安全";
		TeacherVo teacher =findTeacher(m,key);
		
		System.err.println(key+"=="+teacher.getTeacher_id()+"--"+teacher.getTeacher_name());
		
		modelAndView.setViewName("test");
		return modelAndView;	
	}
	
	//遍历listmap去重
	public static Map mapCombine(List<Map> list) {
		Map<Object, List> map = new HashMap<>();  
        for (Map m : list) {  
            Iterator<Object> it = m.keySet().iterator();  
            while (it.hasNext()) {  
                Object key = it.next();  
                if (!map.containsKey(key)) {  
                    List newList = new ArrayList<>();  
                    newList.add(m.get(key));  
                    map.put(key, newList);  
                } else {  
                    map.get(key).add(m.get(key));  
                }  
            }  
        }
        return map;  
	}  
	//在m中查询满足key方向条件的导师
	public  TeacherVo findTeacher(Map m, String key) {
		List<TeacherVo>  list2 = new ArrayList<>();
		list2 = (List<TeacherVo>) m.get(key);
		
		for(int i=0;i<list2.size();i++){
			TeacherVo teacher=new TeacherVo();
			teacher = list2.get(i);
			if(teacher.getTeacher_count()<teacher.getTeacher_limit()){	
				teacherInfoService.incTeachercCount( teacher.getTeacher_id());
				return teacher;
			}
		}
		return null;
	}
}


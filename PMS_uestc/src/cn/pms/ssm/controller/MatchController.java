package cn.pms.ssm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.pms.ssm.po.PaperVo;
import cn.pms.ssm.po.TeacherVo;
import cn.pms.ssm.service.impl.GetStuPaperService;
import cn.pms.ssm.service.impl.TeacherInfoService;

/** 
 * <p>Title: MatchController</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  gpan 
 * @date 创建时间：2017年6月29日 下午8:22:40 
 * @version 1.0 
*/
@Controller
public class MatchController {

	@Autowired
	private  TeacherInfoService teacherInfoService;
	@Autowired
	private  GetStuPaperService getStuPaperService;
	
	@RequestMapping("/testMatch")
	public ModelAndView math()throws Exception{
		
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("run controller");
		//遍历TeacherVos的listmap去重
		Map map=mapCombine(geTeacherVos());

		List<PaperVo> list =new ArrayList<>() ;
		list = gePaperVos();
		for(int i=0;i<list.size();i++){
			PaperVo pVo=list.get(i);
			List<TeacherVo> list_teacherVo = findTeacher(map, pVo);
			System.out.println(pVo.getPaper_stuId()+"=="+pVo.getPaper_title()+
					"===盲审导师1=="+list_teacherVo.get(0).getTeacher_name()+
					"===盲审导师2=="+list_teacherVo.get(1).getTeacher_name());
		}
		
		modelAndView.setViewName("tables");
		return modelAndView;		
	}
	/*
	 * 从Teacher表中得到TeacherInfo
	 */
	public List<Map> geTeacherVos(){
		
		List<TeacherVo> list = new ArrayList<TeacherVo>(); 
		list.addAll(teacherInfoService.selectTeacherInfo());
		//测试读取
		List<Map> listmap = new ArrayList<>();
		
		for(int i=0;i<list.size();i++){
			Map map = new HashMap<>();
			map.put(list.get(i).getTeacher_researchOne(), list.get(i));
			listmap.add(map);
			map.put(list.get(i).getTeacher_researchTwo(), list.get(i));
			listmap.add(map);
			map.put(list.get(i).getTeacher_researchThree(), list.get(i));
			listmap.add(map);
		}
		return listmap;	
	}

	/*
	 * 从paperVO中得到paperinfo
	 */
	public List<PaperVo> gePaperVos(){
		System.out.println("test getPaper");
		List<PaperVo> list = new ArrayList<PaperVo>(); 
		list.addAll(getStuPaperService.selectPaperInfo());
		return list;	
	}
	
	
	/*
	 *遍历TeacherVos的listmap去重
	 */

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
		public  List<TeacherVo> findTeacher(Map m, PaperVo pVo) {
			List<TeacherVo> list = new ArrayList<>();
			
			List<TeacherVo>  listT1 = new ArrayList<>();
			List<TeacherVo>  listT2 = new ArrayList<>();
			TeacherVo teacher=new TeacherVo();
			TeacherVo FirstT = new TeacherVo();
			
			listT1 = (List<TeacherVo>) m.get(pVo.getPaper_researchOne());
			
			listT2 = (List<TeacherVo>) m.get(pVo.getPaper_researchTwo());
			
			for(int i=0;i<listT1.size();i++){
				
				teacher = listT1.get(i);
				if((teacher.getTeacher_count()<teacher.getTeacher_limit())
						&&(teacher.getTeacher_id()!=pVo.getStu_teacherId())){	
					teacherInfoService.incTeachercCount(teacher.getTeacher_id());
				     list.add(teacher);
				     FirstT = teacher;
				     break;
				}
			}
			for(int i=0;i<listT2.size();i++){
				teacher = listT2.get(i);
				if((teacher.getTeacher_count() < teacher.getTeacher_limit())&&(teacher!=FirstT)
						&&(teacher.getTeacher_id()!=pVo.getStu_teacherId())){	
					teacherInfoService.incTeachercCount( teacher.getTeacher_id());
				     list.add(teacher);
				     break;
				}
			}
			return list;
		}	
	
}


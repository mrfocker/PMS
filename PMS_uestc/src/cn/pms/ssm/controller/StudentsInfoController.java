package cn.pms.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.pms.ssm.po.Student;
import cn.pms.ssm.po.StudentPaperInfoVo;
import cn.pms.ssm.service.StudentPaperInfoService;

/** 
 * <p>Title: </p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author:  liuxiang 
 * @date:2017年8月12日
 * @version 1.0 
*/

@Controller
@RequestMapping("/pages")
public class StudentsInfoController {
	
	@Autowired
	StudentPaperInfoService studentPaperInfoService;
	
	@RequestMapping("/studentinfo")
	public @ResponseBody ModelAndView find_studentinfo(StudentPaperInfoVo studentPaperInfoVo) throws Exception{
		
		List<StudentPaperInfoVo> studentPaperInfoVo1 = studentPaperInfoService.do_findStudentPaperInfo(studentPaperInfoVo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("studentPaperInfoList",studentPaperInfoVo1);
		modelAndView.setViewName("/students");
		System.out.println(modelAndView);
		return modelAndView;
		
	}
	
	@RequestMapping("/getPaperAllInfo")
	public @ResponseBody StudentPaperInfoVo getPaperAllInfo(@RequestBody StudentPaperInfoVo studentPaperInfoVo) throws Exception{
		
		//studentPaperInfoVo.setStu_id("201522220299");
		System.out.println(studentPaperInfoVo.getStu_id());
		StudentPaperInfoVo studentPapperInfoVoList = new StudentPaperInfoVo();
		studentPapperInfoVoList = studentPaperInfoService.do_getStudentPaperInfo(studentPaperInfoVo);
		return studentPapperInfoVoList;
	
	}
	
	@RequestMapping("/requeryPaperInfo")
	public @ResponseBody StudentPaperInfoVo requeryPaperInfo(@RequestBody StudentPaperInfoVo studentPaperInfoVo) throws Exception{
		
		System.out.println(studentPaperInfoVo.getStu_id());
		StudentPaperInfoVo studentPapperInfoVoList = new StudentPaperInfoVo();
		//之前的步骤的数据清空
		studentPapperInfoVoList = studentPaperInfoService.do_getStudentPaperInfo(studentPaperInfoVo);
		return studentPapperInfoVoList;
	}

}

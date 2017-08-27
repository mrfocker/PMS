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
import cn.pms.ssm.service.PaperService;
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
		//关闭老师评审状态位
		studentPaperInfoService.do_updateIfSubmit(studentPaperInfoVo);         
		StudentPaperInfoVo studentPapperInfoVoList = new StudentPaperInfoVo();
		studentPapperInfoVoList = studentPaperInfoService.do_getStudentPaperInfo(studentPaperInfoVo);
		return studentPapperInfoVoList;
	}

	//映射到学生论文模态框，导师的评价
	@RequestMapping("/queryTeacherDepartAdvise")
	public @ResponseBody StudentPaperInfoVo queryTeacherAdvise(@RequestBody StudentPaperInfoVo studentPaperInfoVo) throws Exception{
		
		StudentPaperInfoVo teacheradvise = new StudentPaperInfoVo();
		teacheradvise = studentPaperInfoService.do_queryTeacherDepartAdvise(studentPaperInfoVo);
		return teacheradvise;
		
	}
	
	//映射到学生论文模态框，盲审的评价
	@RequestMapping("/queryBlindJudgeAdvise")
	public @ResponseBody StudentPaperInfoVo queryBlindJudgeAdvise(@RequestBody StudentPaperInfoVo studentPaperInfoVo) throws Exception{
			
		StudentPaperInfoVo blindjudgeadvise = new StudentPaperInfoVo();
		blindjudgeadvise = studentPaperInfoService.do_queryBlindJudgeAdvise(studentPaperInfoVo);
		return blindjudgeadvise;
			
		}
	
	@RequestMapping("/queryReplyAdvise")
	public @ResponseBody StudentPaperInfoVo queryReplyJudgeAdvise(@RequestBody StudentPaperInfoVo studentPaperInfoVo) throws Exception{
			
		StudentPaperInfoVo replyadvise = new StudentPaperInfoVo();
		replyadvise = studentPaperInfoService.do_queryReplyJudgeAdvise(studentPaperInfoVo);
		return replyadvise;
			
		}
	
	@RequestMapping("/onejumptwo")
	public @ResponseBody StudentPaperInfoVo onejumptwo(@RequestBody StudentPaperInfoVo studentPaperInfoVo) throws Exception{
		
		StudentPaperInfoVo onejumptwoList = new StudentPaperInfoVo();
		studentPaperInfoService.do_updatSubmit_Pass(studentPaperInfoVo);
		onejumptwoList = studentPaperInfoService.do_getStudentPaperInfo(studentPaperInfoVo);
		return onejumptwoList;
		
	}
	
}

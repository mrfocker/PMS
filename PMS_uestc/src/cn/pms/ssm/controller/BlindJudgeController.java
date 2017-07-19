package cn.pms.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.pms.ssm.po.BlindJudgeGroupVo;
import cn.pms.ssm.po.PaperInfoExtend;
import cn.pms.ssm.po.PaperQueryVo;
import cn.pms.ssm.po.TeacherQueryVo;
import cn.pms.ssm.service.BlindJudgeGroupService;

/** 
 * <p>Title: </p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author:  liuxiang 
 * @date:2017年7月17日
 * @version 1.0 
*/

@Controller
@RequestMapping("/pages")
public class BlindJudgeController {
	
	@Autowired
	private BlindJudgeGroupService blindJudgeGroupService;
	
	@RequestMapping("/submitblindjudge")
	public void submit_BlindResult (BlindJudgeGroupVo blindJudgeGroupVo) throws Exception{
		
		blindJudgeGroupService.submitBlindJudge(blindJudgeGroupVo);
	}
	
	@RequestMapping("/blindjudge")
	public @ResponseBody ModelAndView teacherBlindJudge (BlindJudgeGroupVo blindJudgeGroup) throws Exception{
		
		List<BlindJudgeGroupVo> blindJudgelist = blindJudgeGroupService.do_findBlindJudgePaper(blindJudgeGroup);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("blindJudgelist",blindJudgelist);
		modelAndView.setViewName("/teacher_blind_tables");
		System.out.println(modelAndView);
		return modelAndView;
		
	}
	
	
}

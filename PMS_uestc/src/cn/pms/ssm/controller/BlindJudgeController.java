package cn.pms.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	public @ResponseBody void submit_BlindResult (@RequestBody BlindJudgeGroupVo blindJudgeGroupVo) throws Exception{
		
		if(blindJudgeGroupVo.getResult_code() == 0){
			blindJudgeGroupVo.setTeacher_Result(null);
		}
		else if(blindJudgeGroupVo.getResult_code() == 1){
			blindJudgeGroupVo.setTeacher_Result("同意答辩");
		}
		else if(blindJudgeGroupVo.getResult_code() == 2){
			blindJudgeGroupVo.setTeacher_Result("修改后答辩");
			//将submit置0
			blindJudgeGroupService.do_updatesubmit_0(blindJudgeGroupVo);
		}
		else if(blindJudgeGroupVo.getResult_code() == 3){
			blindJudgeGroupVo.setTeacher_Result("修改后重审");
		}
		else if(blindJudgeGroupVo.getResult_code() == 4){
			blindJudgeGroupVo.setTeacher_Result("不同意答辩");
		}
		System.out.println(blindJudgeGroupVo.getResult_code());
		blindJudgeGroupService.do_updateAdvise_1(blindJudgeGroupVo);
		blindJudgeGroupService.do_updateBlindJudge(blindJudgeGroupVo);
	}
	
	@RequestMapping("/blindjudge")
	public @ResponseBody ModelAndView teacherBlindJudge (BlindJudgeGroupVo blindJudgeGroupVo) throws Exception{
		
		List<BlindJudgeGroupVo> blindJudgelist = blindJudgeGroupService.do_findBlindJudgePaper(blindJudgeGroupVo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("blindJudgelist",blindJudgelist);
		modelAndView.setViewName("blindjudgeIndex");
		System.out.println(modelAndView);
		return modelAndView;
		
	}
	
	@RequestMapping("/bingjudgeResult")
	public @ResponseBody BlindJudgeGroupVo show_blindjudgeResult(@RequestBody BlindJudgeGroupVo blindJudgeGroupVo) throws Exception{
		
		BlindJudgeGroupVo blindJudgeGroupVo1 = new BlindJudgeGroupVo();
		blindJudgeGroupVo1 = blindJudgeGroupService.do_findBlindResult(blindJudgeGroupVo);

		    if(blindJudgeGroupVo1.getTeacher_Result() == null || blindJudgeGroupVo1.getTeacher_Result().equals("")){
				blindJudgeGroupVo1.setResult_code(0);
			}
		    else if(blindJudgeGroupVo1.getTeacher_Result().equals("同意答辩")){
				blindJudgeGroupVo1.setResult_code(1);
			}
		    else if(blindJudgeGroupVo1.getTeacher_Result().equals("修改后答辩")){
				blindJudgeGroupVo1.setResult_code(2);
			}
		    else if(blindJudgeGroupVo1.getTeacher_Result().equals("修改后重审")){
				blindJudgeGroupVo1.setResult_code(3);
			}
		    else if(blindJudgeGroupVo1.getTeacher_Result().equals("不同意答辩")){
				blindJudgeGroupVo1.setResult_code(4);
			}
			System.out.println(blindJudgeGroupVo1.getResult_code());
		
		return blindJudgeGroupVo1;
	}
	
}

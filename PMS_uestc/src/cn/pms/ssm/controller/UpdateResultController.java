package cn.pms.ssm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.pms.ssm.po.Administrator;
import cn.pms.ssm.service.UpdateResultService;
import cn.pms.ssm.vo.BlindJudgeResultVo;
import cn.pms.ssm.vo.PaperPassJson;
import cn.pms.ssm.vo.ReplyResultVo;
import cn.pms.ssm.vo.StudentPaperVo;
import net.sf.json.JSONObject;

/**
 * 管理员修改各阶段的成绩及处理结果的Controller
 * @author HeXi
 *
 */
@Controller
@RequestMapping("/admin")
public class UpdateResultController{
	
	@Autowired
	private UpdateResultService updateResultService;
	
	@RequestMapping(value = "/toUpdateResult")
	public ModelAndView toUpdateResult(HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView();
		
		Administrator admin = (Administrator) httpSession.getAttribute("current_user");
		modelAndView.addObject("admin",admin);

		List<StudentPaperVo> paperResult = updateResultService.selectAllPaperResult();
		modelAndView.addObject("paperResult",paperResult);
		
		List<BlindJudgeResultVo> blindReslut = updateResultService.selectAllBlindResult();
		modelAndView.addObject("blindReslut",blindReslut);	
		
		List<ReplyResultVo> replyReslut = updateResultService.selectAllReplyResult();
		modelAndView.addObject("replyReslut",replyReslut);
		
		modelAndView.setViewName("paperResult");
		return modelAndView;
	}

	@RequestMapping(value = "/UpdatePaperResult", method = RequestMethod.POST)
	public @ResponseBody void UpdatePaperResult(HttpSession httpSession,HttpServletResponse response,
			@RequestParam("stuId") String stuId,@RequestParam("paperIfPass") String paperIfPass) throws IOException{
		ModelAndView modelAndView = new ModelAndView();
		
		Administrator admin = (Administrator) httpSession.getAttribute("current_user");
		modelAndView.addObject("admin",admin);

		System.out.println(stuId);
		System.out.println(paperIfPass);
		
		updateResultService.updatePaperResult(stuId,paperIfPass);
		
		response.reset();
		PrintWriter out = response.getWriter();
		out.write("success");
		out.flush();
		out.close();
		//modelAndView.setViewName("redirectUpdateResult");
		//return modelAndView;
	}
	
	@RequestMapping(value = "/UpdateBlindResult", method = RequestMethod.POST)
	public @ResponseBody void UpdateBlindResult(HttpSession httpSession,HttpServletResponse response,
			@RequestParam("stuId") String stuId,@RequestParam("teacherId") String teacherId,@RequestParam("teacherGrade") int teacherGrade) throws IOException{
		ModelAndView modelAndView = new ModelAndView();
		
		Administrator admin = (Administrator) httpSession.getAttribute("current_user");
		modelAndView.addObject("admin",admin);

		System.out.println(stuId);
		System.out.println(teacherGrade);
		
		updateResultService.updateBlindResult(stuId,teacherId,teacherGrade);
		
		response.reset();
		PrintWriter out = response.getWriter();
		out.write("success");
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/UpdateReplyResult", method = RequestMethod.POST)
	public @ResponseBody void UpdateReplyResult(HttpSession httpSession,HttpServletResponse response,
			@RequestParam("stuId") String stuId,@RequestParam("groupId") String groupId,@RequestParam("teacherId") String teacherId,@RequestParam("replyGrade") int replyGrade) throws IOException{
		ModelAndView modelAndView = new ModelAndView();
		
		Administrator admin = (Administrator) httpSession.getAttribute("current_user");
		modelAndView.addObject("admin",admin);

		System.out.println(stuId);
		System.out.println(groupId);
		System.out.println(teacherId);
		System.out.println(replyGrade);
		
		updateResultService.updateReplyResult(stuId,groupId,teacherId,replyGrade);
		
		response.reset();
		PrintWriter out = response.getWriter();
		out.write("success");
		out.flush();
		out.close();
	}

	@RequestMapping(value = "/UpdateDepartResult", method = RequestMethod.POST)
	public @ResponseBody PaperPassJson UpdateDepartResult(HttpSession httpSession,HttpServletResponse response,HttpServletRequest request,
			@RequestBody PaperPassJson[] paperPassJsons) throws IOException{
		ModelAndView modelAndView = new ModelAndView();
		
		Administrator admin = (Administrator) httpSession.getAttribute("current_user");
		modelAndView.addObject("admin",admin);
		
		System.out.println("接收json");
		for(PaperPassJson ppj:paperPassJsons){
			updateResultService.updateDepartPassResult(ppj.getStuId(),ppj.getPaperDepartPass());
			System.out.println("学号：" + ppj.getStuId() +",是否通过：" + ppj.getPaperDepartPass());
		}
		return new PaperPassJson();
	}
	
}

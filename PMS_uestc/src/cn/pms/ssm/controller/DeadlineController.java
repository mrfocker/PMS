package cn.pms.ssm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.pms.ssm.po.Administrator;
import cn.pms.ssm.service.DeadlineService;

/**
 * 控制最后期限的Controller
 * @author HeXi
 *
 */
@Controller
@RequestMapping("/admin")
public class DeadlineController {
	
	@Autowired
	private DeadlineService deadlineService;
	
	@RequestMapping(value = "/setDeadline")
	public @ResponseBody ModelAndView setDeadline(HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView();
		
		Administrator admin = (Administrator) httpSession.getAttribute("current_user");
		modelAndView.addObject("admin",admin);
		
		String paperPassDeadline = deadlineService.getPaperPassDeadline();
		modelAndView.addObject("paperPassDeadline",paperPassDeadline);
		String blindJudgeDeadline = deadlineService.getBlindJudgeDeadline();
		modelAndView.addObject("blindJudgeDeadline",blindJudgeDeadline);
		String replyDeadline = deadlineService.getReplyDeadline();
		modelAndView.addObject("replyDeadline",replyDeadline);
		
    	modelAndView.setViewName("DeadlineSetting");
    	return modelAndView;
	}
	
	@RequestMapping(value = "/updateDeadline")
	public @ResponseBody ModelAndView updateDeadline(HttpSession httpSession,
			@RequestParam("paperPassDeadline") String paperDeadline,@RequestParam("blindJudgeDeadline") String blindJudgeDeadline,@RequestParam("replyDeadline") String replyDeadline) 
					throws ParseException{
		ModelAndView modelAndView = new ModelAndView();
		
		Administrator admin = (Administrator) httpSession.getAttribute("current_user");
		modelAndView.addObject("admin",admin);
		
		//将日期输入的String格式转换为Date格式
		System.out.println(paperDeadline);
		
		//导师审核deadline
		if(paperDeadline.indexOf("/") != -1){
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Date paperDate = sdf.parse(paperDeadline);
			deadlineService.updatePaperPassDeadline(paperDate);
		}
		
		
		//盲审成绩deadline
		if(blindJudgeDeadline.indexOf("/") != -1){
			SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
			Date blindDate = sdf1.parse(blindJudgeDeadline);
			deadlineService.updateBlindJudgeDeadline(blindDate);
		}
		
		//答辩成绩deadline
		if(replyDeadline.indexOf("/") != -1){		
			SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
			Date replyDate = sdf2.parse(replyDeadline);
			deadlineService.updateReplyDeadline(replyDate);
		}
		
		String paperPassDeadline = deadlineService.getPaperPassDeadline();
		modelAndView.addObject("paperPassDeadline",paperPassDeadline);
		String cblindJudgeDeadline = deadlineService.getBlindJudgeDeadline();
		modelAndView.addObject("blindJudgeDeadline",cblindJudgeDeadline);
		String creplyDeadline = deadlineService.getReplyDeadline();
		modelAndView.addObject("replyDeadline",creplyDeadline);
		
		modelAndView.setViewName("DeadlineSetting");
    	return modelAndView;
	}
}

package cn.pms.ssm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.pms.ssm.po.Administrator;
import cn.pms.ssm.po.Student;
import cn.pms.ssm.service.ReplyTimeService;
import cn.pms.ssm.vo.ReplyTimeVo;

/**
 * 答辩时间控制
 * @author HeXi
 *
 */
@Controller
@RequestMapping("/admin")
public class ReplyTimeController {
	
	@Autowired
	private ReplyTimeService replyTimeService;

	@RequestMapping(value = "/toRequestReplyTime")
	public ModelAndView toRequestReplyTime(HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView();
		
		Administrator admin = (Administrator) httpSession.getAttribute("current_user");
		modelAndView.addObject("admin",admin);

		List<Student> students = replyTimeService.selectRequestReplyTime();
		modelAndView.addObject("students",students);
		
		modelAndView.setViewName("requestReplyTime");
		return modelAndView;
	}
	
	@RequestMapping(value = "/UpdateRequestReplyTime")
	public void UpdateRequestReplyTime(HttpSession httpSession,HttpServletResponse response,
			@RequestParam("stuId") String stuId,@RequestParam("stuRequestReplyTime") String stuRequestReplyTime) throws IOException{
		ModelAndView modelAndView = new ModelAndView();
		
		Administrator admin = (Administrator) httpSession.getAttribute("current_user");
		modelAndView.addObject("admin",admin);

		replyTimeService.updateRequestReplyTime(stuId,stuRequestReplyTime);
		
		response.reset();
		PrintWriter out = response.getWriter();
		out.write("success");
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/toUpdateReplyTime")
	public ModelAndView toUpdateReplyTime(HttpSession httpSession) throws ParseException{
		ModelAndView modelAndView = new ModelAndView();
		
		Administrator admin = (Administrator) httpSession.getAttribute("current_user");
		modelAndView.addObject("admin",admin);

		List<ReplyTimeVo> stuReplyTime = replyTimeService.selectReplyTime();		
		modelAndView.addObject("stuReplyTime",stuReplyTime);
		
		modelAndView.setViewName("stuReplyTime");
		return modelAndView;
	}

	@RequestMapping(value = "/UpdateReplyTime")
	public void UpdateReplyTime(HttpSession httpSession,HttpServletResponse response,
			@RequestParam("stuId") String stuId,@RequestParam("stuReplyTime") String stuReplyTime) throws IOException, ParseException{
		ModelAndView modelAndView = new ModelAndView();
		
		Administrator admin = (Administrator) httpSession.getAttribute("current_user");
		modelAndView.addObject("admin",admin);
		
		System.out.println(stuReplyTime);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date stuReplyDate = sdf.parse(stuReplyTime);
		System.out.println(stuReplyDate);
		
		replyTimeService.updateReplyTime(stuId,stuReplyDate);
		
		response.reset();
		PrintWriter out = response.getWriter();
		out.write("success");
		out.flush();
		out.close();
	}

	@RequestMapping(value = "/setReplyTime")
	public ModelAndView setReplyTime(HttpSession httpSession) throws ParseException{
		ModelAndView modelAndView = new ModelAndView();
		
		Administrator admin = (Administrator) httpSession.getAttribute("current_user");
		modelAndView.addObject("admin",admin);
		
		modelAndView.setViewName("stuReplyTime");
		return modelAndView;
	}
	
	@RequestMapping(value = "/ReplyTimeSetting")
	public void ReplyTimeSetting(HttpSession httpSession,HttpServletResponse response,@RequestParam("replyTime") String replyTime) throws IOException, ParseException{
		ModelAndView modelAndView = new ModelAndView();
		
		Administrator admin = (Administrator) httpSession.getAttribute("current_user");
		modelAndView.addObject("admin",admin);
		
		System.out.println(replyTime);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date replyDate = sdf.parse(replyTime);
		System.out.println(replyDate);
		
		replyTimeService.updateAllReplyTime(replyDate);
		
		response.reset();
		PrintWriter out = response.getWriter();
		out.write("success");
		out.flush();
		out.close();
	}

}

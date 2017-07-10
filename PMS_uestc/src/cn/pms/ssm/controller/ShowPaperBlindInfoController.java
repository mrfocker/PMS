package cn.pms.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebParam.Mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import cn.pms.ssm.po.PaperVo;
import cn.pms.ssm.po.TeacherVo;
import cn.pms.ssm.service.impl.GetPaperMatchService;
import cn.pms.ssm.service.impl.GetPaperService;

/** 
 * <p>Title: ShowPaperBlindInfoController</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  gpan 
 * @date 创建时间：2017年7月4日 下午8:05:56 
 * @version 1.0 
*/
@Controller
@RequestMapping("pages")
public class ShowPaperBlindInfoController {

	@Autowired
	private GetPaperService getPaperService;
	@Autowired
	private GetPaperMatchService getPaperMatchService;
	
	
	//查看当前paper表中提交论文
	@RequestMapping("showBlindInfo")
	public ModelAndView showPaperBlindInfo()throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		List<PaperVo> list =gePaperVos();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("/tables");
		return modelAndView;
	}
	
	/*
	 * 从paperVO中得到paperinfo
	 */
	public List<PaperVo> gePaperVos(){
		System.out.println("test getPaper");
		List<PaperVo> list = new ArrayList<PaperVo>(); 
		list.addAll(getPaperService.selectPaperInfo());
		return list;	
	}
	
	//点击是，进行盲审分配
	@RequestMapping(value="/distribute",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView distribute(Model model,@RequestParam(value="id",required = true) String Paper_stuId) throws Exception{
		
		List<TeacherVo> list=new ArrayList<>();
		list.addAll(getPaperMatchService.matchPaper(Paper_stuId));
		if(list.isEmpty()){
			System.out.println("匹配为空");
			
		}
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("/distribute");
		return modelAndView;
				
		
	}
	
	
}


package cn.pms.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.pms.ssm.po.Paper;
import cn.pms.ssm.po.PaperInfoExtend;
import cn.pms.ssm.po.PaperQueryVo;
import cn.pms.ssm.service.PaperService;

import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

/** 
 * <p>Title: </p> 
 * <p>Description:注解的Handler </p> 
 * <p>Company: uestc_xr</p> 
 * @author:  liuxiang 
 * @date:2017年6月24日
 * @version 1.0 
*/

@Controller
@RequestMapping("/pages")
public class PaperInfoController {
	
	@Autowired
	private PaperService paperService;
	
	//查询列表
	@RequestMapping("/queryPaperInfo")
	public ModelAndView queryPaper()throws Exception{
		/*//返回ModelAndView
		ModelAndView modelAndView =  new ModelAndView();
		//相当 于request的setAttribut，在jsp页面中通过itemsList取数据
		//modelAndView.addObject("itemsList", itemsList);
		
		//指定视图
		modelAndView.setViewName("tables");

		return modelAndView;*/
		
		//List<PaperInfoExtend> paperlist;// = paperService.findpaperlist(null);
		List<Paper> paperlist = new ArrayList<Paper>();
		Paper paper = new Paper();
		paper.setPaper_title("hajh");
		paperlist.add(paper);
		System.out.println("ok23");
		System.out.println(paperlist);
	/*	for(int i = 0; i < paperlist.size();i++)
		{System.out.println(paperlist.get(i));}*/
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("paperlist",paperlist);
		modelAndView.setViewName("/tables");
		return modelAndView;
		//return new ModelAndView("tables");
	}

}

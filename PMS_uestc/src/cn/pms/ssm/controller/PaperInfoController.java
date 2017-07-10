package cn.pms.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	//后台数据转化成Json
	@RequestMapping("/requestJson")
	public @ResponseBody List<PaperInfoExtend> requestJson(List<PaperInfoExtend> paperlist){
		
		
		try {
			paperlist = paperService.findpaperlist(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(paperlist);
		return paperlist;
		
	}
	
	//查询列表
	@RequestMapping("/queryPaperInfo")
	public @ResponseBody ModelAndView queryPaper(HttpServletRequest request, PaperQueryVo paperQueryVo)throws Exception{
		/*//返回ModelAndView
		ModelAndView modelAndView =  new ModelAndView();
		//相当 于request的setAttribut，在jsp页面中通过itemsList取数据
		//modelAndView.addObject("itemsList", itemsList);
		
		//指定视图
		modelAndView.setViewName("tables");

		return modelAndView;*/
		
		List<PaperInfoExtend> paperlist = paperService.findpaperlist(paperQueryVo);
		System.out.println("ok11283");
		System.out .println(paperlist);
		//测试数据
		/*List<PaperInfoExtend> pa = paperService.findpaperlist(null);
		PaperInfoExtend Pa1 = null;
	
		for(int i = 0; i < pa.size();i++)
		{
			Pa1 = pa.get(i);
			System.out.println(Pa1.getPaper_title());
			}*/
		
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("paperlist",paperlist);
		modelAndView.setViewName("/tables");
		System.out.println(modelAndView);
		return modelAndView;
		//return new ModelAndView("tables");
	}

}

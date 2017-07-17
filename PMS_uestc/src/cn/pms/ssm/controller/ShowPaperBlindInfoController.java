package cn.pms.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.swing.internal.plaf.basic.resources.basic;

import cn.pms.ssm.po.Matchchoose;
import cn.pms.ssm.po.PaperVo;
import cn.pms.ssm.po.TeacherVo;
import cn.pms.ssm.service.impl.BlindJudgeService;
import cn.pms.ssm.service.impl.GetPaperMatchService;
import cn.pms.ssm.service.impl.GetPaperService;
import cn.pms.ssm.service.impl.TeacherInfoService;

/** 
 * <p>Title: ShowPaperBlindInfoController</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  gpan 
 * @date 创建时间：2017年7月4日 下午8:05:56 
 * @version 1.0 
*/
@Controller
public class ShowPaperBlindInfoController {

	@Autowired
	private GetPaperService getPaperService;
	@Autowired
	private GetPaperMatchService getPaperMatchService;
	@Autowired
	private TeacherInfoService teacherInfoService;
	@Autowired
	private BlindJudgeService blindJudgeService;
	
	//查看当前paper表中提交论文
	@RequestMapping("pages/showBlindInfo")
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
		List<PaperVo> list = new ArrayList<PaperVo>(); 
		list.addAll(getPaperService.selectPaperInfo());
		
		for(int i=0;i<list.size();i++){
			String str=list.get(i).getJudge_teacherIdOne();
			if(str!=null && str!=""){
				String[] sourceStr=str.split(",");
				list.get(i).setJudge_teacherIdOne(sourceStr[0]);
			    list.get(i).setJudge_teacherIdTwo(sourceStr[1]);
			}
		}
		return list;	
	}
	
	/*
	 * 点击分配，进行盲审分配
	 * test distribute by json
	 */
	@RequestMapping(value="pages/Testdistribute",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody List<TeacherVo> testdistri(@RequestBody String paper_stuId){
		List<TeacherVo> list=new ArrayList<>();
		list.addAll(getPaperMatchService.matchPaper(paper_stuId));
		for(int i=0;i<list.size();i++){
			list.get(i).setPaper_stuId(paper_stuId);
		}
		if(list.size()<=2){
//			System.out.println("匹配不足3");
			list.removeAll(list);
			list.addAll(getPaperMatchService.randomMatchPaper(paper_stuId));//如果小于3,则随机匹配
			for(int i=0;i<list.size();i++){
				list.get(i).setPaper_stuId(paper_stuId);
			}
		}
		return list;	
	}
	
	/*
	 * 返回选择的数据并写入数据库
	 */
	@RequestMapping(value="pages/getchoose",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
		public @ResponseBody String  getchoose(@RequestBody List<Matchchoose> matchchoose){
		for(int i=0;i<matchchoose.size();i++){
			teacherInfoService.incTeachercCount(matchchoose.get(i).getChoose_teaId());
			blindJudgeService.writematchBlindJudgeInfo(matchchoose.get(i));
		}
		String  mString="写入成功";
		return mString;
		
	}
	
	
}


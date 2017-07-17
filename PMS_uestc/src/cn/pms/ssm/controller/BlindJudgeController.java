package cn.pms.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.pms.ssm.po.PaperInfoExtend;
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
	
	@RequestMapping("/blindjudge")
	public void requestJson(){
		
	}
	
	
}

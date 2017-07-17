package cn.pms.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.pms.ssm.po.PaperVo;

/** 
 * <p>Title: JsonTestController</p> 
 * <p>Description:json交互测试 </p> 
 * <p>Company: uestc_xr</p> 
 * @author  gpan 
 * @date 创建时间：2017年7月7日 下午3:23:10 
 * @version 1.0 
*/
@Controller
@RequestMapping("pages")

public class JsonTestController {
	
	//请求json,输出相应json
	@RequestMapping("/requestJson")
	public @ResponseBody PaperVo requestJson(@RequestBody PaperVo paperVo){
		System.out.println(paperVo);
		return paperVo;
	}
}


package cn.pms.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TileTestController {
    @RequestMapping(value = "/tile")
    public String testView() { 
    	System.out.println("执行了");
    	return "adminIndex"; //这里的login为tiles-definitions.xml中配置的视图名称
    }

}

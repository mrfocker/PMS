package cn.pms.ssm.service;

import java.util.List;

import cn.pms.ssm.po.Teacher;

/** 
 * <p>Title: </p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author:  liuxiang 
 * @date:2017年7月18日
 * @version 1.0 
*/
public interface ShowTeacherInfoService {
	
	//导师登录后在页面现实自己的信息
	public List<Teacher> do_getTeacherInfo(Teacher teacher) throws Exception;

}

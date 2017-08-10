package cn.pms.ssm.service;

import java.util.List;

import cn.pms.ssm.po.TeacherQueryVo;

/** 
 * <p>Title: TeacherQueryService</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  liuxiang 
 * @date 创建时间：2017年7月12日 上午10:51:13 
 * @version 1.0 
*/

public interface TeacherQueryService {
	
	//导师查询自己学生的论文信息
	public List<TeacherQueryVo> do_findMyStuInfo(TeacherQueryVo teacherQueryVo) throws Exception;
   //导师提交对自己学生论文的修改意见
	public void do_updateTeacherAdvise(TeacherQueryVo teacherQueryVo) throws Exception;
}

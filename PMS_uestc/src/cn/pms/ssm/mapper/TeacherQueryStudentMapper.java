package cn.pms.ssm.mapper;

import java.util.List;

import cn.pms.ssm.po.PaperInfoExtend;
import cn.pms.ssm.po.PaperQueryVo;
import cn.pms.ssm.po.TeacherQueryVo;

/** 
 * <p>Title: </p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author:  liuxiang 
 * @date:2017年7月11日
 * @version 1.0 
*/
public interface TeacherQueryStudentMapper {
	
	//教师查询自己学生的论文的信息
	public List<TeacherQueryVo> findMyStuInfo(TeacherQueryVo teacherQueryVo) throws Exception;

}

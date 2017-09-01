package cn.pms.ssm.mapper;

import java.util.List;

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
	//教授查询自己学生论文评审的信息(模态框)
	public TeacherQueryVo findTeacherAdvise(TeacherQueryVo teacherQueryVo) throws Exception;
	//教师提交对自己学生审核的结果
	public void updateTeacherAdvise(TeacherQueryVo teacherQueryVo) throws Exception;
	//导师提交评审后advise置1
	public void updateAdvise_1(TeacherQueryVo teacherQueryVo) throws Exception;

}

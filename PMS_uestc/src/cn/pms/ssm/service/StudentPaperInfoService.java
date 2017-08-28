package cn.pms.ssm.service;

import java.util.List;

import cn.pms.ssm.po.StudentPaperInfoVo;

/** 
 * <p>Title: </p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author:  liuxiang 
 * @date:2017年8月13日
 * @version 1.0 
*/
public interface StudentPaperInfoService {
	
	//学术查询论文基本信息（提交论文页面）
	public List<StudentPaperInfoVo> do_findStudentPaperInfo(StudentPaperInfoVo studentPaperInfoVo) throws Exception;
	//获取论文信息（JS判断）
	public StudentPaperInfoVo do_getStudentPaperInfo(StudentPaperInfoVo studentPaperInfoVo) throws Exception;
	//更新学生可提交状态位(置0)
	public void do_updateIfSubmit(StudentPaperInfoVo studentPaperInfoVo) throws Exception;
	//更新学生可提交状态位（置1）
	public void do_updatSubmit_Pass(StudentPaperInfoVo studentPaperInfoVo) throws Exception;
	//更新学导师可评价状态位（置1）
	public void do_updateAdvise_Pass(StudentPaperInfoVo studentPaperInfoVo) throws Exception;
	//导师审核阶段修改建议查询
	public StudentPaperInfoVo do_queryTeacherDepartAdvise(StudentPaperInfoVo studentPaperInfoVo) throws Exception;
	//盲审核阶段修改建议查询
	public StudentPaperInfoVo do_queryBlindJudgeAdvise(StudentPaperInfoVo studentPaperInfoVo) throws Exception;
	//答辩核阶段修改建议查询
	public StudentPaperInfoVo do_queryReplyJudgeAdvise(StudentPaperInfoVo studentPaperInfoVo) throws Exception;
}

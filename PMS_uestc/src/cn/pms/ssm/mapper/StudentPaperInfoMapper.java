package cn.pms.ssm.mapper;

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
public interface StudentPaperInfoMapper {
        
	//学生论文基本信息（上传页面）
	public List<StudentPaperInfoVo> findStudentPaperInfo(StudentPaperInfoVo studentPaperInfoVo) throws Exception;
	//查询论文信息（JS判断）
	//public StudentPaperInfoVo getStudentPaperInfo(StudentPaperInfoVo studentPaperInfoVo) throws Exception;
	public StudentPaperInfoVo getPaperInfo(StudentPaperInfoVo studentPaperInfoVo) throws Exception;
	public StudentPaperInfoVo getFileInfo(StudentPaperInfoVo studentPaperInfoVo) throws Exception;
	public StudentPaperInfoVo getBlindJudgeInfo(StudentPaperInfoVo studentPaperInfoVo) throws Exception;
	public StudentPaperInfoVo getReplyJudgeInfo(StudentPaperInfoVo studentPaperInfoVo) throws Exception;
	public StudentPaperInfoVo getGradeListInfo(StudentPaperInfoVo studentPaperInfoVo) throws Exception;
	public StudentPaperInfoVo getStuInfo(StudentPaperInfoVo studentPaperInfoVo) throws Exception;
}

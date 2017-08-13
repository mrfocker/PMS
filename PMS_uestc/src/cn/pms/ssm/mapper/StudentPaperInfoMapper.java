package cn.pms.ssm.mapper;

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
	public StudentPaperInfoVo findStudentPaperInfo(StudentPaperInfoVo studentPaperInfoVo) throws Exception;
}

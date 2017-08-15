package cn.pms.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.pms.ssm.mapper.StudentPaperInfoMapper;
import cn.pms.ssm.po.StudentPaperInfoVo;
import cn.pms.ssm.service.StudentPaperInfoService;

/** 
 * <p>Title: </p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author:  liuxiang 
 * @date:2017年8月13日
 * @version 1.0 
*/
public class StudentPaperInfoServiceImpl implements StudentPaperInfoService {
	
	@Autowired
	private StudentPaperInfoMapper studentPaperInfoMapper;

	@Override
	public List<StudentPaperInfoVo> do_findStudentPaperInfo(
			StudentPaperInfoVo studentPaperInfoVo) throws Exception {
			
			return studentPaperInfoMapper.findStudentPaperInfo(studentPaperInfoVo);
	}

	@Override
	public StudentPaperInfoVo do_getStudentPaperInfo(
			StudentPaperInfoVo studentPaperInfoVo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

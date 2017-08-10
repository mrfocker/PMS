package cn.pms.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import cn.pms.ssm.mapper.PaperInfoExtendMapper;
import cn.pms.ssm.mapper.TeacherQueryStudentMapper;
import cn.pms.ssm.po.TeacherQueryVo;
import cn.pms.ssm.service.TeacherQueryService;

/** 
 * <p>Title: TeacherQueryServiceImpl</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  liuxiang 
 * @date 创建时间：2017年7月12日 下午5:09:37 
 * @version 1.0 
*/

public class TeacherQueryServiceImpl implements TeacherQueryService{
	
	@Autowired
	private TeacherQueryStudentMapper teacherQueryStudentMapper;

	@Override
	public List<TeacherQueryVo> do_findMyStuInfo(TeacherQueryVo teacherQueryVo) throws Exception {

		return teacherQueryStudentMapper.findMyStuInfo(teacherQueryVo);
	}
	
	@Override
	public void do_updateTeacherAdvise(TeacherQueryVo teacherQueryVo) throws Exception{
		
		teacherQueryStudentMapper.updateTeacherAdvise(teacherQueryVo);
	}

	@Override
	public TeacherQueryVo do_findTeacherAdvise(TeacherQueryVo teacherQueryvo) throws Exception {
		
		return teacherQueryStudentMapper.findTeacherAdvise(teacherQueryvo);
	}

}

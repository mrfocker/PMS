package cn.pms.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pms.ssm.mapper.TeacherInfoMapper;

/** 
 * <p>Title: TeacherInfoServiceImpl</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  gpan 
 * @date 创建时间：2017年6月28日 下午6:55:09 
 * @version 1.0 
*/
@Service("TeacherInfoService")
public class TeacherInfoServiceImpl implements TeacherInfoService{

	@Autowired
	private TeacherInfoMapper teacherInfoMapper;
	
	@Override
	public String selectTeacherRearch(String tea_id) {
		// TODO Auto-generated method stub
		return teacherInfoMapper.selectTeacherRearch(tea_id);
	}

	
}


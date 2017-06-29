package cn.pms.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pms.ssm.mapper.TeacherInfoMapper;
import cn.pms.ssm.po.Teacher;
import cn.pms.ssm.po.TeacherVo;

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
	public List<TeacherVo> selectTeacherInfo() {
		// TODO Auto-generated method stub
		return teacherInfoMapper.selectTeacherInfo();
	}
	
	public void incTeachercCount(String tea_Id){
			teacherInfoMapper.incTeachercCount(tea_Id);
		return ;
	}

	
}


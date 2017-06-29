package cn.pms.ssm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.pms.ssm.po.Teacher;
import cn.pms.ssm.po.TeacherVo;

/** 
 * <p>Title: TeacherInfoService</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  gpan 
 * @date 创建时间：2017年6月28日 下午6:32:37 
 * @version 1.0 
*/
@Service
public interface TeacherInfoService {
	public List<TeacherVo> selectTeacherInfo();
	
	public void incTeachercCount(String tea_Id);
}


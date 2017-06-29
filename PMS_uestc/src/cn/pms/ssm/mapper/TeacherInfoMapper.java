package cn.pms.ssm.mapper;

import java.util.List;

import cn.pms.ssm.po.Teacher;
import cn.pms.ssm.po.TeacherVo;

/** 
 * <p>Title: TeacherInfoMapper</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  gpan 
 * @date 创建时间：2017年6月28日 下午5:37:59 
 * @version 1.0 
*/

public interface TeacherInfoMapper {
	//
	public List<TeacherVo> selectTeacherInfo();
	//增加导师评阅数量
	public void incTeachercCount(String tea_Id);
}


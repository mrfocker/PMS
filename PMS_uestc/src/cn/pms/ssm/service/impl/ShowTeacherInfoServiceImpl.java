package cn.pms.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.pms.ssm.mapper.ShowTeacherInfoMapper;
import cn.pms.ssm.service.ShowTeacherInfoService;
import cn.pms.ssm.po.Teacher;

/** 
 * <p>Title: </p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author:  liuxiang 
 * @date:2017年7月18日
 * @version 1.0 
*/
public class ShowTeacherInfoServiceImpl implements ShowTeacherInfoService {
	
	//导师提交盲审结果
		@Autowired
		private ShowTeacherInfoMapper showTeacherInfoMapper;
		
		@Override
		public List<Teacher> do_getTeacherInfo(Teacher teacher) throws Exception {
			
			return showTeacherInfoMapper.getTeacherInfo(teacher);
		}

}

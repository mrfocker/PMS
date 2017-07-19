package cn.pms.ssm.mapper;

import java.util.List;
import cn.pms.ssm.po.Teacher;
/** 
 * <p>Title: </p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author:  liuxiang 
 * @date:2017年7月18日
 * @version 1.0 
*/
public interface ShowTeacherInfoMapper {

	//显示导师信息
	public List<Teacher> getTeacherInfo(Teacher teacher) throws Exception;
}

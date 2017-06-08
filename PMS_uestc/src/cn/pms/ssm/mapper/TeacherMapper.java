package cn.pms.ssm.mapper;

import java.util.List;

import cn.pms.ssm.po.User;
import cn.pms.ssm.po.Teacher;

/**
 * 
 * <p>Title: UserMapper</p>
 * <p>Description: mapper鎺ュ彛锛岀浉褰� 浜巇ao鎺ュ彛锛岀敤鎴风鐞�</p>
 * <p>Company: www.itcast.com</p> 
 * @author	浼犳櫤.鐕曢潚
 * @date	2015-4-22涓嬪崍2:45:12
 * @version 1.0
 */
public interface TeacherMapper {
	
	
	//鏍规嵁id鏌ヨ鐢ㄦ埛淇℃伅
	public Teacher FindTeacherById(int id) throws Exception;
	
		

}

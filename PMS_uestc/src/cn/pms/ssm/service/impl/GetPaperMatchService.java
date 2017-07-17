package cn.pms.ssm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.pms.ssm.po.TeacherVo;

/** 
 * <p>Title: GetPaperMatchService</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  gpan 
 * @date 创建时间：2017年7月4日 下午10:31:27 
 * @version 1.0 
*/
@Service

public interface GetPaperMatchService {

	//通过传入的Paper_stuID进行匹配老师，并返回满足条件的TeacherList
	public List<TeacherVo>  matchPaper(String Paper_stuId);
	//通过传入的Paper_stuID进行匹配老师，随机选取并返回满足条件的TeacherList
	public List<TeacherVo>  randomMatchPaper(String Paper_stuId);

}


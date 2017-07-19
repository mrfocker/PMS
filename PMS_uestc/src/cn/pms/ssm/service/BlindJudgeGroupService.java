package cn.pms.ssm.service;

import java.util.List;

import cn.pms.ssm.po.BlindJudgeGroupVo;
/** 
 * <p>Title: </p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author:  liuxiang 
 * @date:2017年7月17日
 * @version 1.0 
*/
public interface BlindJudgeGroupService {
	
	//导师查询需要盲审的论文信息
	public List<BlindJudgeGroupVo> do_findBlindJudgePaper(BlindJudgeGroupVo blindJudgeGroupVo) throws Exception;
	//导师提交盲审结果
	public void submitBlindJudge(BlindJudgeGroupVo blindJudgeGroupVo) throws Exception;

}

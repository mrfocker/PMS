package cn.pms.ssm.mapper;

import java.util.List;

import cn.pms.ssm.po.BlindJudgeGroupVo;
import cn.pms.ssm.po.Teacher;

/** 
 * <p>Title: BlindJudge</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  liuxiang 
 * @date 创建时间：2017年7月17日 上午11:28:02 
 * @version 1.0 
*/

public interface BlindJudgeMapper {
	
	//导师查询自己要盲审的论文
	public List<BlindJudgeGroupVo> findBlindJudgePaper(BlindJudgeGroupVo blindJudgeGroupVo) throws Exception;
	//导师提交盲审结果
	public void insertBlindJudge(BlindJudgeGroupVo blindJudgeGroupVo) throws Exception;
	//模态框显示已经盲审的结果
	public BlindJudgeGroupVo findBlindResult(BlindJudgeGroupVo blindJudgeGroupVo) throws Exception;
}

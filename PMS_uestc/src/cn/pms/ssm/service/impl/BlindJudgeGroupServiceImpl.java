package cn.pms.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.pms.ssm.mapper.PaperInfoExtendMapper;
import cn.pms.ssm.po.BlindJudgeGroupVo;
import cn.pms.ssm.service.BlindJudgeGroupService;
import cn.pms.ssm.mapper.BlindJudgeMapper;

/** 
 * <p>Title: </p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author:  liuxiang 
 * @date:2017年7月17日
 * @version 1.0 
*/
public class BlindJudgeGroupServiceImpl implements BlindJudgeGroupService {

	//导师提交盲审结果
	@Autowired
	private BlindJudgeMapper blindJudgeMapper;

	@Override
	public void submitBlindJudge(BlindJudgeGroupVo blindJudgeGroupVo) throws Exception{
		
		blindJudgeMapper.insertBlindJudge(blindJudgeGroupVo);
	}

	@Override
	public List<BlindJudgeGroupVo> do_findBlindJudgePaper(
			BlindJudgeGroupVo blindJudgeGroupVo) throws Exception {
		
		return blindJudgeMapper.findBlindJudgePaper(blindJudgeGroupVo);
	}
	
	@Override
	public BlindJudgeGroupVo do_findBlindResult(BlindJudgeGroupVo blindJudgeGroupVo) throws Exception{
		
		return blindJudgeMapper.findBlindResult(blindJudgeGroupVo);
	}
	
	@Override
	public void do_updateBlindJudge(BlindJudgeGroupVo blindJudgeGroupVo) throws Exception{
		
		blindJudgeMapper.updateBlindJudge(blindJudgeGroupVo);
	}
}

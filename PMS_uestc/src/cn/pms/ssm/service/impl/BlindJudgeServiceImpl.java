package cn.pms.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pms.ssm.mapper.BlindJudgeMapper;
import cn.pms.ssm.po.Matchchoose;

@Service("BlindJudgeService")
public class BlindJudgeServiceImpl implements BlindJudgeService{
	
	@Autowired
	private BlindJudgeMapper blindJudgeMapper;
	
	@Override
	public void writematchBlindJudgeInfo(Matchchoose matchchoose) {
		// TODO Auto-generated method stub
			blindJudgeMapper.writematchBlindJudgeInfo(matchchoose);
		return;
	}

}

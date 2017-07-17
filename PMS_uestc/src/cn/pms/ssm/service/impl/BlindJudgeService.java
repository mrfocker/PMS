package cn.pms.ssm.service.impl;

import org.springframework.stereotype.Service;

import cn.pms.ssm.po.Matchchoose;

@Service
public interface BlindJudgeService {
	//传入匹配的Stu-Tea类
		public void writematchBlindJudgeInfo(Matchchoose matchchoose);
}

package cn.pms.ssm.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pms.ssm.mapper.DeadlineMapper;
import cn.pms.ssm.service.DeadlineService;

/**
 * DeadlineService实现类
 * @author HeXi
 *
 */
@Service("deadlineService")
public class DeadlineServiceImpl implements DeadlineService{

	@Autowired
	private DeadlineMapper deadlineMapper;
	
	@Override
	public String getPaperPassDeadline() {
		return deadlineMapper.getPaperPassDeadline();
	}

	@Override
	public String getBlindJudgeDeadline() {
		return deadlineMapper.getBlindJudgeDeadline();
	}

	@Override
	public String getReplyDeadline() {
		return deadlineMapper.getReplyDeadline();
	}
	
	@Override
	public void updatePaperPassDeadline(Date paperDeadline) {
		deadlineMapper.updatePaperPassDeadline(paperDeadline);
	}

	@Override
	public void updateBlindJudgeDeadline(Date blindDate) {
		deadlineMapper.updateBlindJudgeDeadline(blindDate);
	}

	@Override
	public void updateReplyDeadline(Date replyDate) {
		deadlineMapper.updateReplyDeadline(replyDate);
	}

}

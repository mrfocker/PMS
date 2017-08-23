package cn.pms.ssm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pms.ssm.mapper.ReplyTimeMapper;
import cn.pms.ssm.po.Student;
import cn.pms.ssm.service.ReplyTimeService;
import cn.pms.ssm.vo.ReplyTimeVo;

/**
 * 管理员修改答辩时间的实现类
 * @author HeXi
 *
 */
@Service("replyTimeService")
public class ReplyTimeServiceImpl implements ReplyTimeService{
	
	@Autowired
	private ReplyTimeMapper replyTimeMapper;

	@Override
	public List<Student> selectRequestReplyTime() {
		return replyTimeMapper.selectRequestTime();
	}

	@Override
	public void updateRequestReplyTime(String stuId, String stuRequestReplyTime) {
		replyTimeMapper.updateRequestReplyTime(stuId,stuRequestReplyTime);
	}

	@Override
	public List<ReplyTimeVo> selectReplyTime() {
		return replyTimeMapper.selectReplyTime();
	}

	@Override
	public void updateReplyTime(String stuId, Date stuReplyTime) {
		replyTimeMapper.updateReplyTime(stuId, stuReplyTime);
	}

	@Override
	public void updateAllReplyTime(Date replyDate) {
		replyTimeMapper.updateAllReplyTime(replyDate);
	}

}

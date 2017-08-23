package cn.pms.ssm.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.pms.ssm.po.Student;
import cn.pms.ssm.vo.ReplyTimeVo;

/**
 * 管理员修改答辩时间的Service
 * @author HeXi
 *
 */
@Service
public interface ReplyTimeService {

	//找到所有学生的申请答辩时间
	List<Student> selectRequestReplyTime();

	//更新某学生的答辩请求时间
	void updateRequestReplyTime(String stuId, String stuRequestReplyTime);

	//找到所有学生的答辩时间
	List<ReplyTimeVo> selectReplyTime();

	//更新学生的答辩时间
	void updateReplyTime(String stuId, Date stuReplyTime);

	//跟新统一的答辩时间
	void updateAllReplyTime(Date replyDate);

}

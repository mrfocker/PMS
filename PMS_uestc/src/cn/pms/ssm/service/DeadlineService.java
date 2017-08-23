package cn.pms.ssm.service;

import java.util.Date;

import org.springframework.stereotype.Service;

/**
 * DeadlineService
 * @author HeXi
 *
 */
@Service
public interface DeadlineService {
	
	//得到本导师审核结果提交的最后期限
	String getPaperPassDeadline();
	
	//得到盲审成绩提交的最后期限
	String getBlindJudgeDeadline();

	//得到答辩成绩提交的最后期限
	String getReplyDeadline();
	
	//修改本导师审核结果提交的最后期限
	void updatePaperPassDeadline(Date paperDate);

	//修改盲审成绩提交的最后期限
	void updateBlindJudgeDeadline(Date blindDate);

	//修改答辩成绩提交的最后期限
	void updateReplyDeadline(Date replyDate);

}

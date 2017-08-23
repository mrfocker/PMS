package cn.pms.ssm.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

/**
 * DeadlineMapper
 * @author HeXi
 *
 */
public interface DeadlineMapper {

	String getPaperPassDeadline();

	String getBlindJudgeDeadline();

	String getReplyDeadline();
	
	void updatePaperPassDeadline(@Param("paperDeadline")Date paperDeadline);

	void updateBlindJudgeDeadline(@Param("blindDeadline")Date blindDeadline);

	void updateReplyDeadline(@Param("replyDeadline")Date replyDeadline);

}

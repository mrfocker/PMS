package cn.pms.ssm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.pms.ssm.vo.BlindJudgeResultVo;
import cn.pms.ssm.vo.ReplyResultVo;
import cn.pms.ssm.vo.StudentPaperVo;

/**
 * 管理员更改结果的Service
 * @author HeXi
 *
 */
@Service
public interface UpdateResultService {

	//找到导师审核的结果
	List<StudentPaperVo> selectAllPaperResult();

	//找到盲审结果
	List<BlindJudgeResultVo> selectAllBlindResult();

	//找到答辩结果
	List<ReplyResultVo> selectAllReplyResult();

	//更新导师审核的结果
	void updatePaperResult(String stuId, String paperIfPass);

	//更改盲审结果
	void updateBlindResult(String stuId, String teacherId, int teacherGrade);

	//更改答辩结果
	void updateReplyResult(String stuId, String groupId, String teacherId, int replyGrade);

	//修改学院审核结果
	void updateDepartPassResult(String stuId, String paperDepartPass);

}

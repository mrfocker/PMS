package cn.pms.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pms.ssm.vo.BlindJudgeResultVo;
import cn.pms.ssm.vo.ReplyResultVo;
import cn.pms.ssm.vo.StudentPaperVo;

/**
 * 处理结果的Mapper
 * @author HeXi
 *
 */
public interface ResultMapper {

	//选择所有论文的导师审核结果
	List<StudentPaperVo> selectAllPaperResult();

	//选择所有学生论文的盲审结果
	List<BlindJudgeResultVo> selectAllBlindResult();

	//选择所有学生论文的答辩结果
	List<ReplyResultVo> selectAllReplyResult();

	//导师状态改为“修改”时控制学生可以再次提交论文
	void updatePaperSubmitResult(@Param("stuId")String stuId,@Param("paperIfPass") String paperIfPass);

	//更新导师审核状态
	void updatePaperResult(@Param("stuId")String stuId,@Param("paperIfPass") String paperIfPass);

	//更新盲审状态
	void updateBlindResult(@Param("stuId")String stuId,@Param("teacherId")String teacherId, @Param("teacherGrade") int teacherGrade,@Param("teacherResult") String teacherResult);

	//状态改为“修改”时学生再次提交论文
	void updateBlindSubmitResult(@Param("stuId")String stuId,@Param("teacherId")String teacherId, @Param("teacherGrade") int teacherGrade,@Param("teacherResult") String teacherResult);

	//更改学生论文提交状态
	void updateSubmitResult(@Param("stuId")String stuId);
	
	//找到某学生所有盲审老师的结果
	List<String> findAllBlindResult(@Param("stuId")String stuId);

	//更新最终盲审结果
	void updatePaperBlindJudgeResult(@Param("stuId")String stuId,@Param("blindResult") String blindResult);

	//更改答辩成绩
	void updateReplyGrade(@Param("stuId")String stuId,@Param("groupId") String groupId,@Param("teacherId") String teacherId,@Param("replyGrade") int replyGrade);

	//找到某学生所有答辩成绩
	List<Integer> findAllReplyResult(@Param("stuId")String stuId,@Param("groupId") String groupId);

	//更改答辩结果
	void updatePaperReplyResult(@Param("stuId")String stuId,@Param("groupId") String groupId,@Param("replyResult") String replyResult);

	//更改学院审核结果
	void updateDepartPassResult(@Param("stuId")String stuId,@Param("paperDepartPass") String paperDepartPass);

}

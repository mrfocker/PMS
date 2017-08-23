package cn.pms.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pms.ssm.mapper.ResultMapper;
import cn.pms.ssm.service.UpdateResultService;
import cn.pms.ssm.vo.BlindJudgeResultVo;
import cn.pms.ssm.vo.ReplyResultVo;
import cn.pms.ssm.vo.StudentPaperVo;

/**
 * 管理员修改结果的实现类
 * @author HeXi
 *
 */
@Service("updateResultService")
public class UpdateResultServiceImpl implements UpdateResultService{

	@Autowired
	private ResultMapper resultMapper;

	@Override
	public List<StudentPaperVo> selectAllPaperResult() {
		return resultMapper.selectAllPaperResult();
	}

	@Override
	public List<BlindJudgeResultVo> selectAllBlindResult() {
		return resultMapper.selectAllBlindResult();
	}

	@Override
	public List<ReplyResultVo> selectAllReplyResult() {
		return resultMapper.selectAllReplyResult();
	}

	@Override
	public void updatePaperResult(String stuId, String paperIfPass) {
		if(paperIfPass.equals("修改")){
			resultMapper.updatePaperSubmitResult(stuId,paperIfPass);
		}else{
			resultMapper.updatePaperResult(stuId,paperIfPass);
		}
	}

	@Override
	public void updateBlindResult(String stuId,String teacherId, int teacherGrade) {
		String teacherResult;
		if(teacherGrade >= 60){
			teacherResult = "通过";
		}else if(teacherGrade == 0){
			teacherResult = "修改";
			resultMapper.updateSubmitResult(stuId);
		}else{
			teacherResult = "不通过";
		}
		resultMapper.updateBlindResult(stuId,teacherId,teacherGrade,teacherResult);
		List<String> results = resultMapper.findAllBlindResult(stuId);
		String blindResult = "通过";
		if(results.contains("不通过")){
			blindResult = "不通过";
		}
		resultMapper.updatePaperBlindJudgeResult(stuId,blindResult);
	}

	@Override
	public void updateReplyResult(String stuId, String groupId, String teacherId, int replyGrade) {
		resultMapper.updateReplyGrade(stuId,groupId,teacherId,replyGrade);
		List<Integer> grades = resultMapper.findAllReplyResult(stuId,groupId);
		//取n位老师的平均值，大于等于60则通过，否则不通过
		int sum = 0;
		for (int i = 0 ; i < grades.size() ; i ++){
			sum = grades.get(i) + sum;
		}
		int avg = sum/grades.size();
		System.out.println(avg);
		String replyResult = "通过";
		if(avg < 60){
			replyResult = "不通过";
		}
		resultMapper.updatePaperReplyResult(stuId,groupId,replyResult);
	}

	@Override
	public void updateDepartPassResult(String stuId, String paperDepartPass) {
		resultMapper.updateDepartPassResult(stuId,paperDepartPass);
	}
}

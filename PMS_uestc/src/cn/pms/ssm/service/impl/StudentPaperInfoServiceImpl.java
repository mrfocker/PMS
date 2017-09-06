package cn.pms.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.pms.ssm.mapper.StudentPaperInfoMapper;
import cn.pms.ssm.po.StudentPaperInfoVo;
import cn.pms.ssm.service.StudentPaperInfoService;

/** 
 * <p>Title: </p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author:  liuxiang 
 * @date:2017年8月13日
 * @version 1.0 
*/
public class StudentPaperInfoServiceImpl implements StudentPaperInfoService {
	
	@Autowired
	private StudentPaperInfoMapper studentPaperInfoMapper;

	@Override
	public List<StudentPaperInfoVo> do_findStudentPaperInfo(
			StudentPaperInfoVo studentPaperInfoVo) throws Exception {
			
			return studentPaperInfoMapper.findStudentPaperInfo(studentPaperInfoVo);
	}

	@Override
	public StudentPaperInfoVo do_getStudentPaperInfo(
		StudentPaperInfoVo studentPaperInfoVo) throws Exception {
		System.out.println("here");
		System.out.println(studentPaperInfoVo.getStu_id());
		StudentPaperInfoVo allPaperInfo = new StudentPaperInfoVo();
		StudentPaperInfoVo myPaperInfo = new StudentPaperInfoVo();
		StudentPaperInfoVo myFileInfo = new StudentPaperInfoVo();
		StudentPaperInfoVo myBlindJudgeInfo = new StudentPaperInfoVo();
		StudentPaperInfoVo myReplyJudgeInfo = new StudentPaperInfoVo();
		StudentPaperInfoVo myGradeListInfo = new StudentPaperInfoVo();
		StudentPaperInfoVo mySelfInfo = new StudentPaperInfoVo();
			
		mySelfInfo = studentPaperInfoMapper.getStuInfo(studentPaperInfoVo);
		if(mySelfInfo != null){
			System.out.println("myselfInfo ok");
			allPaperInfo.setStu_name(mySelfInfo.getStu_name());
			allPaperInfo.setStu_id(mySelfInfo.getStu_id());
			allPaperInfo.setStu_ifdegree(mySelfInfo.getStu_ifdegree());
		}
			
			myPaperInfo = studentPaperInfoMapper.getPaperInfo(studentPaperInfoVo);
			if(myPaperInfo != null){
			System.out.println("myPaperInfo ok");
			allPaperInfo.setPaper_title(myPaperInfo.getPaper_title());
			allPaperInfo.setPaper_researchOne(myPaperInfo.getPaper_researchOne());
			allPaperInfo.setPaper_researchTwo(myPaperInfo.getPaper_researchTwo());
			allPaperInfo.setPaper_researchThree(myPaperInfo.getPaper_researchThree());
			allPaperInfo.setPaper_ifPass(myPaperInfo.getPaper_ifPass());
			allPaperInfo.setPaper_departPass(myPaperInfo.getPaper_departPass());
			allPaperInfo.setPaper_ifSubmit(myPaperInfo.getPaper_ifSubmit());
			allPaperInfo.setPaper_repetitiveRateAll(myPaperInfo.getPaper_repetitiveRateAll());
			allPaperInfo.setPaper_repetitiveRateSingle(myPaperInfo.getPaper_repetitiveRateSingle());
			allPaperInfo.setPaper_ifAdvise(myPaperInfo.getPaper_ifAdvise());
			allPaperInfo.setPaper_blindjudgePass(myPaperInfo.getPaper_blindjudgePass());
			allPaperInfo.setPaper_ifReply(myPaperInfo.getPaper_ifReply());
			allPaperInfo.setPaper_replyPass(myPaperInfo.getPaper_replyPass());
			allPaperInfo.setPaper_over(myPaperInfo.getPaper_over());
				
			if((myPaperInfo.getPaper_repetitiveRateAll() != null) && (myPaperInfo.getPaper_repetitiveRateSingle() != null)){
				System.out.println("check here");
				System.out.println(Float.parseFloat(myPaperInfo.getPaper_repetitiveRateAll()));
				if(Float.parseFloat(myPaperInfo.getPaper_repetitiveRateAll()) >= 0.2){
					allPaperInfo.setPaper_ifPaperRepetitiveRatePass("不通过");
				}
				if((Float.parseFloat(myPaperInfo.getPaper_repetitiveRateAll()) < 0.2 && Float.parseFloat(myPaperInfo.getPaper_repetitiveRateAll()) >= 0.15)|| Float.parseFloat(myPaperInfo.getPaper_repetitiveRateSingle()) > 0.25 ){
					allPaperInfo.setPaper_ifPaperRepetitiveRatePass("修改");
				}
				if(Float.parseFloat(myPaperInfo.getPaper_repetitiveRateAll()) <= 0.15 && Float.parseFloat(myPaperInfo.getPaper_repetitiveRateSingle()) <= 0.25){
					allPaperInfo.setPaper_ifPaperRepetitiveRatePass("通过");
				}
				}
				System.out.println(allPaperInfo.getPaper_ifSubmit());
			}
			
			myBlindJudgeInfo = studentPaperInfoMapper.getBlindJudgeInfo(studentPaperInfoVo);
			if(myBlindJudgeInfo != null){
				System.out.println("myBlindJudgeInfo ok");
				allPaperInfo.setTeacher_Result(myBlindJudgeInfo.getTeacher_Result());
			}
			
			myReplyJudgeInfo = studentPaperInfoMapper.getReplyJudgeInfo(studentPaperInfoVo);
			if(myReplyJudgeInfo != null){
				System.out.println("myReplyJudgeInfo ok");
				allPaperInfo.setReply_result(myReplyJudgeInfo.getReply_result());
			}
			
			myGradeListInfo = studentPaperInfoMapper.getGradeListInfo(studentPaperInfoVo);
			if(myGradeListInfo != null){
				System.out.println("myGradeListInfo ok");
				allPaperInfo.setGrade_ifPass(myGradeListInfo.getGrade_ifPass());
			}
			
			myFileInfo =  studentPaperInfoMapper.getFileInfo(studentPaperInfoVo);
			if(myFileInfo != null){
				System.out.println("myFileInfo ok");
				allPaperInfo.setFile_id(myFileInfo.getFile_id());
			}
		    return allPaperInfo;
	}

	@Override
	public void do_updateIfSubmit(StudentPaperInfoVo studentPaperInfoVo)
			throws Exception {
		studentPaperInfoMapper.updateIfSubmit(studentPaperInfoVo);
	}

	@Override
	public StudentPaperInfoVo do_queryTeacherDepartAdvise(
			StudentPaperInfoVo studentPaperInfoVo) throws Exception {
		
		return studentPaperInfoMapper.getPaperInfo(studentPaperInfoVo);
	}

	@Override
	public void do_updatSubmit_Pass(StudentPaperInfoVo studentPaperInfoVo)
			throws Exception {
		studentPaperInfoMapper.updateSubmit_Pass(studentPaperInfoVo);
		
	}

	@Override
	public StudentPaperInfoVo do_queryBlindJudgeAdvise(
			StudentPaperInfoVo studentPaperInfoVo) throws Exception {
		return studentPaperInfoMapper.getBlindJudgeInfo(studentPaperInfoVo);
	}

	@Override
	public StudentPaperInfoVo do_queryReplyJudgeAdvise(
			StudentPaperInfoVo studentPaperInfoVo) throws Exception {
		return studentPaperInfoMapper.getReplyJudgeInfo(studentPaperInfoVo);
	}

	@Override
	public void do_updateAdvise_Pass(StudentPaperInfoVo studentPaperInfoVo)
			throws Exception {
		studentPaperInfoMapper.updateAdvise_Pass(studentPaperInfoVo);
		
	}

}

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
			/*myFileInfo =  studentPaperInfoMapper.getFileInfo(studentPaperInfoVo);
			myBlindJudgeInfo = studentPaperInfoMapper.getBlindJudgeInfo(studentPaperInfoVo);
			myReplyJudgeInfo = studentPaperInfoMapper.getReplyJudgeInfo(studentPaperInfoVo);
			myGradeListInfo = studentPaperInfoMapper.getGradeListInfo(studentPaperInfoVo);
			
			allPaperInfo.setPaper_title(myPaperInfo.getPaper_title());
			allPaperInfo.setPaper_researchOne(myPaperInfo.getPaper_researchOne());
			allPaperInfo.setPaper_researchTwo(myPaperInfo.getPaper_researchTwo());
			allPaperInfo.setPaper_researchThree(myPaperInfo.getPaper_researchThree());
			allPaperInfo.setPaper_ifPass(myPaperInfo.getPaper_ifPass());
			allPaperInfo.setPaper_departPss(myPaperInfo.getPaper_departPss());
			allPaperInfo.setFile_id(myFileInfo.getFile_id());
			allPaperInfo.setTeacher_Result(myBlindJudgeInfo.getTeacher_Result());
			allPaperInfo.setReply_result(myReplyJudgeInfo.getReply_result());
			allPaperInfo.setGrade_ifPass(myGradeListInfo.getGrade_ifPass());
			
			System.out.println(allPaperInfo.getPaper_title());
			System.out.println(allPaperInfo.getPaper_researchOne());
			System.out.println(allPaperInfo.getPaper_researchTwo());
			System.out.println(allPaperInfo.getPaper_researchThree());
			System.out.println(allPaperInfo.getPaper_ifPass());
			System.out.println(allPaperInfo.getPaper_departPss());
			System.out.println(allPaperInfo.getFile_id());
			System.out.println(allPaperInfo.getTeacher_Result());
			System.out.println(allPaperInfo.getReply_result());
			System.out.println(allPaperInfo.getGrade_ifPass());*/
			
		    return allPaperInfo;
	}

}

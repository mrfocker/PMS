package cn.pms.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pms.ssm.mapper.GetPaperMatchMapper;
import cn.pms.ssm.po.TeacherVo;

/** 
 * <p>Title: GetPaperMatchServiceImpl</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  gpan 
 * @date 创建时间：2017年7月4日 下午10:31:42 
 * @version 1.0 
*/
@Service("GetPaperMatchService")

public class GetPaperMatchServiceImpl implements GetPaperMatchService {

		@Autowired 
		private GetPaperMatchMapper getPaperMatchMapper;

		public List<TeacherVo> matchPaper(String Paper_stuId) {
			// TODO Auto-generated method stub
			return getPaperMatchMapper.matchPaper(Paper_stuId);
		}
		
		public List<TeacherVo> randomMatchPaper(String Paper_stuId){
			return getPaperMatchMapper.randomMatchPaper(Paper_stuId);
		}
		
}


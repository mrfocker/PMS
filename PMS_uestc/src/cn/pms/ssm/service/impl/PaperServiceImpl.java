package cn.pms.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.pms.ssm.mapper.PaperInfoExtendMapper;
import cn.pms.ssm.po.Paper;
import cn.pms.ssm.po.PaperInfoExtend;
import cn.pms.ssm.po.PaperQueryVo;
import cn.pms.ssm.service.PaperService;

/** 
 * <p>Title: </p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author:  liuxiang 
 * @date:2017年6月30日
 * @version 1.0 
*/
public class PaperServiceImpl implements PaperService{
	
	@Autowired
	private PaperInfoExtendMapper paperInfoExtendMapper;

	
	@Override
	public List<PaperInfoExtend> do_findpaperlist(PaperQueryVo paperQueryVo) throws Exception{
		//通过PaperInfoExtend查询数据库
		return paperInfoExtendMapper.findpaperlist(paperQueryVo);
	}

}

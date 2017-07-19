package cn.pms.ssm.service;

import java.util.List;

import cn.pms.ssm.po.PaperInfoExtend;
import cn.pms.ssm.po.PaperQueryVo;

/** 
 * <p>Title: </p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author:  liuxiang 
 * @date:2017年6月30日
 * @version 1.0 
*/
public interface PaperService {
	
	//论文信息综合查询
		public List<PaperInfoExtend> do_findpaperlist(PaperQueryVo paperQueryVo) throws Exception;

}

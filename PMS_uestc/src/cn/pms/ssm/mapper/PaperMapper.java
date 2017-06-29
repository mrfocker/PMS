package cn.pms.ssm.mapper;

import java.util.List;

import cn.pms.ssm.po.Paper;
import cn.pms.ssm.po.PaperInfoExtend;
import cn.pms.ssm.po.PaperQueryVo;
import cn.pms.ssm.po.Teacher;

/** 
 * <p>Title: </p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author:  liuxiang 
 * @date:2017年6月27日
 * @version 1.0 
*/
public interface PaperMapper {
	
	//论文信息综合查询
	public List<PaperInfoExtend> findpaperlist(PaperQueryVo paperQueryVo) throws Exception;

}

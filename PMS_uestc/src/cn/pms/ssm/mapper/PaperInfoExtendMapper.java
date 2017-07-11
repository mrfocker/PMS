package cn.pms.ssm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;


import cn.pms.ssm.po.PaperInfoExtend;
import cn.pms.ssm.po.PaperQueryVo;
import cn.pms.ssm.po.Paper;
/** 
 * <p>Title: </p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author:  liuxiang 
 * @date:2017年6月30日
 * @version 1.0 
*/
public interface PaperInfoExtendMapper {
	
	//学生查询论文信息综合查询
	public List<PaperInfoExtend> findpaperlist(PaperQueryVo paperQueryVo) throws Exception;
	
	//教师查询自己学生论文信息

}

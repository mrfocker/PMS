package cn.pms.ssm.mapper;

import java.util.List;

import cn.pms.ssm.po.PaperVo;

/** 
 * <p>Title: GetStuPaperMapper</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  gpan 
 * @date 创建时间：2017年6月29日 下午8:02:01 
 * @version 1.0 
*/

public interface GetPaperMapper {
	//查询Paper信息
	public List<PaperVo> selectPaperInfo();
	
}


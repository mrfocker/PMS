package cn.pms.ssm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.pms.ssm.po.PaperVo;

/** 
 * <p>Title: getStuPaperService</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  gpan 
 * @date 创建时间：2017年6月29日 下午8:14:22 
 * @version 1.0 
*/
@Service
public interface GetPaperService {
	public List<PaperVo> selectPaperInfo();
}


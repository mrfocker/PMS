package cn.pms.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pms.ssm.mapper.GetPaperMapper;
import cn.pms.ssm.po.PaperVo;

/** 
 * <p>Title: getStuPaperServiceImpl</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  gpan 
 * @date 创建时间：2017年6月29日 下午8:15:05 
 * @version 1.0 
*/
@Service("GetStuPaperService")
public class GetPaperServiceImpl implements GetPaperService {

	@Autowired
	private GetPaperMapper getPaperMapper;
	
	@Override
	public List<PaperVo> selectPaperInfo() {
		// TODO Auto-generated method stub
		return getPaperMapper.selectPaperInfo();
	}
	
}


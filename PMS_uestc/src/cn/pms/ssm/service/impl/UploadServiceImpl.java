/**
 * 
 */
package cn.pms.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pms.ssm.mapper.UpLoadMapper;
import cn.pms.ssm.po.Paper;
import cn.pms.ssm.service.UploadService;

/** 
 * <p>Title: UploadServiceImpl</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年6月21日 下午7:41:40 
 * @version 1.0 
*/
@Service("uploadService")
public class UploadServiceImpl implements UploadService {

	@Autowired
	private UpLoadMapper upLoadMapper;
	/* (non-Javadoc)
	 * @see cn.pms.ssm.service.UploadService#insertPaperItem(cn.pms.ssm.po.Paper)
	 */
	@Override
	public void insertPaperItem(Paper paper) {
		// TODO Auto-generated method stub
		upLoadMapper.insertPaperItem(paper);
	}

}

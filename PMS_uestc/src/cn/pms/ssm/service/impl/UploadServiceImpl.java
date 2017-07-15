/**
 * 
 */
package cn.pms.ssm.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pms.ssm.mapper.UpLoadMapper;
import cn.pms.ssm.po.Paper;
import cn.pms.ssm.service.UploadService;
import cn.pms.ssm.vo.UploadVo;

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
	public void insertPaperItem(UploadVo uploadVo) {
		// TODO Auto-generated method stub
		upLoadMapper.insertPaperItem(uploadVo);
	}
	/* (non-Javadoc)
	 * @see cn.pms.ssm.service.UploadService#updatePaperItem(cn.pms.ssm.po.Paper)
	 */
	@Override
	public void updatePaperItem(UploadVo uploadVo) {
		// TODO Auto-generated method stub
		upLoadMapper.updatePaperItem(uploadVo);
	}
	/* (non-Javadoc)
	 * @see cn.pms.ssm.service.UploadService#selectPaperItem(cn.pms.ssm.po.Paper)
	 */
	@Override
	public ArrayList<Integer> selectPaperItem(UploadVo uploadVo) {
		// TODO Auto-generated method stub
		return upLoadMapper.selectPaperItem(uploadVo);
	}
	/* (non-Javadoc)
	 * @see cn.pms.ssm.service.UploadService#insertFileItem(cn.pms.ssm.vo.UploadVo)
	 */
	@Override
	public void insertFileItem(UploadVo uploadVo) {
		// TODO Auto-generated method stub
		upLoadMapper.insertFileItem(uploadVo);
	}
	/* (non-Javadoc)
	 * @see cn.pms.ssm.service.UploadService#selectPaperIfExist(cn.pms.ssm.vo.UploadVo)
	 */
	@Override
	public UploadVo selectPaperIfExist(UploadVo uploadVo) {
		// TODO Auto-generated method stub
		return upLoadMapper.selectPaperIfExist(uploadVo);
	}

}

/**
 * 
 */
package cn.pms.ssm.service.impl;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pms.ssm.mapper.DownloadMapper;
import cn.pms.ssm.mapper.UpLoadMapper;
import cn.pms.ssm.po.Paper;
import cn.pms.ssm.service.DownloadService;
import cn.pms.ssm.vo.DownloadVo;

/** 
 * <p>Title: DownloadServiceImpl</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年7月3日 下午4:43:35 
 * @version 1.0 
*/
@Service("downloadService")
public class DownloadServiceImpl implements DownloadService {

	@Autowired
	private DownloadMapper downloadMapper;
	/* (non-Javadoc)
	 * @see cn.pms.ssm.service.DownloadService#downloadFile(cn.pms.ssm.po.Paper)
	 */
	@Override
	public Paper downloadSingle(Paper paper) {
		// TODO Auto-generated method stub
		ArrayList<String> paperItemList = downloadMapper.selectPaperItem(paper);
		paper.setPaper_name(paperItemList.get(paperItemList.size()-1));
		
		return paper;
	}
	/* (non-Javadoc)
	 * @see cn.pms.ssm.service.DownloadService#selectAllItem()
	 */
	@Override
	public ArrayList<DownloadVo> selectAllItem() {
		// TODO Auto-generated method stub
		ArrayList<DownloadVo> list = downloadMapper.selectAllItem(); 
		return list;
	}

}

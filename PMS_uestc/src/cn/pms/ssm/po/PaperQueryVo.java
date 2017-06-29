package cn.pms.ssm.po;
/** 
 * <p>Title:PaperQueryVo </p> 
 * <p>Description:包装查询对象 </p> 
 * <p>Company: uestc_xr</p> 
 * @author:  liuxiang 
 * @date:2017年6月25日
 * @version 1.0 
*/
public class PaperQueryVo {

	//论文信息
	private Paper paper;
	//为了系统可扩展性，对原始po进行扩展
	private PaperInfoExtend paperInfoExtend;
	
	public Paper getPaper() {
		return paper;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	public PaperInfoExtend getPaperInfoExtend() {
		return paperInfoExtend;
	}
	public void setPaperInfoExtend(PaperInfoExtend paperInfoExtend) {
		this.paperInfoExtend = paperInfoExtend;
	}
	
	
}

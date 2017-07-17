package cn.pms.ssm.po;
/** 
 * <p>Title: TeacherVo</p> 
 * <p>Description: 封装扩展TeacherVO类</p> 
 * <p>Company: uestc_xr</p> 
 * @author  gpan 
 * @date 创建时间：2017年6月29日 下午6:49:22 
 * @version 1.0 
*/

public class TeacherVo extends Teacher {
	//扩展TeacherVO类
	private String paper_stuId;

	public String getPaper_stuId() {
		return paper_stuId;
	}

	public void setPaper_stuId(String paper_stuId) {
		this.paper_stuId = paper_stuId;
	}
}


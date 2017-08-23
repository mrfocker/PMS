package cn.pms.ssm.vo;

/**
 * JSON格式数据的实体
 * @author HeXi
 *
 */
public class PaperPassJson {
	
	private String stuId;
	private String paperTitle;
	private String paperDepartPass;
	
	public PaperPassJson(String stuId, String paperTitle, String paperDepartPass) {
		this.stuId = stuId;
		this.paperTitle = paperTitle;
		this.paperDepartPass = paperDepartPass;
	}
	
	public PaperPassJson(){
		super();
	}
	
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getPaperTitle() {
		return paperTitle;
	}
	public void setPaperTitle(String paperTitle) {
		this.paperTitle = paperTitle;
	}
	public String getPaperDepartPass() {
		return paperDepartPass;
	}
	public void setPaperDepartPass(String paperDepartPass) {
		this.paperDepartPass = paperDepartPass;
	}
	
	
}

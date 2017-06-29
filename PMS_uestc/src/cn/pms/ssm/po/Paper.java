package cn.pms.ssm.po;
/** 
 * <p>Title: Paper</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  gpan 
 * @date 创建时间：2017年6月29日 下午8:03:39 
 * @version 1.0 
*/

public class Paper {
	private String Paper_stuId;
	private String Paper_title;
	private String Paper_researchOne;
	private String Paper_researchTwo;
	private String Paper_researchThree;
	private String Paper_reason;
	private float Paper_repetitiveRateAll;
	private float Paper_repetitiveRateSingle;
	private int Paper_ifPass;
	public String getPaper_stuId() {
		return Paper_stuId;
	}
	public void setPaper_stuId(String paper_stuId) {
		Paper_stuId = paper_stuId;
	}
	public String getPaper_title() {
		return Paper_title;
	}
	public void setPaper_title(String paper_title) {
		Paper_title = paper_title;
	}
	public String getPaper_researchOne() {
		return Paper_researchOne;
	}
	public void setPaper_researchOne(String paper_researchOne) {
		Paper_researchOne = paper_researchOne;
	}
	public String getPaper_researchTwo() {
		return Paper_researchTwo;
	}
	public void setPaper_researchTwo(String paper_researchTwo) {
		Paper_researchTwo = paper_researchTwo;
	}
	public String getPaper_researchThree() {
		return Paper_researchThree;
	}
	public void setPaper_researchThree(String paper_researchThree) {
		Paper_researchThree = paper_researchThree;
	}
	public String getPaper_reason() {
		return Paper_reason;
	}
	public void setPaper_reason(String paper_reason) {
		Paper_reason = paper_reason;
	}
	public float getPaper_repetitiveRateAll() {
		return Paper_repetitiveRateAll;
	}
	public void setPaper_repetitiveRateAll(float paper_repetitiveRateAll) {
		Paper_repetitiveRateAll = paper_repetitiveRateAll;
	}
	public float getPaper_repetitiveRateSingle() {
		return Paper_repetitiveRateSingle;
	}
	public void setPaper_repetitiveRateSingle(float paper_repetitiveRateSingle) {
		Paper_repetitiveRateSingle = paper_repetitiveRateSingle;
	}
	public int getPaper_ifPass() {
		return Paper_ifPass;
	}
	public void setPaper_ifPass(int paper_ifPass) {
		Paper_ifPass = paper_ifPass;
	}
	
	
}


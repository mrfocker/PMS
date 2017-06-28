package cn.pms.ssm.po;
/** 
 * <p>Title: Paper</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  liuxiang 
 * @date 创建时间：2017年6月28日 上午11:31:41 
 * @version 1.0 
*/

public class Paper {
	
	private String Paper_stuid;
	private String Paper_title;
	private String Paper_researchOne;
	private String Paper_researchTwo;
	private String Paper_reaserchThree;
	private String Paper_reason;
	private Float Paper_repetitiveRateAll;
	private Float Paper_repetitiveRateSing;
	private int Paper_ifPass;
	private int Paper_blindJudge;
	public String getPaper_stuid() {
		return Paper_stuid;
	}
	public void setPaper_stuid(String paper_stuid) {
		Paper_stuid = paper_stuid;
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
	public String getPaper_reaserchThree() {
		return Paper_reaserchThree;
	}
	public void setPaper_reaserchThree(String paper_reaserchThree) {
		Paper_reaserchThree = paper_reaserchThree;
	}
	public String getPaper_reason() {
		return Paper_reason;
	}
	public void setPaper_reason(String paper_reason) {
		Paper_reason = paper_reason;
	}
	public Float getPaper_repetitiveRateAll() {
		return Paper_repetitiveRateAll;
	}
	public void setPaper_repetitiveRateAll(Float paper_repetitiveRateAll) {
		Paper_repetitiveRateAll = paper_repetitiveRateAll;
	}
	public Float getPaper_repetitiveRateSing() {
		return Paper_repetitiveRateSing;
	}
	public void setPaper_repetitiveRateSing(Float paper_repetitiveRateSing) {
		Paper_repetitiveRateSing = paper_repetitiveRateSing;
	}
	public int getPaper_ifPass() {
		return Paper_ifPass;
	}
	public void setPaper_ifPass(int paper_ifPass) {
		Paper_ifPass = paper_ifPass;
	}
	public int getPaper_blindJudge() {
		return Paper_blindJudge;
	}
	public void setPaper_blindJudge(int paper_blindJudge) {
		Paper_blindJudge = paper_blindJudge;
	}
	@Override
	public String toString() {
		return "Paper [Paper_stuid=" + Paper_stuid + ", Paper_title=" + Paper_title + ", Paper_researchOne="
				+ Paper_researchOne + ", Paper_researchTwo=" + Paper_researchTwo + ", Paper_reaserchThree="
				+ Paper_reaserchThree + ", Paper_reason=" + Paper_reason + ", Paper_repetitiveRateAll="
				+ Paper_repetitiveRateAll + ", Paper_repetitiveRateSing=" + Paper_repetitiveRateSing + ", Paper_ifPass="
				+ Paper_ifPass + ", Paper_blindJudge=" + Paper_blindJudge + "]";
	}
	public Paper(String paper_stuid, String paper_title, String paper_researchOne, String paper_researchTwo,
			String paper_reaserchThree, String paper_reason, Float paper_repetitiveRateAll,
			Float paper_repetitiveRateSing, int paper_ifPass, int paper_blindJudge) {
		super();
		Paper_stuid = paper_stuid;
		Paper_title = paper_title;
		Paper_researchOne = paper_researchOne;
		Paper_researchTwo = paper_researchTwo;
		Paper_reaserchThree = paper_reaserchThree;
		Paper_reason = paper_reason;
		Paper_repetitiveRateAll = paper_repetitiveRateAll;
		Paper_repetitiveRateSing = paper_repetitiveRateSing;
		Paper_ifPass = paper_ifPass;
		Paper_blindJudge = paper_blindJudge;
	}
	
	public Paper(){
		
	}

}

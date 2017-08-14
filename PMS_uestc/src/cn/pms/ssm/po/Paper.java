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
	
	private String Paper_stuId;
	private String Paper_title;
	private String Paper_researchOne;
	private String Paper_researchTwo;
	private String Paper_researchThree;
	private String Paper_reason;
	private Float Paper_repetitiveRateAll;
	private Float Paper_repetitiveRateSingle;
	private String Paper_ifPass;
	private String Paper_advise;
	private String Paper_departPass;
	private int Paper_blindJudge;
	
	
	public String getPaper_departPass() {
		return Paper_departPass;
	}
	public void setPaper_departPass(String paper_departPass) {
		Paper_departPass = paper_departPass;
	}
	public String getPaper_stuId() {
		return Paper_stuId;
	}
	public void setPaper_stuId(String paper_stuId) {
		Paper_stuId = paper_stuId;
	}
	public Float getPaper_repetitiveRateSingle() {
		return Paper_repetitiveRateSingle;
	}
	public void setPaper_repetitiveRateSingle(Float paper_repetitiveRateSingle) {
		Paper_repetitiveRateSingle = paper_repetitiveRateSingle;
	}
	public String getPaper_advise() {
		return Paper_advise;
	}
	public void setPaper_advise(String paper_advise) {
		Paper_advise = paper_advise;
	}
	public String getPaper_stuid() {
		return Paper_stuId;
	}
	public void setPaper_stuid(String paper_stuid) {
		Paper_stuId = paper_stuid;
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
		return Paper_researchThree;
	}
	public void setPaper_reaserchThree(String paper_reaserchThree) {
		Paper_researchThree = paper_reaserchThree;
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
		return Paper_repetitiveRateSingle;
	}
	public void setPaper_repetitiveRateSing(Float paper_repetitiveRateSingle) {
		Paper_repetitiveRateSingle = paper_repetitiveRateSingle;
	}
	public String getPaper_ifPass() {
		return Paper_ifPass;
	}
	public void setPaper_ifPass(String paper_ifPass) {
		Paper_ifPass = paper_ifPass;
	}
	public int getPaper_blindJudge() {
		return Paper_blindJudge;
	}
	public void setPaper_blindJudge(int paper_blindJudge) {
		Paper_blindJudge = paper_blindJudge;
	}
	
}

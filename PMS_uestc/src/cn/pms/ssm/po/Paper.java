/**
 * 
 */
package cn.pms.ssm.po;

/**
 * <p>
 * Title: Paper
 * </p>
 * <p>
 * Description:TODO
 * </p>
 * <p>
 * Company: uestc_xr
 * </p>
 * 
 * @author Xiaozhe
 * @date 创建时间：2017年6月20日 下午8:01:43
 * @version 1.0
 */
public class Paper {
	
	private String Paper_stuId;
	private String Paper_name;
	private String Paper_title;
	private String Paper_researchOne;
	private String Paper_researchTwo;
	private String Paper_researchThree;
	private String Paper_reason;
	private float Paper_repetitiveRateAll;
	private float Paper_repetitiveRateSingle;
	private String Paper_ifPass;
	private int Paper_ifSubmit;
	
	
	/**
	 * @return the paper_stuId
	 */
	public String getPaper_stuId() {
		return Paper_stuId;
	}
	/**
	 * @param paper_stuId the paper_stuId to set
	 */
	public void setPaper_stuId(String paper_stuId) {
		Paper_stuId = paper_stuId;
	}
	/**
	 * @return the paper_title
	 */
	public String getPaper_title() {
		return Paper_title;
	}
	/**
	 * @param paper_title the paper_title to set
	 */
	public void setPaper_title(String paper_title) {
		Paper_title = paper_title;
	}
	/**
	 * @return the paper_researchOne
	 */
	public String getPaper_researchOne() {
		return Paper_researchOne;
	}
	/**
	 * @param paper_researchOne the paper_researchOne to set
	 */
	public void setPaper_researchOne(String paper_researchOne) {
		Paper_researchOne = paper_researchOne;
	}
	/**
	 * @return the paper_researchTwo
	 */
	public String getPaper_researchTwo() {
		return Paper_researchTwo;
	}
	/**
	 * @param paper_researchTwo the paper_researchTwo to set
	 */
	public void setPaper_researchTwo(String paper_researchTwo) {
		Paper_researchTwo = paper_researchTwo;
	}
	/**
	 * @return the paper_researchThree
	 */
	public String getPaper_researchThree() {
		return Paper_researchThree;
	}
	/**
	 * @param paper_researchThree the paper_researchThree to set
	 */
	public void setPaper_researchThree(String paper_researchThree) {
		Paper_researchThree = paper_researchThree;
	}
	/**
	 * @return the paper_reason
	 */
	public String getPaper_reason() {
		return Paper_reason;
	}
	/**
	 * @param paper_reason the paper_reason to set
	 */
	public void setPaper_reason(String paper_reason) {
		Paper_reason = paper_reason;
	}
	/**
	 * @return the paper_repetitiveRateAll
	 */
	public float getPaper_repetitiveRateAll() {
		return Paper_repetitiveRateAll;
	}
	/**
	 * @param paper_repetitiveRateAll the paper_repetitiveRateAll to set
	 */
	public void setPaper_repetitiveRateAll(float paper_repetitiveRateAll) {
		Paper_repetitiveRateAll = paper_repetitiveRateAll;
	}
	/**
	 * @return the paper_repetitiveRateSingle
	 */
	public float getPaper_repetitiveRateSingle() {
		return Paper_repetitiveRateSingle;
	}
	/**
	 * @param paper_repetitiveRateSingle the paper_repetitiveRateSingle to set
	 */
	public void setPaper_repetitiveRateSingle(float paper_repetitiveRateSingle) {
		Paper_repetitiveRateSingle = paper_repetitiveRateSingle;
	}

	public String getPaper_ifPass() {
		return Paper_ifPass;
	}
	
	public void setPaper_ifPass(String paper_ifPass) {
		Paper_ifPass = paper_ifPass;
	}
	
	/**
	 * @return the paper_name
	 */
	public String getPaper_name() {
		return Paper_name;
	}
	/**
	 * @param paper_name the paper_name to set
	 */
	public void setPaper_name(String paper_name) {
		Paper_name = paper_name;
	}
	
	public int getPaper_ifSubmit() {
		return Paper_ifSubmit;
	}
	
	public void setPaper_ifSubmit(int paper_ifSubmit) {
		Paper_ifSubmit = paper_ifSubmit;
	}

}

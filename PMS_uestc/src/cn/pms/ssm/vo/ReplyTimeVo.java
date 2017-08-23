package cn.pms.ssm.vo;

/**
 * 显示学生答辩时间及最后结果的实体类
 * @author Administrator
 *
 */
public class ReplyTimeVo {
	
	private String Stu_id;
	private String Stu_name;
	private String Reply_time;
	private String Reply_result;
	
	public String getStu_id() {
		return Stu_id;
	}
	
	public void setStu_id(String stu_id) {
		Stu_id = stu_id;
	}
	
	public String getStu_name() {
		return Stu_name;
	}
	
	public void setStu_name(String stu_name) {
		Stu_name = stu_name;
	}
	
	public String getReply_time() {
		return Reply_time;
	}

	public void setReply_time(String reply_time) {
		Reply_time = reply_time;
	}

	public String getReply_result() {
		return Reply_result;
	}
	
	public void setReply_result(String reply_result) {
		Reply_result = reply_result;
	}
	
}

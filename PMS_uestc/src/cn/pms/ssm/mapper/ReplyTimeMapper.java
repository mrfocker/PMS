package cn.pms.ssm.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pms.ssm.po.Student;
import cn.pms.ssm.vo.ReplyTimeVo;

/**
 * 答辩时间的Mapper
 * @author HeXi
 *
 */
public interface ReplyTimeMapper {

	//找到所有学生的申请答辩时间
	List<Student> selectRequestTime();

	//更新学生的答辩申请时间
	void updateRequestReplyTime(@Param("stuId")String stuId,@Param("stuRequestReplyTime") String stuRequestReplyTime);

	//找到所有学术的答辩时间
	List<ReplyTimeVo> selectReplyTime();

	//更新学生的答辩时间
	void updateReplyTime(@Param("stuId")String stuId,@Param("stuReplyTime") Date stuReplyTime);

	//统一更新答辩时间
	void updateAllReplyTime(@Param("replyDate")Date replyDate);

}

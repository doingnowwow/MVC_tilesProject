package kr.or.ddit.user.reviewreply.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ReviewReplyVO;

public interface ReviewReplyService {
	public List<ReviewReplyVO> rrList(Map<String, String> params);
	
	public void insertReviewReply(ReviewReplyVO rrvo);
	
	public void deleteReviewReply(Map<String, String> params);

	public void updateReviewReply(ReviewReplyVO rrvo);
	
	public void insertReviewReReplyInfo(ReviewReplyVO rrInfo);
}

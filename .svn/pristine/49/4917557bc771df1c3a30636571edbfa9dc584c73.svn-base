package kr.or.ddit.user.reviewreply.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ReviewReplyVO;

public interface ReviewReplyDao {
	public List<ReviewReplyVO> rrList(Map<String, String> params) throws SQLException;
	
	public void insertReviewReply(ReviewReplyVO rrvo) throws SQLException;

	public void deleteReviewReply(Map<String, String> params) throws SQLException;

	public void updateReviewReply(ReviewReplyVO rrvo) throws SQLException;
	
	public void insertReviewReReplyInfo(ReviewReplyVO rrInfo) throws SQLException;
}

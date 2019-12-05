package kr.or.ddit.user.reviewreply.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.user.review.dao.ReviewDao;
import kr.or.ddit.user.review.dao.ReviewDaoImpl;
import kr.or.ddit.vo.ReviewReplyVO;

public class ReviewReplyDaoImpl implements ReviewReplyDao {
	private SqlMapClient client;
	
	private static ReviewReplyDao dao;
	
	public static ReviewReplyDao getInstance(){
		return (dao == null) ? dao = new ReviewReplyDaoImpl() : dao;
	}
	
	private ReviewReplyDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	@Override
	public List<ReviewReplyVO> rrList(Map<String, String> params) throws SQLException {
		return client.queryForList("review_reply.rrList", params);
	}

	@Override
	public void insertReviewReply(ReviewReplyVO rrvo) throws SQLException {
		client.insert("review_reply.insertReviewReply", rrvo);
	}

	@Override
	public void insertReviewReReplyInfo(ReviewReplyVO rrInfo)
			throws SQLException {
		try{
			client.startTransaction();
			String rr_seq;
			if(rrInfo.getRr_seq().intern() == "0".intern()){
				//현재의 댓글의 부모글이 루트글
				rr_seq = (String) client.queryForObject("review_reply.incrementSEQ", rrInfo);
			}else{
				//현재의 댓글의 부모글이 댓글
				client.update("review_reply.updateSEQ", rrInfo);
				rr_seq = String.valueOf(Integer.parseInt(rrInfo.getRr_seq()) + 1);
			}
			rrInfo.setRr_seq(rr_seq);
			
			String rr_depth = String.valueOf(Integer.parseInt(rrInfo.getRr_depth()) + 1);
			rrInfo.setRr_depth(rr_depth);;
			
			client.insert("review_reply.insertReviewReReply", rrInfo);
				
			client.commitTransaction();
		}finally{
			client.endTransaction();
		}		
	}

	@Override
	public void deleteReviewReply(Map<String, String> params)
			throws SQLException {
		client.update("review_reply.deleteReviewReply", params);
	}

	@Override
	public void updateReviewReply(ReviewReplyVO rrvo)
			throws SQLException {
		client.update("review_reply.updateReviewReply", rrvo);
	}

}

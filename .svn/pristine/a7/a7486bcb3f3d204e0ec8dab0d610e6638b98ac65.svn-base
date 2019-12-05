package kr.or.ddit.user.reviewreply.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.reviewreply.dao.ReviewReplyDao;
import kr.or.ddit.user.reviewreply.dao.ReviewReplyDaoImpl;
import kr.or.ddit.vo.ReviewReplyVO;

public class ReviewReplyServiceImpl implements ReviewReplyService {
	
	private static ReviewReplyService service = new ReviewReplyServiceImpl();
	
	private ReviewReplyDao dao;
	
	private ReviewReplyServiceImpl(){
		dao = ReviewReplyDaoImpl.getInstance();
	}
	
	public static ReviewReplyService getInstance(){
		return (service == null) ? service = new ReviewReplyServiceImpl() : service;
	}
	
	@Override
	public List<ReviewReplyVO> rrList(Map<String, String> params) {
		List<ReviewReplyVO> list = null;
		try {
			list = dao.rrList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void insertReviewReply(ReviewReplyVO rrvo) {
		try {
			dao.insertReviewReply(rrvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertReviewReReplyInfo(ReviewReplyVO rrInfo) {
		try {
			dao.insertReviewReReplyInfo(rrInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteReviewReply(Map<String, String> params) {
		try {
			dao.deleteReviewReply(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateReviewReply(ReviewReplyVO rrvo) {
		try {
			dao.updateReviewReply(rrvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

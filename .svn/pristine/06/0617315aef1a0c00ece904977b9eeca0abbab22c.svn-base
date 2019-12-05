package kr.or.ddit.user.review.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.ReviewVO;

public class ReviewDaoImpl implements ReviewDao {
	private SqlMapClient client;
	
	private static ReviewDao dao;
	
	public static ReviewDao getInstance(){
		return (dao == null) ? dao = new ReviewDaoImpl() : dao;
	}
	
	private ReviewDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}

	@Override
	public List<ReviewVO> reviewList(Map<String, String> params)
			throws SQLException {
		return client.queryForList("review.reviewList", params);
	}

	@Override
	public String totalCount(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("review.totalCount", params);
	}

	@Override
	public ReviewVO reviewInfo(Map<String, String> params) throws SQLException {
		client.update("review.updateHit", params);
		return (ReviewVO) client.queryForObject("review.reviewInfo", params);
	}

	@Override
	public String insertReviewInfo(ReviewVO reviewInfo, FileItem[] items)
			throws SQLException {
		return (String) client.insert("review.insertReview", reviewInfo);
	}

	@Override
	public void updateReviewInfo(ReviewVO reviewInfo) throws SQLException {
		client.update("review.updateReview", reviewInfo);
	}

	@Override
	public void deleteFreeboardInfo(Map<String, String> params)
			throws SQLException {
		client.update("review.deleteReview", params);
	}

}

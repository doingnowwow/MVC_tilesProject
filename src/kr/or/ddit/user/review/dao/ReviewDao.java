package kr.or.ddit.user.review.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.ReviewVO;

public interface ReviewDao {
	public List<ReviewVO> reviewList(Map<String, String> params) throws SQLException;
	
	public String totalCount(Map<String, String> params) throws SQLException;
	
	public ReviewVO reviewInfo(Map<String, String> params) throws SQLException;
	
	public String insertReviewInfo(ReviewVO reviewInfo, FileItem[] items) throws SQLException;
	
	public void updateReviewInfo(ReviewVO reviewInfo) throws SQLException;
	
	public void deleteFreeboardInfo(Map<String, String> params) throws SQLException;
}

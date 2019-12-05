package kr.or.ddit.user.reviewfile.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ReviewFileVO;

public interface ReviewFileDao {
	public void insertReviewFileInfo(List<ReviewFileVO> fileItemList) throws SQLException;
	
	public ReviewFileVO fileItemInfo(Map<String, String> params) throws SQLException;
}

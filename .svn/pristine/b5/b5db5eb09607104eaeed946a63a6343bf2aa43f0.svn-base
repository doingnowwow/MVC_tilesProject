package kr.or.ddit.user.reviewfile.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.ReviewFileVO;

public class ReviewFileDaoImpl implements ReviewFileDao {
	private SqlMapClient client;
	
	private static ReviewFileDao dao;
	
	public static ReviewFileDao getInstance(){
		return (dao == null) ? dao = new ReviewFileDaoImpl() : dao;
	}
	
	private ReviewFileDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	@Override
	public void insertReviewFileInfo(List<ReviewFileVO> fileItemList)
			throws SQLException {
		try{
			client.startTransaction();
			for(ReviewFileVO fileItemInfo : fileItemList){
				client.insert("reviewFile.insertReviewFile", fileItemInfo);
			}
			client.commitTransaction();
		}finally{
			client.endTransaction();
		}
	}

	@Override
	public ReviewFileVO fileItemInfo(Map<String, String> params)
			throws SQLException {
		return (ReviewFileVO) client.queryForObject("reviewFile.fileItemInfo", params);
	}

}

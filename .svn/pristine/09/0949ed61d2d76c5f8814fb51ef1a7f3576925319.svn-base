package kr.or.ddit.user.reviewfile.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.reviewfile.dao.ReviewFileDao;
import kr.or.ddit.user.reviewfile.dao.ReviewFileDaoImpl;
import kr.or.ddit.vo.ReviewFileVO;
import kr.or.ddit.vo.ReviewVO;

public class ReviewFileServiceImpl implements ReviewFileService {
	
	private static ReviewFileService service = new ReviewFileServiceImpl();
	
	private ReviewFileDao dao;
	
	private ReviewFileServiceImpl(){
		dao = ReviewFileDaoImpl.getInstance();
	}
	
	public static ReviewFileService getInstance(){
		return (service == null) ? service = new ReviewFileServiceImpl() : service;
	}
	
	@Override
	public void insertReviewFileInfo(List<ReviewVO> fileItemList) {
		// TODO Auto-generated method stub

	}

	@Override
	public ReviewFileVO fileItemInfo(Map<String, String> params) {
		ReviewFileVO vo = null;
		try {
			vo = dao.fileItemInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

}

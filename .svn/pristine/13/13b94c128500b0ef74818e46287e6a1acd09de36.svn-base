package kr.or.ddit.user.review.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.user.review.dao.ReviewDao;
import kr.or.ddit.user.review.dao.ReviewDaoImpl;
import kr.or.ddit.user.reviewfile.dao.ReviewFileDao;
import kr.or.ddit.user.reviewfile.dao.ReviewFileDaoImpl;
import kr.or.ddit.utiles.AttachFileMapper;
import kr.or.ddit.utiles.AttachFileMapper_ReviewFile;
import kr.or.ddit.vo.ReviewFileVO;
import kr.or.ddit.vo.ReviewVO;

public class ReviewServiceImpl implements ReviewService {
	private static ReviewService service = new ReviewServiceImpl();
	
	private ReviewDao reviewDao;
	private ReviewFileDao reviewfileDao;
	
	private ReviewServiceImpl(){
		reviewDao = ReviewDaoImpl.getInstance();
		reviewfileDao = ReviewFileDaoImpl.getInstance();
	}
	
	public static ReviewService getInstance(){
		return (service == null) ? service = new ReviewServiceImpl() : service;
	}

	@Override
	public List<ReviewVO> reviewList(Map<String, String> params) {
		List<ReviewVO> list = null;
		try {
			list = reviewDao.reviewList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String totalCount(Map<String, String> params) {
		String totalCount = "0";
		try {
			totalCount = reviewDao.totalCount(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCount;
	}

	@Override
	public ReviewVO reviewInfo(Map<String, String> params) {
		ReviewVO vo = new ReviewVO();
		try {
			vo = reviewDao.reviewInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public void insertReviewInfo(ReviewVO reviewInfo, FileItem[] items) {
		try {
			String review_no = reviewDao.insertReviewInfo(reviewInfo, items);
			
			List<ReviewFileVO> fileItemList = AttachFileMapper_ReviewFile.mapping(items, review_no);
			reviewfileDao.insertReviewFileInfo(fileItemList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateReviewInfo(ReviewVO reviewInfo) {
		try {
			reviewDao.updateReviewInfo(reviewInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteReviewInfo(Map<String, String> params) {
		try {
			reviewDao.deleteFreeboardInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

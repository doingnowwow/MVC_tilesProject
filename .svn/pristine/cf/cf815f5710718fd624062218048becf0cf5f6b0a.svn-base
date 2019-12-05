package kr.or.ddit.user.review.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.ReviewVO;

public interface ReviewService {
	public List<ReviewVO> reviewList(Map<String, String> params);
	
	public String totalCount(Map<String, String> params);
	
	public ReviewVO reviewInfo(Map<String, String> params);
	
	public void insertReviewInfo(ReviewVO reviewInfo, FileItem[] items);
	
	public void updateReviewInfo(ReviewVO reviewInfo);
	
	public void deleteReviewInfo(Map<String, String> params);
}

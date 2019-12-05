package kr.or.ddit.user.qna.service;

import java.util.List;
import java.util.Map;


import kr.or.ddit.vo.QnaVO;

import org.apache.commons.fileupload.FileItem;

public interface QnaService {

	
	public List<QnaVO> qnaList(Map<String,String> params);
	
	public void insertQna(QnaVO qnaInfo , FileItem[] items) ;
	
	public void updateQna(QnaVO qnaInfo);
	
	public void deleteQna(Map<String, String> params);
	
	public QnaVO qnaInfo(Map<String, String> params);
	
	public String totalCount(Map<String,String> params);
	
	public void insertQnaReplyInfo(QnaVO qnaInfo);
	
	
}

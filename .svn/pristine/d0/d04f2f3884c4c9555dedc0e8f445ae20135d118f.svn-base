package kr.or.ddit.user.qna.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.QnaVO;

import org.apache.commons.fileupload.FileItem;

public interface QnaDao {
	
	//리스트 전체출력
	public List<QnaVO> qnaList(Map<String, String> params) throws SQLException;

	//글추가
	public String insertQna(QnaVO qnaInfo, FileItem[] items) throws SQLException;

	//글수정
	public void updateQna(QnaVO qnaInfo) throws SQLException;

	//글삭제
	public void deleteQna(Map<String, String> params) throws SQLException;

	//글상세
	public QnaVO qnaInfo(Map<String, String> params) throws SQLException;

	//조회수
	public String totalCount(Map<String, String> params) throws SQLException;

	
	//답글추가
	public void insertQnaReplyInfo(QnaVO qnaInfo) throws SQLException;

}

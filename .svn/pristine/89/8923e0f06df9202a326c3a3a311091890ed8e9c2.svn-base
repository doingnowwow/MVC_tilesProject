package kr.or.ddit.user.qna.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.qna.dao.QnaDao;
import kr.or.ddit.user.qna.dao.QnaDaoImpl;
import kr.or.ddit.user.qnafile.AttachFileMapper;
import kr.or.ddit.user.qnafile.dao.QnaFileDao;
import kr.or.ddit.user.qnafile.dao.QnaFileDaoImpl;
import kr.or.ddit.vo.QnaFileVO;
import kr.or.ddit.vo.QnaVO;

import org.apache.commons.fileupload.FileItem;

public class QnaServiceImpl implements QnaService {
	
	private static QnaServiceImpl service = new QnaServiceImpl();
	
	private QnaDao qnaDao;
	private QnaFileDao fileDao;
	
	
	public QnaServiceImpl(){
		qnaDao = QnaDaoImpl.getInstance();
		fileDao = QnaFileDaoImpl.getInstance();
	}
	
	public static QnaServiceImpl getInstance(){
		return  (service == null) ? service = new QnaServiceImpl() : service;
				
	
	}
	
	

	@Override
	public List<QnaVO> qnaList(Map<String, String> params) {
		List<QnaVO> qnaList = null;
		try {
			qnaList = qnaDao.qnaList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qnaList;
	}

	@Override
	public void insertQna(QnaVO qnaInfo, FileItem[] items) {
		
		try {
			String qna_no = qnaDao.insertQna(qnaInfo, items);
			
			List<QnaFileVO> fileItemList = AttachFileMapper.mapping(items, qna_no);
			
			fileDao.insertFileitemInfo(fileItemList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

	}

	@Override
	public void updateQna(QnaVO qnaInfo) {
		try {
			qnaDao.updateQna(qnaInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteQna(Map<String, String> params) {
		try {
			qnaDao.deleteQna(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public QnaVO qnaInfo(Map<String, String> params) {
		QnaVO qnaInfo = null;
		
		try {
			qnaInfo = qnaDao.qnaInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qnaInfo;
	}

	@Override
	public String totalCount(Map<String, String> params) {
		String totalCount ="0";
		
		
		try {			
			totalCount = qnaDao.totalCount(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return totalCount;
	}

	@Override
	public void insertQnaReplyInfo(QnaVO qnaInfo) {

		try {
			qnaDao.insertQnaReplyInfo(qnaInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

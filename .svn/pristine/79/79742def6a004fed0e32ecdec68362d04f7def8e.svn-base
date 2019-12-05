package kr.or.ddit.user.qnafile.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.qnafile.dao.QnaFileDao;
import kr.or.ddit.user.qnafile.dao.QnaFileDaoImpl;
import kr.or.ddit.vo.QnaFileVO;

public class QnaFileServiceImpl implements QnaFileService {
	
	private static QnaFileService service = new QnaFileServiceImpl();
	
	private QnaFileDao dao;
	
	private QnaFileServiceImpl(){
		
		dao = QnaFileDaoImpl.getInstance();
	}
	
	public static QnaFileService getInstance(){
		
		return (service == null) ? service = new QnaFileServiceImpl(): service; 
	}
	

	@Override
	public void insertFileitemInfo(List<QnaFileVO> fileItemList) {
		// TODO IFileItemServiceImpl 에서 IFileItemDaoImpl의 해당 메서드 호출시 작성 예약
	}

	@Override
	public QnaFileVO fileItemInfo(Map<String, String> params) {
		
		QnaFileVO  fileIntemInfo = null;
		
		try {
			fileIntemInfo = dao.fileItemInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return fileIntemInfo;
	}

}

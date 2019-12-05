package kr.or.ddit.user.noticefile.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.noticefile.dao.NoticeFileDao;
import kr.or.ddit.user.noticefile.dao.NoticeFileDaoImpl;
import kr.or.ddit.vo.NoticeFileVO;

public class NoticeFileServiceImpl implements NoticeFileService {
	
	private static NoticeFileService service = new NoticeFileServiceImpl();
	private NoticeFileDao dao;
	
	private NoticeFileServiceImpl(){
		
		dao = NoticeFileDaoImpl.getInstance();
	}
	
	public static NoticeFileService getInstance(){
		
		return (service == null) ? service = new NoticeFileServiceImpl(): service; 
	}

	@Override
	public void insertFileitemInfo(List<NoticeFileVO> fileItemList) {
		// IFileItemServiceImpl에서 IFileItemDaoImpl의 해당 메서드 호출 시 작성 예약

	}

	@Override
	public NoticeFileVO fileItemInfo(Map<String, String> params) {
		NoticeFileVO fileItemInfo = null;
		try {
			fileItemInfo = dao.fileItemInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fileItemInfo;
	}
	


}

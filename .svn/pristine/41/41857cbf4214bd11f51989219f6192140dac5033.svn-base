package kr.or.ddit.user.eventfile.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.eventfile.dao.EventFileDao;
import kr.or.ddit.user.eventfile.dao.EventFileDaoImpl;
import kr.or.ddit.vo.EventFileVO;

public class EventFileServiceImpl implements EventFileService {
	
	private static EventFileService service = new EventFileServiceImpl();
	private EventFileDao dao;
	
	private EventFileServiceImpl(){
		
		dao = EventFileDaoImpl.getInstance();
	}
	
	public static EventFileService getInstance(){
		
		return (service == null) ? service = new EventFileServiceImpl(): service; 
	}

	@Override
	public void insertFileitemInfo(List<EventFileVO> fileItemList) {
		// IFileItemServiceImpl에서 IFileItemDaoImpl의 해당 메서드 호출 시 작성 예약

	}

	@Override
	public EventFileVO fileItemInfo(Map<String, String> params) {
		EventFileVO fileItemInfo = null;
		try {
			fileItemInfo = dao.fileItemInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fileItemInfo;
	}
	


}

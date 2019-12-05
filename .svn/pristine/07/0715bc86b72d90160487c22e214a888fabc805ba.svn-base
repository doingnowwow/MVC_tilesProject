package kr.or.ddit.user.event.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.event.dao.EventDao;
import kr.or.ddit.user.event.dao.EventDaoImpl;
import kr.or.ddit.user.eventfile.AttachFileMapper;
import kr.or.ddit.user.eventfile.dao.EventFileDao;
import kr.or.ddit.user.eventfile.dao.EventFileDaoImpl;
import kr.or.ddit.vo.EventFileVO;
import kr.or.ddit.vo.EventVO;

import org.apache.commons.fileupload.FileItem;

public class EventServiceImpl implements EventService {
	private static EventServiceImpl service = new EventServiceImpl();
	private EventDao eventDao;
	private EventFileDao fileDao; 
 
	
	private EventServiceImpl(){
		eventDao = EventDaoImpl.getInstance();
		fileDao = EventFileDaoImpl.getInstance(); 
	}

	public static EventServiceImpl getInstance(){
		return (service == null) ? service = new EventServiceImpl() : service;
	}

	@Override
	public List<EventVO> eventList(Map<String, String> params) {
		List<EventVO> eventList = null;
		try {
			eventList = eventDao.eventList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventList;
	}

	@Override
	public EventVO eventInfo(Map<String, String> params) {
		EventVO eventInfo = null;
		try {
			eventInfo = eventDao.eventInfo(params);
		} catch (SQLException e) {
		}
		return eventInfo;
	}

	@Override
	public void insertEventInfo(EventVO eventInfo, FileItem[] items) {
		try {
			String event_no = eventDao.insertEventInfo(eventInfo, items);
			List<EventFileVO> fileItemList = AttachFileMapper.mapping(items, event_no);
			fileDao.insertFileitemInfo(fileItemList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateEventInfo(EventVO eventInfo) {
		try {
			eventDao.updateEventInfo(eventInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEventInfo(Map<String, String> params) {
		try {
			eventDao.deleteEventInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	

	@Override
	public String totalCount(Map<String, String> params) {
		String totalCount = "0";
		try {
			totalCount = eventDao.totalCount(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return totalCount;
	}


}

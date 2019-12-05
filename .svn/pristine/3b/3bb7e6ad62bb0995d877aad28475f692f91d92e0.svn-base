package kr.or.ddit.user.event.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.EventVO;

import org.apache.commons.fileupload.FileItem;

import com.ibatis.sqlmap.client.SqlMapClient;

public class EventDaoImpl implements EventDao{
	private static EventDaoImpl dao = new EventDaoImpl();
	private SqlMapClient client;
	
	private EventDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	public static EventDao getInstance(){
		return (dao == null) ? dao = new EventDaoImpl() : dao;
	}
	@Override
	public List<EventVO> eventList(Map<String, String> params) throws SQLException {
		return client.queryForList("event.eventList", params);
	}
	@Override 
	public EventVO eventInfo(Map<String, String> params) throws SQLException {
		client.update("event.updateEventHIT", params);
		return (EventVO) client.queryForObject("event.eventInfo", params);
	}
	@Override
	public String insertEventInfo(EventVO eventInfo, FileItem[] items) throws SQLException {
		return (String) client.insert("event.insertEventInfo", eventInfo);
	}
	@Override
	public void updateEventInfo(EventVO eventInfo) throws SQLException {
		client.update("event.updateEventInfo", eventInfo);
	}
	@Override
	public void deleteEventInfo(Map<String, String> params) throws SQLException {
		client.update("event.deleteEventInfo", params);
	}
	@Override
	public String totalCount(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("event.totalCount", params);
	}



}

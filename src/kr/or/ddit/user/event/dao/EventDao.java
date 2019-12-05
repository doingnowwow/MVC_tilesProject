package kr.or.ddit.user.event.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.EventVO;

import org.apache.commons.fileupload.FileItem;

public interface EventDao {
	
	public List<EventVO> eventList(Map<String, String> params) throws SQLException;
	public EventVO eventInfo(Map<String, String> params) throws SQLException;

	public String insertEventInfo(EventVO eventInfo, FileItem[] items) throws SQLException;
	public void updateEventInfo(EventVO eventInfo) throws SQLException;
	public void deleteEventInfo(Map<String, String> params) throws SQLException;

	public String totalCount(Map<String, String> params) throws SQLException;
}

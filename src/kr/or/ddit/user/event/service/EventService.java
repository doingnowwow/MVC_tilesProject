package kr.or.ddit.user.event.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.EventVO;

import org.apache.commons.fileupload.FileItem;

public interface EventService {
	
	public List<EventVO> eventList(Map<String, String> params);
	public EventVO eventInfo(Map<String, String> params);

	public void insertEventInfo(EventVO eventInfo, FileItem[] items);
	public void updateEventInfo(EventVO eventInfo);
	public void deleteEventInfo(Map<String, String> params);

	public String totalCount(Map<String, String> params);
}

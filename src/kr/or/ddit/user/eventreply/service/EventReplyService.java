package kr.or.ddit.user.eventreply.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.EventReplyVO;

public interface EventReplyService {

	public List<EventReplyVO> erList(Map<String, String> params);
	public void insertEventReply(EventReplyVO ervo);
	public void deleteEventReply(Map<String, String> params);
	public void updateEventReply(EventReplyVO ervo);
	public void insertEventReReplyInfo(EventReplyVO erInfo);
}

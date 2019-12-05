package kr.or.ddit.user.eventreply.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.eventreply.dao.EventReplyDao;
import kr.or.ddit.user.eventreply.dao.EventReplyDaoImpl;
import kr.or.ddit.vo.EventReplyVO;

public class EventReplyServiceImpl implements EventReplyService {

	private static EventReplyService service = new EventReplyServiceImpl();

	private EventReplyDao dao;

	private EventReplyServiceImpl() {
		dao = EventReplyDaoImpl.getInstance();
	}

	public static EventReplyService getInstance() {
		return (service == null) ? service = new EventReplyServiceImpl()
				: service;
	}

	@Override
	public List<EventReplyVO> erList(Map<String, String> params) {
		List<EventReplyVO> list = null;
		try {
			list = dao.erList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void insertEventReply(EventReplyVO ervo) {
		try {
			dao.insertEventReply(ervo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEventReply(Map<String, String> params) {
		try {
			dao.deleteEventReply(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateEventReply(EventReplyVO ervo) {
		try {
			dao.updateEventReply(ervo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertEventReReplyInfo(EventReplyVO erInfo) {
		try {
			dao.insertEventReReplyInfo(erInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

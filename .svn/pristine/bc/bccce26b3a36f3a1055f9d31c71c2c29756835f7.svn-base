package kr.or.ddit.user.eventreply.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.user.review.dao.ReviewDao;
import kr.or.ddit.user.review.dao.ReviewDaoImpl;
import kr.or.ddit.vo.EventReplyVO;
import kr.or.ddit.vo.ReviewReplyVO;

public class EventReplyDaoImpl implements EventReplyDao {
	private SqlMapClient client;

	private static EventReplyDao dao;

	public static EventReplyDao getInstance() {
		return (dao == null) ? dao = new EventReplyDaoImpl() : dao;
	}

	private EventReplyDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}

	@Override
	public List<EventReplyVO> erList(Map<String, String> params)
			throws SQLException {
		return client.queryForList("event_reply.erList", params);
	}

	@Override
	public void insertEventReply(EventReplyVO ervo) throws SQLException {
		client.insert("event_reply.insertEventReply", ervo);

	}

	@Override
	public void deleteEventReply(Map<String, String> params)
			throws SQLException {
		client.update("event_reply.deleteEventReply", params);
	}

	@Override
	public void updateEventReply(EventReplyVO ervo) throws SQLException {
		client.update("event_reply.updateEventReply", ervo);

	}

	@Override
	public void insertEventReReplyInfo(EventReplyVO erInfo) throws SQLException {
		try {
			client.startTransaction();
			String rr_seq;
			if (erInfo.getEr_seq().intern() == "0".intern()) {
				// 현재의 댓글의 부모글이 루트글
				rr_seq = (String) client.queryForObject(
						"event_reply.incrementSEQ", erInfo);
			} else {
				// 현재의 댓글의 부모글이 댓글
				client.update("event_reply.updateSEQ", erInfo);
				rr_seq = String
						.valueOf(Integer.parseInt(erInfo.getEr_seq()) + 1);
			}
			erInfo.setEr_seq(rr_seq);

			String rr_depth = String.valueOf(Integer.parseInt(erInfo
					.getEr_depth()) + 1);
			erInfo.setEr_depth(rr_depth);
			;

			client.insert("event_reply.insertEventReReply", erInfo);

			client.commitTransaction();
		} finally {
			client.endTransaction();
		}
	}

}

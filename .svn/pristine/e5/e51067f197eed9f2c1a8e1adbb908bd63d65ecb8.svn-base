package kr.or.ddit.user.eventfile.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.EventFileVO;

import com.ibatis.sqlmap.client.SqlMapClient;

public class EventFileDaoImpl implements EventFileDao {

	private static EventFileDao dao = new EventFileDaoImpl();
	private SqlMapClient client;

	private EventFileDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}

	public static EventFileDao getInstance() {
		return (dao == null) ? dao = new EventFileDaoImpl() : dao;
	}

	@Override
	public void insertFileitemInfo(List<EventFileVO> fileItemList)
			throws SQLException {
		try {
			client.startTransaction();
			for (EventFileVO fileItemInfo : fileItemList) {
					client.insert("eventfile.insertFileItem", fileItemInfo);
			}
			client.commitTransaction();
		} finally {
			client.endTransaction();
		}
	}

	@Override
	public EventFileVO fileItemInfo(Map<String, String> params)
			throws SQLException {
		return (EventFileVO) client.queryForObject("eventfile.fileItemInfo", params);
	}

}

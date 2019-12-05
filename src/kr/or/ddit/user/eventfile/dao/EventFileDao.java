package kr.or.ddit.user.eventfile.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.EventFileVO;

public interface EventFileDao {
	
	public void insertFileitemInfo(List<EventFileVO> fileItemList) throws SQLException;
	public EventFileVO fileItemInfo(Map<String, String> params) throws SQLException;

}

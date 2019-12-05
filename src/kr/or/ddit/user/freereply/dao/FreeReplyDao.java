package kr.or.ddit.user.freereply.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.FreeReplyVO;


public interface FreeReplyDao {
	public List<FreeReplyVO> rrList(Map<String, String> params) throws SQLException;
	
	public void insertFreeReply(FreeReplyVO rrvo) throws SQLException;

	public void deleteFreeReply(Map<String, String> params) throws SQLException;

	public void updateFreeReply(FreeReplyVO rrvo) throws SQLException;
	
	public void insertFreeReReplyInfo(FreeReplyVO rrInfo) throws SQLException;
}

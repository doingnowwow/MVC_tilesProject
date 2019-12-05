package kr.or.ddit.user.freereply.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.user.review.dao.ReviewDao;
import kr.or.ddit.user.review.dao.ReviewDaoImpl;
import kr.or.ddit.vo.FreeReplyVO;
import kr.or.ddit.vo.ReviewReplyVO;

public class FreeReplyDaoImpl implements FreeReplyDao {
	private SqlMapClient client;
	
	private static FreeReplyDao dao;
	
	public static FreeReplyDao getInstance(){
		return (dao == null) ? dao = new FreeReplyDaoImpl() : dao;
	}
	
	private FreeReplyDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	@Override
	public List<FreeReplyVO> rrList(Map<String, String> params) throws SQLException {
		return client.queryForList("free_reply.rrList", params);
	}

	@Override
	public void insertFreeReply(FreeReplyVO rrvo) throws SQLException {
		client.insert("free_reply.insertFreeReply", rrvo);
	}

	@Override
	public void insertFreeReReplyInfo(FreeReplyVO rrInfo)
			throws SQLException {
		try{
			client.startTransaction();
			String fr_seq;
			if(rrInfo.getFr_seq().intern() == "0".intern()){
				//현재의 댓글의 부모글이 루트글
				fr_seq = (String) client.queryForObject("free_reply.incrementSEQ", rrInfo);
			}else{
				//현재의 댓글의 부모글이 댓글
				client.update("free_reply.updateSEQ", rrInfo);
				fr_seq = String.valueOf(Integer.parseInt(rrInfo.getFr_seq()) + 1);
			}
			rrInfo.setFr_seq(fr_seq);
			
			String fr_depth = String.valueOf(Integer.parseInt(rrInfo.getFr_depth()) + 1);
			rrInfo.setFr_depth(fr_depth);
			
			client.insert("free_reply.insertFreeReReply", rrInfo);
				
			client.commitTransaction();
		}finally{
			client.endTransaction();
		}		
	}

	@Override
	public void deleteFreeReply(Map<String, String> params)
			throws SQLException {
		client.update("free_reply.deleteFreeReply", params);
	}

	@Override
	public void updateFreeReply(FreeReplyVO rrvo)
			throws SQLException {
		client.update("free_reply.updateFreeReply", rrvo);
	}

}

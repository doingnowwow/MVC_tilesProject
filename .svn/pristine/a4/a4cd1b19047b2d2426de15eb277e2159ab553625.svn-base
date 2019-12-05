package kr.or.ddit.user.freereply.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.freereply.dao.FreeReplyDao;
import kr.or.ddit.user.freereply.dao.FreeReplyDaoImpl;
import kr.or.ddit.vo.FreeReplyVO;

public class FreeReplyServiceImpl implements FreeReplyService {
	
	private static FreeReplyService service = new FreeReplyServiceImpl();
	
	private FreeReplyDao dao;
	
	private FreeReplyServiceImpl(){
		dao = FreeReplyDaoImpl.getInstance();
	}
	
	public static FreeReplyService getInstance(){
		return (service == null) ? service = new FreeReplyServiceImpl() : service;
	}
	
	@Override
	public List<FreeReplyVO> rrList(Map<String, String> params) {
		List<FreeReplyVO> list = null;
		try {
			list = dao.rrList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void insertFreeReply(FreeReplyVO rrvo) {
		try {
			dao.insertFreeReply(rrvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertFreeReReplyInfo(FreeReplyVO rrInfo) {
		try {
			dao.insertFreeReReplyInfo(rrInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteFreeReply(Map<String, String> params) {
		try {
			dao.deleteFreeReply(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateFreeReply(FreeReplyVO rrvo) {
		try {
			dao.updateFreeReply(rrvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

package kr.or.ddit.user.notice.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.NoticeVO;

import org.apache.commons.fileupload.FileItem;

import com.ibatis.sqlmap.client.SqlMapClient;

public class NoticeDaoImpl implements NoticeDao{ 
	private static NoticeDaoImpl dao = new NoticeDaoImpl();
	private SqlMapClient client;
	
	private NoticeDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	public static NoticeDao getInstance(){
		return (dao == null) ? dao = new NoticeDaoImpl() : dao;
	}
	@Override 
	public List<NoticeVO> noticeList(Map<String, String> params) throws SQLException {
		return client.queryForList("notice.noticeList", params);
	}
	@Override
	public NoticeVO noticeInfo(Map<String, String> params) throws SQLException {
		client.update("notice.updateNoticeHIT", params);
		return (NoticeVO) client.queryForObject("notice.noticeInfo", params);
		
	}
	
	@Override
	public String insertNoticeInfo(NoticeVO noticeInfo, FileItem[] items) throws SQLException {
		return (String) client.insert("notice.insertNoticeInfo", noticeInfo);
	}
	
	@Override
	public void updateNoticeInfo(NoticeVO noticeInfo) throws SQLException {
		client.update("notice.updateNoticeInfo", noticeInfo);
	
	}
	@Override
	public void deleteNoticeInfo(Map<String, String> params) throws SQLException {
		client.update("notice.deleteNoticeInfo", params);
	}
	@Override
	public String totalCount(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("notice.totalCount", params);
	}
	

}

package kr.or.ddit.user.notice.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.NoticeVO;

public interface NoticeDao {
	public List<NoticeVO> noticeList(Map<String, String> params) throws SQLException;
	public NoticeVO noticeInfo(Map<String, String> params)throws SQLException;

	public String insertNoticeInfo(NoticeVO noticeInfo, FileItem[] items) throws SQLException;
	public void updateNoticeInfo(NoticeVO noticeInfo) throws SQLException;
	public void deleteNoticeInfo(Map<String, String> params) throws SQLException;

	public String totalCount(Map<String, String> params) throws SQLException;

}

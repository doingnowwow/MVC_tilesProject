package kr.or.ddit.user.notice.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.notice.dao.NoticeDao;
import kr.or.ddit.user.notice.dao.NoticeDaoImpl;
import kr.or.ddit.user.noticefile.AttachFileMapper;
import kr.or.ddit.user.noticefile.dao.NoticeFileDao;
import kr.or.ddit.user.noticefile.dao.NoticeFileDaoImpl;
import kr.or.ddit.vo.NoticeFileVO;
import kr.or.ddit.vo.NoticeVO;

import org.apache.commons.fileupload.FileItem;

public class NoticeServiceImpl implements NoticeService{
	private static NoticeServiceImpl service = new NoticeServiceImpl();
	private NoticeDao noticeDao;
	private NoticeFileDao fileDao;
	
	private NoticeServiceImpl(){
		noticeDao = NoticeDaoImpl.getInstance();
		fileDao = NoticeFileDaoImpl.getInstance(); 
	}

	public static NoticeServiceImpl getInstance(){
		return (service == null) ? service = new NoticeServiceImpl() : service;
	}
	
	
	
	@Override
	public List<NoticeVO> noticeList(Map<String, String> params) {
		List<NoticeVO> noticeList = null;
		try {
			noticeList = noticeDao.noticeList(params);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return noticeList;
	}

	@Override
	public NoticeVO noticeInfo(Map<String, String> params) {
		NoticeVO noticeInfo = null;
		try {
			noticeInfo = noticeDao.noticeInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return noticeInfo;
	}

	@Override
	public void insertNoticeInfo(NoticeVO noticeInfo, FileItem[] items) {
		try {
			String notice_no = noticeDao.insertNoticeInfo(noticeInfo, items);
			List<NoticeFileVO> fileItemList = AttachFileMapper.mapping(items, notice_no);
			fileDao.insertFileitemInfo(fileItemList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateNoticeInfo(NoticeVO noticeInfo) {
	try {
		noticeDao.updateNoticeInfo(noticeInfo);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	}

	@Override
	public void deleteNoticeInfo(Map<String, String> params) {
		try {
			noticeDao.deleteNoticeInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public String totalCount(Map<String, String> params) {
		String totalCount = "0";
		try {
			totalCount = noticeDao.totalCount(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return totalCount;
	}


}

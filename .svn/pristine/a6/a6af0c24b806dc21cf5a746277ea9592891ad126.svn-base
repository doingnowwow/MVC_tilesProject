package kr.or.ddit.user.notice.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.NoticeVO;

import org.apache.commons.fileupload.FileItem;

public interface NoticeService {
	public List<NoticeVO> noticeList(Map<String, String> params);
	public NoticeVO noticeInfo(Map<String, String> params);

	public void insertNoticeInfo(NoticeVO noticeInfo, FileItem[] items);
	public void updateNoticeInfo(NoticeVO noticeInfo);
	public void deleteNoticeInfo(Map<String, String> params);

	public String totalCount(Map<String, String> params);

}

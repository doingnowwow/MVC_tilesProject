package kr.or.ddit.admin.notice.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.notice.service.NoticeService;
import kr.or.ddit.user.notice.service.NoticeServiceImpl;
import kr.or.ddit.vo.NoticeVO;

public class NoticeViewAction implements IAction{
private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}
 
	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		String notice_no = request.getParameter("notice_no");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("notice_no", notice_no);
		
		NoticeService service = NoticeServiceImpl.getInstance();
//		NoticeFileService fileService = NoticeFileServiceImpl.getInstance();
		
		NoticeVO noticeInfo = service.noticeInfo(params);
//		NoticeFileVO noticeFileInfo = fileService.fileItemInfo(params);
		
		request.setAttribute("noticeInfo", noticeInfo);
//		request.setAttribute("noticeFileInfo", noticeFileInfo);
		

		return "/admin/notice/noticeView.tiles";
	}
}

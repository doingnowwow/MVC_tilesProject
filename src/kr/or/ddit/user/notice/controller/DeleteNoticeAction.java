package kr.or.ddit.user.notice.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.notice.service.NoticeService;
import kr.or.ddit.user.notice.service.NoticeServiceImpl;

public class DeleteNoticeAction implements IAction{
private boolean redirectFlag = true;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		String notice_no = request.getParameter("notice_no");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("notice_no", notice_no);
		
		NoticeService service = NoticeServiceImpl.getInstance();
		service.deleteNoticeInfo(params);
		
		
		return "/user/notice/noticeList.do";
	}

}

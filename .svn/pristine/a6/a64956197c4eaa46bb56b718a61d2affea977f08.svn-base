package kr.or.ddit.admin.notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.notice.service.NoticeService;
import kr.or.ddit.user.notice.service.NoticeServiceImpl;
import kr.or.ddit.vo.NoticeVO;

public class NoticeFormAction implements IAction{
private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		Map<String, String> params = new HashMap<String, String>();
		NoticeService service = NoticeServiceImpl.getInstance();
		List<NoticeVO> noticeList = service.noticeList(params);
		
		request.setAttribute("noticeList", noticeList);

		return "/admin/notice/noticeForm.tiles";
	}
} 

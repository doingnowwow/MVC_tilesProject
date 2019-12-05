package kr.or.ddit.user.event.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.event.service.EventService;
import kr.or.ddit.user.event.service.EventServiceImpl;
import kr.or.ddit.user.eventreply.service.EventReplyService;
import kr.or.ddit.user.eventreply.service.EventReplyServiceImpl;
import kr.or.ddit.user.freereply.service.FreeReplyService;
import kr.or.ddit.user.freereply.service.FreeReplyServiceImpl;
import kr.or.ddit.vo.EventReplyVO;
import kr.or.ddit.vo.EventVO;
import kr.or.ddit.vo.FreeReplyVO;

public class EventViewAction implements IAction{
	private boolean redirectFlag = false;

	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		String event_no = request.getParameter("event_no");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("event_no", event_no);
		
		EventService service = EventServiceImpl.getInstance();
		EventVO eventInfo = service.eventInfo(params);
		
		EventReplyService fservice = EventReplyServiceImpl.getInstance();
		List<EventReplyVO> erList = fservice.erList(params);
		
		
		request.setAttribute("eventInfo", eventInfo);
		request.setAttribute("erList", erList);


		return "/user/event/eventView.tiles";
	}
}

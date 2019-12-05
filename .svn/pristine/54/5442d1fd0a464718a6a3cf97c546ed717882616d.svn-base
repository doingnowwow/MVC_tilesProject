package kr.or.ddit.user.eventreply.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.eventreply.service.EventReplyService;
import kr.or.ddit.user.eventreply.service.EventReplyServiceImpl;

public class DeleteEventReplyAction implements IAction{
	private boolean redirectFlag = true;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		String er_no = request.getParameter("er_no");

		Map<String, String> params = new HashMap<String, String>();
		params.put("er_no", er_no);
		
		EventReplyService service = EventReplyServiceImpl.getInstance();
		service.deleteEventReply(params);
		
		return "/user/event/eventList.do";	
	}

}

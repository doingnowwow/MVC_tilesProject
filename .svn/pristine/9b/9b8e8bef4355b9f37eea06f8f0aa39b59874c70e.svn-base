package kr.or.ddit.user.event.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.event.service.EventService;
import kr.or.ddit.user.event.service.EventServiceImpl;

public class DeleteEventAction implements IAction {
	private boolean redirectFlag = true;

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
		service.deleteEventInfo(params);

		return "/user/event/eventList.do";

	}

}

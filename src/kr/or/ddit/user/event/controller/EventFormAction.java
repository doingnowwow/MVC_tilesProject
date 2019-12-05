package kr.or.ddit.user.event.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.event.service.EventService;
import kr.or.ddit.user.event.service.EventServiceImpl;
import kr.or.ddit.vo.EventVO;

public class EventFormAction implements IAction {
	private boolean redirectFlag = false;

	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, String> params = new HashMap<String, String>();
		EventService service = EventServiceImpl.getInstance();
		List<EventVO> eventList = service.eventList(params);

		request.setAttribute("eventList", eventList);

		return "/user/event/eventForm.tiles";
	}

}

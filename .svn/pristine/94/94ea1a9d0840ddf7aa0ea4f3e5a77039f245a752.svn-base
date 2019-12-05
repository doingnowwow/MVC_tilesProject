package kr.or.ddit.user.eventreply.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.eventreply.service.EventReplyService;
import kr.or.ddit.user.eventreply.service.EventReplyServiceImpl;
import kr.or.ddit.vo.EventReplyVO;

import org.apache.commons.beanutils.BeanUtils;

public class UpdateEventReplyAction implements IAction{
	private boolean redirectFlag = true;

	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		EventReplyVO erInfo = new EventReplyVO();
		
		try {
			BeanUtils.populate(erInfo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		EventReplyService service = EventReplyServiceImpl.getInstance();
		service.updateEventReply(erInfo);
		
		return "/user/event/eventView.do"; 
	}
}

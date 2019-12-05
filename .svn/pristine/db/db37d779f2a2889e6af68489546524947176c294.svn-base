package kr.or.ddit.user.event.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.event.service.EventService;
import kr.or.ddit.user.event.service.EventServiceImpl;
import kr.or.ddit.utiles.FileUploadRequestWrapper;
import kr.or.ddit.vo.EventVO;

import org.apache.commons.beanutils.BeanUtils;

public class InsertEventAction implements IAction {
	private boolean redirectFlag = true;

	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		FileUploadRequestWrapper wrapper = (FileUploadRequestWrapper) request;

		EventVO eventInfo = new EventVO();

		try {
			try {
				BeanUtils.populate(eventInfo, request.getParameterMap());
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			} catch (InvocationTargetException e) {
			e.printStackTrace();
			}

		EventService service = EventServiceImpl.getInstance();
		service.insertEventInfo(eventInfo, wrapper.getFileItemValues("files"));

		return "/user/event/eventList.do";
	}

}

package kr.or.ddit.user.freereply.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.freereply.service.FreeReplyService;
import kr.or.ddit.user.freereply.service.FreeReplyServiceImpl;
import kr.or.ddit.user.reviewreply.service.ReviewReplyService;
import kr.or.ddit.user.reviewreply.service.ReviewReplyServiceImpl;
import kr.or.ddit.vo.FreeReplyVO;
import kr.or.ddit.vo.ReviewReplyVO;

public class InsertFreeReplyAction implements IAction {
	private boolean redirectFlag = true;

	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		FreeReplyVO rrInfo = new FreeReplyVO();
		
		try {
			BeanUtils.populate(rrInfo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		FreeReplyService service = FreeReplyServiceImpl.getInstance();
		service.insertFreeReply(rrInfo);
		
		return "/user/freeboard/freeboardList.do";
	}
}

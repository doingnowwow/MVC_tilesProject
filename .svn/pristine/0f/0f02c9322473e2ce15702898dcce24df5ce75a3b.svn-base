package kr.or.ddit.user.freereply.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.freereply.service.FreeReplyService;
import kr.or.ddit.user.freereply.service.FreeReplyServiceImpl;
import kr.or.ddit.user.reviewreply.service.ReviewReplyService;
import kr.or.ddit.user.reviewreply.service.ReviewReplyServiceImpl;

public class DeleteFreeReplyAction implements IAction {
	private boolean redirectFlag = true;

	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		String fr_no = request.getParameter("fr_no");

		Map<String, String> params = new HashMap<String, String>();
		params.put("fr_no", fr_no);
		
		FreeReplyService service = FreeReplyServiceImpl.getInstance();
		service.deleteFreeReply(params);
		
		return "/user/freeboard/freeboardList.do";	
	}

}

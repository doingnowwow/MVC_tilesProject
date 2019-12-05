package kr.or.ddit.user.freeboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.freeboard.service.FreeService;
import kr.or.ddit.user.freeboard.service.FreeServiceImpl;
import kr.or.ddit.user.freereply.service.FreeReplyService;
import kr.or.ddit.user.freereply.service.FreeReplyServiceImpl;
import kr.or.ddit.vo.FreeReplyVO;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.ReviewReplyVO;

public class FreeboardViewAction implements IAction {

	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		String free_no = request.getParameter("free_no");

		Map<String, String> params = new HashMap<String, String>();
		params.put("free_no", free_no);
		
		FreeService service = FreeServiceImpl.getInstance();
		FreeVO freeInfo = service.freeInfo(params);
		
		FreeReplyService fservice = FreeReplyServiceImpl.getInstance();
		List<FreeReplyVO> rrList = fservice.rrList(params);
		
		request.setAttribute("freeInfo", freeInfo);
		request.setAttribute("rrList", rrList);
		
		return "/user/freeboard/freeboardView.tiles";
	}

}

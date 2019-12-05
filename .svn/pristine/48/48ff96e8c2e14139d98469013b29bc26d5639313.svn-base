package kr.or.ddit.admin.freeboard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.freeboard.service.FreeService;
import kr.or.ddit.user.freeboard.service.FreeServiceImpl;

public class DeleteFreeboardAction implements IAction {
	private boolean redirectFlag = true;
	
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
		service.deleteFreeInfo(params);
		
		
		return "/admin/freeboard/freeboardList.do";
	}


}

package kr.or.ddit.admin.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;

public class LogoutAction implements IAction {
	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().invalidate();
		
		String message = "로그아웃되었습니다.";
		request.setAttribute("message", message);
		
		return "/admin/main/main.tiles";
	}

}

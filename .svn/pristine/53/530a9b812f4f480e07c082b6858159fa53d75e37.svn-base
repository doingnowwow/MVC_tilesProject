package kr.or.ddit.user.member.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;

public class LogoutAction implements IAction {
	private boolean redirectFlag = true;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().invalidate();
		
		String message = "";
		try {
			message = URLEncoder.encode("로그아웃되었습니다.", "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		request.setAttribute("message", message);
		
		return "/user/main.do?message="+message;
	}

}

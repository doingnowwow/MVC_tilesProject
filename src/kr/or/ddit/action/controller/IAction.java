package kr.or.ddit.action.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IAction {
	//프론트 컨트롤러(프론트 앤드 디자인 패턴)가 응답 제어(true : redirect, false : forward)
	public boolean isRedirect();
	
	//Model 레이어 접근
	public String process(HttpServletRequest request, HttpServletResponse response);
}

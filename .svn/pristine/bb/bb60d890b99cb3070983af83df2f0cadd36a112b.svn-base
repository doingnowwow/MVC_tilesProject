package kr.or.ddit.base.uri.adapter;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.base.uri.mapper.URIHandlerMapper;

//클라이언트의 요청시 서블릿 패스를 기준으로 선택된 커맨드 컨트롤러(Servant) 클래스의 동적 인스턴스 진행 및 반환
public class URIHandlerAdapter {
	public static IAction getAction(String servletPath){
		Map<String, String> actionMap = URIHandlerMapper.getActionMap();
		
		IAction action = null;
		
		if(actionMap.containsKey(servletPath)){
			try {
				Class targetClass = Class.forName(actionMap.get(servletPath));
				action = (IAction) targetClass.newInstance();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		return action;
	}
}

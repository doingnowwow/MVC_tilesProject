package kr.or.ddit.base.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.base.uri.adapter.URIHandlerAdapter;

/**
 * 소프트웨어 공학의 소프트웨어 디자인 패턴
 * MVC 패턴 모델 2 : M(Model Layer : Service, Dao, VO)
 * 				   V(View Layer : JSP)
 * 				   C(Controller Layer : Servlet)
 *					* MVC 레이별 역할을 구분하고 분리하며, 프론트 컨트롤러(C) 디자인 패턴을 적용한 컨트롤러의 클라이언트의 전체 요청을 취득 처리하고, 
 *					  프론트 컨트롤러가 분석한 클라이언트의 요청의 실제 처리를 위한 커맨드 컨트롤러(Servant)를 구현하여 활용하며,
 *					  커맨드 컨트롤러(Servant)가 모델 접근 및 취득한 데이터를 활용하여 V(JSP) 대상으로 제공.
 */
public class WebController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getServletPath();
		
		//클라이언트의 요청시 서블릿 패스를 기준으로 커맨드 컨트롤러
		//Servant 컨트롤러 선택하고, 동적으로 인스턴스화 처리
		//전체 커맨드 컨트롤러(Servant) 공통 implements하는 인터페이스
		IAction action = URIHandlerAdapter.getAction(requestURI);
		
		if(action != null){
			String viewName = action.process(request, response);
			if(viewName != null){
				if(action.isRedirect()){
					//do확장자 리다이렉트
					response.sendRedirect(request.getContextPath() + viewName);
				}else{
					RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
					dispatcher.forward(request, response);
				}
			}
		}else{
			//404처리
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}

}

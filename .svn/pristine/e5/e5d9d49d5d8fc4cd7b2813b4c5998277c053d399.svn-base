package kr.or.ddit.user.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;

public class MemberFormAction implements IAction {
	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}
	
	//반환값 View(/WEB-INF/경로/특정 JSP)
	//do확장자를 활용한 리다이렉트, 포워딩 처리
	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		//redirectFlag = true
		//Model(서비스 레이어) 레이어 접근
		//ajax(요청시 반환값) response에 출력버퍼 저장 후 null 반환
		//파일다운로드 파일 다운로드 설정을 response 대상 처리 후 null 반환
		
		//포워딩 처리
		//List<MemberVO> memberList = service.memberList();
		//request.setAttribute("memberList", memberList);
		//포워딩 처리...(/user/member/memberList.tiles)
		//request.getAttribute("memberList");
		//List<MemberVO> 취득 가능
		//header.jsp, left.jsp, footer.jsp, content_header.jsp
		//memberList.jsp <= ${memberList}
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		return "/user/member/memberForm.tiles";
	}

}

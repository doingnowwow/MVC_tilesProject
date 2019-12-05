package kr.or.ddit.admin.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.member.service.MemberService;
import kr.or.ddit.user.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberViewAction  implements IAction{
private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}
	
	
	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
	
	String mem_id = request.getParameter("mem_id");
	Map<String,String> params = new HashMap<String, String>();
	params.put("mem_id", mem_id);
	MemberService service = MemberServiceImpl.getInstance();
	MemberVO	memberInfo = service.memberInfo(params);


	request.setAttribute("memberInfo", memberInfo);
		
		
		
	return "/admin/member/memberView.tiles";
	}

}

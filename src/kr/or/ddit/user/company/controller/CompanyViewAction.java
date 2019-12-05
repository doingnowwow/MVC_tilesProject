package kr.or.ddit.user.company.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.company.service.CompanyService;
import kr.or.ddit.user.company.service.CompanyServiceImpl;
import kr.or.ddit.user.member.service.MemberService;
import kr.or.ddit.user.member.service.MemberServiceImpl;
import kr.or.ddit.vo.CompanyVO;
import kr.or.ddit.vo.MemberVO;

public class CompanyViewAction implements IAction{
private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}
	
	
	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
	
		String com_id = request.getParameter("com_id");
	Map<String,String> params = new HashMap<String, String>();
	params.put("com_id", com_id);
	
	CompanyService service = CompanyServiceImpl.getInstance();
			
	CompanyVO comInfo = service.companyInfo(params);
	


	request.setAttribute("comInfo", comInfo);
		
		
		
		return "/user/company/companyView.tiles";
	}
}

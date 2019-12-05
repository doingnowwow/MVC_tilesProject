package kr.or.ddit.user.member.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.listener.SessionManager;
import kr.or.ddit.user.company.service.CompanyService;
import kr.or.ddit.user.company.service.CompanyServiceImpl;
import kr.or.ddit.user.member.service.MemberService;
import kr.or.ddit.user.member.service.MemberServiceImpl;
import kr.or.ddit.utiles.CryptoGenerator;
import kr.or.ddit.vo.CompanyVO;
import kr.or.ddit.vo.MemberVO;

public class LoginCheckAction implements IAction {
	private boolean redirectFlag = true;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		
		HttpSession session =request.getSession();
		
		mem_id = CryptoGenerator.decryptRSA(session, mem_id);
		mem_pass = CryptoGenerator.decryptRSA(session, mem_pass);
		
//		SessionManager.getInstance().loginDuplicationCheck(session.getId(), mem_id);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_id", mem_id);
		params.put("mem_pass", mem_pass);
		
		MemberService service = MemberServiceImpl.getInstance();
		MemberVO memberInfo = service.memberInfo(params);
		
		Map<String, String> params2 = new HashMap<String, String>();
		params2.put("com_id", mem_id);
		params2.put("com_pass", mem_pass);
		
		CompanyService service2 = CompanyServiceImpl.getInstance();
		CompanyVO companyInfo = service2.companyInfo(params2);
		
		String message = "";
		if(memberInfo == null && companyInfo == null){
			try {
				message = URLEncoder.encode("회원이 아닙니다.", "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}else if(memberInfo != null && companyInfo == null){
			request.getSession().setAttribute("LOGIN_MEMBERINFO", memberInfo);
			request.getSession().setAttribute("name", memberInfo.getMem_name());
			try {
				message = URLEncoder.encode(memberInfo.getMem_name() + "님 환영합니다.", "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}else if(memberInfo == null && companyInfo != null){
			request.getSession().setAttribute("LOGIN_MEMBERINFO", companyInfo);
			request.getSession().setAttribute("name", companyInfo.getCom_name());
			try {
				message = URLEncoder.encode(companyInfo.getCom_name() + "님 환영합니다.", "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("message", message);
		
		return "/user/main.do?message="+message;
	}

}

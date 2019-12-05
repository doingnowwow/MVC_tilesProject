package kr.or.ddit.user.company.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.company.service.CompanyService;
import kr.or.ddit.user.company.service.CompanyServiceImpl;
import kr.or.ddit.user.member.service.MemberService;
import kr.or.ddit.user.member.service.MemberServiceImpl;
import kr.or.ddit.vo.CompanyVO;
import kr.or.ddit.vo.MemberVO;

public class UpdateCompanyAction implements IAction {
	private boolean redirectFlag = true;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		CompanyVO companyInfo = new CompanyVO();
		try {
			BeanUtils.populate(companyInfo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		CompanyService service = CompanyServiceImpl.getInstance();
		service.updateCompanyInfo(companyInfo);
		
		return "/user/main.do";
	}
}

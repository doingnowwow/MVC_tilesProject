package kr.or.ddit.user.member.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.member.service.MemberService;
import kr.or.ddit.user.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

import org.apache.commons.beanutils.BeanUtils;

public class UpdateMemberAction  implements IAction{
	
private boolean redirectFlag = true;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		MemberVO memberInfo = new MemberVO();
		try {
			BeanUtils.populate(memberInfo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		MemberService service = MemberServiceImpl.getInstance();
		service.updateMemberInfo(memberInfo);
		
		return "/user/main.do";
	}
}

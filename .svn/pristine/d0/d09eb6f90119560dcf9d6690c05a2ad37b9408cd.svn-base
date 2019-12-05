package kr.or.ddit.admin.company.controller;

import java.util.HashMap;
import java.util.List;
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

public class CompanyListAction implements IAction {

	private boolean redirectFlag = false;

	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
	/*	String currentPage = request.getParameter("currentPage");
		if(currentPage == null){
			currentPage = "1";
		}
		*/

		String search_keycode = request.getParameter("search_keycode");
		String search_keyword = request.getParameter("search_keyword");
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);


		CompanyService service = CompanyServiceImpl.getInstance();
		List<CompanyVO> companyList = service.companyList(params);
	
	// 페이지네이션
	
	/*String totalCount = service.totalCount(params);
	RolePagingUtiles pagingUtiles = new RolePagingUtiles(Integer.parseInt(currentPage),Integer.parseInt(totalCount),request);

	params.put("startCount", String.valueOf(pagingUtiles.getStartCount()));
	params.put("endCount", String.valueOf(pagingUtiles.getEndCount()));
	String page = pagingUtiles.getPagingHTMLS();*/
//	request.setAttribute("page", page);
	
	request.setAttribute("companyList", companyList);
		
		return "/admin/company/companyList.tiles";
	}

}

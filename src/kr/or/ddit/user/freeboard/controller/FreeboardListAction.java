package kr.or.ddit.user.freeboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.freeboard.service.FreeService;
import kr.or.ddit.user.freeboard.service.FreeServiceImpl;
import kr.or.ddit.utiles.RolePagingUtiles;
import kr.or.ddit.vo.FreeVO;


public class FreeboardListAction implements IAction {
	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {

		

		String currentPage = request.getParameter("currentPage");
		if(currentPage == null){
			currentPage = "1";
		} 

		String search_keycode = request.getParameter("search_keycode");
		String search_keyword = request.getParameter("search_keyword");

		Map<String, String> params = new HashMap<String, String>();
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);
		
		FreeService service = FreeServiceImpl.getInstance();
		
		String totalCount = service.totalCount(params);
		
		RolePagingUtiles pagingUtiles = new RolePagingUtiles(Integer.parseInt(currentPage),
															 Integer.parseInt(totalCount),
															 request);
		
		
		params.put("startCount", String.valueOf(pagingUtiles.getStartCount()));
		params.put("endCount", String.valueOf(pagingUtiles.getEndCount())); 
		
		List<FreeVO> freeList = service.freeList(params);
		
		

		request.setAttribute("freeList", freeList);
		request.setAttribute("pagingUtiles", pagingUtiles);

		return "/user/freeboard/freeboardList.tiles";
	}

}

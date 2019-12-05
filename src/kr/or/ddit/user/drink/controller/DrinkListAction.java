package kr.or.ddit.user.drink.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.drink.service.DrinkService;
import kr.or.ddit.user.drink.service.DrinkServiceImpl;
import kr.or.ddit.user.freeboard.service.FreeService;
import kr.or.ddit.user.freeboard.service.FreeServiceImpl;
import kr.or.ddit.utiles.RolePagingUtiles;
import kr.or.ddit.vo.DrinkVO;
import kr.or.ddit.vo.FreeVO;

public class DrinkListAction implements IAction {
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
		String align_keycode = request.getParameter("align_keycode");

		Map<String, String> params = new HashMap<String, String>();
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);
		params.put("align_keycode", align_keycode);
		
		
		DrinkService service = DrinkServiceImpl.getInstance();
		
		String totalCount = service.totalCount(params);
		
		RolePagingUtiles pagingUtiles = new RolePagingUtiles(Integer.parseInt(currentPage),
															 Integer.parseInt(totalCount),
															 request);
		
		
		params.put("startCount", String.valueOf(pagingUtiles.getStartCount()));
		params.put("endCount", String.valueOf(pagingUtiles.getEndCount())); 
		
		List<DrinkVO> drinkList = service.drinkList(params);
		
		request.setAttribute("drinkList", drinkList);
		
		request.setAttribute("drinkList", drinkList);
		request.setAttribute("pagingUtiles", pagingUtiles);
		
		return "/user/drink/drinkList.tiles";
	}

}

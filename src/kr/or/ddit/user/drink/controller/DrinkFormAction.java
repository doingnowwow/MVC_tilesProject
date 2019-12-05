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
import kr.or.ddit.vo.DrinkVO;
import kr.or.ddit.vo.FreeVO;

public class DrinkFormAction implements IAction {

private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		Map<String, String> params = new HashMap<String, String>();
		DrinkService service = DrinkServiceImpl.getInstance();
		List<DrinkVO> drinkList = service.drinkList(params);
		
		request.setAttribute("drinkList", drinkList);
		
		return "/user/drink/drinkForm.tiles";
	}

}

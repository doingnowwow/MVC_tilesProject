package kr.or.ddit.admin.drink.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.drink.service.DrinkService;
import kr.or.ddit.user.drink.service.DrinkServiceImpl;
import kr.or.ddit.user.freeboard.service.FreeService;
import kr.or.ddit.user.freeboard.service.FreeServiceImpl;

public class DeleteDrinkAction implements IAction {

private boolean redirectFlag = true;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		
		String drink_no = request.getParameter("drink_no");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("drink_no", drink_no);
		
		DrinkService service = DrinkServiceImpl.getInstance();
		service.deleteDrinkInfo(params);
		
		
		return "/admin/drink/drinkList.do";
	}

}

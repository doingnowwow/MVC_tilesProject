package kr.or.ddit.user.drink.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.drink.service.DrinkService;
import kr.or.ddit.user.drink.service.DrinkServiceImpl;
import kr.or.ddit.user.freeboard.service.FreeService;
import kr.or.ddit.user.freeboard.service.FreeServiceImpl;
import kr.or.ddit.vo.DrinkVO;
import kr.or.ddit.vo.FreeVO;

public class UpdateDrinkAction implements IAction {

	private boolean redirectFlag = true;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		DrinkVO drinkInfo = new DrinkVO();

		try {
			BeanUtils.populate(drinkInfo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DrinkService service = DrinkServiceImpl.getInstance();
		service.updateDrinkInfo(drinkInfo);
		
		return "/user/drink/drinkList.do";
	}
}

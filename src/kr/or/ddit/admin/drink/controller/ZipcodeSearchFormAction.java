package kr.or.ddit.admin.drink.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.drink.service.DrinkService;
import kr.or.ddit.user.drink.service.DrinkServiceImpl;
import kr.or.ddit.user.zipcode.service.IZipCodeService;
import kr.or.ddit.user.zipcode.service.IZipCodeServiceImpl;
import kr.or.ddit.vo.DrinkVO;
import kr.or.ddit.vo.ZipcodeVO;

public class ZipcodeSearchFormAction implements IAction {
private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {

		
		return "/admin/drink/zipcodeSearchForm.tiles";
	}
}

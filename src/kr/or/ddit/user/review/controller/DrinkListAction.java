package kr.or.ddit.user.review.controller;

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
import kr.or.ddit.vo.DrinkVO;

public class DrinkListAction implements IAction {
	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
		String drink_name = request.getParameter("drink_name");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("drink_name", drink_name);
		
		DrinkService service = DrinkServiceImpl.getInstance();
		List<DrinkVO> drinkList = service.drinkListbyName(params);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = null;
		try {
			jsonData = mapper.writeValueAsString(drinkList);
		} catch (JsonGenerationException e1) {
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.println(jsonData);
		
		return null;
	}

}

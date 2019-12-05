package kr.or.ddit.user.drink.controller;

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
import kr.or.ddit.user.zipcode.service.IZipCodeService;
import kr.or.ddit.user.zipcode.service.IZipCodeServiceImpl;
import kr.or.ddit.vo.ZipcodeVO;

public class ZipcodeSearchAction implements IAction {
private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {

		 String dong = request.getParameter("dong");
		   
		 Map<String, String> params = new HashMap<String, String>();
		 params.put("dong", dong);
		  
		 IZipCodeService service = IZipCodeServiceImpl.getInstance(); 
		 List<ZipcodeVO> zipcodeList = service.zipcodeList(params);
		   
		 ObjectMapper mapper = new ObjectMapper();
		 
		 String jsonData;
		 PrintWriter out;
		try {
			jsonData = mapper.writeValueAsString(zipcodeList);
			
			response.setCharacterEncoding("UTF-8");
	         response.setContentType("text/html; charset=UTF-8");
			
			out = response.getWriter();
			out.println(jsonData);
			 
		} catch (JsonGenerationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return null;
	}
}

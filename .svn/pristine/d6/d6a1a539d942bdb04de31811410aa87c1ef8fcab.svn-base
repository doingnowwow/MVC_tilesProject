package kr.or.ddit.admin.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.company.service.CompanyService;
import kr.or.ddit.user.company.service.CompanyServiceImpl;
import kr.or.ddit.user.member.service.MemberService;
import kr.or.ddit.user.member.service.MemberServiceImpl;

public class SearchIDAction  implements IAction{
	private boolean redirectFlag = false;

	@Override
	public boolean isRedirect() {
		
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
	
		String com_name = request.getParameter("com_name");
	
		String com_email = request.getParameter("com_email");
		
					
		Map<String,String> params = new HashMap<String, String> ();
		params.put("com_name",com_name);
		params.put("com_email",com_email);
		
		CompanyService service = CompanyServiceImpl.getInstance();

		
		String searchID = service.searchId(params);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = null;
		try {
			jsonData = mapper.writeValueAsString(searchID);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		PrintWriter out = null;
		try {
			out= response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.print(jsonData);
		
		
		
		
		
		
		
		return null;
	}

}

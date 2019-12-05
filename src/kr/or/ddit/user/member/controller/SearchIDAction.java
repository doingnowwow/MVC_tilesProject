package kr.or.ddit.user.member.controller;

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
	
		String mem_name = request.getParameter("mem_name");
		String mem_bir = request.getParameter("mem_bir");
		String mem_email = request.getParameter("mem_email");
		
					
		Map<String,String> params = new HashMap<String, String> ();
		params.put("mem_name",mem_name);
		params.put("mem_bir",mem_bir);
		params.put("mem_email",mem_email);

		MemberService service = MemberServiceImpl.getInstance();
		
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

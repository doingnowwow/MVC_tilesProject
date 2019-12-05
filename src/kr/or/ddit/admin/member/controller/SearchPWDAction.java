package kr.or.ddit.admin.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.member.service.MemberService;
import kr.or.ddit.user.member.service.MemberServiceImpl;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class SearchPWDAction implements IAction {
	private boolean redirectFlag = false;

	@Override
	public boolean isRedirect() {
		
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
	
		String mem_id = request.getParameter("mem_id");
		String mem_name = request.getParameter("mem_name");
		String mem_email = request.getParameter("mem_email");
		
					
		Map<String,String> params = new HashMap<String, String> ();
		params.put("mem_id",mem_id);
		params.put("mem_name",mem_name);
		params.put("mem_email",mem_email);

		MemberService service = MemberServiceImpl.getInstance();
		
		String searchPWD = service.searchPwd(params);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = null;
		try {
			jsonData = mapper.writeValueAsString(searchPWD);
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

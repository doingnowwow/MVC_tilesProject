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
import kr.or.ddit.vo.CompanyVO;
import kr.or.ddit.vo.MemberVO;

public class CheckedIDAction implements IAction {
	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}
	
	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		String com_id = request.getParameter("com_id");

		Map<String,String> params = new HashMap<String,String>();
		params.put("com_id", com_id);

		CompanyService service = CompanyServiceImpl.getInstance();
		CompanyVO companyInfo = service.companyInfo(params);
		
		Map<String , String> jsonMap = new HashMap<String,String>();
		
		if(companyInfo ==null){
			jsonMap.put("flag", "true");
			
		}else{
			jsonMap.put("flag", "false");
		}
		
		ObjectMapper jsonMapper = new ObjectMapper();
		String jsonData = null;
		try {
			jsonData = jsonMapper.writeValueAsString(jsonMap);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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

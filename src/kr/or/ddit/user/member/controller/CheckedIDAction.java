package kr.or.ddit.user.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.member.service.MemberService;
import kr.or.ddit.user.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class CheckedIDAction implements IAction {
	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}
	
	//반환값 View(/WEB-INF/경로/특정 JSP)
	//do확장자를 활용한 리다이렉트, 포워딩 처리
	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		String mem_id = request.getParameter("mem_id");

		Map<String,String> params = new HashMap<String,String>();
		params.put("mem_id", mem_id);

		MemberService service = MemberServiceImpl.getInstance();
		MemberVO memberInfo = service.memberInfo(params);
		
		//http://search.maven.org
		//	jackson-core-asl-1.9.13.jar
		//	jackson-mapper-asl-1.9.13.jar
		//  자바 객체 -> json형식 문자열
		//  json형식 문자열 -> 자바객체
		
		Map<String , String> jsonMap = new HashMap<String,String>();
		
		if(memberInfo ==null){
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

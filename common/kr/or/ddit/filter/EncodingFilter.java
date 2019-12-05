package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang3.StringUtils;

public class EncodingFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		// 클라이언트 요청시 요청 헤더에 서버에서 요청 데이터 처리를 위한 인코딩 설정 정보를 전송.
		// 클라이언트 요창시 쿼리스트링 method=GET : server.xml 파일 내 <connector URIencoding ="UTF-8"/>
		//						  method=POST : jsp 내 request.setCharatorEncoding("UTF-8");
		
		String encodingType = servletRequest.getCharacterEncoding();
		
		//http://commons.apache.org
		//		commons-lang3-e.1.jar
		// WEB-INF/lib		import
		
		if(StringUtils.isEmpty(encodingType)){
			encodingType = "UTF-8";
		}
		
		servletRequest.setCharacterEncoding("UTF-8");
		// servletRequest, servletResponse 는 jsp의 기본객체
		// HttpServletRequest,HttpServletResponse를 생성할 때 활용
		
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}

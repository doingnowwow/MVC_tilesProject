package kr.or.ddit.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.utiles.CryptoGenerator;




//1회용인 공개키와 비밀키를 생성하는 클래스.
public class RSAFilter implements Filter{
   
   
      @Override
      public void destroy() {
         
      }
      @Override
      public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain filterChain) throws IOException, ServletException {
         HttpServletRequest requestA = (HttpServletRequest) request;
         HttpSession session = requestA.getSession();
         String uri=requestA.getRequestURI();
         
         if(!uri.equals("/SUL/user/member/loginCheck.do")){
        	 
	         Map<String, String> publicKeyMap = CryptoGenerator.generatePairKey(session);
	         request.setAttribute("publicKeyMap", publicKeyMap);         
         }
         filterChain.doFilter(request, response);
      }
      @Override
      public void init(FilterConfig arg0) throws ServletException {
         
      }
  }

package kr.or.ddit.base.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.utiles.CryptoGenerator;

public class GetPublickey implements IAction {

   private boolean isRedirect =false;
   @Override
   public boolean isRedirect() {
      return isRedirect;
   }

   @Override
   public String process(HttpServletRequest request,
         HttpServletResponse response) {
      HttpSession session =request.getSession();
      
      Map<String, String> publicKeyMap = CryptoGenerator.generatePairKey(session);
      request.setAttribute("publicKeyMap", publicKeyMap);
   
      String page=request.getServletPath();
      return page;
   }

}
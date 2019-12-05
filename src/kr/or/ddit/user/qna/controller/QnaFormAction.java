package kr.or.ddit.user.qna.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.qna.service.QnaService;
import kr.or.ddit.user.qna.service.QnaServiceImpl;
import kr.or.ddit.vo.QnaVO;

public class QnaFormAction implements IAction {
	
private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

		
		
		@Override
		public String process(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, String> params = new HashMap<String, String>();
			
			QnaService service = QnaServiceImpl.getInstance();
			List<QnaVO> qnaList = service.qnaList(params);
			
			request.setAttribute("qnaList", qnaList);

			return "/user/qna/qnaForm.tiles";
		}
		
		
		

}
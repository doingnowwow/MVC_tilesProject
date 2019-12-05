package kr.or.ddit.admin.qna.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.qna.service.QnaService;
import kr.or.ddit.user.qna.service.QnaServiceImpl;
import kr.or.ddit.user.review.service.ReviewService;
import kr.or.ddit.user.review.service.ReviewServiceImpl;

public class DeleteQnaAction  implements IAction{
	private boolean redirectFlag = true;

	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		String qna_no = request.getParameter("qna_no");
		

		Map<String, String> params = new HashMap<String, String>();
		params.put("qna_no", qna_no);
		
		QnaService service = QnaServiceImpl.getInstance();
		service.deleteQna(params);
		
		
		
		return "/admin/qna/qnaList.do";
	}
}

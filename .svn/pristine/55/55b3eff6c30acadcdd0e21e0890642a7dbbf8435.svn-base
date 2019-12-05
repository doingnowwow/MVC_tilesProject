package kr.or.ddit.user.reviewreply.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.review.service.ReviewService;
import kr.or.ddit.user.review.service.ReviewServiceImpl;
import kr.or.ddit.user.reviewreply.service.ReviewReplyService;
import kr.or.ddit.user.reviewreply.service.ReviewReplyServiceImpl;

public class DeleteReviewReplyAction implements IAction {
	private boolean redirectFlag = true;

	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		String rr_no = request.getParameter("rr_no");
		
		String rnum = request.getParameter("rnum");
		String review_no = request.getParameter("review_no");

		Map<String, String> params = new HashMap<String, String>();
		params.put("rr_no", rr_no);
		
		ReviewReplyService service = ReviewReplyServiceImpl.getInstance();
		service.deleteReviewReply(params);
		
		return "/user/review/reviewView.do?review_no="+review_no+"&rnum="+rnum;	
	}
}

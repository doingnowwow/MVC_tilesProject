package kr.or.ddit.admin.review.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.review.service.ReviewService;
import kr.or.ddit.user.review.service.ReviewServiceImpl;

public class DeleteReviewAction implements IAction {
	private boolean redirectFlag = true;

	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		String review_no = request.getParameter("review_no");

		Map<String, String> params = new HashMap<String, String>();
		params.put("review_no", review_no);
		
		ReviewService service = ReviewServiceImpl.getInstance();
		service.deleteReviewInfo(params);
		
		return "/admin/review/reviewList.do";
	}

}

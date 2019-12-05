package kr.or.ddit.admin.review.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.review.service.ReviewService;
import kr.or.ddit.user.review.service.ReviewServiceImpl;
import kr.or.ddit.user.reviewreply.service.ReviewReplyService;
import kr.or.ddit.user.reviewreply.service.ReviewReplyServiceImpl;
import kr.or.ddit.vo.ReviewReplyVO;
import kr.or.ddit.vo.ReviewVO;

public class ReviewViewAction implements IAction {
	private boolean redirectFlag = false;

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
		ReviewVO reviewInfo = service.reviewInfo(params);
		
		ReviewReplyService rrservice = ReviewReplyServiceImpl.getInstance();
		List<ReviewReplyVO> rrList = rrservice.rrList(params);
		
		request.setAttribute("reviewInfo", reviewInfo);
		request.setAttribute("rrList", rrList);
				
		return "/admin/review/reviewView.tiles";
	}

}

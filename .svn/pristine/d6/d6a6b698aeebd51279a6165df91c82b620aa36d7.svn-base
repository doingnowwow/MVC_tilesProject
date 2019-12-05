package kr.or.ddit.user.reviewreply.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.reviewreply.service.ReviewReplyService;
import kr.or.ddit.user.reviewreply.service.ReviewReplyServiceImpl;
import kr.or.ddit.vo.ReviewReplyVO;

public class InsertReviewReplyAction implements IAction {
	private boolean redirectFlag = true;

	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		ReviewReplyVO rrInfo = new ReviewReplyVO();
		
		try {
			BeanUtils.populate(rrInfo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		ReviewReplyService service = ReviewReplyServiceImpl.getInstance();
		service.insertReviewReply(rrInfo);
		
		String rnum = request.getParameter("rnum");
		String review_no = request.getParameter("review_no");
		
		return "/user/review/reviewView.do?review_no="+review_no+"&rnum="+rnum;
	}

}

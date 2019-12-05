package kr.or.ddit.user.review.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.review.service.ReviewService;
import kr.or.ddit.user.review.service.ReviewServiceImpl;
import kr.or.ddit.vo.ReviewVO;

public class UpdateReviewAction implements IAction {
	private boolean redirectFlag = true;

	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		ReviewVO reviewInfo = new ReviewVO();
		
		try {
			BeanUtils.populate(reviewInfo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		ReviewService service = ReviewServiceImpl.getInstance();
		service.updateReviewInfo(reviewInfo);
		
		return "/user/review/reviewList.do";
	}

}

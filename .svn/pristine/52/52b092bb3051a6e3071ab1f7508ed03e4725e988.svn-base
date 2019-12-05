package kr.or.ddit.user.review.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.review.service.ReviewService;
import kr.or.ddit.user.review.service.ReviewServiceImpl;
import kr.or.ddit.utiles.FileUploadRequestWrapper;
import kr.or.ddit.vo.ReviewVO;

public class InsertReviewAction implements IAction {
	private boolean redirectFlag = true;

	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		FileUploadRequestWrapper wrapper = (FileUploadRequestWrapper)request;
		
		ReviewVO reviewInfo = new ReviewVO();
		
		try {
			BeanUtils.populate(reviewInfo, wrapper.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		ReviewService service = ReviewServiceImpl.getInstance();
		service.insertReviewInfo(reviewInfo, wrapper.getFileItemValues("files"));
		
		return "/user/review/reviewList.do";
	}

}

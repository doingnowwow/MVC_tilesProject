package kr.or.ddit.user.qna.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.qna.service.QnaService;
import kr.or.ddit.user.qna.service.QnaServiceImpl;
import kr.or.ddit.vo.QnaVO;

import org.apache.commons.beanutils.BeanUtils;

public class InsertQnaReplyAction implements IAction {

	private boolean redirectFlag = true;

	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {

		QnaVO qnaInfo = new QnaVO();

		try {
			BeanUtils.populate(qnaInfo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		QnaService service = QnaServiceImpl.getInstance();
		service.insertQnaReplyInfo(qnaInfo);
		return "/user/qna/qnaList.do";
	}
}

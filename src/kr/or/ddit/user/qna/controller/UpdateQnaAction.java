package kr.or.ddit.user.qna.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.qna.service.QnaService;
import kr.or.ddit.user.qna.service.QnaServiceImpl;
import kr.or.ddit.utiles.RolePagingUtiles;
import kr.or.ddit.vo.QnaVO;

public class UpdateQnaAction implements IAction {
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
		service.updateQna(qnaInfo);
		
		
		return "/user/qna/qnaList.do";
	}

}

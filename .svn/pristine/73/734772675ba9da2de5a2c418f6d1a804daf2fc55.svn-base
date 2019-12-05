package kr.or.ddit.user.qna.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.qna.service.QnaService;
import kr.or.ddit.user.qna.service.QnaServiceImpl;


import kr.or.ddit.utiles.FileUploadRequestWrapper;
import kr.or.ddit.vo.QnaVO;

import org.apache.commons.beanutils.BeanUtils;

public class InsertQnaAction  implements IAction{
private boolean redirectFlag = true;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
	FileUploadRequestWrapper wrapper = (FileUploadRequestWrapper)request;


		QnaVO qnaInfo = new QnaVO();
		
		try {
			try {
				BeanUtils.populate(qnaInfo, wrapper.getParameterMap());
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			e.printStackTrace();
		}
		
		
		QnaService serivce = QnaServiceImpl.getInstance();
		serivce.insertQna(qnaInfo,wrapper.getFileItemValues("files"));
		
		
		return "/user/qna/qnaList.do";
	}
}

package kr.or.ddit.user.notice.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.notice.service.NoticeService;
import kr.or.ddit.user.notice.service.NoticeServiceImpl;
import kr.or.ddit.utiles.FileUploadRequestWrapper;
import kr.or.ddit.vo.NoticeVO;

public class InsertNoticeAction implements IAction{
private boolean redirectFlag = true;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		FileUploadRequestWrapper wrapper = (FileUploadRequestWrapper)request;

		
		NoticeVO noticeInfo = new NoticeVO();
		
		try {
			try{
			BeanUtils.populate(noticeInfo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		}catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		NoticeService service = NoticeServiceImpl.getInstance();
		service.insertNoticeInfo(noticeInfo,wrapper.getFileItemValues("files"));

		
		
		return "/user/notice/noticeList.do";
	}
}

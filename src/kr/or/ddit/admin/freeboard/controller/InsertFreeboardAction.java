package kr.or.ddit.admin.freeboard.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.freeboard.service.FreeService;
import kr.or.ddit.user.freeboard.service.FreeServiceImpl;
import kr.or.ddit.utiles.FileUploadRequestWrapper;
import kr.or.ddit.vo.FreeVO;

public class InsertFreeboardAction implements IAction {
	private boolean redirectFlag = true;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		FileUploadRequestWrapper wrapper = (FileUploadRequestWrapper)request;

		FreeVO freeInfo = new FreeVO();
		
		try {
			BeanUtils.populate(freeInfo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FreeService service = FreeServiceImpl.getInstance();
		service.insertfreeInfo(freeInfo, wrapper.getFileItemValues("files"));
		
		return "/admin/freeboard/freeboardList.do";
	}
}

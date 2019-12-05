package kr.or.ddit.admin.freeboard.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.freeboard.service.FreeService;
import kr.or.ddit.user.freeboard.service.FreeServiceImpl;
import kr.or.ddit.vo.FreeVO;

public class UpdateFreeboardAction implements IAction {

	private boolean redirectFlag = true;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		FreeVO freeInfo = new FreeVO();

		try {
			BeanUtils.populate(freeInfo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		FreeService service = FreeServiceImpl.getInstance();
		service.updatefreeInfo(freeInfo);
		
		return "/admin/freeboard/freeboardList.do";
	}

}

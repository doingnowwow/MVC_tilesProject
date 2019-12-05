package kr.or.ddit.admin.freeboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.freeboard.service.FreeService;
import kr.or.ddit.user.freeboard.service.FreeServiceImpl;
import kr.or.ddit.user.notice.service.NoticeService;
import kr.or.ddit.user.notice.service.NoticeServiceImpl;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.Free_FileVO;
import kr.or.ddit.vo.NoticeVO;

public class FreeboardFormAction implements IAction {
	
	
	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		Map<String, String> params = new HashMap<String, String>();
		FreeService service = FreeServiceImpl.getInstance();
		List<FreeVO> freeboardList = service.freeList(params);
		
		request.setAttribute("freeboardList", freeboardList);

		return "/admin/freeboard/freeboardForm.tiles";
	}
	
	



}

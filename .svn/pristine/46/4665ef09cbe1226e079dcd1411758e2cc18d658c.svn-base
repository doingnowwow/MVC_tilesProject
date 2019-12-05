package kr.or.ddit.admin.qna.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.qna.service.QnaService;
import kr.or.ddit.user.qna.service.QnaServiceImpl;
import kr.or.ddit.utiles.RolePagingUtiles;
import kr.or.ddit.vo.QnaVO;

public class QnaListAction implements IAction{

	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		
		String currentPage = request.getParameter("currentPage");
		if(currentPage == null){
			currentPage = "1";
		}
		
		String search_keycode = request.getParameter("search_keycode");
		String search_keyword = request.getParameter("search_keyword");
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);
		
		
		QnaService service = QnaServiceImpl.getInstance();
		String totalCount = service.totalCount(params);
		
		RolePagingUtiles pagingUtiles = new RolePagingUtiles(Integer.parseInt(currentPage),Integer.parseInt(totalCount),request);

		params.put("startCount", String.valueOf(pagingUtiles.getStartCount()));
		params.put("endCount", String.valueOf(pagingUtiles.getEndCount()));
		
		List<QnaVO> qnaList = service.qnaList(params);
		String page = pagingUtiles.getPagingHTMLS();
		
		
		request.setAttribute("qnaList", qnaList);
		request.setAttribute("page", page);
		
		
		
		
		
		
		
		return "/admin/qna/qnaList.tiles";
	}

}

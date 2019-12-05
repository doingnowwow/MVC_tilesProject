package kr.or.ddit.user.freeboard.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.FreeVO;


public interface FreeService {
	public List<FreeVO> freeList(Map<String, String> params);
	public FreeVO freeInfo(Map<String, String> params);
	public void insertfreeInfo(FreeVO freeInfo , FileItem[] items);
	public void updatefreeInfo(FreeVO freeInfo);
	public void deleteFreeInfo(Map<String, String> params);

	public String totalCount(Map<String, String> params);
	public void insertfreeReplyInfo(FreeVO freeInfo);
}

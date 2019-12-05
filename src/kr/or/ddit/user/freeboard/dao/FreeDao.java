package kr.or.ddit.user.freeboard.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.FreeVO;

public interface FreeDao {
	public List<FreeVO> freeList(Map<String, String> params) throws SQLException;
	public FreeVO freeInfo(Map<String, String> params) throws SQLException;
	public String insertfreeInfo(FreeVO freeInfo, FileItem[] items) throws SQLException;
	public void updatefreeInfo(FreeVO freeInfo) throws SQLException;
	public void deleteFreeInfo(Map<String, String> params) throws SQLException;

	public String totalCount(Map<String, String> params) throws SQLException;
	public void insertfreeReplyInfo(FreeVO freeInfo) throws SQLException;
}

package kr.or.ddit.user.freeboard.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.FreeVO;


public class FreeDaoImpl implements FreeDao {

	
	private static FreeDao dao = new FreeDaoImpl();
	private SqlMapClient client;
	
	private FreeDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static FreeDao getInstance(){
		return (dao == null) ? dao = new FreeDaoImpl() : dao;
	}
	
	
	@Override
	public List<FreeVO> freeList(Map<String, String> params)
			throws SQLException {
		return client.queryForList("free.freeList", params);
	}

	@Override
	public FreeVO freeInfo(Map<String, String> params) throws SQLException {
		client.update("free.updateBOHIT", params);
		return (FreeVO) client.queryForObject("free.freeInfo", params);
	}

	@Override
	public String insertfreeInfo(FreeVO freeInfo, FileItem[] items) throws SQLException {
		return (String) client.insert("free.insertFreeInfo", freeInfo);
	}

	@Override
	public void updatefreeInfo(FreeVO freeInfo) throws SQLException {
		client.update("free.updateFreeInfo", freeInfo);

	}

	@Override
	public void deleteFreeInfo(Map<String, String> params) throws SQLException {
		client.update("free.deleteFreeInfo", params);

	}

	@Override
	public String totalCount(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("free.totalCount", params);
	}

	@Override
	public void insertfreeReplyInfo(FreeVO freeInfo) throws SQLException {
		// TODO Auto-generated method stub

	}

}

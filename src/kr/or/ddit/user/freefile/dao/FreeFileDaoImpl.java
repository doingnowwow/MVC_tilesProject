package kr.or.ddit.user.freefile.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.Free_FileVO;

public class FreeFileDaoImpl implements FreeFileDao { 
	private static FreeFileDao dao = new FreeFileDaoImpl();
	private SqlMapClient client;
	
	private FreeFileDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	} 
	public static FreeFileDao getInstance(){
		return (dao == null) ? dao = new FreeFileDaoImpl() : dao;
	}
	@Override
	public void insertFileItemInfo(List<Free_FileVO> fileItemList)
			throws SQLException {
		try{
		client.startTransaction();
		for(Free_FileVO fileItemInfo : fileItemList){
			// 첨부파일 최대 2개 : insert 최대 2번
			//    1. insert 성공, 2. insert 성공 commit
			//    1. insert 성공, 2. insert 실패 rollback
			//    1. insert 실패

			// Commit : startTransaction() -> commitTransaction()
			//			-> endTransaction()
			// Rollback : startTransaction() -> 에러발생 commitTransaction() 호출 X
			//			-> endTransaction()
				client.insert("freefile.insertFreeFile", fileItemInfo);
		}
			client.commitTransaction();
		}finally{
			client.endTransaction();
			
		}
	} 
	
	@Override
	public Free_FileVO fileItemInfo(Map<String, String> params)
			throws SQLException {
		return (Free_FileVO) client.queryForObject("freefile.freefileInfo", params);
	}
	
}

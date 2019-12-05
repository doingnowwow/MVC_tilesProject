package kr.or.ddit.user.drinkfile.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.DrinkFileVO;
import kr.or.ddit.vo.Free_FileVO;

public class DrinkFileDaoImpl implements DrinkFileDao { 
	private static DrinkFileDao dao = new DrinkFileDaoImpl();
	private SqlMapClient client;
	
	private DrinkFileDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	} 
	public static DrinkFileDao getInstance(){
		return (dao == null) ? dao = new DrinkFileDaoImpl() : dao;
	}
	@Override
	public void insertFileItemInfo(List<DrinkFileVO> fileItemList)
			throws SQLException {
		try{
		client.startTransaction();
		for(DrinkFileVO fileItemInfo : fileItemList){
			// 첨부파일 최대 2개 : insert 최대 2번
			//    1. insert 성공, 2. insert 성공 commit
			//    1. insert 성공, 2. insert 실패 rollback
			//    1. insert 실패

			// Commit : startTransaction() -> commitTransaction()
			//			-> endTransaction()
			// Rollback : startTransaction() -> 에러발생 commitTransaction() 호출 X
			//			-> endTransaction()
				client.insert("drinkfile.insertDrinkFile", fileItemInfo);
		}
			client.commitTransaction();
		}finally{
			client.endTransaction();
			
		}
	} 
	
	@Override
	public DrinkFileVO fileItemInfo(Map<String, String> params)
			throws SQLException {
		return (DrinkFileVO) client.queryForObject("drinkfile.drinkfileInfo", params);
	}
	
}

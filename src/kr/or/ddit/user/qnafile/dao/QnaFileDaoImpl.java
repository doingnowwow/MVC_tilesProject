package kr.or.ddit.user.qnafile.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.QnaFileVO;
import kr.or.ddit.vo.QnaVO;

public class QnaFileDaoImpl implements QnaFileDao {
	
	private static QnaFileDao dao = new QnaFileDaoImpl();
	
	private SqlMapClient client;
	
	private QnaFileDaoImpl(){
		client  = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static QnaFileDao getInstance(){
		return (dao ==null) ? dao = new QnaFileDaoImpl(): dao;
	}
	

	@Override
	public void insertFileitemInfo(List<QnaFileVO> fileItemList)
			throws SQLException {

		try{
			client.startTransaction();

			for(QnaFileVO fileItemInfo : fileItemList){
				
				client.insert("qnafile.insertFileItem", fileItemInfo);
				
			}
			
			client.commitTransaction();
			
		}finally{
			client.endTransaction();
		}
		
	}

	@Override
	public QnaFileVO fileItemInfo(Map<String, String> params) throws SQLException {
		
		return (QnaFileVO) client.queryForObject("qnafile.fileItemInfo",params);
	}

}

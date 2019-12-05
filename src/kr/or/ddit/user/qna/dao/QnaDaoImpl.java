package kr.or.ddit.user.qna.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.QnaVO;

import org.apache.commons.fileupload.FileItem;

import com.ibatis.sqlmap.client.SqlMapClient;

public class QnaDaoImpl implements QnaDao {
	
	private static QnaDao dao = new  QnaDaoImpl();
	
	private SqlMapClient client;
	
	public QnaDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static QnaDao getInstance(){
		return (dao == null) ? dao = new QnaDaoImpl() : dao;
	}

	@Override
	public List<QnaVO> qnaList(Map<String, String> params) throws SQLException {
		return client.queryForList("qna.qnaList",params);
	}

	@Override
	public String insertQna(QnaVO qnaInfo, FileItem[] items) throws SQLException {
		return (String)client.insert("qna.insertQna",qnaInfo);

	}

	@Override
	public void updateQna(QnaVO qnaInfo) throws SQLException {
		client.update("qna.updateQna",qnaInfo);
	}

	@Override
	public void deleteQna(Map<String, String> params) throws SQLException {
			client.update("qna.deleteQna",params);
	}

	@Override
	public QnaVO qnaInfo(Map<String, String> params) throws SQLException {
		client.update("qna.updateQNAHIT",params);
		return (QnaVO) client.queryForObject("qna.qnaInfo",params);
	}

	@Override
	public String totalCount(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("qna.totalCount",params);
	}

	@Override
	public void insertQnaReplyInfo(QnaVO qnaInfo) throws SQLException {
	try{	
		client.startTransaction();
		String qna_seq;
		
		if("0".intern() == qnaInfo.getQna_seq().intern()){
			qna_seq = (String) client.queryForObject("qna.incrementSEQ",qnaInfo);
		}else{
			client.update("qna.updateSEQ",qnaInfo);
			qna_seq = String.valueOf(Integer.parseInt(qnaInfo.getQna_seq())+1);
		}
		
		qnaInfo.setQna_seq(qna_seq);
	
		String qna_depth = String.valueOf(Integer.parseInt(qnaInfo.getQna_depth())+1);
		qnaInfo.setQna_depth(qna_depth);
		
		client.insert("qna.insertQnaReply",qnaInfo);
		
		client.commitTransaction();
	}finally{
		client.endTransaction();
	}
	}

}

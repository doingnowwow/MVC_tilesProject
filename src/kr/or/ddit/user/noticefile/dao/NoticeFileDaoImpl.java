package kr.or.ddit.user.noticefile.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.NoticeFileVO;

import com.ibatis.sqlmap.client.SqlMapClient;

public class NoticeFileDaoImpl implements NoticeFileDao {

	private static NoticeFileDao dao = new NoticeFileDaoImpl();
	private SqlMapClient client;

	private NoticeFileDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}

	public static NoticeFileDao getInstance() {
		return (dao == null) ? dao = new NoticeFileDaoImpl() : dao;
	}

	@Override
	public void insertFileitemInfo(List<NoticeFileVO> fileItemList)
			throws SQLException {
		try {
			client.startTransaction();
			for (NoticeFileVO fileItemInfo : fileItemList) {
					client.insert("noticefile.insertFileItem", fileItemInfo);
			}
			client.commitTransaction();
		} finally {
			client.endTransaction();
		}
	}

	@Override
	public NoticeFileVO fileItemInfo(Map<String, String> params)
			throws SQLException {
		return (NoticeFileVO) client.queryForObject("noticefile.fileItemInfo", params);
	}

}

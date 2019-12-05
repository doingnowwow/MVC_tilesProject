package kr.or.ddit.user.drink.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.DrinkVO;
import kr.or.ddit.vo.FreeVO;

public class DrinkDaoImpl implements DrinkDao {

	
	private static DrinkDao dao = new DrinkDaoImpl();
	private SqlMapClient client;
	
	private DrinkDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static DrinkDao getInstance(){
		return (dao == null) ? dao = new DrinkDaoImpl() : dao;
	}
	
	
	@Override
	public List<DrinkVO> drinkList(Map<String, String> params)
			throws SQLException {
		return client.queryForList("drink.drinkList", params);
	}

	@Override
	public DrinkVO drinkInfo(Map<String, String> params) throws SQLException {
		client.update("drink.updateBOHIT", params);
		return (DrinkVO) client.queryForObject("drink.drinkInfo", params);
	}

	@Override
	public String insertDrinkInfo(DrinkVO drinkInfo, FileItem[] items) throws SQLException {
		return (String) client.insert("drink.insertDrinkInfo", drinkInfo);
	}

	@Override
	public void updateDrinkInfo(DrinkVO drinkInfo) throws SQLException {
		client.update("drink.updateDrinkInfo", drinkInfo);

	}

	@Override
	public void deleteDrinkInfo(Map<String, String> params) throws SQLException {
		client.update("drink.deleteDrinkInfo", params);

	}

	@Override
	public String totalCount(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("drink.totalCount", params);
	}

	@Override
	public void insertDrinkReplyInfo(DrinkVO drinkInfo) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DrinkVO> drinkListbyName(Map<String, String> params)
			throws SQLException {
		return client.queryForList("drink.drinkListbyName", params);
	}

}

package kr.or.ddit.user.drink.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.DrinkVO;

public interface DrinkDao {
	public List<DrinkVO> drinkList(Map<String, String> params) throws SQLException;
	public DrinkVO drinkInfo(Map<String, String> params) throws SQLException;
	public String insertDrinkInfo(DrinkVO drinkInfo, FileItem[] items) throws SQLException;
	public void updateDrinkInfo(DrinkVO drinkInfo) throws SQLException;
	public void deleteDrinkInfo(Map<String, String> params) throws SQLException;

	public String totalCount(Map<String, String> params) throws SQLException;
	public void insertDrinkReplyInfo(DrinkVO drinkInfo) throws SQLException;
	
	//현주
	public List<DrinkVO> drinkListbyName(Map<String, String> params) throws SQLException;
}

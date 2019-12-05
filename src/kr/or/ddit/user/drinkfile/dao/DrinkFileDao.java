package kr.or.ddit.user.drinkfile.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.DrinkFileVO;
import kr.or.ddit.vo.Free_FileVO;

public interface DrinkFileDao {
	public void insertFileItemInfo(List<DrinkFileVO> fileItemList) throws SQLException;
	public DrinkFileVO fileItemInfo(Map<String, String> params)throws SQLException;
}

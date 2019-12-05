package kr.or.ddit.user.drinkfile.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.drinkfile.dao.DrinkFileDao;
import kr.or.ddit.user.drinkfile.dao.DrinkFileDaoImpl;

import kr.or.ddit.vo.DrinkFileVO;


public class DrinkFileServiceImpl implements DrinkFileService {
	private static DrinkFileService service = new DrinkFileServiceImpl();
	private DrinkFileDao dao;
	
	private DrinkFileServiceImpl(){
		dao = DrinkFileDaoImpl.getInstance();
		
	}
	public static DrinkFileService getInstance(){
		return (service == null) ? service = new DrinkFileServiceImpl() : service;
	}

	@Override
	public DrinkFileVO fileItemInfo(Map<String, String> params) {
		DrinkFileVO fileItemInfo = null;
		try {
			fileItemInfo = dao.fileItemInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fileItemInfo;
	}
	@Override
	public void insertFileItemInfo(List<DrinkFileVO> fileItemList) {
		// TODO Auto-generated method stub
		
	}

}

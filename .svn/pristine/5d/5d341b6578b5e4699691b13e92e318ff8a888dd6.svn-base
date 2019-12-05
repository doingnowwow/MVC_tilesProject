package kr.or.ddit.user.drink.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.user.drink.dao.DrinkDao;
import kr.or.ddit.user.drink.dao.DrinkDaoImpl;
import kr.or.ddit.user.drinkfile.dao.DrinkFileDao;
import kr.or.ddit.user.drinkfile.dao.DrinkFileDaoImpl;
import kr.or.ddit.user.freeboard.dao.FreeDao;
import kr.or.ddit.user.freeboard.dao.FreeDaoImpl;
import kr.or.ddit.user.freeboard.service.FreeService;
import kr.or.ddit.user.freeboard.service.FreeServiceImpl;
import kr.or.ddit.user.freefile.dao.FreeFileDao;
import kr.or.ddit.user.freefile.dao.FreeFileDaoImpl;
import kr.or.ddit.utiles.AttachFileMapper;
import kr.or.ddit.utiles.AttachFileMapper_DrinkFile;
import kr.or.ddit.vo.DrinkFileVO;
import kr.or.ddit.vo.DrinkVO;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.Free_FileVO;

public class DrinkServiceImpl implements DrinkService {

	
	private static DrinkService service = new DrinkServiceImpl();
	private DrinkDao drinkDao;
	private DrinkFileDao drinkfileDao;
	
	private DrinkServiceImpl(){
		drinkDao = DrinkDaoImpl.getInstance();
		drinkfileDao = DrinkFileDaoImpl.getInstance();
	} 
	
	public static DrinkService getInstance(){
		return (service == null) ? service = new DrinkServiceImpl() : service;
	}
	
	
	@Override
	public List<DrinkVO> drinkList(Map<String, String> params) {
		List<DrinkVO> drinkList = null;
		try {
			drinkList = drinkDao.drinkList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return drinkList;
	}

	@Override
	public DrinkVO drinkInfo(Map<String, String> params) {
		DrinkVO drinkInfo = null;
		try {
			drinkInfo = drinkDao.drinkInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return drinkInfo;
	}

	@Override
	public void insertDrinkInfo(DrinkVO drinkInfo, FileItem[] items) {
		try { 
			String drink_no = drinkDao.insertDrinkInfo(drinkInfo, items);
			
			List<DrinkFileVO> fileItemList = AttachFileMapper_DrinkFile.mapping(items, drink_no);
			
			drinkfileDao.insertFileItemInfo(fileItemList);
			// 첨부파일 인서트할 때 bo_no => file_bo_no로 활용
			/*List<Free_FileVO> fileItemList = AttachFileMapper.mapping(items, bo_no);
			freefileDao.insertFileItemInfo(fileItemList);*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateDrinkInfo(DrinkVO drinkInfo) {
		try {
			drinkDao.updateDrinkInfo(drinkInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteDrinkInfo(Map<String, String> params) {
		try {
			drinkDao.deleteDrinkInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	@Override
	public String totalCount(Map<String, String> params) {
		String totalCount = "0";
		try{
		totalCount = drinkDao.totalCount(params);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return totalCount;
	}

	@Override
	public void insertDrinkReplyInfo(DrinkVO drinkInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DrinkVO> drinkListbyName(Map<String, String> params) {
		List<DrinkVO> list = null;
		try {
			list = drinkDao.drinkListbyName(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}

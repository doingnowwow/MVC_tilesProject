package kr.or.ddit.user.drink.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.DrinkVO;

public interface DrinkService {
	public List<DrinkVO> drinkList(Map<String, String> params);
	public DrinkVO drinkInfo(Map<String, String> params);
	public void insertDrinkInfo(DrinkVO drinkInfo, FileItem[] items);
	public void updateDrinkInfo(DrinkVO drinkInfo);
	public void deleteDrinkInfo(Map<String, String> params);

	public String totalCount(Map<String, String> params);
	public void insertDrinkReplyInfo(DrinkVO drinkInfo);
	
	public List<DrinkVO> drinkListbyName(Map<String, String> params);
}

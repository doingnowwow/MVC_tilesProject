package kr.or.ddit.utiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.vo.DrinkFileVO;

public class AttachFileMapper_DrinkFile {
	public static List<DrinkFileVO> mapping(FileItem[] items, String drink_no){
		List<DrinkFileVO> fileItemList = new ArrayList<DrinkFileVO>();
		
		if(items != null){
			DrinkFileVO fileItemInfo = null;
			for(FileItem item : items){
				fileItemInfo = new DrinkFileVO();
				
				fileItemInfo.setDrink_no(drink_no);
				
				// d:\temp\a.png or a.png
				// a.png
				String fileName = FilenameUtils.getName(item.getName());
				fileItemInfo.setDfile_name(fileName);
				fileItemInfo.setDfile_content_type(item.getContentType());
				fileItemInfo.setDfile_size(String.valueOf(item.getSize()));
				
				// a.png => a
				String baseName = FilenameUtils.getBaseName(fileName);
				// a.png => png						
				String extension = FilenameUtils.getExtension(fileName);
				// 파일명_랜덤값.확장자 => file_save_name으로 활용
				// 랜덤값 : UUID(Univerally Unique IDentifier) : 128bit 랜덤 유일값 반환(-포함)
				String genID = UUID.randomUUID().toString().replace("-", "");
				
				String fileSaveName = baseName + "_" + genID + "." + extension;
				
				fileItemInfo.setDfile_save_name(fileSaveName);
				
				fileItemList.add(fileItemInfo);
				
				saveFile(fileSaveName, item);
			}
		}
		return fileItemList;
	}

	private static void saveFile(String fileSaveName, FileItem item) {
		File saveFile = new File(GlobalConstant.FILE_PATH, fileSaveName);
		
		try {
			item.write(saveFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}











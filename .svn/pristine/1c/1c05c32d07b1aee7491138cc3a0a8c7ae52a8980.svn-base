package kr.or.ddit.user.eventfile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.vo.EventFileVO;
import kr.or.ddit.vo.NoticeFileVO;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;

public class AttachFileMapper {
	public static List<EventFileVO> mapping(FileItem[] items, String event_no){
		List<EventFileVO> fileItemList = new ArrayList<EventFileVO>();
		
		if(items != null){
			EventFileVO fileItemInfo = null;
			for(FileItem item : items){
				fileItemInfo = new EventFileVO();
				
				fileItemInfo.setEvent_no(event_no);
				
				// d:\temp\a.png or a.png
				// a.png
				String fileName = FilenameUtils.getName(item.getName());
				
				fileItemInfo.setEfile_name(fileName);
				fileItemInfo.setEvent_content_type(item.getContentType());
				fileItemInfo.setEfile_size(String.valueOf(item.getSize()));
				
				// a.png => a
				String baseName = FilenameUtils.getBaseName(fileName);
				// a.png => png						
				String extension = FilenameUtils.getExtension(fileName);
				// 파일명_랜덤값.확장자 => file_save_name으로 활용
				// 랜덤값 : UUID(Univerally Unique IDentifier) : 128bit 랜덤 유일값 반환(-포함)
				String genID = UUID.randomUUID().toString().replace("-", "");
				
				String fileSaveName = baseName + "_" + genID + "." + extension;
				
				
				fileItemInfo.setEfile_save_name(fileSaveName);				
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











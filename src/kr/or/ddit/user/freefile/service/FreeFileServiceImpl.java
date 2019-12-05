package kr.or.ddit.user.freefile.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.freefile.dao.FreeFileDao;
import kr.or.ddit.user.freefile.dao.FreeFileDaoImpl;
import kr.or.ddit.vo.Free_FileVO;

public class FreeFileServiceImpl implements FreeFileService {
	private static FreeFileService service = new FreeFileServiceImpl();
	private FreeFileDao dao;
	
	private FreeFileServiceImpl(){
		dao = FreeFileDaoImpl.getInstance();
		
	}
	public static FreeFileService getInstance(){
		return (service == null) ? service = new FreeFileServiceImpl() : service;
	}

	@Override
	public Free_FileVO fileItemInfo(Map<String, String> params) {
		Free_FileVO fileItemInfo = null;
		try {
			fileItemInfo = dao.fileItemInfo(params); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fileItemInfo;
	}
	@Override
	public void insertFileItemInfo(List<Free_FileVO> fileItemList) {
		// TODO Auto-generated method stub
		
	}

}

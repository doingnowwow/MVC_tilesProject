package kr.or.ddit.user.freeboard.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.user.freeboard.dao.FreeDao;
import kr.or.ddit.user.freeboard.dao.FreeDaoImpl;
import kr.or.ddit.user.freefile.dao.FreeFileDao;
import kr.or.ddit.user.freefile.dao.FreeFileDaoImpl;
import kr.or.ddit.utiles.AttachFileMapper;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.Free_FileVO;
import kr.or.ddit.vo.QnaFileVO;

public class FreeServiceImpl implements FreeService {

	
	private static FreeService service = new FreeServiceImpl();
	private FreeDao freeDao;
	private FreeFileDao freefileDao;
	
	
	private FreeServiceImpl(){
		freeDao = FreeDaoImpl.getInstance();
		freefileDao = FreeFileDaoImpl.getInstance();
	} 
	
	public static FreeService getInstance(){
		return (service == null) ? service = new FreeServiceImpl() : service;
	}
	
	
	@Override
	public List<FreeVO> freeList(Map<String, String> params) {
		List<FreeVO> freeboardList = null;
		try {
			freeboardList = freeDao.freeList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return freeboardList;
	}

	@Override
	public FreeVO freeInfo(Map<String, String> params) {
		FreeVO freeInfo = null;
		try {
			freeInfo = freeDao.freeInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return freeInfo;
	}

	@Override
	public void insertfreeInfo(FreeVO freeInfo, FileItem[] items) {
		try { 
			String free_no = freeDao.insertfreeInfo(freeInfo, items);
			
			List<Free_FileVO> fileItemList = AttachFileMapper.mapping(items, free_no);
			
			freefileDao.insertFileItemInfo(fileItemList);
			// 첨부파일 인서트할 때 bo_no => file_bo_no로 활용
			/*List<Free_FileVO> fileItemList = AttachFileMapper.mapping(items, bo_no);
			freefileDao.insertFileItemInfo(fileItemList);*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatefreeInfo(FreeVO freeInfo) {
		try {
			freeDao.updatefreeInfo(freeInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteFreeInfo(Map<String, String> params) {
		try {
			freeDao.deleteFreeInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String totalCount(Map<String, String> params) {
		String totalCount = "0";
		try{
		totalCount = freeDao.totalCount(params);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return totalCount;
	}

	@Override
	public void insertfreeReplyInfo(FreeVO freeInfo) {
		// TODO Auto-generated method stub

	}

}

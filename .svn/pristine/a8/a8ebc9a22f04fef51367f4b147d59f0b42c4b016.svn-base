package kr.or.ddit.user.freeboard.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.user.freefile.service.FreeFileService;
import kr.or.ddit.user.freefile.service.FreeFileServiceImpl;
import kr.or.ddit.user.qnafile.service.QnaFileService;
import kr.or.ddit.user.qnafile.service.QnaFileServiceImpl;
import kr.or.ddit.vo.Free_FileVO;
import kr.or.ddit.vo.QnaFileVO;

public class FreeFileDownAction implements IAction {

	private boolean redirectFlag = false;

	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,	HttpServletResponse response) {
		
		

		String fileSEQ = request.getParameter("fileSEQ");
	    String free_no = request.getParameter("free_no");
	      
	      Map<String, String> params = new HashMap<String, String>();
	      params.put("ffile_seq", fileSEQ);
	      
	      FreeFileService service = FreeFileServiceImpl.getInstance();
	      Free_FileVO freefileInfo = service.fileItemInfo(params);
	      
	  
	      
	      File downloadFile = new File(GlobalConstant.FILE_PATH, freefileInfo.getFfile_save_name());
	      
	      if(downloadFile.exists()){
	         String fileName = null;
	         try {
	            fileName = URLEncoder.encode(freefileInfo.getFfile_name(), "UTF-8");
	         } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	         }
	         
	         response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
	         response.setContentType("application/octet-stream");
	         response.setContentLength((int)downloadFile.length());
	      
	         byte[] buffer = new byte[(int)downloadFile.length()];
	         
	         BufferedInputStream inputStream = null;
	         
	         try{
	         inputStream = new BufferedInputStream(new FileInputStream(downloadFile));
	         } catch(FileNotFoundException e){
	            e.printStackTrace();
	         }
	         BufferedOutputStream outputStream = null;
	         
	         try {
	            outputStream = new BufferedOutputStream(response.getOutputStream());
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
	         
	         int readCNT = 0;
	         try {
	            while((readCNT = inputStream.read(buffer)) != -1){
	               outputStream.write(buffer);
	            }
	         } catch (IOException | IllegalStateException e) {
	            e.printStackTrace();
	         }
	         
	         try {
	            inputStream.close();
	         } catch (IOException  | IllegalStateException e) {
	            e.printStackTrace();
	         }
	         try {
	            outputStream.close();
	         } catch (IOException  | IllegalStateException e) {
	            e.printStackTrace();
	         }
	      }
	      
	      return null;
	   }
}

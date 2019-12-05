package kr.or.ddit.user.notice.controller;

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
import kr.or.ddit.user.noticefile.service.NoticeFileService;
import kr.or.ddit.user.noticefile.service.NoticeFileServiceImpl;
import kr.or.ddit.vo.NoticeFileVO;

public class NoticeFileDownAction implements IAction {
	private boolean redirectFlag = false;

	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,	HttpServletResponse response) {
		
		String fileSEQ = request.getParameter("fileSEQ");
	    String notice_no = request.getParameter("notice_no");
	      
	      Map<String, String> params = new HashMap<String, String>();
	      params.put("nfile_seq", fileSEQ);
	      
	      NoticeFileService service = NoticeFileServiceImpl.getInstance();
	      NoticeFileVO noticefileInfo = service.fileItemInfo(params);
	      
	  
	      
	      File downloadFile = new File(GlobalConstant.FILE_PATH, noticefileInfo.getNfile_save_name());
	      
	      if(downloadFile.exists()){
	         String fileName = null;
	         try {
	            fileName = URLEncoder.encode(noticefileInfo.getNfile_name(), "UTF-8");
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

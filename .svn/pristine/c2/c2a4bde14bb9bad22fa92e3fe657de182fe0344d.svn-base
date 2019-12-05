<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 등록</title>
<script>
$(function(){
	// 섬머노트를 div를 활용한 textarea에 추가.
	// http://summernote.org 활용
    $('#event_content').summernote({
    		lang: 'ko-KR',
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
	
	$('#eventForm').submit(function(){
		// 입력값 검증 - 과제
		$(this).attr('action', '${pageContext.request.contextPath}/user/event/insertEvent.do');
		$(this).append('<input type="hidden" name="com_id" value="${LOGIN_MEMBERINFO.com_id}"></input>');
		$(this).append('<input type="hidden" name="com_name" value="${LOGIN_MEMBERINFO.com_name}"></input>');
// 		$(this).append('<input type="hidden" name="notice_no" value="${pageContext.request.remoteAddr}"></input>');
		$(this).append('<input type="hidden" name="event_content" value="' + $('#event_content').summernote('code') + '"></input>');
		return true;		
	});
	
    $('#listEventBTN').click(function(){
		location.href = '${pageContext.request.contextPath}/user/event/eventList.do';
	});
    
}); 
</script>
</head>
<body>
<form id="eventForm" class="form-horizontal" role="form" action="<%=request.getContextPath()%>/user/event/insertEventAction.do" method="post" enctype="multipart/form-data">
	<div class="form-group">
		<label class="control-label col-sm-2" for="event_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="event_title" name="event_title">
		</div>
	</div>
	<div class="form-group">
	 <label class="control-label col-sm-2" for="event_title">시작일:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="event_start" name="event_start">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="event_title">종료일:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="event_end" name="event_end">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="event_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="event_content">내용을 입력해주세요...</div>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="file01">첨부파일1:</label>
		<div class="col-sm-10">
			 <input type="file" class="filestyle" id="file01" name="files" data-buttonName="btn-primary">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="file02">첨부파일2:</label>
		<div class="col-sm-10">
			 <input type="file" class="filestyle" id="file02" name="files" data-buttonName="btn-primary">
		</div>
	</div>
	<div class="form-group"> 
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-info" style="float: right" >등록</button>
			<button type="reset" class="btn btn-danger" style="float: right" >취소</button>
			<button type="button" class="btn btn-primary" style="float: right" id="listEventBTN">목록</button>
		</div>
	</div>
</form>
</body>
</html>
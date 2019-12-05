<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세보기</title>
<!-- 이미지 슬라이드 사이즈 조정 -->
<style type="text/css">
.carousel{
	width:200px;
    height:150px;
    margin-left: 200px;
}
.carousel-inner > .item > img{
    width:200px;
    height:150px;
}       

</style>

<script>
$(function(){
	// 섬머노트를 div를 활용한 textarea에 추가.
	// http://summernote.org 활용
    $('#notice_content').summernote({
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
 
    $('#com_name').val('${eventInfo.com_name}');
    $('#event_title').val('${eventInfo.event_title}');
    $('#com_name').val('${eventInfo.com_name}');
    
    $('#event_start').val('${fn:substringBefore(eventInfo.event_start, " ")}');
    $('#event_end').val('${fn:substringBefore(eventInfo.event_end, " ")}'); 
    $('#event_content').summernote('code', '${eventInfo.event_content}'); 
    
    $('#eventView').submit(function(){
    	var flag = redirectFlag();
    	if(flag){
    		var title = $('input[name=event_title]').val();

			if (title.length <= 0) {
				alertPRT('제목을 입력하세요!');
				return false;
    		
    	}
    	$(this).attr('action', '${pageContext.request.contextPath}/admin/event/updateEvent.do');
    	$(this).append('<input type="hidden" name="com_id" value="${LOGIN_MEMBERINFO.com_id}"></input>');
    	$(this).append('<input type="hidden" name="mem_id" value="${LOGIN_MEMBERINFO.mem_id}"></input>');

    	$(this).append('<input type="hidden" name="event_content" value="' + $('#event_content').summernote('code') + '"></input>');
		$(this).append('<input type="hidden" name="event_no" value="${eventInfo.event_no}"></input>');
    	return true;
    	
    	}else{
    		alertPRT('작성자만 수정할 수 있어욘~');
    		return false;
    	}
    });
    
    $('#listEventBTN').click(function(){
		location.href = '${pageContext.request.contextPath}/admin/event/eventList.do';
	});
    $('#deleteEventBTN').click(function(){
		location.href = '${pageContext.request.contextPath}/admin/event/deleteEvent.do?event_no=${eventInfo.event_no}';
	});
  
	$('#eventReplyRegist').submit(function(){
		if(!"${LOGIN_MEMBERINFO}"){
			alert("로그인하세요.");
			return false;
		}
		
		$(this).attr('action', '${pageContext.request.contextPath}/admin/eventreply/insertEventReply.do');
		$(this).append('<input type="hidden" name="event_no" value="${eventInfo.event_no}"></input>');
		$(this).append('<input type="hidden" name="er_seq" value="0"></input>');
		$(this).append('<input type="hidden" name="er_depth" value="0"></input>');
		$(this).append('<input type="hidden" name="mem_id" value="${LOGIN_MEMBERINFO.mem_id}"></input>');
	
	});
	$('.update').click(function(){
		if(!"${LOGIN_MEMBERINFO}"){
			alert("로그인하세요.");
			return false;
		}else if("${LOGIN_MEMBERINFO.com_id}" != "${eventInfo.mem_id}"){
			alert("해당 게시글은 작성자만 수정할 수 있습니다123.");
			return false;
		}
	});
	
	$('form').on('click', 'button[class=delete]', function(){
		if(!"${LOGIN_MEMBERINFO}"){
			alert("로그인하세요.");
			return false;
		}else if("${LOGIN_MEMBERINFO.com_id}" != "${eventInfo.mem_id}"){
			alertPRT('해당 게시글은 작성자만 삭제할 수 있습니다.');
			return false;
		}else if("${LOGIN_MEMBERINFO.com_id}" == "${eventInfo.mem_id}"){
			var er_no = $(this).attr('id');
			$(location).attr('href', '${pageContext.request.contextPath}/admin/eventreply/deleteEventReply.do?er_no=' + er_no);
		}
	});
	
	
});
	function alertPRT(msg) {
		BootstrapDialog.show({
			title : '경고!',
			message : msg
		});
	} 
	
	function redirectFlag() {
		if ('${eventInfo.com_id}' == '${LOGIN_MEMBERINFO.com_id}') {
			return true;
		}
		return false;
	};
	
</script>
</head>
<body>
<form id="eventView" class="form-horizontal" role="form" method="post">
	<div class="form-group">
		<label class="control-label col-sm-2" for="event_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="event_title" name="event_title">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="com_name">상호명:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="com_name" name="com_name" disabled="disabled">
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
			<div id="event_content"></div>
		</div>
	</div>
	<hr>
	<div class="form-group">
		<label class="control-label col-sm-2" for="event_content">첨부파일:</label>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">

			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
			</ol>
	
			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox" style="height: 200px;">
				<c:forEach items="${eventInfo.items }" var="efileitem" varStatus="stat">
						<c:if test="${stat.first }">
							<div class="item active">
						</c:if> 
						<c:if test="${stat.last }">
							<div class="item">
						</c:if>
						<img src="/files/${efileitem.efile_save_name }" alt="pic1">
					</div>
			</c:forEach>
			</div>
			<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
</div>
</div>
</div>
	<div class="form-group"> 
			<button type="button" class="btn btn-danger"  style="float: right"  id="deleteEventBTN">삭제</button>
			<button type="reset"  class="btn btn-warning" style="float: right" id="resetEventBTN">취소</button>
			<button type="submit" class="btn btn-info" 	  style="float: right">저장</button>
			<button type="button" class="btn btn-primary" style="float: right" id="listEventBTN">목록</button>
	</div>
</form>


<form id="eventReplyRegist" method="post" action="">
	<div class="form-group"> 
		<label class="control-label col-sm-2" >댓글:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="er_content" >
		</div>
		<br><br>
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary">댓글등록</button>
		</div>
	</div>
</form>
<hr>
	<c:forEach items="${erList}" var="replyList">
<form id="${replyList.er_no}" method="post" action="${pageContext.request.contextPath}/admin/eventreply/updateEventReply.do">
	<div class="form-group"> 
		<label class="control-label col-sm-2" >댓글:</label>
		<div class="col-sm-10">	
			<c:forEach begin="1" end="${replyList.er_depth}" varStatus="stat">
				<span id="span">==&gt;</span>
				<c:if test="${stat.last }">
					<i class="fa fa-angle-right"></i>
				</c:if>
			</c:forEach>
			
			<input type="text" class="form-control" id="event_reply_content" name="er_content" value="${replyList.er_content }">
			<input type="hidden" name="er_no" value="${replyList.er_no }">
		</div>
		<br><br>
		<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="update" id="${replyList.er_no}">댓글수정</button>
				<button type="button" class="delete" id="${replyList.er_no}">댓글삭제</button>
				<input type="text" value="${replyList.mem_id }" style="float: right" disabled>
				<input type="text" value="${replyList.er_date }" style="float: right" disabled>
		</div>
	</div>
</form>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
<form method="post" action="${pageContext.request.contextPath}/admin/eventreply/insertEventReReply.do">
		<div class="form-group">
				<label class="control-label col-sm-2" >대댓글:</label>
		
			<input type="hidden" name="er_no" value="${replyList.er_no}">
			<input type="hidden" name="event_no" value="${eventInfo.event_no}">
			<input type="hidden" name="mem_id" value="${LOGIN_MEMBERINFO.mem_id}">
			<input type="hidden" name="er_group" value="${replyList.er_no}">
			<input type="hidden" name="er_seq" value="${replyList.er_seq}">
			<input type="hidden" name="er_depth" value="${replyList.er_depth}">
			<input type="text" class="form-control" id="er_content" name="er_content" >
	
			<button type="submit" class="btn btn-primary" >댓글등록</button>
		</div>
</form>
	</c:forEach>


</body>
</html>
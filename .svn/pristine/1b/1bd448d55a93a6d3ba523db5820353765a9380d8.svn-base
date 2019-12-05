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
 
     
    $('#notice_title').val('${noticeInfo.notice_title}');
    $('#notice_reg_date').val('${noticeInfo.notice_reg_date}');
    $('#mem_id').val('${noticeInfo.mem_id}');
    $('#notice_content').summernote('code', '${noticeInfo.notice_content}');
    
    $('#noticeView').submit(function(){
    	//enctype >> 첨부파일 관련
//     	if('${noticeFileInfo.nfile_seq}'!='' && '${noticeFileInfo.nfile_seq}'!='null'){
//     	 	$(this).attr('enctype', 'multipart/form-data');
//     	}else{
//     	 	$(this).attr('enctype', 'application/x-www-form-urlencoded');
//     	}
    	
     	var flag = redirectFlag();
    	if(flag){
     		var title = $('input[name=notice_title]').val();

 			if (title.length <= 0) {
 				alertPRT('제목을 입력하세요!');
				return false;
    		
     	}
    	$(this).attr('action', '${pageContext.request.contextPath}/admin/notice/updateNotice.do');
		$(this).append('<input type="hidden" name="notice_content" value="' + $('#notice_content').summernote('code') + '"></input>');
		$(this).append('<input type="hidden" name="notice_no" value="${noticeInfo.notice_no}"></input>');
    	return true;
    	
     	}else{
     		alertPRT('작성자만 수정할 수 있어욘~');
     		return false;
     	}		
    });
    
    $('#listNoticeBTN').click(function(){
		location.href = '${pageContext.request.contextPath}/admin/notice/noticeList.do';
	});
    $('#deleteNoticeBTN').click(function(){
		location.href = '${pageContext.request.contextPath}/admin/notice/deleteNotice.do?notice_no=${noticeInfo.notice_no}';
	});
    
});
 function redirectFlag(){
	if('${freeboardInfo.bo_writer}' == '${LOGIN_MEMBERINFO.mem_id}'){
		if('${freeboardInfo.bo_pwd}' == $('#bo_pwd').val()){
			return true;
		}
	}
	return false;
} 


	function alertPRT(msg) {

		BootstrapDialog.show({
			title : '경고!',
			message : msg
		});
	}
	function redirectFlag() {
		if ('${noticeInfo.mem_id}' == '${LOGIN_MEMBERINFO.mem_id}') {
			return true;
		}else if('${noticeInfo.com_id}' == '${LOGIN_MEMBERINFO.com_id}'){
			return true;
		}
		return false;
	}
</script>
</head>
<body>
<form id="noticeView" class="form-horizontal" role="form" method="post">
	<div class="form-group">
		<label class="control-label col-sm-2" for="notice_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="notice_title" name="notice_title">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="mem_id" >작성자:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="mem_id" name="mem_id" disabled="disabled">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="free_reg_date" >작성일:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="notice_reg_date" name="notice_reg_date" disabled="disabled">
		</div>
	</div>
		<div class="form-group">
		<label class="control-label col-sm-2" for="notice_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="notice_content"></div>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="notice_content">첨부파일:</label>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">

			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
			</ol>
	
			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox" style="height: 200px;">
				<c:forEach items="${noticeInfo.items }" var="nfileitem" varStatus="stat">
						<c:if test="${stat.first }">
							<div class="item active">
						</c:if>
						<c:if test="${stat.last }">
							<div class="item">
						</c:if>
						<img src="/files/${nfileitem.nfile_save_name }" alt="pic1">
			</div>
			</c:forEach>
			<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
	</div>	</div>
	<div class="form-group"> 
		<div class="col-sm-offset-2 col-sm-10"> 
			<button type="button" class="btn btn-danger" style="float: right" id="deleteNoticeBTN">삭제</button>
			<button type="reset" class="btn btn-warning" style="float: right" id="resetNoticeBTN">취소</button>
			<button type="submit" class="btn btn-info" style="float: right">저장</button>
			<button type="button" class="btn btn-primary" style="float: right" id="listNoticeBTN">목록</button>
		</div>
	</div>
</form>
</body>
</html>
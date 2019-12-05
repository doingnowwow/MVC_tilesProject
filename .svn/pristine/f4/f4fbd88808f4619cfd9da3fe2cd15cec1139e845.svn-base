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
<title>자유게시글 정보</title>
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

hr{
	border : 1px solid lightgray;
}

#free_reply_content{
	display : inline-block;
	margin-left : 188px;
}

#fr_content{
	display : inline-block;

	width : 700px;
}  
img {
	width: 200px;
	height: 150px;
}
   
</style>

<script>
$(function(){
	// 섬머노트를 div를 활용한 textarea에 추가.
	// http://summernote.org 활용
    $('#free_content').summernote({
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
  
    
    $('#free_reg_date').val('${freeInfo.free_reg_date}');
    $('#free_title').val('${freeInfo.free_title}');
    $('#free_content').summernote('code', '${freeInfo.free_content}');
    $('#mem_id').val('${freeInfo.mem_id}');

    //게시글 수정
    $('#freeboardView').submit(function(){
    	
    	var flag = redirectFlag();
    	
    	if(flag){
	    	var title = $('input[name=free_title]').val();
	
			if (title.length <= 0) {
				alertPRT('제목을 입력하세요!');
				return false;
			}    	
    	
	    	$(this).attr('action', '${pageContext.request.contextPath}/user/freeboard/updateFreeboard.do');
	    	$(this).append('<input type="hidden" name="mem_id" value="${LOGIN_MEMBERINFO.mem_id}"></input>');
			$(this).append('<input type="hidden" name="free_ip" value="${pageContext.request.remoteAddr}"></input>'); 
			$(this).append('<input type="hidden" name="free_content" value="' + $('#free_content').summernote('code') + '"></input>');
			$(this).append('<input type="hidden" name="free_no" value="${freeInfo.free_no}"></input>');
			
			return true;
		}else{
			alertPRT('해당 게시글을 수정할수 없습니다.');
			return false;
		}
    });
    
    //게시글 목록
    $('#freeboardListBTN').click(function(){
		location.href = '${pageContext.request.contextPath}/user/freeboard/freeboardList.do';
	});
    
    
    //게시글 삭제
    $('#deleteFreeboardBTN').click(function(){
    	var flag = redirectFlag();
    	if (flag) {
    		location.href = '${pageContext.request.contextPath}/user/freeboard/deleteFreeboard.do?free_no='+${freeInfo.free_no};

		} else {
			alertPRT('해당게시글을 삭제할수 없습니다.');

		}
    });
    
    
    //댓글 등록
    $('#freeReplyRegist').submit(function(){
    	
    	if(eval('${!empty LOGIN_MEMBERINFO.mem_id}')){
    		$(this).attr('action', '${pageContext.request.contextPath}/user/freereply/insertFreeReply.do');
			$(this).append('<input type="hidden" name="free_no" value="${freeInfo.free_no}"></input>');
			$(this).append('<input type="hidden" name="fr_seq" value="0"></input>');
			$(this).append('<input type="hidden" name="fr_depth" value="0"></input>');
			$(this).append('<input type="hidden" name="mem_id" value="${LOGIN_MEMBERINFO.mem_id}"></input>');
			
			return true;
		}else if('${!empty LOGIN_MEMBERINFO.com_id}'){
			alert('일반회원만 등록 가능합니다.');
			return false;
		}else{
			alertPRT('로그인하세요.');
		 	return false;
		}  
		/* 
		var flag = redirectFlag();
		
		if(flag){
			$(this).attr('action', '${pageContext.request.contextPath}/user/freereply/insertFreeReply.do');
			$(this).append('<input type="hidden" name="free_no" value="${freeInfo.free_no}"></input>');
			$(this).append('<input type="hidden" name="fr_seq" value="0"></input>');
			$(this).append('<input type="hidden" name="fr_depth" value="0"></input>');
			$(this).append('<input type="hidden" name="mem_id" value="${LOGIN_MEMBERINFO.mem_id}"></input>');
			
			return true;
		}else{
		 	alertPRT('로그인하세요.');
		 	return false;
		} */
	});
    
    //댓글 수정
    $('.update').click(function(){
		if(!"${LOGIN_MEMBERINFO}"){
			alert("로그인하세요.");
			return false;
		}else if("${LOGIN_MEMBERINFO.mem_id}" != "${freeInfo.mem_id}"){
			alert("해당 댓글은 작성자만 수정할 수 있습니다.");
			return false;
		}
	});
    
  
    //댓글 삭제
    $('form').on('click', 'button[class=delete]', function(){
		if(!"${LOGIN_MEMBERINFO}"){
			alert("로그인하세요.");
			return false;
		}else if("${LOGIN_MEMBERINFO.mem_id}" != "${freeInfo.mem_id}"){
    	
			alertPRT('해당 게시글은 작성자만 삭제할 수 있습니다.');
		}else if("${LOGIN_MEMBERINFO.mem_id}" == "${freeInfo.mem_id}"){
			var fr_no = $(this).attr('id');
			$(location).attr('href', '${pageContext.request.contextPath}/user/freereply/deleteFreeReply.do?fr_no=' + fr_no);
		}
	});
    
    
    
});

function alertPRT(msg) {
	BootstrapDialog.show({
		title : '경고!',
		message : msg
	});
} 


function redirectFlag(){
	 if ('${freeInfo.mem_id}' == '${LOGIN_MEMBERINFO.mem_id}') {
		return true;
	 }
	 return false;
}; 
</script>
</head>
<body>
<form id="freeboardView" class="form-horizontal" role="form" action="" method="post">
	<div class="form-group">
		<label class="control-label col-sm-2" for="free_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="free_title" name="free_title" >
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
			<input type="text" class="form-control" id="free_reg_date" name="free_reg_date" disabled="disabled">
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="free_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="free_content"></div>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="free_content">첨부파일:</label>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
			</ol>
	
			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox" style="height: 200px;">
				<c:forEach items="${freeInfo.items }" var="freeitem" varStatus="stat">
					<c:if test="${stat.first }">
						<div class="item_active">
					</c:if>
					<c:if test="${stat.last }">
						<div class="item">
					</c:if>
						<img src="/files/${freeitem.ffile_save_name }" alt="pic1"
						
							onclick="javscript:location.href='${pageContext.request.contextPath }/user/freeboard/freeFileDown.do?fileSEQ=${freeitem.ffile_seq }&free_no=${freeitem.free_no}';">
					</div>
				</c:forEach>		 
				
			</div> 
			<!-- Left and right controls -->
			<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
		</div>
	</div>
	
	<br><br><br>
	<div class="form-group"> 
		<div class="col-sm-offset-2 col-sm-10">
			<button type="button" class="btn btn-danger" id="deleteFreeboardBTN">삭제</button>
			<button type="button" class="btn btn-info" id="freeboardListBTN">목록</button>
			<button type="submit" class="btn btn-default" style="float: right">수정</button>
		</div>
	</div>
</form>
<hr>
<form id="freeReplyRegist" method="post">
	<div class="form-group"> 
		<label class="control-label col-sm-2" >댓글:</label>
	
			<input type="text" class="form-control" id="fr_content" name="fr_content" >
	
	
			<button type="submit" class="btn btn-primary">댓글등록</button>
	
	</div>
</form>
<hr>
	<c:forEach items="${rrList}" var="replyList">
<form id="${replyList.fr_no}" method="post" action="${pageContext.request.contextPath}/user/freereply/updateFreeReply.do">
		<div class="form-group"> 
		<label class="control-label col-sm-2" >댓글:</label>
		<div class="col-sm-10">
			<c:forEach begin="1" end="${replyList.fr_depth}" varStatus="stat">
				<span>==&gt;</span>
				<c:if test="${stat.last }">
					<i class="fa fa-angle-right"></i>
				</c:if>
			</c:forEach>
			
			<input type="text" class="form-control" id="review_reply_content" name="fr_content" value="${replyList.fr_content }">
			<input type="hidden" name="fr_no" value="${replyList.fr_no }">
			</div>
			<br><br>
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="update" id="${replyList.fr_no}">댓글수정</button>
				<button type="button" class="delete" id="${replyList.fr_no}">댓글삭제</button>
				<input type="text" value="${replyList.mem_id }" style="float: right" disabled>
				<input type="text" value="${replyList.fr_date }" style="float: right" disabled>
			</div>
		</div>
</form>
<form method="post" action="${pageContext.request.contextPath}/user/freereply/insertFreeReReply.do">
		<div class="form-group">
		<label class="control-label col-sm-2" >대댓글:</label>
	
			<input type="hidden" name="fr_no" value="${replyList.fr_no}">
			<input type="hidden" name="free_no" value="${freeInfo.free_no}">
			<input type="hidden" name="mem_id" value="${LOGIN_MEMBERINFO.mem_id}">
			<input type="hidden" name="fr_group" value="${replyList.fr_no}">
			<input type="hidden" name="fr_seq" value="${replyList.fr_seq}">
			<input type="hidden" name="fr_depth" value="${replyList.fr_depth}">
			<input type="text" class="form-control" id="fr_content" name="fr_content" >
		
			<button type="submit" class="btn btn-primary" >댓글등록</button>
	
	
		</div>
</form>
	</c:forEach>

</body>
</html>
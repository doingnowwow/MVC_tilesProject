<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시글 댓글등록</title>

<script>
$(function(){
	// 섬머노트를 div를 활용한 textarea에 추가.
	// http://summernote.org 활용
    $('#qna_content').summernote({
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
    
$('#goList').click(function(){
	
	
	location.href = '${pageContext.request.contextPath}/admin/qna/qnaList.do';
	
})  
    
    
$('#replyForm').submit(function(){
    	
	
	
 	
    	var title = $('input[name=qna_title]').val();
    	
    	if(title.length<=0){
    		alertPRT('제목을 입력하세요!');
			return false;
    	}
    	
    	if(title.length>32){
    		alertPRT('제목은 32자까지만 가능합니다');
			return false;
    	}
    	
    	
    	$(this).attr('action','${pageContext.request.contextPath}/admin/qna/insertQnaReply.do');
    	$(this).append('<input type="hidden" name="mem_id" value="${LOGIN_MEMBERINFO.mem_id}"></input>');
    	$(this).append('<input type="hidden" name="mem_id" value="${LOGIN_MEMBERINFO.com_id}"></input>');    	
    	$(this).append('<input type="hidden" name="qna_ip" value="${pageContext.request.remoteAddr}"></input>');
    	$(this).append('<input type="hidden" name="qna_content" value="'+ $('#qna_content').summernote('code')+'"></input>');
    	$(this).append('<input type="hidden" name="qna_group" value="${param.qna_group}"></input>');    	
    	$(this).append('<input type="hidden" name="qna_seq" value="${param.qna_seq}"></input>');    	
    	$(this).append('<input type="hidden" name="qna_depth" value="${param.qna_depth}"></input>');    	
    	return true;

    	
    
    
    
});




////////////////////////////////////////////
});



</script>
</head>
<body>
<div class="row">
	 <div class="col-sm-3">
		 <label class="col-sm-2 control-label">No :</label>
  		 <p class="form-control-static">111</p>
	 </div>
	 <div class="col-sm-8">
	 	<label class="col-sm-2 control-label">제목 :</label>
    	<p class="form-control-static">${param.qna_title}</p>	 </div>
	 <div class="col-sm-1">
	 	<p class="text-right text-danger bg-danger">${LOGIN_MEMBER.mem_id }의 답변</p>
	 </div>
</div>
<hr />
<form id="replyForm" class="form-horizontal" role="form" action="" method="post">
	<div class="form-group">
		<label class="control-label col-sm-2" for="qna_title" >제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="qna_title" name="qna_title" placeholder="제목은 간단히적어...." >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="mem_id">답변자명:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="mem_id" name="mem_id" value="${LOGIN_MEMBERINFO.mem_id}" disabled="disabled">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="qna_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="qna_content"><p>내용은 간단하게 적어라...</p></div>
		</div>
	</div>
	<div class="form-group"> 
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-success" style="float: right;">답글등록하기</button>
			<button type="reset" class="btn btn-danger"> 다시쓰기 </button>
			<button type="button" class="btn btn-info" id="goList">목록으로 돌아가기</button>
		</div>
	</div>
</form>
</body>
</html>
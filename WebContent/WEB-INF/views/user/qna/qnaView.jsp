<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시글 정보</title>
<!-- 이미지 슬라이드 사이즈 조정 -->
<style type="text/css">
.carousel {
	width: 200px;
	height: 150px;
	margin-left: 200px;
}

img {
	width: 200px;
	height: 150px;
}



</style>
<script>
	$(function() {
		// 섬머노트를 div를 활용한 textarea에 추가.
		// http://summernote.org 활용
		$('#qna_content').summernote({
			height : 150,
			codemirror : {
				theme : 'monokai'
			}
		});

		// 초기 표출 화면 
		$('#qna_title').val('${qnaInfo.qna_title}');
		$('#qna_content').summernote('code', '${qnaInfo.qna_content}');
		$('#mem_id').val('${qnaInfo.mem_id}');

		// 목록으로 돌아가기
		$('#qnaListBTN')
				.click(
						function() {
							location.href = '${pageContext.request.contextPath}/user/qna/qnaList.do';

						});

		/* 	$('#qnaFormBTN').click(function(){
				
				if(eval('${!empty LOGIN_MEMBERINFO}')){
					
					$(location).attr('href','${pageContext.request.contextPath}/user/main.jsp?contentPage=/user/qna/qnaForm.do');
				}else{
					alertPRT('로그인해주세요!');
					return flag;
				}
				
				 
				
			}) */

		// 게시글삭제
		$('#deleteQnaBTN').click(function() {

		var flag = redirectFlag();
		
		if (flag) {
				$(location).attr('href','${pageContext.request.contextPath}/user/qna/deleteQna.do?qna_no=${qnaInfo.qna_no}');

							} else {
								alertPRT('해당게시글은 작성자만 삭제할수잇어!');

							}

						})

		//게시글 수정
		$('#qnaView').submit(function() {
			

		var flag = redirectFlag();
		
		if(flag){
							var title = $('input[name=qna_title]').val();

							if (title.length <= 0) {
								alertPRT('제목을 입력하세요!');
								return false;
							}
							
			$(this).attr('action','${pageContext.request.contextPath}/user/qna/updateQna.do');
			$(this).append('<input type="hidden" name="mem_id" value="${LOGIN_MEMBERINFO.mem_id}"></input>');
			$(this).append('<input type="hidden" name="mem_id" value="${LOGIN_MEMBERINFO.com_id}"></input>');
			$(this).append('<input type="hidden" name="qna_ip" value="${pageContext.request.remoteAddr}"></input>');
			$(this).append('<input type="hidden" name="qna_content" value="'+ $('#qna_content').summernote('code') + '"></input>');
			$(this).append(	'<input type="hidden" name="qna_no" value="${qnaInfo.qna_no}"></input>');

				return true;
		}else{
			alertPRT('작성자만 수정할 수 있습니다!');
			return false;
		}
	});

//답글쓰기				
$('#replyFormBTN').click(function() {
	
	var flag = adminCheck();
	
	if(flag){
		
		
	var qna_title = encodeURIComponent('${qnaInfo.qna_title}');

	var url = '${pageContext.request.contextPath}/user/qna/qnaReplyForm.do';
	$(location).attr('href',url	+ "?rnum=${param.rnum}&qna_title="+ qna_title+ "&qna_group=${qnaInfo.qna_group}&qna_seq=${qnaInfo.qna_seq}&qna_depth=${qnaInfo.qna_depth}");
	
		return true;
	
	}else{
		alertPRT('관리자만 답글을 등록할 수 있습니다!');
		return false;
	}
	

	
		})
		
		
		
		
		
		
		
///////////////////////////여기가 끝 
	});

function alertPRT(msg) {

		BootstrapDialog.show({
			title : '경고!',
			message : msg
		});

		
	} 
	
	
function redirectFlag(){
	
	if ('${qnaInfo.mem_id}' == '${LOGIN_MEMBERINFO.mem_id}') {
		return true;
	 }else if('${qnaInfo.mem_id}' == '${LOGIN_MEMBERINFO.com_id}'){
		 return true;
	 }else{
		 
	 return false;
	 }
}

function adminCheck(){
	
	if(${LOGIN_MEMBERINFO.mem_admin eq "y"}){
		return true;
	}
	
	return false;

}

	  
</script>
</head>
<body>
 <div class="panel panel-grey">
  <div class="panel-heading">QnA 게시판입니다</div>
  <br><br>
	<form class="form-horizontal" role="form" action="" method="post"	id="qnaView">
		<div class="form-group">
			<label class="control-label col-sm-2" for="qna_title">제목:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="qna_title"
					name="qna_title">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="mem_id">작성자 아이디:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="mem_id" name="mem_id" disabled="disabled">
			</div>
		</div>


		<div class="form-group">
			<label class="control-label col-sm-2" for="qna_content">내용:</label>
			<div class="col-sm-10">
				<div id="qna_content"></div>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="qna_content">첨부파일:</label>
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>

				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox" style="height: 200px;">
					<c:forEach items="${qnaInfo.items }" var="qfileitem"
						varStatus="stat">
						<c:if test="${stat.first }">
							<div class="item active"> 
						</c:if>
						<c:if test="${stat.last }">
							<div class="item">
							</div>
						</c:if>
						<img src="/files/${qfileitem.qfile_save_name }" alt="사진ㅋ" 
						onclick="javscript:location.href='${pageContext.request.contextPath }/user/qna/qnaFileDown.do?fileSEQ=${qfileitem.qfile_seq }&qna_no=${qfileitem.qna_no}';">	</div>
				</c:forEach>

			<!-- Left and right controls -->
			<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>

</div>	</div>	
	<br><br><br><br><br>
		<div class="form-group"  > 
			<div class="col-sm-offset-2 col-sm-10" >
				<button type="submit" class="btn btn-success" id="qnaFormBTN">글수정하기</button>
				<button type="button" class="btn btn-danger" id="deleteQnaBTN">글삭제</button>
				<button type="button" class="btn btn-primary" id="replyFormBTN">답글달기</button>
				<button type="button" class="btn btn-info" id="qnaListBTN">목록으로	돌아가기</button>
				<!-- 	<button type="submit" class="btn btn-default" style="float: right">수정</button> -->
			</div>
		</div>
	
	</form>
	</div>
	
</body>
</html>
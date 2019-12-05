<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기게시글 등록</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/validation_board.js"></script>
<script>
$(function(){
	// 섬머노트를 div를 활용한 textarea에 추가.
	// http://summernote.org 활용
    $('#review_content').summernote({
    		lang: 'ko-KR',
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
    // 포커스 처리
    // $('#review_content').summernote( {focus: true} );
    // 값 취득
    // $('#review_content').summernote('code');
    // 값 추가
    // $('#review_content').summernote('code', '<font color="red">추가글</font>');
    // 에디터 제거
    // $('#review_content').summernote('destroy');
    
// 	reviewotstrapDialog.show({
// 	    title: '알럿창',
// 	    message: '알럿창으로 활용하세요!'
// 	});
	
// 	reviewotstrapDialog.show({
//         message: '컨펌 다이얼로그로 활용하세요!',
//         buttons: [{
//             label: 'Button 1'
//         }, {
//             label: 'Button 2',
//             cssClass: 'btn-primary',
//             action: function(){
//                 alert('Hi Orange!');
//             }
//         }, {
//             icon: 'glyphicon glyphicon-ban-circle',
//             label: 'Button 3',
//             cssClass: 'btn-warning'
//         }, {
//             label: 'Close',
//             action: function(dialogItself){
//                 dialogItself.close();
//             }
//         }]
//     });

	$('#reviewForm').submit(function(){
		$(this).attr('action', '${pageContext.request.contextPath}/user/review/insertReview.do');
		$(this).append('<input type="hidden" name="mem_id" value="${LOGIN_MEMBERINFO.mem_id}"></input>');
		$(this).append('<input type="hidden" name="review_ip" value="${pageContext.request.remoteAddr}"></input>');
		$(this).append('<input type="hidden" name="review_content" value="' + $('#review_content').summernote('code') + '"></input>');
		
		if(!$('#review_title').val().validationTITLE()){
		 	BootstrapDialog.show({
		 	    title: '경고',
		 	    message: '제목을 바르게 입력해주세요.'
	 		});
			return false;
		}
		if($('input[name=review_content]').val().length <= 0){
		 	BootstrapDialog.show({
		 	    title: '경고',
		 	    message: '내용을 입력해주세요.'
	 		});
			return false;
		}
		if($('#drink_name').val().trim().length <= 0){
			BootstrapDialog.show({
		 	    title: '경고',
		 	    message: '상호명을 입력해주세요.'
	 		});
			return false;
		}
		if($('#drink_no').val().trim().length <= 0){
			BootstrapDialog.show({
		 	    title: '경고',
		 	    message: '상호명을 정확하게 입력해주세요.'
	 		});
			return false;
		}
		
		return true;
	});
	
	$('#listBTN').click(function(){
		$(location).attr('href', '${pageContext.request.contextPath}/user/review/reviewList.do');
	});
	
	$('#searchDrink').click(function(){
		var url = '${pageContext.request.contextPath }/modal/drinkCheck.do';
		var options = 'copyhistory=no,width=380px;height=300px,status=no,resizable=no,scrollbar=no';
		window.open(url, '검색', options);
	});
});
</script>
</head>
<body>
<form id="reviewForm" class="form-horizontal" role="form" action="" method="post" enctype="multipart/form-data">
	<div class="form-group">
		<label class="control-label col-sm-2" for="review_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="review_title" name="review_title" placeholder="제목 입력...">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="drink_no">상호명:</label>
		<div class="col-sm-10">
			<input type="text" id="drink_name" name="drink_name" value="">&nbsp;&nbsp;
			<input type="hidden" id="drink_no" name="drink_no" value="">&nbsp;&nbsp;
			<button type="button" class="btn btn-info" id="searchDrink">검색</button>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="review_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="review_content" >내용을 입력해주세요...</div>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="review_like">추천:</label>
		<div class="col-sm-10">
			<input type="radio" class="form-control" id="review_like" name="review_like" value="y">추천&nbsp;&nbsp;&nbsp;
			<input type="radio" class="form-control" id="review_like" name="review_like" value="n">비추천
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
			<button type="submit" class="btn btn-info" style="float: right">등록</button>
			<button type="reset" class="btn btn-danger" style="float: right" >취소</button>
			<button type="button" class="btn btn-primary" style="float: right" id="listBTN">목록</button>
		</div>
	</div>
</form>
</body>
</html>
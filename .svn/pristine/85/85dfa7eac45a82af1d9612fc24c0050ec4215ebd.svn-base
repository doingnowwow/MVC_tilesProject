<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시글 등록</title>
<script>
$(function(){
	// 섬머노트를 div를 활용한 textarea에 추가.
	// http://summernote.org 활용
    $('#drink_info').summernote({
    		lang: 'ko-KR',
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });

	$('#drinkForm').submit(function(){
		
		$(this).attr('action', '${pageContext.request.contextPath}/user/drink/insertDrink.do');
		/* $(this).append('<input type="hidden" name="bo_ip" value="${pageContext.request.remoteAddr}"></input>');  */
		$(this).append('<input type="hidden" name="com_id" value="${LOGIN_MEMBERINFO.com_id}"></input>');
		$(this).append('<input type="hidden" name="drink_name" value="${LOGIN_MEMBERINFO.com_name}"></input>');
		$(this).append('<input type="hidden" name="drink_tel" value="${LOGIN_MEMBERINFO.com_tel}"></input>');
		$(this).append('<input type="hidden" name="drink_info" value="' + $('#drink_info').summernote('code') + '"></input>');
		
		 
		$('input[name=drink_zip]').attr('value', $('input[name=drink_zip1]').val() +'-'+ $('input[name=drink_zip2]').val());
		 
		return true;		
	});
	
	$('#drinkListBTN').click(function(){
		location.href = '${pageContext.request.contextPath}/user/drink/drinkList.do';
	});
	
});

function zipcodePopup(){
	
    var url = '${pageContext.request.contextPath}/user/drink/zipcodeSearchForm.do';
    var options = 'copyhistory=no, width=380px, height=400px, status=no, resizable=no, scrollbar=no';
    window.open(url, '타이틀', options);
    
 }
 
</script>
</head>
<body>
<form id="drinkForm" class="form-horizontal" enctype="multipart/form-data" role="form" action="" method="post">


	<div class="form-group">
		<label class="control-label col-sm-2" for="drink_zip">우편 번호:</label>
		<div class="col-sm-10">
		<input type="hidden" name="drink_zip" value="">
		<input type="text" name="drink_zip1" id="drink_zip1" size="3" value="" /> - 
         <input type="text" name="drink_zip2" id="drink_zip2" size="3" value="" />
         <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent" type="button" onclick="zipcodePopup();">우편번호검색</button><br><br>
      </div>
      
      
      <label class="control-label col-sm-2" for="drink_add">주소:</label> 
     
      <div class="col-sm-10">
      <input type="text" class="form-control" id="drink_add" name="drink_add" placeholder="">
      </div>
      
      <label class="control-label col-sm-2" for="drink_add2">상세주소:</label>
      <div class="col-sm-10">
       <input type="text" class="form-control" id="drink_add2" name="drink_add2" placeholder="">
         </div>
	
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="drink_link">홈페이지 링크:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="drink_link" name="drink_link" placeholder="제목 입력...">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="drink_info">내용:</label>
		<div class="col-sm-10"> 
			<div id="drink_info">내용을 입력해주세요...</div>
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
			<button type="button" class="btn btn-danger" style="float: right">취소</button>
			<button type="button" class="btn btn-primary" style="float: right" id="drinkListBTN">목록</button>
		</div>
	</div>
</form>
</body>
</html>
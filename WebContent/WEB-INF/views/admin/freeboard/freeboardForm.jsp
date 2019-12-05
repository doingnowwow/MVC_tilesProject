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
    $('#free_content').summernote({
    		lang: 'ko-KR',
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });

	$('#freeboardForm').submit(function(){
		
	 	var title = $('input[name=free_title]').val();

    	 
    	if(title.length<=0){
    		alert('제목을 입력하세요!');
			return false;
    	}
    	
    
    	$(this).attr('action', '${pageContext.request.contextPath}/admin/freeboard/insertFreeboard.do');
    	$(this).append('<input type="hidden" name="mem_id" value="${LOGIN_MEMBERINFO.mem_id}"></input>');
    	$(this).append('<input type="hidden" name="free_ip" value="${pageContext.request.remoteAddr}"></input>'); 
    	$(this).append('<input type="hidden" name="free_content" value="' + $('#free_content').summernote('code') + '"></input>');
    		
    	return true;
    	

	});
	
	$('#freeboardListBTN').click(function(){
		location.href = '${pageContext.request.contextPath}/admin/freeboard/freeboardList.do';
	});
});
</script>
</head>
<body>
<form id="freeboardForm" class="form-horizontal" enctype="multipart/form-data" role="form" action="<%=request.getContextPath()%>/user/freeboard/insertFreeboard.do" method="post">
	<div class="form-group">
		<label class="control-label col-sm-2" for="free_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="free_title" name="free_title" placeholder="제목 입력...">
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="free_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="free_content">내용을 입력해주세요...</div>
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
			<button type="reset" class="btn btn-danger" style="float: right">취소</button>
			<button type="button" class="btn btn-primary" style="float: right" id="freeboardListBTN">목록</button>
		</div>
	</div>
</form>
</body>
</html>
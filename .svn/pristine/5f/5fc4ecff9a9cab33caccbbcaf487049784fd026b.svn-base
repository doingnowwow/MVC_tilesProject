<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시글 등록</title>
<script type="text/javascript">
$(function(){
	// 섬머노트를 div를 활용한 textarea에 추가.
	// http://summernote.org 활용
     $('#qna_content').summernote({
    		lang: 'ko-KR',
			height: 150,
			codemirror: {
				
			theme: 'monokai'
		}
    }); 
    // 포커스 처리
    // $('#bo_content').summernote( {focus: true} );
    // 값 취득
    // $('#bo_content').summernote('code');
    // 값 추가
    // $('#bo_content').summernote('code', '<font color="red">추가글</font>');
    // 에디터 제거
    // $('#bo_content').summernote('destroy');
    
/* 	BootstrapDialog.show({
	    title: '알럿창',
	    message: '알럿창으로 활용하세요!'
	});
	
	BootstrapDialog.show({
        message: '컨펌 다이얼로그로 활용하세요!',
        buttons: [{
            label: 'Button 1'
        }, {
            label: 'Button 2',
            cssClass: 'btn-primary',
            action: function(){
                alert('Hi Orange!');
            }
        }, {
            icon: 'glyphicon glyphicon-ban-circle',
            label: 'Button 3',
            cssClass: 'btn-warning'
        }, {
            label: 'Close',
            action: function(dialogItself){
                dialogItself.close();
            }
        }]
    });*/
    
    
    $('#qnaForm').submit(function(){
    	
    	
    	var title = $('input[name=qna_title]').val();
    	
    	if(title.length<=0){
    		alertPRT('제목을 입력하세요!');
			return false;
    	}
    	
    	
    	$(this).attr('action','${pageContext.request.contextPath}/user/qna/insertQna.do');
   	$(this).append('<input type="hidden" name="mem_id" value="${LOGIN_MEMBERINFO.mem_id}"></input>');
 	$(this).append('<input type="hidden" name="mem_id" value="${LOGIN_MEMBERINFO.com_id}"></input>');
    	$(this).append('<input type="hidden" name="qna_ip" value="${pageContext.request.remoteAddr}"></input>');
    	$(this).append('<input type="hidden" name="qna_content" value="'+ $('#qna_content').summernote('code')+'"></input>');
    
    	return true;
    	
    	
    });
    
    
    $('#qnaListBTN').click(function(){
    	
    	location.href = '${pageContext.request.contextPath}/user/qna/qnaList.do';
    	
    });

}); 



function alertPRT(msg){
	

	BootstrapDialog.show({
		title : '알립니다.!',
		message : msg
	});

	return false;
}

</script>
</head>
<body>
<div class="panel panel-grey">
  <div class="panel-heading">QnA 게시판입니다</div>
  <br><br>

<form id="qnaForm" class="form-horizontal" role="form" action="" method="post" enctype="multipart/form-data">
	<div class="form-group">
		<label class="control-label col-sm-2" for="qna_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="qna_title" name="qna_title" placeholder="제목 입력...">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="mem_id">작성자 :</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="mem_id" name="mem_id"  value="${LOGIN_MEMBERINFO.mem_id}" disabled="disabled" >
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-sm-2" for="qna_content">내용:</label>
		<div class="col-sm-10"> 
		
		
		
			<div id="qna_content">내용을 입력해주세요...</div>
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
			<button type="button" class="btn btn-danger" style="float: right">다지우기</button>
			<button type="button" class="btn btn-primary" style="float: right" id="qnaListBTN">목록</button>
		</div>
	</div>
</form>
</div>
</body>
</html>
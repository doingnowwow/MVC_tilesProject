<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기게시글 정보</title>
<!-- 이미지 슬라이드 사이즈 조정 -->
<style type="text/css">
.carousel{
   width:200px;
    height:150px;
    margin-left: 200px;
}
img{
    width:200px;
    height:200px;
}       
#review_reply_content{
   display : inline-block;
   margin-left : 188px;
}

#rr_content{
   display : inline-block;
   margin-left : 188px;
   width : 700px;
}

hr{
   border : 1px solid lightgray;
}

#span{
   margin-left : 10px;
    font-size : 1.5em;
    font-style : bold;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/validation_board.js"></script>
<script>
$(function(){
   // 섬머노트를 div를 활용한 textarea에 추가.
   // http://summernote.org 활용
    $('#review_content').summernote({
         height: 150,
         codemirror: {
         theme: 'monokai'
      }
    });
    
    $('#review_title').val('${reviewInfo.review_title}');
    $('#review_content').summernote('code', '${reviewInfo.review_content}');
    $('#drink_no').val('${reviewInfo.drink_no}');
    $('#drink_name').val('${reviewInfo.drink_name}');
    $('input[id=${reviewInfo.review_like}]').prop('checked', true);
//     alert("${reviewInfo.review_like}");
    
   $('#reviewListBTN').click(function(){
      location.href = '${pageContext.request.contextPath}/admin/review/reviewList.do';
   });
   
   $('#reviewView').submit(function(){
      
      $(this).append('<input type="hidden" name="review_no" value="${reviewInfo.review_no}"></input>');
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
      if($('#y').prop('checked') == false && $('#n').prop('checked') == false){
         BootstrapDialog.show({
              title: '경고',
              message: '추천여부을 선택해주세요.'
          });
         return false;
      }
      
      var flag = redirectFlag();
      
      if(flag){
         
         $(this).attr('action', '${pageContext.request.contextPath}/admin/review/updateReview.do');
         return true;
      }else{
          alertPRT('해당 게시글은 작성자만 수정할 수 있습니다.');
          return false;
      }
   });

   $('#deleteBTN').click(function(){
      var flag = redirectFlag();
      
      if(flag){
         $(location).attr('href', '${pageContext.request.contextPath}/admin/review/deleteReview.do?review_no=${reviewInfo.review_no}');
      }else{
         alertPRT('해당 게시글은 작성자만 삭제할 수 있습니다.');
         return false;
      }
      
   });
   
   $('#reviewReplyRegist').submit(function(){
      if(!"${LOGIN_MEMBERINFO}"){
         alert("로그인하세요.");
         return false;
      }
      
      $(this).append('<input type="hidden" name="review_no" value="${reviewInfo.review_no}"></input>');
      $(this).append('<input type="hidden" name="rr_seq" value="0"></input>');
      $(this).append('<input type="hidden" name="rr_depth" value="0"></input>');
      $(this).append('<input type="hidden" name="mem_id" value="${LOGIN_MEMBERINFO.mem_id}"></input>');
      $(this).append('<input type="hidden" name="review_content" value="' + $('#review_content').summernote('code') + '"></input>');
   });
   
   $('.update').click(function(){
      var mem_id = $('input[name=reple_mem_id]').val();
      
      if(!"${LOGIN_MEMBERINFO}"){
         alertPRT("로그인하세요.");
         return false;
      }else if("${LOGIN_MEMBERINFO.mem_id}" != mem_id){
         alertPRT("해당 댓글은 작성자만 수정할 수 있습니다.");
         return false;
      }
   });
   
   $('form').on('click', 'button[class=delete]', function(){
      var rr_no = $(this).attr('id');
      var review_no = $('input[name=review_no]').val();
      var rnum = $('input[name=rnum]').val();
      var mem_id = $('input[name=reple_mem_id]').val();
      var flag = redirectFlag();
      
      if(!"${LOGIN_MEMBERINFO}"){
         alertPRT("로그인하세요.");
         return false;
      }else if("${LOGIN_MEMBERINFO.mem_id}" != mem_id){
         alertPRT("해당 댓글은 작성자만 삭제할 수 있습니다.");
         return false;
      }
      $(location).attr('href', '${pageContext.request.contextPath}/admin/reviewreply/deleteReviewReply.do?rr_no='+rr_no+'&review_no='+review_no);
   });
   
   $('#rrrr').submit(function(){
      if(!"${LOGIN_MEMBERINFO}"){
         alertPRT("로그인하세요.");
         return false;
      }
   });
   
   $('#searchDrink').click(function(){
      var url = '${pageContext.request.contextPath }/modal/drinkCheck.do';
      var options = 'copyhistory=no,width=380px;height=300px,status=no,resizable=no,scrollbar=no';
      window.open(url, '검색', options);
   });
});

function alertPRT(msg){
   BootstrapDialog.show({
        title: '경고',
        message: msg
    });
}

function redirectFlag(){
   if('${reviewInfo.mem_id}' == '${LOGIN_MEMBERINFO.mem_id}'){
      return true;
   }
   return false;
}
</script>
</head>
<body>
<form id="reviewView" class="form-horizontal" role="form" action="" method="post">
   <input type="hidden" name="rnum" value="${reviewInfo.rnum}">
   <input type="hidden" name="review_no" value="${reviewInfo.review_no}">
   <div class="form-group">
      <label class="control-label col-sm-2" for="review_title">제목:</label>
      <div class="col-sm-10">
         <input type="text" class="form-control" id="review_title" name="review_title" >
      </div>
   </div>
   <div class="form-group">
      <label class="control-label col-sm-2" for="drink_no">상호명:</label>
      <div class="col-sm-10">
         <input type="hidden" id="drink_no" name="drink_no" value="${reviewInfo.drink_no}">&nbsp;&nbsp;
         <input type="text" id="drink_name" name="drink_name" value="${reviewInfo.drink_name}">&nbsp;&nbsp;
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
         <input type="radio" class="form-control" id="y" name="review_like" value="y">추천&nbsp;&nbsp;&nbsp;
         <input type="radio" class="form-control" id="n" name="review_like" value="n">비추천
      </div>
   </div>
   <div class="form-group">
      <label class="control-label col-sm-2" for="review_content">첨부파일:</label>
      <div id="myCarousel" class="carousel slide" data-ride="carousel">
         <!-- Indicators -->
         <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
         </ol>
   
         <!-- Wrapper for slides -->
         <div class="carousel-inner" role="listbox" style="height: 200px;">
            <c:forEach items="${reviewInfo.items }" var="fileitem" varStatus="stat">
               <c:if test="${stat.first}">
                  <div class="item active">
               </c:if>
               <c:if test="${stat.last }">
                  <div class="item">
               </c:if>
               <img src="/files/${fileitem.rfile_save_name }" alt="pic1" 
               onclick="javscript:location.href='${pageContext.request.contextPath }/admin/review/reviewFileDown.do?fileSEQ=${fileitem.rfile_seq }&review_no=${fileitem.review_no}';">
            </div>
            </c:forEach>
         </div>
         <!-- Left and right controls -->
         <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
         <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
      </div>
   </div></div>
   <br><br><br><br><br>
   <div class="form-group"> 
      <div class="col-sm-offset-2 col-sm-10">
         <button type="submit" class="btn btn-default" style="float: right">수정</button>
         <button type="button" class="btn btn-danger" id="deleteBTN">삭제</button>
         <button type="button" class="btn btn-info" id="reviewListBTN">목록</button>
      </div>
   </div>
</form>
<form id="reviewReplyRegist" method="post" action="${pageContext.request.contextPath}/admin/reviewreply/insertReviewReply.do">
   <div class="form-group"> 
      <label class="control-label col-sm-2" >댓글:</label>
      <div class="col-sm-10">
         <input type="text" class="form-control" name="rr_content" >
      </div>
      <br><br>
      <div class="col-sm-offset-2 col-sm-10">
         <button type="submit" class="btn btn-primary">댓글등록</button>
      </div>
   </div>
</form>
<hr>
   <c:forEach items="${rrList}" var="replyList">
<form id="${replyList.rr_no}" method="post" action="${pageContext.request.contextPath}/admin/reviewreply/updateReviewReply.do">
      <div class="form-group"> 
         <c:forEach begin="1" end="${replyList.rr_depth}" varStatus="stat">
            <span id="span">==&gt;</span>
            <c:if test="${stat.last }">
               <i class="fa fa-angle-right"></i>
            </c:if>
         </c:forEach>
         <input type="text" class="form-control" id="review_reply_content" name="rr_content" value="${replyList.rr_content }">
         <input type="hidden" name="rr_no" value="${replyList.rr_no }">
         <input type="hidden" name="review_no" value="${reviewInfo.review_no}">
         <input type="hidden" name="rnum" value="${reviewInfo.rnum}">
         <input type="hidden" name="reple_mem_id" value="${replyList.mem_id}">
         <br><br>
         <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="update" id="${replyList.rr_no}">댓글수정</button>
            <button type="button" class="delete" id="${replyList.rr_no}">댓글삭제</button>
            <input type="text" value="${replyList.mem_id }" style="float: right" disabled>
            <input type="text" value="${replyList.rr_date }" style="float: right" disabled>
         </div>
      </div>
</form>
<form id="rrrr" method="post" action="${pageContext.request.contextPath}/admin/reviewreply/insertReviewReReply.do">
      <div class="form-group">
         <input type="hidden" name="rr_no" value="${replyList.rr_no}">
         <input type="hidden" name="review_no" value="${reviewInfo.review_no}">
         <input type="hidden" name="mem_id" value="${LOGIN_MEMBERINFO.mem_id}">
         <input type="hidden" name="rr_group" value="${replyList.rr_no}">
         <input type="hidden" name="rr_seq" value="${replyList.rr_seq}">
         <input type="hidden" name="rr_depth" value="${replyList.rr_depth}">
         <input type="text" class="form-control" id="rr_content" name="rr_content" >
         <button type="submit" class="btn btn-primary" >댓글등록</button>
      </div>
</form>
   </c:forEach>
</body>
</html>
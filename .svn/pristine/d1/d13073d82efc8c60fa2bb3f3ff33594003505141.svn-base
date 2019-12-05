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
</style>

<script>
$(function(){
	// 섬머노트를 div를 활용한 textarea에 추가.
	// http://summernote.org 활용
    $('#drink_info').summernote({
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
    
    
    var drink_zip = '${drinkInfo.drink_zip}';
    $('input[name=drink_zip1]').val(drink_zip.split('-')[0]);
	$('input[name=drink_zip2]').val(drink_zip.split('-')[1]);
  

    $('#drink_add').val('${drinkInfo.drink_add}');
    $('#drink_add2').val('${drinkInfo.drink_add2}');
    $('#drink_name').val('${drinkInfo.drink_name}');
    $('#drink_link').val('${drinkInfo.drink_link}');
    $('#drink_tel').val('${drinkInfo.drink_tel}');
    $('#drink_info').summernote('code', '${drinkInfo.drink_info}');
    
    
    //글 수정
    $('#drinkView').submit(function(){
    	
    	var flag = redirectFlag();
    	if (flag) {
	    	$(this).attr('action', '${pageContext.request.contextPath}/user/drink/updateDrink.do');
			/* $(this).append('<input type="hidden" name="bo_ip" value="${pageContext.request.remoteAddr}"></input>'); */
			$(this).append('<input type="hidden" name="drink_info" value="' + $('#drink_info').summernote('code') + '"></input>');
			$(this).append('<input type="hidden" name="drink_no" value="${drinkInfo.drink_no}"></input>');
			$('input[name=drink_zip]').attr('value', $('input[name=drink_zip1]').val() +'-'+ $('input[name=drink_zip2]').val());
    	} else {
			alertPRT('작성자만 수정 가능합니다.');
		}
    });
    
    //목록보기
    $('#drinkListBTN').click(function(){
    	location.href = '${pageContext.request.contextPath}/user/drink/drinkList.do';
    });
    
    //글 삭제
    $('#deleteDrinkBTN').click(function(){
    	
		var flag = redirectFlag();
    	
    	if (flag) {
    		location.href = '${pageContext.request.contextPath}/user/drink/deleteDrink.do?drink_no='+${drinkInfo.drink_no};
		} else {
			alertPRT('작성자만 삭제 가능합니다.');
		}
    });
    

    
});
function zipcodePopup(){
	
    var url = '${pageContext.request.contextPath}/modal/zipcodeSearchForm.do';
    var options = 'copyhistory=no, width=380px, height=400px, status=no, resizable=no, scrollbar=no';
    window.open(url, '타이틀', options);
    
}
 
function alertPRT(msg){
	BootstrapDialog.show({
 	    title: '경고',
 	    message: msg
 	});
}

function redirectFlag(){
	if('${drinkInfo.com_id}' == '${LOGIN_MEMBERINFO.com_id}'){
		return true;
	}
	return false;
}
</script>
</head>
<body>
<form id="drinkView" class="form-horizontal" enctype="application/x-www-form-urlencoded" role="form" action="" method="post">

	<div class="form-group">
		<label class="control-label col-sm-2" for="drink_name">상호명:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="drink_name" name="drink_name" disabled="disabled" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="drink_add">우편 번호:</label>
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
		<label class="control-label col-sm-2" for="drink_tel">전화번호:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="drink_tel" name="drink_tel"  disabled="disabled">
		</div>
	</div>	 
	<div class="form-group">
		<label class="control-label col-sm-2" for="drink_link">링크:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="drink_link" name="drink_link" >
		</div>
	</div>	
	<div class="form-group">
	
		<label class="control-label col-sm-2" for="drink_info">상세 내용:</label>
		<div class="col-sm-10"> 
			<div id="drink_info"></div>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="drink_content">첨부파일:</label>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
			</ol>
	
			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox" style="height: 200px;">
				<c:forEach items="${drinkInfo.items }" var="drinkitem" varStatus="stat">
					<c:if test="${stat.first }">
						<div class="item_active">
					</c:if>
					<c:if test="${stat.last }">
						<div class="item">
					</c:if>
					<img src="/files/${drinkitem.dfile_save_name }" alt="pic1"
					onclick="javscript:location.href='${pageContext.request.contextPath }/user/drink/drinkFileDown.do?fileSEQ=${drinkitem.dfile_seq }&free_no=${drinkitem.drink_no}';">
	
						
					</div>
				</c:forEach> 
			</div>
			<!-- Left and right controls -->
			<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
	</div>
	<div class="form-group"> 
		<div class="col-sm-offset-2 col-sm-10">
			<button type="button" class="btn btn-danger" id="deleteDrinkBTN">삭제</button>
			<button type="button" class="btn btn-info" id="drinkListBTN">목록</button>
			<button type="submit" class="btn btn-default" style="float: right">수정</button>
		</div>
	</div>
	</div>
</form>
</body>
</html>

<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뭐든지 물어봐 목록</title>
</head>
<body>
<div id="qnaList_content"></div>
		<div class="col-lg-12"></div>
			<div class="row"></div>
				<div class="col-lg-12">
					<div class="panel panel-lightgray">
    	 <div class="panel-heading">QnA게시판</div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th scope="col" width="5%">No</th>
					<th scope="col" width="65%">제목</th>
					<th scope="col" width="10%">작성자</th>
					<th scope="col" width="10%">작성일</th>
					<th scope="col" width="10%">조회수</th>
				
				</tr>
			</thead>
			
			
			<tbody id="qnaListTBY">
			<c:if test="${empty qnaList }">
				<tr align="center">
					<td colspan="5"><font color="red">등록된 게시글이 없습니다.</font></td>
				</tr>
			</c:if>
			<c:if test="${!empty qnaList }">
				<c:forEach items="${qnaList }" var="qnaInfo">
					<tr>
						<td><input type="hidden" value="${qnaInfo.qna_no }"/>${qnaInfo.rnum }</td>
						<td align="left">
							<c:forEach begin="1" end="${qnaInfo.qna_depth}" varStatus="stat">
							 &nbsp;&nbsp;&nbsp;<span>└</span>
								<c:if test="${stat.last }">
										<i class="fa fa-angle-right"></i>
								</c:if>
							</c:forEach>
									${qnaInfo.qna_title }
									</td>
						<td>${qnaInfo.mem_id }</td>
						<td>${fn:substringBefore(qnaInfo.qna_reg_date, ' ')}</td>
						<td>${qnaInfo.qna_hit }</td>
				
					</tr>
				</c:forEach>
			</c:if>
			</tbody>
			
			
		</table>
	</div>
</div>
	${page}

<div >
<form action="${pageContext.request.contextPath }/user/qna/qnaList.do" method="post" class="form-inline pull-right">
		<input id="search_keyword" type="text"  name="search_keyword" placeholder="검색어 입력..." class="form-control" />
		<select class="form-control" name="search_keycode" >
		
			<option value="TOTAL">전체</option>
			<option value="TITLE">제목</option>
			<option value="CONTENT">내용</option>
			<option value="WRITER">작성자</option>
		</select>
	    <button type="submit" class="btn btn-primary form-control">검색</button>
	    <button type="button" class="btn btn-info form-control" id="registBTN">게시글 등록</button>
</form>
</div>	
</body>

<script type="text/javascript">
$(function(){
	
	$('#registBTN').click(function(){
		
		if(eval('${!empty LOGIN_MEMBERINFO}')){
			$(location).attr('href', '${pageContext.request.contextPath}/user/qna/qnaForm.do');
		}else{
			alertPRT('로그인해주셈');
			false;
		
		} 
	});
	
	
	$('#qnaListTBY tr').click(function(){
		var qna_no = $(this).find('td:eq(0) input').val();
		 var rnum= $(this).find('td:eq(0)').text();
         var url = '${pageContext.request.contextPath}/user/qna/qnaView.do';
         $(location).attr('href', url + '?qna_no=' + qna_no + '&rnum=' + rnum);

	});
});

function alertPRT(msg) {

	BootstrapDialog.show({
		title : '경고!',
		message : msg
	});

	
} 
</script>
</html>
<%@page import="kr.or.ddit.vo.FreeVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.freeboard.service.FreeServiceImpl"%>
<%@page import="kr.or.ddit.user.freeboard.service.FreeService"%>
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
<title>후기게시글 목록</title>
</head>
<body>
	<div id="reviewList_content">
		<div class="col-lg-12">
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-lightgray">
						<div class="panel-heading">후기게시판</div>
						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col" width="5%">No</th>
									<th scope="col" width="55%">제목</th>
									<th scope="col" width="10%">작성자</th>
									<th scope="col" width="10%">작성일</th>
									<th scope="col" width="10%">조회수</th>
								</tr>
							</thead>


							<tbody id="reviewListTBY">
								<c:if test="${empty reviewList }">
									<tr align="center">
										<td colspan="5"><font color="red">등록된 게시글이 없습니다.</font></td>
									</tr>
								</c:if>
								<c:forEach items="${reviewList }" var="reviewInfo">
									<tr>
										<td><input type="hidden" value="${reviewInfo.review_no }" />${reviewInfo.rnum }</td>
										<td align="left">${reviewInfo.review_title }</td>
										<td>${reviewInfo.mem_id }</td>
										<td>${fn:substringBefore(reviewInfo.review_reg_date, ' ')}</td>
										<td>${reviewInfo.review_hit }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>

		</div>
	</div>
	${pagingUtiles.pagingHTMLS }
<div >
<form action="${pageContext.request.contextPath }/user/review/reviewList.do" method="post" class="form-inline pull-left">
		<select class="form-control" name="align_keycode" >
			<option>정렬조건</option>
			<option value="HIT">조회순</option>
			<option value="LIKE">추천순</option>
			<option value="DISLIKE">비추천순</option>
			<option value="DATE">최신순</option>
		</select>
	    <button type="submit" class="btn btn-primary form-control" id="alignBTN">정렬</button>
</form>
<form action="${pageContext.request.contextPath }/user/review/reviewList.do" method="post" class="form-inline pull-right">
		<input id="search_keyword" type="text" name="search_keyword" placeholder="검색어 입력..." class="form-control" />
		<select class="form-control" name="search_keycode" id="search_keycode">
			<option value="TOTAL">전체</option>
			<option value="TITLETT">제목</option>
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
			$(location).attr('href', '${pageContext.request.contextPath}/user/review/reviewForm.do');
		}else{
			alert("로그인해주세요.");
		}
	});
	
	
	$('#reviewListTBY tr').click(function(){
		var review_no = $(this).find('td:eq(0) input').val();
        var rnum= $(this).find('td:eq(0)').text();
        var url = '${pageContext.request.contextPath}/user/review/reviewView.do';
        $(location).attr('href', url + '?review_no=' + review_no + '&rnum=' + rnum);

	});
	
});
</script>
</html>
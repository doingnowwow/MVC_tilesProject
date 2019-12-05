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
<title>자유게시글 목록</title>
</head>
<body>
<div id="freeboardList_content">
		<div class="col-lg-12">
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-lightgray">
    	<div class="panel-heading">자유게시판</div>
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
			
			
			<tbody id="freeListTBY">
			<c:if test="${empty freeList }">
				<tr align="center">
					<td colspan="5"><font color="red">등록된 게시글이 없습니다.</font></td>
				</tr>
			</c:if>
			<c:if test="${!empty freeList }">
				<c:forEach items="${freeList }" var="freeInfo">
					<tr>
						<td><input type="hidden" value="${freeInfo.free_no }"/>${freeInfo.rnum }</td>
						<td align="left">
									${freeInfo.free_title }
									</td>
						<td>${freeInfo.mem_id }</td>
						<td>${fn:substringBefore(freeInfo.free_reg_date, ' ')}</td>
						<td>${freeInfo.free_hit }</td>
					</tr>
				</c:forEach>
			</c:if>
			</tbody>
			
			
		</table>
		</div>
		</div>
		</div>
		
	</div>
</div>
${pagingUtiles.pagingHTMLS }
<div >
<form action="${pageContext.request.contextPath}/user/freeboard/freeboardList.do" method="post" class="form-inline pull-right">
		<input id="search_keyword" name="search_keyword" type="text" placeholder="검색어 입력..." class="form-control" />
		<select class="form-control" name="search_keycode" >
			<option value="TOTAL">전체</option>
			<option value="TITLE">제목</option>
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
		if(eval('${!empty LOGIN_MEMBERINFO.mem_id}')){
			$(location).attr('href', '${pageContext.request.contextPath}/user/freeboard/freeboardForm.do');
		}else if('${!empty LOGIN_MEMBERINFO.com_id}'){
			alert('일반회원만 등록 가능합니다.');
			return false;
		}else{
			alert('로그인 해주세요.');
		}  
		
	});
	
	
	$('#freeListTBY tr').click(function(){
		if(eval('${!empty LOGIN_MEMBERINFO}')){
			var free_no = $(this).find('td:eq(0) input').val();
	        var rnum= $(this).find('td:eq(0)').text();
	        var url = '${pageContext.request.contextPath}/user/freeboard/freeboardView.do';
	        $(location).attr('href', url + '?free_no=' + free_no + '&rnum=' + rnum);
		 }else{
				alert('로그인 해주세요.');
		 }  
	});
});

</script>



</html>
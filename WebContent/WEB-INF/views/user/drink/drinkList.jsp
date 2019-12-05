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
<title>술집 리스트 목록</title>
</head>
<body>
	<div id="freeboardList_content">
		<div class="col-lg-12">
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-lightgray"> 
						<div class="panel-heading">술집 리스트</div>
						<table class="table table-bordered table-hover">
							<thead>
								<tr>
									<th scope="col" width="5%">No</th>
									<th scope="col" width="10%">지역</th>
									<th scope="col" width="55%">술집명</th>
									<th scope="col" width="10%">작성일</th>
									<th scope="col" width="10%">조회수</th>
								</tr>
							</thead>


							<tbody id="freeListTBY">
								<c:if test="${empty drinkList }">
									<tr align="center">
										<td colspan="5"><font color="red">등록된 게시글이 없습니다.</font></td>
									</tr>
								</c:if>
								<c:if test="${!empty drinkList }">
									<c:forEach items="${drinkList }" var="drinkInfo">
										<tr>
											<td><input type="hidden" value="${drinkInfo.drink_no }" />${drinkInfo.rnum }</td>
											<td align="left">
												${fn:substringBefore(drinkInfo.drink_add, ' ') }</td>
											<td>${drinkInfo.drink_name }</td>
											<td>${fn:substringBefore(drinkInfo.drink_reg_date, ' ')}</td>
											<td>${drinkInfo.drink_hit }</td>
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
<form action="${pageContext.request.contextPath }/user/drink/drinkList.do" method="post" class="form-inline pull-left">
		<select class="form-control" name="align_keycode" >
			<option>정렬조건</option>
			<option value="HIT">조회순</option>
			<option value="DATE">최신순</option>
		</select>
	    <button type="submit" class="btn btn-primary form-control" id="alignBTN">정렬</button>
</form>

<form action="${pageContext.request.contextPath}/user/drink/drinkList.do" method="post" class="form-inline pull-right">
		<input id="search_keyword" name="search_keyword" type="text" placeholder="검색어 입력..." class="form-control" />
		<select class="form-control" name="search_keycode" >
		
			<option value="TOTAL">전체</option>
			<option value="NAME">상호명</option>
			<option value="TITLE">지역</option>
			<!-- <option value="">지역</option> -->
		</select>
	    <button type="submit" class="btn btn-primary form-control">검색</button>
	    <button type="button" class="btn btn-info form-control" id="registBTN">게시글 등록</button>
</form>
</div>	
</body>

<script type="text/javascript">
$(function(){
	
	$('#registBTN').click(function(){
		if(eval('${!empty LOGIN_MEMBERINFO.com_id}')){
			$(location).attr('href', '${pageContext.request.contextPath}/user/drink/drinkForm.do');
		}else if('${!empty LOGIN_MEMBERINFO.mem_id}'){
			alert('사업자회원만 등록 가능합니다.');
			return false;
		}else{
			alert('로그인 해주세요.');
		}  
	});	
	
	$('#freeListTBY tr').click(function(){
		
		if(eval('${!empty LOGIN_MEMBERINFO}')){
			var drink_no = $(this).find('td:eq(0) input').val();
	        var rnum= $(this).find('td:eq(0)').text();
	        var url = '${pageContext.request.contextPath}/user/drink/drinkView.do';
	        $(location).attr('href', url + '?drink_no=' + drink_no + '&rnum=' + rnum);
		}else{
			alert('로그인 해주세요.');
		}  
	});
	
	$('#alignBTN').click(function(){
		$(location).attr('href', '${pageContext.request.contextPath}/user/drink/drinkForm.do');
	});
	
	 var drink_add = '${drinkInfo.drink_add}';

	    $('input[name=drink_zip1]').val(drink_add.split(' ')[0]);
	
});
</script>
</html>
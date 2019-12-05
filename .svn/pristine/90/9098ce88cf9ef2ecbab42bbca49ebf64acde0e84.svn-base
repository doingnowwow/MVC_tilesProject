
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type='text/javascript'
	src='http://code.jquery.com/jquery-latest.js'></script>
<script type='text/javascript'>
/* 	$(function() {
		$('table tr:gt(0)').click(function() {

			var mem_id = $(this).find('td:eq(0)').text();
			location.href = '${pageContext.request.contextPath}/06/main.jsp?contentPage=/06/memberView.jsp?mem_id=' + mem_id;

		});

	}); */
</script>
</head>
<body>



	<div class="panel panel-grey">
		<div class="panel-heading">일반회원관리</div>
		<div class="panel-body">
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>아이디</th>
						<th>닉네임</th>
						<th>이름</th>
						<th>이메일</th>
						<th>탈퇴여부</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${memberList }" var="memberInfo">
						<tr>
							<td>${memberInfo.mem_id }</td>
							<td>${memberInfo.mem_nickname }</td>
							<td>${memberInfo.mem_name }</td>
							<td>${memberInfo.mem_email }</td>
							<td>${memberInfo.mem_delete }</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
		${page }

		<div class="searchForm" align="right" style="margin-top: 10px;">
			<form method="post"
				action="${pageContext.request.contextPath }/admin/member/memberList.do">
				<select name="search_keycode">
					<option value="ALL">전체</option>
					<option value="NAME">이름</option>
					<option value="ID">아이디</option>
					<option value="NICK">닉네임</option>
				</select> <input type="text" id="search_keyword" name="search_keyword">
				<button class="btn btn-success" type="submit">검색</button>

			</form>
		</div>

	</div>







</body>
</html>









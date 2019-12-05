<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.vo.EventVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.event.service.EventServiceImpl"%>
<%@page import="kr.or.ddit.user.event.service.EventService"%>
<%@page import="kr.or.ddit.user.event.dao.EventDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EVENT 목록</title>
</head>
<body>
	<div id="eventList">
		<div class="col-lg-12">
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-lightgray">
						<div class="panel-heading">EVENT</div>
						<table class="table table-bordered table-hover">
							<thead>
								<tr>
									<th scope="col" width="5%">No</th>
									<th scope="col" width="50%">제목</th>
									<th scope="col" width="10%">작성자</th>
									<th scope="col" width="10%">시작일</th>
									<th scope="col" width="10%">마감일</th>
									<th scope="col" width="10%">조회수</th>
								</tr>
							</thead>
							<tbody id="eventListTBY">
								<c:if test="${empty eventList }">
									<tr align="center">
										<td colspan="5"><font color="red">등록된 게시글이 없다~</font></td>
									</tr>
								</c:if>
								<c:if test="${!empty eventList }">
									<c:forEach items="${eventList }" var="eventInfo">
										<tr>
											<td><input type="hidden" value="${eventInfo.event_no }" />${eventInfo.rnum }</td>
											<td align="left">${eventInfo.event_title }</td>
											<td>${eventInfo.com_name }</td>
											<td>${fn:substringBefore(eventInfo.event_start, ' ')}</td>
											<td>${fn:substringBefore(eventInfo.event_end, ' ')}</td>
											<td>${eventInfo.event_hit }</td>
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
	${page}
	<div>
		<form
			action="${pageContext.request.contextPath}/user/event/eventList.do"
			method="post" class="form-inline pull-right">
			<input id="search_keyword" name="search_keyword" type="text"
				class="form-control" /> <select class="form-control"
				name="search_keycode">
				<option value="TOTAL">전체</option>
				<option value="TITLE">제목</option>
				<option value="CONTENT">내용</option>
				<option value="WRITER">작성자</option>
			</select>
			<button type="submit" class="btn btn-primary form-control">검색</button>
			<button type="button" class="btn btn-info form-control"
				id="registBTN">게시글 등록</button>
		</form>
	</div>
</body>

<script type="text/javascript">
	function alertPRT(msg) {

		BootstrapDialog.show({
			title : '경고!',
			message : msg
		});

		return flag;
	}
	$(function() {
		$('#registBTN').click(function() {
			if(eval('${!empty LOGIN_MEMBERINFO.com_id}')){
				$(location).attr('href', '${pageContext.request.contextPath}/user/event/eventForm.do');
			}else if('${!empty LOGIN_MEMBERINFO.mem_id}'){
				alert('사업자만 등록 가능합니다.');
				return false;
			}else{
				alert('로그인 해주세요.');
			}  
			
		});
		$('#eventListTBY tr').click(function() {
				var event_no = $(this).find('td:eq(0) input').val();
				var rnum = $(this).find('td:eq(0)').text();
				var url = '${pageContext.request.contextPath}/user/event/eventView.do';
				$(location).attr('href', url + '?event_no=' + event_no + '&rnum='+ rnum);
				});
	});
</script>
</html>
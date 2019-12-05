<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.vo.NoticeVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.notice.service.NoticeServiceImpl"%>
<%@page import="kr.or.ddit.user.notice.service.NoticeService"%>
<%@page import="kr.or.ddit.user.notice.dao.NoticeDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 목록</title>
</head>
<body>
	<div id="noticeList">
		<div class="col-lg-12">
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-lightgray">
						<div class="panel-heading">공지사항</div>
						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col" width="5%">No</th>
									<th scope="col" width="65%">제목</th>
									<th scope="col" width="10%">작성자</th>
									<th scope="col" width="10%">작성일</th>
									<th scope="col" width="10%">조회수</th>
								</tr>
							</thead>
							<tbody id="noticeListTBY">
								<c:if test="${empty noticeList }">
									<tr align="center">
										<td colspan="5"><font color="red">등록된 게시글이 없다~</font></td>
									</tr>
								</c:if>
								<c:if test="${!empty noticeList }">
									<c:forEach items="${noticeList }" var="noticeInfo">
										<tr>
											<td><input type="hidden"
												value="${noticeInfo.notice_no }" />${noticeInfo.rnum }</td>
											<td align="left">${noticeInfo.notice_title }</td>
											<td>${noticeInfo.mem_id }</td>
											<td>${fn:substringBefore(noticeInfo.notice_reg_date, ' ')}</td>
											<td>${noticeInfo.notice_hit }</td>
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
<form action="${pageContext.request.contextPath}/admin/notice/noticeList.do" method="post" class="form-inline pull-right">
		<input id="search_keyword" name="search_keyword"type="text" class="form-control" />
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
function alertPRT(msg) {

	BootstrapDialog.show({
		title : '경고!',
		message : msg
	});

	return flag;
}
$(function(){
	$('#registBTN').click(function(){
		if(eval('${!empty LOGIN_MEMBERINFO}')){
			$(location).attr('href', '${pageContext.request.contextPath}/admin/notice/noticeForm.do');
		}else{
			alertPRT('로그인하셔야돼요');
			return false;
		}
	});
	
	$('#noticeListTBY tr').click(function(){
		var notice_no = $(this).find('td:eq(0) input').val();
        var rnum= $(this).find('td:eq(0)').text();
        var url = '${pageContext.request.contextPath}/admin/notice/noticeView.do'; 
        $(location).attr('href', url + '?notice_no=' + notice_no + '&rnum=' + rnum );
	});
});
</script>
</html>
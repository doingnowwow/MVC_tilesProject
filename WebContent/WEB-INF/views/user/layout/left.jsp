<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<script>
function changeTo(x) {
    x.style.backgroundColor = "gold";
  }

  function changeBack(x) {
    x.style.backgroundColor = "#3c3c3c";
  }
</script>
</head>
<body>
<!--BEGIN SIDEBAR MENU-->
<nav id="sidebar" role="navigation" data-step="2"
	data-intro="Template has &lt;b&gt;many navigation styles&lt;/b&gt;"
	data-position="right" class="navbar-default navbar-static-side">
	<div class="sidebar-collapse menu-scroll  ">
	
		<ul id="side-menu" class="nav nav-pills nav-stacked">
			<ul id="side-menu" class="nav">
			<div class="clearfix"></div>
			
			<li onmouseover="changeTo(this)" onmouseout="changeBack(this)">
				<a href="${pageContext.request.contextPath}/user/notice/noticeList.do">
						<i class="fa fa-circle-o-notch fa-spin fa-fw"> <div class="icon-bg bg-green"></div></i>
						 <span class="menu-title">공지사항</span>
						
				</a>
				</li>
			<li onmouseover="changeTo(this)" onmouseout="changeBack(this)">
				<a href="${pageContext.request.contextPath}/user/drink/drinkList.do">
			<i class="fa fa-coffee fa-fw"><div class="icon-bg bg-orange"></div></i>
						 <span class="menu-title">술집</span>
				</a>
			</li>
			<li onmouseover="changeTo(this)" onmouseout="changeBack(this)">
				<a href="${pageContext.request.contextPath}/user/review/reviewList.do">
					<i class="fa  fa-apple fa-fw  ></i>"><div class="icon-bg bg-green"></div></i>
					
					<span class="menu-title">후기</span>
				</a>
			</li>
			<li>
			<li onmouseover="changeTo(this)" onmouseout="changeBack(this)" >
				<a href="${pageContext.request.contextPath}/user/event/eventList.do">
 					<i class="fa fa-edit fa-fw"><div class="icon-bg bg-violet"></div></i>
					<span class="menu-title">EVENT</span>
				</a>
			</li>
			<li onmouseover="changeTo(this)" onmouseout="changeBack(this)">
				<a href="${pageContext.request.contextPath}/user/freeboard/freeboardList.do">
					<i class="fa fa-th-list fa-fw"><div class="icon-bg bg-blue"></div></i>
					<span class="menu-title">자유게시판</span>
				</a>
			</li>
			<li onmouseover="changeTo(this)" onmouseout="changeBack(this)">
				<a href="${pageContext.request.contextPath}/user/qna/qnaList.do">
					<i class="fa fa-database fa-fw"><div class="icon-bg bg-red"></div></i>
					<span class="menu-title">Q&A</span>
				</a>
			</li> 
		</ul>
	</div>
</nav>
</body>
</html>
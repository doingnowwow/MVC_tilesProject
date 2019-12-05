

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type='text/javascript' src='http://code.jquery.com/jquery-latest.js'></script>
<script type='text/javascript' src='${pageContext.request.contextPath }/js/validation_member.js'></script>
<script type='text/javascript'>
	$(function() {
		$('#mem_nickname').val("${memberInfo.mem_nickname}");
		$('#mem_pass').val("${memberInfo.mem_pass}");
		$('#mem_tel1').val("${memberInfo.mem_tel.split('-')[0] }");
		$('#mem_tel2').val("${memberInfo.mem_tel.split('-')[1] }");
		$('#mem_tel3').val("${memberInfo.mem_tel.split('-')[2] }");
		$('#mem_email1').val("${memberInfo.mem_email.split('@')[0] }");
		$('#mem_email2').val("${memberInfo.mem_email.split('@')[1] }");
		
		
		//목록으로돌아가기
		$('#list').click(function() {
			$(location).attr('href', '${pageContext.request.contextPath }/user/main.do');
		});
		
		
		  //탈퇴하기
		$('#out').click(function(){
			if($('#mem_pass').val() != $('#mem_pass_confirm').val()){
				alert('비밀번호를 확인해주세요.');
				return false;
			}
			location.href = '${pageContext.request.contextPath }/user/member/deleteMember.do?mem_id=${memberInfo.mem_id}';
		});
		  
		  
		// 정보수정하기
		$('#memberForm').submit(function(){
			$(this).attr('action', '${pageContext.request.contextPath }/user/member/updateMember.do');
			
			if(!$('#mem_pass').val().validationPWD()){
				alert('패스워드를 바르게 입력해주세요.');
				return false;
			}
		
			if($('#mem_pass').val() != $('#mem_pass_confirm').val()){
				alert('비밀번호를 확인해주세요.');
				return false;
			}
			
			if(!$('#mem_nickname').val().validationNICK()){
				alert("닉네임을 바르게 입력해주세요.");
				return false;
			}

			var mem_tel = $('#mem_tel1').val() + '-' +
						  $('#mem_tel2').val() + '-' +
						  $('#mem_tel3').val();
			if(!mem_tel.validationTEL()){
				alert('핸드폰번호를 바르게 입력해주세요.');
				return false;
			}
			$('#mem_tel').val(mem_tel);

			var mem_email = $('#mem_email1').val() + '@' +   $('#mem_email2').val();
			if(!mem_email.validationMAIL()){
				alert('메일 주소를 바르게 입력해주세요.');
				return false;
			}
			$('#mem_email').val(mem_email);
			
			return true;
		});	
			
	})
	
</script>
</head>
<style>
.fieldName {
	text-align: center;
	background-color: #f4f4f4;
}

.tLine {
	background-color: #d2d2d2;
	height: 1px;
}

.btnGroup {
	text-align: right;
}

td {
	text-align: left;
}
</style>
<body>

  <div class="panel panel-blue" style="background:#fff;">
                                            <div class="panel-heading">
                                                내 정보 관리하기</div>
                                            <div class="panel-body pan">
	<form name="memberForm" method="post" id="memberForm" >

		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table table-hover table-bordered">
			
			<tr>
				
			</tr>
			
			<tr>
				<td class="fieldName" width="100px" height="25">성 명</td>
				<td>
					<input type="text" name="mem_name"	value="${LOGIN_MEMBERINFO.mem_name }" disabled="disabled"   />
					<input type="hidden" name="mem_name"	value="${LOGIN_MEMBERINFO.mem_name }" />
				</td>
			</tr>
			

			<tr>
			
				<td class="fieldName" width="100px" height="25">생년월일</td>
				<td>
				
				<input  type="hidden" name="mem_bir" value="${LOGIN_MEMBERINFO.mem_bir }" /> 
				<input  type="text"	name="mem_bir1" size="4" value="${LOGIN_MEMBERINFO.mem_bir.substring(0,4)}" disabled="disabled" />년
				<input type="text" name="mem_bir2" size="2" value="${LOGIN_MEMBERINFO.mem_bir.substring(5,7) }"disabled="disabled" />월 
				<input  type="text" name="mem_bir3" size="2"	value="${LOGIN_MEMBERINFO.mem_bir.substring(9,10) }" disabled="disabled" />일
				
				
				</td>
			</tr>
			

			<tr>
				<td class="fieldName" width="100px" height="25">아이디</td>
				<td><input type="text" name="mem_id"
					value="${LOGIN_MEMBERINFO.mem_id }" disabled="disabled">
					<input type="hidden" name="mem_id" value="${LOGIN_MEMBERINFO.mem_id }"></td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td class="fieldName" width="100px" height="25">닉네임</td>
				<td><input type="text" name="mem_nickname" id="mem_nickname"
					value="" >
				</td>
			</tr>
			<tr>
				<td class="fieldName" width="100px" height="25">비밀번호</td>
				<td><input type="text" name="mem_pass" id="mem_pass"	value="" /> 8 ~ 20 자리 영문자 및 숫자 사용</td>
			</tr>
			

			<tr>
				<td class="fieldName" width="100px" height="25">비밀번호확인</td>
				<td><input type="text" name="mem_pass_confirm" id="mem_pass_confirm"
					value="" /> 8 ~ 20 자리 영문자 및 숫자 사용</td>
			</tr>
			
	
			

			<tr>
				<td class="fieldName" width="100px" height="25">핸드폰</td>
				<td><input type="hidden" name="mem_tel" id="mem_tel" /> 
				<select	name="mem_tel1" id="mem_tel1">
						<option value="010">010</option>
						<option value="016">011</option>
						<option value="017">017</option>
						<option value="019">019</option>
				</select> - 
				<input type="text" name="mem_tel2" id="mem_tel2" size="4" value="" />	- 
				<input type="text" name="mem_tel3" id="mem_tel3" size="4" value="" />
				</td>
			</tr>
			

			<tr>
				<td class="fieldName" width="100px" height="25">이메일</td>
				<td><input type="hidden" name="mem_email" id="mem_email"/>
				 <input type="text"	name="mem_email1" value="" id="mem_email1" /> @ 
				 <select name="mem_email2" id="mem_email2">
						<option value="naver.com">naver.com</option>
						<option value="daum.net">daum.net</option>
						<option value="hanmail.net">hanmail.net</option>
						<option value="nate.com">nate.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="lycos.co.kr">lycos.co.kr</option>
						<option value="pretty.net">pretty.net</option>
						<option value = "orgio.net">orgio.net</option>
						<option value = "unitel.co.kr">unitel.co.kr</option>
				</select></td>
			</tr>
			<tr>
				<td class="btnGroup" colspan="2">
					<button	class="btn btn-success"	id="modify" type="submit">수정하기</button>
					<button	class="btn btn-danger"	id="cancel" type="reset">취소</button>
					<button	class="btn btn-danger"	id="out" type="button">회원탈퇴하기</button>
					<button	class="btn btn-info"	id="list" type="button">뒤로가기</button>
				</td>
			</tr>
			
		</table>
	</form>
	</div>
	</div>
</body>
</html>









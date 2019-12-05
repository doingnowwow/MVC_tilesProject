<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type='text/javascript'	src='http://code.jquery.com/jquery-latest.js'></script>
<script type='text/javascript' src='${pageContext.request.contextPath }/js/validation_company.js'></script>
<script type="text/javascript">
$(function() {
	$('#btn3').click(function() {
		$(location).attr('href', '${pageContext.request.contextPath }/user/main.do');
	});
	
	$('form[name=comForm]').submit(function(){
		$(this).attr('action', '${pageContext.request.contextPath }/user/company/insertCompany.do');
		
		if(!$('input[name=com_name]').val().validationNM()){
			alert('성명을 바르게 입력해주세요.');
			return false;
		}

		var com_bir = $('input[name=com_bir1]').val() + '-' +
		              $('input[name=com_bir2]').val() + '-' +
		              $('input[name=com_bir3]').val();
		if(!com_bir.validationBIR()){
			alert('생년월일을 바르게 입력해주세요.');
			return false;
		}
		$('input[name=com_bir]').val(com_bir);
		
		var com_id = $('input[name=com_id1]').val() + '-' +
			         $('input[name=com_id2]').val() + '-' +
			         $('input[name=com_id3]').val();
		if(!com_id.validationID()){
			alert('사업자번호를 바르게 입력해주세요.');
			return false;
		}
		$('input[name=com_id]').val(com_id);
		
		if(!$('input[name=com_pass]').val().validationPWD()){
			alert('패스워드를 바르게 입력해주세요.');
			return false;
		}
		
		if(!$('input[name=com_nickname]').val().validationNN()){
			alert('닉네임을 바르게 입력해주세요.');
			return false;
		}
		
		if($('input[name=com_pass]').val() != $('input[name=com_pass_confirm]').val()){
			alert('비밀번호를 확인해주세요.');
			return false;
		}
		
		var com_tel = $('select[name=com_tel1]').val() + '-' +
					        $('input[name=com_tel2]').val() + '-' +
					        $('input[name=com_tel3]').val();
		if(!com_tel.validationHP()){
			alert('핸드폰 번호를 바르게 입력해주세요.');
			return false;
		}
		$('input[name=com_tel]').val(com_tel);

		var com_email = $('input[name=com_email1]').val() + '@' +
		               $('select[name=com_email2]').val();
		if(!com_email.validationMAIL()){
			alert('메일 주소를 바르게 입력해주세요.');
			return false;
		}
		$('input[name=com_email]').val(com_email);
	});
});

function idCheck(){
	var com_id = $('input[name=com_id1]').val() + '-' +
    $('input[name=com_id2]').val() + '-' +
    $('input[name=com_id3]').val();
	if(!com_id.validationID()){
	alert('사업자번호를 바르게 입력해주세요.');
	return false;
	}
	
	$.ajax({
		 type : "get" 
	    , url : "/SUL/user/company/checkedID.do"
	    ,dataType : "json"
	    ,data : { "com_id" : com_id	}
	    ,error : function(result) {
				alert("code : " + result.status + "\r\nmessage : "	+ result.reponseText);
			}
	    ,success : function(res) {
		    	if(eval(res.flag)){
		    		$('#spanid').text("사용할수 있는 아이디").css('color','red');
				}else{
					$('#spanid').text("사용할수 없는 아이디").css('color','red');
				}
			}
	});
}
</script>
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
 <div class="panel panel-green">
  <div class="panel-heading">사업자 회원가입창</div>
   <div class="panel-body">
	<form name="comForm" method="post"	action="" class="form-horizontal">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table table-hover-color">
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
				<td class="fieldName" width="100px" height="25">성 명</td>
				<td><input type="text" name="com_name" value="" /></td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td class="fieldName" width="100px" height="25">생년월일</td>
				<td><input type="hidden" name="com_bir" />
				 <input type="text"	name="com_bir1" size="4" value=""   />년
				 <input type="text"	name="com_bir2" size="2" value="" />월
				 <input type="text"	name="com_bir3" size="2" value="" />일</td>
			</tr>
			
			<tr>
				<td class="fieldName" width="100px" height="25">사업자번호</td>
				<td><input type="hidden" name="com_id" />
					<input type="text"	name="com_id1" size="3" value=""   /> - 
					<input type="text"	name="com_id2" size="2" value="" /> - 
				 	<input type="text"	name="com_id3" size="5" value="" />&nbsp;&nbsp;
				 	<b><a href="javascript:idCheck();">[사업자번호 중복검사]</a></b>
				 	&nbsp;&nbsp;<span id="spanid"></span></td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td class="fieldName" width="100px" height="25">닉네임</td>
				<td><input type="text" name="com_nickname" value=""></td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td class="fieldName" width="100px" height="25">비밀번호</td>
				<td><input type="text" name="com_pass" value="" /> 8 ~ 20 자리 영문자 및 숫자 사용</td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td class="fieldName" width="100px" height="25">비밀번호확인</td>
				<td><input type="text" name="com_pass_confirm" value="" /> 8 ~20 자리 영문자 및 숫자 사용</td>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
		
		
			<tr>
			</tr>
			<tr>
				<td class="fieldName" width="100px" height="25">핸드폰</td>
				<td><input type="hidden" name="com_tel" /> 
				<select	name="com_tel1">
						<option value="010">010</option>
						<option value="016">016</option>
						<option value="017">017</option>
						<option value="019">019</option>
				</select> - <input type="text" name="com_tel2" size="4" value="" /> - <input
					type="text" name="com_tel3" size="4" value="" /></td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td class="fieldName" width="100px" height="25">이메일</td>
				<td><input type="hidden" name="com_email" />
				 <input type="text"	name="com_email1" value="" /> @ 
				 <select name="com_email2">
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
			
			</tr>
			<tr>
				
			</tr>
			<tr>
			
			</tr>
			<tr>
			
			</tr>
			<tr>
				<td class="btnGroup" colspan="2">
					<button
						class="btn btn-success"	id="btn1" type="submit">가입하기</button>
					<button
						class="btn btn-danger"	id="btn2" type="reset">취소</button>
					<button
						class="btn btn-info"	id="btn3" type="button">메인화면</button>
				</td>
			</tr>
		</table>
	</form>
	</div>
	</div>
	</div>
</body>
</html>









<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type='text/javascript'	src='http://code.jquery.com/jquery-latest.js'></script>
<script type='text/javascript' src='${pageContext.request.contextPath }/js/validation_member.js'></script>
<script type="text/javascript">

$(function() {
	
	// 목록으로 돌아가는 버튼
	$('#btn3').click(function() {
		$(location).attr('href', '${pageContext.request.contextPath }/user/main.do');
	});
	

	// 회원가입 버튼
	$('form[name=memberForm]').submit(function(){
		$(this).attr('action', '${pageContext.request.contextPath }/user/member/insertMember.do');
		
		if(!$('input[name=mem_name]').val().validationNM()){
			alertPRT('성명을 바르게 입력해주세요.');
			return false;
		}

		var mem_bir = $('input[name=mem_bir1]').val() + '-' +
		              $('input[name=mem_bir2]').val() + '-' +
		              $('input[name=mem_bir3]').val();
		
		if(!mem_bir.validationBIR()){
			alertPRT('생년월일을 바르게 입력해주세요.');
			return false;
		}
		$('input[name=mem_bir]').val(mem_bir);
		  if(!$('#mem_id').val().validationID()){
			  alertPRT('아이디를 바르게 입력해주세요.');
			return false;
		} 
		   
		 if(!$('input[name=mem_nickname]').val().validationNICK()){
			 alertPRT('닉네임 바르게 입력해주세요.');
				return false;
			}  
		  if(!$('#mem_pass').val().validationPWD()){
			  alertPRT('패스워드를 바르게 입력해주세요.');
			return false;
		}
	 	if($('#mem_pass').val() != $('#mem_pass_confirm').val()){
	 		alertPRT('비밀번호를 확인해주세요.');
			return false;
		}   
		var mem_tel = $('select[name=mem_tel1]').val() + '-' +
							$('input[name=mem_tel2]').val() + '-' +
					        $('input[name=mem_tel3]').val();
		
		$('input[name=mem_tel]').val(mem_tel);
		var mem_email = $('input[name=mem_email1]').val() + '@' +   $('select[name=mem_email2]').val();
		if(!mem_email.validationMAIL()){
			alertPRT('메일 주소를 바르게 입력해주세요.');
			return false;
		}
		$('input[name=mem_email]').val(mem_email);
	});
	
	
	
	
	
	

});




function idCheck(){
	
	 var mem_id = $('#mem_id').val();
	 
	 if(!mem_id.validationID()){
		 alertPRT('아이디를 바르게 입력해주세요.');
		return ;
	} 
	 
	 
	 
	$.ajax({
		 type : "POST" 
	    , url : "${pageContext.request.contextPath }/user/member/checkedID.do"
	    ,dataType : "json"
	    ,data : { "mem_id" : mem_id	}
	    ,error : function(xhr) {
	    	alert("상태" + xhr.status + "\n text :" + xhr.statusText);
			}
	    ,success : function(res) {
					

	    	if(eval(res.flag)){
	    		$('#spanid').text("사용할수 있는 아이디!!!!!").css('color','red');
			}else{
				$('#spanid').text("사용할수 없는 아이디!!!!!").css('color','red');
			}
 			
			

			}

		});

	}
	



function alertPRT(msg){
	

	BootstrapDialog.show({
		title : '알립니다.!',
		message : msg
	});

	return false;
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
  <div class="panel-heading">일반회원 회원가입창</div>
   <div class="panel-body">
	<form name="memberForm" method="post" class="form-horizontal"	>
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table table-hover-color">
			<tr>
			</tr>
			
			<tr>
				
			</tr>
			<tr>
		
				<td class="fieldName" width="100px" height="25" >성 명</td>
				<td><input type="text" name="mem_name" value="" /></td>
				
			</tr>
			<tr>
			
			</tr>
		
			<tr>
				
			</tr>

			<tr>
				<td class="fieldName" width="100px" height="25">생년월일</td>
				<td><input type="hidden" name="mem_bir" />
				 <input type="text"	name="mem_bir1" size="4" value=""   />년
				 <input type="text"	name="mem_bir2" size="2" value="" />월
				 <input type="text"	name="mem_bir3" size="2" value="" />일</td>
			</tr>
			<tr>
			</tr>

			<tr>
				<td class="fieldName" width="100px" height="25">아이디</td>
				<td><input id="mem_id" type="text" name="mem_id" value="">&nbsp;&nbsp;<b><a
						href="javascript:idCheck();">[ID 중복검사]</a></b>&nbsp;&nbsp;<span id="spanid"></span></td>
			</tr>
			
			<tr>
				<td class="fieldName" width="100px" height="25">닉네임</td>
				<td><input type="text" name="mem_nickname" value="">4 ~ 10 자리 특수문자사용가능</td>
			</tr>
			<tr>
			</tr>

			<tr>
				<td class="fieldName" width="100px" height="25">비밀번호</td>
				<td><input id="mem_pass" type="text" name="mem_pass" value="" /> 4 ~ 10 자리 영문자 및 숫자 사용</td>
			</tr>
			<tr>
			</tr>

			<tr>
				<td class="fieldName" width="100px" height="25">비밀번호확인</td>
				<td><input id="mem_pass_confirm" type="text" name="mem_pass_confirm" value="" /> 4 ~10 자리 영문자 및 숫자 사용</td>
			</tr>
			<tr>
			</tr>
	
			
			

			<tr>
				<td class="fieldName" width="100px" height="25">핸드폰</td>
				<td><input type="hidden" name="mem_tel" /> 
				<select	name="mem_tel1">
						<option value="010">010</option>
						<option value="016">016</option>
						<option value="017">017</option>
						<option value="019">019</option>
				</select> - <input type="text" name="mem_tel2" size="4" value="" /> - <input
					type="text" name="mem_tel3" size="4" value="" /></td>
			</tr>
			

			<tr>
				<td class="fieldName" width="100px" height="25">이메일</td>
				<td><input type="hidden" name="mem_email" />
				 <input type="text"	name="mem_email1" value="" /> @ 
				 <select name="mem_email2">
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
						class="btn btn-info"	id="btn3" type="button">목록</button>
				</td>
			</tr>
		
		</table>
		</form>
	</div>
	</div>
	</div>
</body>
</html>









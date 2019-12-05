<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type='text/javascript'
	src='http://code.jquery.com/jquery-latest.js'></script>
<script type='text/javascript'
	src='${pageContext.request.contextPath }/js/validation_member.js'></script>
<script type="text/javascript">

$(function() {
	
	// 목록으로 돌아가는 버튼
	$('#btn3').click(function() {
		$(location).attr('href', '${pageContext.request.contextPath }/user/main.do');
	});
	

	
		
	$('#searchMemPass').click(function(){
		
		
		
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath }/user/member/searchPWD.do"
			,data : { mem_id :$('#mem_id').val(),
					mem_name : $('#mem_name').val(),
					mem_email:$('#mem_email').val()
			
			},
			error : function(xhr){
				alert("상태 : " + xhr.status);
				
			},
			
			success : function(res){
				
				
				code = "당신이 찾던 비밀번호는" +res+"입니다";
				
				if(res =='null'){
					alertPRT("회원이 아닙니다.");
					
				}else{
					
				alertPRT(code);
				}
				
			}
			
			
			//////////////ajax끝
		});
	
	})
	
	
	$('#searchComPass').click(function(){
		
		
		
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath }/user/company/searchPWD.do"
			,data : { com_name :$('#com_name').val(),
					com_id : $('#com_id').val(),
					
					com_email:$('#com_email').val()
			
			},
			error : function(xhr){
				alert("상태 : " + xhr.status);
				
			},
			
			success : function(res){
				
				code = "당신이 찾던 비밀번호는" +res+"입니다";
				if(res =='null'){
					alertPRT("회원이 아닙니다.");
					
				}else{
					
				alertPRT(code);
				}
				
			}
			
			
			//////////////ajax끝
		});
	
	})
	
	
	
	
	
	
	
	
	
///////////////////
});





	



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
<!-- 일반회원 비밀번호찾기  -->
	
	<div class="panel panel-grey">
     <div class="panel-heading">일반회원 비밀번호 찾기</div>
        <div class="panel-body">
	<form name="searchID" method="post">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table table-hover table-condensed">
			

			<tr>
				
			</tr>
			
			<tr>
				<td class="fieldName" width="100px" height="25">아이디</td>
				<td><input type="text" id="mem_id" name="mem_id" value="" /></td>
			</tr>
			
			<tr>
				<td class="fieldName" width="100px" height="25">성 명</td>
				<td><input type="text" id="mem_name" name="mem_name" value="" /></td>
			</tr>
			

			<tr>
				<td class="fieldName" width="100px" height="25">이메일</td>
				<td><input type="text" id="mem_email" name="mem_email" value=""
					placeholder="dfd@gmail.com" /></td>
			</tr>
			<tr>
				
			</tr>

			
			<tr>
				<td class="btnGroup" colspan="2">
					<button
						class="btn btn-success"
						id="searchMemPass" type="button">비밀번호찾기</button>
					<button
						class="btn btn-danger"	
						id="btn2" type="reset">취소</button>
				</td>
			</tr>
		</table>
	</form>
	</div>
	</div>
	
		
	<br><br>	
	<!-- 사업자  비밀번호찾기  -->
	<div class="panel panel-grey">
     <div class="panel-heading">사업자 비밀번호찾기</div>
        <div class="panel-body">
	
	<form name="searchComID" method="post">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table table-hover table-condensed">
		

			
			<tr>
				<td class="fieldName" width="100px" height="25">아이디</td>
				<td><input type="text" id="com_id" name="com_id" value="" /></td>
			</tr>
			<tr>
				<td class="fieldName" width="100px" height="25">성 명</td>
				<td><input type="text" id="com_name" name="com_name" value="" /></td>
			</tr>
		
			<tr>
				<td class="fieldName" width="100px" height="25">이메일</td>
				<td><input type="text" id="com_email" name="com_email" value=""
					placeholder="dfd@gmail.com" /></td>
			</tr>
		
			<tr>
				<td class="btnGroup" colspan="2">
					<button
					class="btn btn-success"
						id="searchComPass" type="button">비밀번호찾기</button>
					<button
					class="btn btn-danger"
						id="btn2" type="reset">취소</button>
				
				</td>
			</tr>
		</table>
	</form>
	</div>
	</div>
		
		<button		class="btn btn-info"
						id="btn3" type="button">메인으로 돌아가기</button>

</body>
</html>









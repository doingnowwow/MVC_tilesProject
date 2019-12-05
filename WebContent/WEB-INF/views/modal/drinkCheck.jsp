<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
td {f on t-family:"돋움";
	font-size: 9pt;
	line-height: 16px;
	color: #818181;
	letter-spacing: 0px;
}

td a {
	font-family: "돋움";
	font-size: 9pt;
	line-height: 16px;
	color: #818181;
	letter-spacing: 0px;
	text-decoration: none;
}

td a:hover {
	font-family: "돋움";
	font-size: 9pt;
	line-height: 16px;
	color: #818181;
	letter-spacing: 0px;
	text-decoration: underline;
}
</style>
<script type='text/javascript' src='http://code.jquery.com/jquery-latest.js'></script>
<script>
	$(function(){
		$('#searchImg').click(function(){
			$.ajax({
			    type : "POST"
			    , url : "${pageContext.request.contextPath}/user/review/drinkList.do"
			    , dataType : "json"
			    , data : { drink_name : $('#drink_name').val() }
			    , error : function(result) {
			              		alert("code : " + result.status + "\r\n message : " + result.reponseText);
			              }
			    , success : function(result) {
								var htmls = '<table width="100%" height="200px" border="0" cellspacing="0" cellpadding="0" ' + 
											'style="overflow:scroll;" id="drinkTBL">' +
											'<thead>' +
											'<tr>' + 
												'<th>ID</th>' +
												'<th>상호명</th>' + 
												'<th>주소</th>' + 
											'</tr>' + 
										'</thead>' +
										'<tbody>';
								for(var i = 0; i < result.length; i++){
									htmls += '<tr>' +
												'<td>' + result[i].drink_no + '</td>' +
												'<td>' + result[i].drink_name + '</td>' +
												'<td>' + result[i].drink_add + '</td>' +
											'</tr>';
								}
								htmls += '</tbody></table>';
								
								$('#viewTable').html(htmls);
								
								$('#drinkTBL tr:gt(0)').click(function(){
									var drink_no = $(this).find('td:eq(0)').text();
									var drink_name = $(this).find('td:eq(1)').text();
									
									$(opener.document).find('#drink_no').val(drink_no);
									$(opener.document).find('#drink_name').val(drink_name);
									
									self.close();
								});
			    			}
			});
		});
	});
</script>
</head>
<body>
	<table width="354" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td><img src="../image/open_table01.gif" width="354" height="10"></td>
		</tr>
		<tr>
			<td height="10" background="../image/open_table02.gif" align="center">&nbsp;</td>
		</tr>
		<tr>
			<td height="300" align="center" valign="top"
				background="../image/open_table02.gif">
				<table width="300" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="25"><div align="center">술집이름을 입력해주세요.</div></td>
					</tr>
					<tr>
						<td height="38" background="../image/open_tt.gif" align="center">
							<input type="text" id="drink_name">&nbsp;&nbsp;
							<input type="image" src="${pageContext.request.contextPath}/image/bt_search.gif" border='0'
							align="middle" id="searchImg">
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>
							<div style="overflow: auto; white-space: nowrap; overflow-X: hidden; height: 200px;" id="viewTable">
							</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td><img src="../image/open_table03.gif" width="354" height="10"></td>
		</tr>
	</table>
</body>
</html>
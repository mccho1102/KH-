<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.outer{
		width:600px;
		height:500px;
		background:black;
		color:white;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
	}
	
	.outer label, .outer td{
		color:white;
	}
	
	input{
		margin-top:2px;
	}
	
	#updatePwdBtn, #cancelBtn {
		background:orangered;
		border-radius:5px;
		width:auto;
		height:25px;
		padding:0px 5px;
		text-align:center;
	}
	
	#updatePwdBtn:hover, #cancelBtn:hover{
		cursor:pointer;
	}
	td {
		text-align:right;
	}
	#updatePwdBtn{
		background:yellowgreen;
	}
	#updatePwdBtn, #cancelBtn {
		display:inline-block;
	}
</style>s
<title>비밀번호 변경</title>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<div class="outer">
		<br>
		<h2 align="center">비밀번호 변경</h2>
		
		<!-- 비밀번호 변경 폼 -->
		<form id="updatePwdForm" name="updatePwdForm" method="post"
			action="<%=request.getContextPath()%>/updatePwd.me">
			
			<table align="center">
				<tr>
					<td>현재 비밀번호</td>
					<td>
						<input type="password" name="userPwd">
					</td>
				</tr>
				<tr>
					<td>새로운 비밀번호</td>
					<td>
						<input type="password" name="newPwd">
					</td>
				</tr>
				<tr>
					<td>새로운 비밀번호 확인</td>
					<td>
						<input type="password" name="newPwd2">
					</td>
				</tr>
			</table>
		
			<br><br>
			<div class="btns" align="center">
				<div id="updatePwdBtn" onclick="checkPwd()">변경하기</div>
				<div id="cancleBtn" 
				onclick="location.href='javascript:history.back()';">취소</div>
			</div>
		
		</form>
	</div>
	<script>
		function checkPwd(){
			// 새로운 비밀번호
			var value = $("input[name=newPwd]").val().trim();
			
			// 숫자, 문자 포함 형태
			// 6~12자리 이내
			var regExp = /^[A-Za-z0-9]{6,12}$/; 
			
			if(!regExp.test(value)){
				alert("비밀번호는 숫자와 문자 포함 6~12자리 이내로 작성하세요.");
				return false;
			}
			
			// 새로운 비밀번호 확인
			var value2 = $("input[name=newPwd2]").val().trim();
			
			if(value != value2){
				alert("비밀번호가 일치하지 않습니다.");
				$("input [name=newPwd2]").focus();
				return false;
			}
			
			$("#updatePwdForm").submit();
		}
	</script>
</body>
</html>
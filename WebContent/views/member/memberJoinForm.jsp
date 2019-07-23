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
	
	#idCheck, #goMain, #joinBtn {
		background:orangered;
		border-radius:5px;
		width:80px;
		height:25px;
		text-align:center;
	}
	
	#idCheck:hover, #joinBtn:hover, #goMain:hover {
		cursor:pointer;
	}
	td {
		text-align:right;
	}
	#joinBtn {
		background:yellowgreen;
	}
	#joinBtn, #goMain {
		display:inline-block;
	}
	.labelCenter{
		text-align : center;
	}
</style>
<title>회원가입</title>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<!-- 1. 회원가입 폼 작성 -->
	<div class="outer">
	<br>
		<h2 align="center">회원가입</h2>
	
		<form id="joinForm" name="joinForm" method="POST"
			action="<%= request.getContextPath()%>/insert.me">
		
			<table>
				<tr>
					<td width="200px">* 아이디</td>
					<td><input type="text" maxlength="13" name="userId" required></td>
					<td width="200px"><div id="idCheck" onclick="checkId();">중복확인</div>
					</td>
				</tr>
				<tr>
					<td></td>
					<td class="labelCenter">
						<label id="regId">&nbsp;</label>
					</td>
				</tr>
				<tr>
					<td>* 비밀번호</td>
					<td>
						<input type="password" maxlength="13" name="userPwd" required>
					</td>
					<td class="labelCenter">
						<label id="regPwd"></label>
					</td>
				</tr>
				<tr>
					<td>* 비밀번호 확인</td>
					<td>
						<input type="password" maxlength="13" name="userPwd2" required>
					</td>
					<td class="labelCenter">
						<label id="pwdResult"></label>
					</td>
				</tr>
				<tr>
					<td>* 이름</td>
					<td>
						<input type="text" maxlength="5" name="userName" required>
					</td>
					<td class="labelCenter">
						<label id="regName"></label>
					</td>
				</tr>
				<tr>
					<td>연락처</td>
					<td>
						<input type="tel" maxlength="11" name="phone"
							placeholder="(-제외해서 입력해주세요.)">
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<input type="email" name="email">
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<input type="text" name="address">
					</td>
				</tr>
				<tr>
					<td>관심분야</td>
					<td>
						<input type="checkbox" id="sports" 
						name="interest" value="운동">
						<label for="sports">운동</label>
						<input type="checkbox" id="climbing" 
						name="interest" value="등산">
						<label for="sports">등산</label>
						<input type="checkbox" id="fishing" 
						name="interest" value="낚시">
						<label for="sports">낚시</label>
						<input type="checkbox" id="cooking" 
						name="interest" value="요리">
						<label for="sports">요리</label>
						<input type="checkbox" id="game" 
						name="interest" value="게임">
						<label for="sports">게임</label>
						<input type="checkbox" id="etc" 
						name="interest" value="기타">
						<label for="sports">기타</label>
					</td>
				</tr>
			</table>
			<br>
			
			<div class="btns" align="center">
				<div id="goMain" onclick="goMain();">메인으로</div>
				
				<input type="submit" id="joinButton" value="회원가입">
			</div>
		</form>
	</div>
	
	<script>
	// 2. 메인페이지로 돌아가기 버튼
	function goMain(){
		location.href="<%= request.getContextPath() %>";
	}	
	
	// 3. 실시간으로 입력 형식 검사 (정규표현식 사용)
	
		var idC = false;
		var pwdC = false;
		var pwd2C = false;
		var nameC = false;
		
	$(document).ready(function(){
		
		
		
		// 아이디 검사
		$("#joinForm input[name=userId]").keyup(function(){
			var value = $("#joinForm input[name=userId]").val().trim()
			
			// 첫 글자는 영어 소문자
			// 나머지 글자는 영어(소, 대) + 숫자
			// 5글자 이상
			var regExp = /^[a-z][A-Za-z0-9]{4,}$/;
			if(regExp.test(value)){
				$("#regId").text("사용가능한 아이디입니다.")
				.css({"color":"green", "font-weight":"bold"});
				idC = true;
			}else{
				$("#regId").text("사용불가능한 아이디입니다.")
				.css({"color":"red", "font-weight":"bold"});
				idC = false;
			}
		});
		
		// 비밀번호 형식 검사
		$("#joinForm input[name=userPwd]").keyup(function(){
			var value = $("#joinForm input[name=userPwd]").val().trim();
			
			// 숫자, 문자 포함 형태
			// 6~12자리 이내
			var regExp = /^[A-Za-z0-9]{6,12}$/; 
			
			if(regExp.test(value)){
				$("#regPwd").text("사용가능 합니다.").css("color", "green")
				pwdC = true;
			}else{
				$("#regPwd").text("사용불가 합니다.").css("color", "red")
				pwdC = false;
			}
		});
		
		// 비밀번호 일치 여부 검사
		$("#joinForm input[name=userPwd], input[name=userPwd2]").keyup(function(){
			var pwd = $("#joinForm input[name=userPwd]").val().trim();
			var pwd2 = $("input[name=userPwd2]").val().trim();
			
			if(pwd == pwd2){
				$("#pwdResult").text("비밀번호 일치").css("color", "green");	
				pwd2C=true;
			}else{
				$("#pwdResult").text("비밀번호 불일치").css("color", "red");	
				pwd2C=false;
			}
		});
		
		// 이름 형식 검사
		$("input[name=userName]").blur(function(){
			
			// 한글 2글자 이상 5글자이내
			var regExp = /^[가-힣]{2,}$/;
			
			if(regExp.test($(this).val())){
				$("#regName").text("정상입력").css("color","green");
				nameC = true;
			}else {
				$("#regName").text("한글만 입력").css("color","red");
				nameC = false;
			}
		});
	});
	
	// 회원가입 버튼 클릭 시 검사
	$("#joinForm").submit(function(){
		
		// 연락처 형식 검사
		var regExp = /^[0][0-9]{1,2}[0-9]{3,4}[0-9]{4}$/;
		
		if(!regExp.test($("input[name=phone]").val() )){
			window.alert("연락처 형식을 확인해주세요.")
			$("input[name=phone]").focus();
		
			return false;
		}
		
		// 이메일 형식 검사
		regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		
		if(!regExp.test($("input[name=email]").val())){
			alert("이메일 형식을 확인해주세요.");
			$("input[name=email]").focus();
			return false;
		}
		
		/* // 아이디 형식 검사
		var value = $("#joinForm input[name=userId]").val().trim()
		regExp = /^[a-z][A-Za-z0-9]{4,}$/;
		
		if(!regExp.test(value)){
			alert("아이디 형식을 확인해주세요.");
			$("#joinForm input[name=userId]").focus();
			return false;
		} */
		
		if(!idC){ alert("아이디 형식을 확인해주세요."); return false;}
		if(!pwdC){ alert("비밀번호 형식을 확인해주세요."); return false;}
		if(!pwd2C){ alert("비밀번호가 일치하지 않습니다.."); return false;}
		if(!nameC){ alert("이름 형식을 확인해주세요."); return false;}
		
		$("#joinForm input[name=userId]").removeAttr("dissabled");
	});
	
	
	// 5. 아이디 중복 체크
	function checkId() {
		window.open("idCheckForm.jsp", "checkForm", "width=300, height=200");
					// 팝업 창 주소 	        팝업 창 이름                      팝업 창 스타일
	}
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>
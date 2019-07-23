<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
<%
	// MyPageServlet에서 setAttribute한 값 저장하기
	// 페이지 지시자는 페이지당 하나가 원칙!
	// -> 단 import는 추가 기능
	Member member = (Member)request.getAttribute("member");
	
	String userId = member.getUserId();
	String userPwd = member.getUserPwd();
	String userName = member.getUserName();
	
	String phone = (member.getPhone() != null) ? member.getPhone() : "";
	String email = (member.getEmail() != null) ? member.getEmail() : "";
	String address = (member.getAddress() != null) ? member.getAddress() : "";
	
	String[] checkedInterest = new String[6];
	// 화면에 나타난 checkbox 체크용
	
	if(member.getInterest() != null){
		String[] tmpArr = member.getInterest().split(", ");
		// 임시 저장 배열
		
		for(int i=0; i<tmpArr.length; i++){
			switch(tmpArr[i]){
			case "운동" : checkedInterest[0] = "checked"; break;
			case "등산" : checkedInterest[1] = "checked"; break;
			case "낚시" : checkedInterest[2] = "checked"; break;
			case "요리" : checkedInterest[3] = "checked"; break;
			case "게임" : checkedInterest[4] = "checked"; break;
			case "기타" : checkedInterest[5] = "checked"; break;
			
			}
		}
	}
%>    
    
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
	
	#goMain, #updateBtn, #deleteBtn, #pwdUpdateBtn{
		background:orangered;
		border-radius:5px;
		width:auto;
		height:25px;
		padding:0px 5px;
		text-align:center;
	}
	
	#goMain:hover,  #updateBtn:hover, #deleteBtn:hover, #pwdUpdateBtn:hover {
		cursor:pointer;
	}
	td {
		text-align:right;
	}
	#updateBtn, #deleteBtn, #pwdUpdateBtn {
		background:yellowgreen;
	}
	#goMain,  #updateBtn, #deleteBtn, #pwdUpdateBtn {
		display:inline-block;
	}
</style>
<title>회원 정보</title>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<!-- 1. 회원정보 수정 폼 작성 -->
	<div class="outer">
	<br>
		<h2 align="center">회원 정보 수정</h2>
	
		<form id="updateForm" name="updateForm" method="POST"
			action="<%= request.getContextPath()%>/update.me">
		
			<table>
				<tr>
					<td width="200px">아이디</td>
					<td><input type="text" maxlength="13" name="userId" 
					 value="<%= userId%>" readonly></td>
					<!-- <td width="200px"><div id="idCheck" onclick="checkId();">중복확인</div>
					</td> -->
				</tr>
				<tr>
					<td></td>
					<!-- <td class="labelCenter">
						<label id="regId">&nbsp;</label>
					</td> -->
				</tr>
				<!-- <tr>
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
				</tr> -->
				<tr>
					<td>이름</td>
					<td>
						<input type="text" maxlength="5" name="userName" 
						value="<%= userName %>" readonly>
					</td>
					<!-- <td class="labelCenter">
						<label id="regName"></label>
					</td> -->
				</tr>
				<tr>
					<td>연락처</td>
					<td>
						<input type="tel" maxlength="11" name="phone"
							placeholder="(-제외해서 입력해주세요.)" value="<%= phone %>">
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<input type="email" name="email" value="<%= email %>">
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<input type="text" name="address" value="<%= address %>">
					</td>
				</tr>
				<tr>
					<td>관심분야</td>
					<td>
						<input type="checkbox" id="sports" 
						name="interest" value="운동" <%= checkedInterest[0] %> >
						<label for="sports">운동</label>
						<input type="checkbox" id="climbing" 
						name="interest" value="등산" <%= checkedInterest[1] %>>
						<label for="sports">등산</label>
						<input type="checkbox" id="fishing" 
						name="interest" value="낚시" <%= checkedInterest[2] %>>
						<label for="sports">낚시</label>
						
						<br>
						
						<input type="checkbox" id="cooking" 
						name="interest" value="요리" <%= checkedInterest[3] %>>
						<label for="sports">요리</label>
						<input type="checkbox" id="game" 
						name="interest" value="게임" <%= checkedInterest[4] %>>
						<label for="sports">게임</label>
						<input type="checkbox" id="etc" 
						name="interest" value="기타" <%= checkedInterest[5] %>>
						<label for="sports">기타</label>
					</td>
				</tr>
			</table>
			<br>
			
			<div class="btns" align="center">
				<div id="goMain" onclick="goMain();">메인으로</div>
				<div id="updateBtn" onclick="updateMember();">수정하기</div>
				<div id="pwdUpdateBtn" onclick="updatePwd();">비밀번호변경</div>
				<div id="deleteBtn" onclick="deleteMember();">탈퇴하기</div>
			</div>
		</form>
	</div>
	<script>
		function goMain() {
			location.href = "<%= request.getContextPath() %>";
		}	
		
		// 회원 정보 수정
		function updateMember(){
			$("#updateForm").submit();
		}
			
		$("#updateForm").submit(function(){
			
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
				
		});
			
			/* // 아이디 형식 검사
			var value = $("#joinForm input[name=userId]").val().trim()
			regExp = /^[a-z][A-Za-z0-9]{4,}$/;
			
			if(!regExp.test(value)){
				alert("아이디 형식을 확인해주세요.");
				$("#joinForm input[name=userId]").focus();
				return false;
			} */
			
			
			
		// 비밀번호 변경하기 
		function updatePwd(){
				
			location.href="views/member/pwdupdateForm.jsp";
			
		}
	</script>
</body>
</html>





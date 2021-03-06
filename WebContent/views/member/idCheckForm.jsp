<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 체크</title>
<script>


	// 중복 체크창 아이디 입력 부분에 초기값 설정
	// + 확인버튼 활성, 비활성화 설정
	function idValue(){
		var userId;
		
		// 중복 체크 창이 처음 열렸을때
		if('<%= request.getAttribute("result") %>' == "null"){
			userId = opener.document.joinForm.userId.value;
			// -> 부모창에 입력된 아이디 값을 가져와라
		}else{
			// 중복 체크 동작 후
			// 체크에 사용된 아이디를 다시 입력창에 입력하기
			userId = "<%= request.getAttribute("userId")%>";
			
			// 사용 가능한 아이디인 경우
			if(<%= request.getAttribute("result")%> == 0){
				document.getElementById("usedId").removeAttribute("disabled");
			}else{
				document.getElementById("usedId").setAttribute("disabled");
			}
		}
		
		document.getElementById("userId").value = userId;
		
	}
	
	// 중복체크한 아이디를 사용 -> 회원가입 창에 입력
	function usedId(){
		if(<%= request.getAttribute("result")%> == 0){
			opener.document.joinForm.userId.value
				= document.getElementById("userId").value;
			
			opener.document.joinForm.userId.setAttribute("disabled", "disabled");
			
		}
		
		if(opener != null){ // 중복체크 창 닫기
			opener.checkForm = null;
			self.close();
		}
	}
	
</script>
</head>
<body onload="idValue();">
	<form action="<%= request.getContextPath() %>/idCheck.me"
			id="idCheckForm" method="post">
			<input type="text" id="userId" name="userId">
			<input type="submit" value= 중복확인>
			</form>
			<br>
				<%
					if(request.getAttribute("result") != null){
						int result = (int)request.getAttribute("result");
						
						if(result > 0){
					%>
						
							이미 사용중인 아이디 입니다.
					<% 
						}else{ 
					%>
							사용 가능한 아이디 입니다.
					<%
						}
					}
				%>
			<br>
			<br>
			
			<input type="button" id="cancel" value="취소" onclick="window.close();">
			<input type="button" id="usedId" value="확인" onclick="usedId();" disabled>
</body>
</html>
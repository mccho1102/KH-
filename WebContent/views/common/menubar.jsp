<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.model.vo.Member"%>
<%

	// session 객체에 담겨진 loginUser 정보를 저장해두기
	Member loginUser = (Member)session.getAttribute("loginUser");
	System.out.println(loginUser);

	// 회원가입 성공 시 메세지 출력	
	String msg = (String)session.getAttribute("msg");
	

	/********** 3. 아이디 저장 처리 (Cookie) ************/
	
	// 세션은 서버가 생성 및 관리
	// 쿠키는 서버가 생성하고 / 브라우저가 관리
	
	// 쿠키는 최대 4KB 
	
	/*
		순서
		1) 로그인 시 아이디 저장 saveId 체크박스의
			체크 여부에 따라 서버에서 쿠키 생성
			쿠키 key=saveid , value=userid
		
		2) response 객체에 setCookie 메소드를 이용하여 
			쿠키 객체 전달(브라우저가 해당 쿠키 관리)
			
		3) 다음 요청 때 이 쿠키를 함께 서버로 전송함.
		4) 서버가 로그인 페이지를 생성할 때 전송된 쿠키 배열객체에서
			saveId 라는 쿠키가 있다면 그 value를 id 입력상자에 입력
			아이디 저장 체크박스를 check함
		5) 
	*/
	
	// 아이디 저장 체크박스 값을 수정하기 위한 변수
	boolean saveId = false; 

	// 쿠키에 저장된 아이디를 저장할 변수
	String userIdSaved = "";
	
	Cookie[] cookies = request.getCookies();
	
	// 아이디 저장 체크박스
	// 아이디 저장을 체크하지 않으면 서버 첫 시작 시 request.getCookies() 값이 null 이므로
	// 조건없이 바로 접근하면 NullPointerException이 발생한다.
	// -> if문으로 null여부 체크
	if(cookies != null){
		for(Cookie ck : cookies){
			if(ck.getName().equals("saveId")){
				userIdSaved = ck.getValue();
				saveId = true;
			}
		}
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
	body{
		background:url('<%=request.getContextPath() %>/images/a1.jpg') no-repeat;
		color : white;
		background-size : 100%;
		
	}
	
	
	#loginBtn input, #memberJoinBtn, #logoutBtn, #myPage{
		display:inline-block;
		verticla-align:middle;
		text-align:center;
		background:orangered;
		color:white;
		height:25px;
		width:100px;
		border-radius:5px;
	}
	#memberJoinBtn {
		background:yellowgreen;
	}
	#loginBtn:hover, #changeInfo:hover, #logoutBtn:hover, #memberJoinBtn:hover, #myPage:hover{
		cursor:pointer;
	}
	.loginArea > form, #userInfo {
		float:right;
	}
	#logout, #myPage {
		background:orangered;
		color:white;
		text-decoration:none;
		border-radius:5px;
	}
	#myPage {
		background:yellowgreen;
	}
	
	.wrap {
		background:black;
		width:100%;
		height:50px;
		opacity : 0.5;
	}
	.menu {
		background:black;
		color:white;
		text-align:center;
		vertical-align:middle;
		width:150px;
		height:50px;
		display:table-cell;
		
	}
	.nav {
		width:600px;
		margin-left:auto;
		margin-right:auto;
	}
	.menu:hover {
		background:darkgray;
		color:orangered;
		font-weight:bold;
		cursor:pointer;
	}
</style>
<script>
	
	// 회원가입 성공시 alert 출력
	var msg = "<%= msg %>";
	
		if(msg != "null"){ // msg 값이 있을 경우
			alert(msg);
		<% session.removeAttribute("msg"); %>
		}

</script>
</head>

<body>
	<h1 align="center">KH정보교육원 조신진님의 교육</h1>
	
	<!-- -------------------1. 회원 관련 서비스------------------------ --> >
	
	<div class="loginArea">
	
	<!-- 2. 로그인 여부에 따라 화면 변경 -->
	<!-- 2.1 로그인이 되어있는 경우 / 안되어있는 경우에 따라 화면이 달라야 하기 때문에
		if문을 이용하여 session의 값을 검사 -> session 값 유무에 따라 화면 변경
		->> 페이지 제일 상단에 session값을 저장해놓을 변수 선언.
	 -->
	
	<!-- 2.2  로그인이 되어있지 않은 경우 -->
	<% if(loginUser == null){ %>
		<!-- 1.1 로그인 관련 폼 만들기 -->
		<form id="loginForm" method="POST" 
		action="<%= request.getContextPath() %>/login.me"
		onsubmit="return validate();">
		
		<table>
			<tr>
				<td>ID : </td>
				<td>
					<input type="text" name="userId" id="userId" value="<%= saveId ? userIdSaved : "" %>">
				</td>			
			</tr>
			<tr>
				<td>PW : </td>
				<td>
					<input type="password" name="userPwd" id="userPwd">
				</td>
			</tr>
			<tr>
			<td colspan="2"><input type="checkbox" name="saveId" id="saveId" <%= saveId ? "checked" : "" %>>&nbsp;
					<label for="saveId">아이디 저장</label></td>
			</tr>
		</table>
		<div class="btns" align="center">
			<div id="memberJoinBtn" onclick="memberJoin();">회원가입</div>
			<div id="loginBtn"><input type="submit" value="로그인"></div>
		</div>
	</form>
	<% } else { %>
		<div id="userInfo">
			<label><%= loginUser.getUserName() %>님 로그인되셨습니다.</label>
			<div class="btns" align="right">
				<div id="myPage" onclick="location.href='<%=request.getContextPath()%>/myPage.me'">
				정보수정</div>
				<div id="logoutBtn" onclick="logout();">로그아웃</div>
			</div>
		</div>
	<% } %>
	</div>
	<script>
		// 1.2 로그인 유효성 검사
		function validate(){
			if($("#userId").val().trim().length == 0){
				alert("아이디를 입력하세요");
				$("#userId").focus();
				
				return false;
			}
			
			if($("#userPwd").val().trim().length == 0){
				alert("비밀번호를 입력해주세요");				
				$("#userPwd").focus();
				
				return false;
			}
			
			return true;
			// LoginServlet 생성하기
		
		}
		
		// 2.3 로그아웃
		function logout(){
			// 로그아웃 버튼 클릭 시
			// LogoutServlet 으로 이동하여
			// session에 저장된 값을 삭제
			location.href = "<%= request.getContextPath() %>/logout.me";
		}
		
		// 4. 회원 가입 버튼 클릭 시 회원 가입 페이지로 이동
		function memberJoin(){
			location.href = "<%= request.getContextPath() %>/views/member/memberJoinForm.jsp";
		}
	</script>
	
	<!-------------------------------------------------------------------------------------->
	
	<!-- 메뉴바 작성 -->
	<br clear="both">
	<br>
	
	<div class="wrap">
		<div class="nav">
			<div class="menu" onclick="goHome();">HOME</div>
			<div class="menu" onclick="goNotice();">공지사항</div>
			<div class="menu" onclick="goBoard();">게시판</div>
			<div class="menu" onclick="goThumbnail();">사진게시판</div>
		</div>
	</div>
	<script>
		function goHome() {
			location.href="<%=request.getContextPath()%>";
		}
		
		// 공지사항 목록 이동
		function goNotice() {
			location.href="<%=request.getContextPath()%>/list.no";
		}
	
	</script>
</body>
</html>























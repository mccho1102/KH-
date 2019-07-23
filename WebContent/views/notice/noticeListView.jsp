<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, notice.model.vo.Notice"%>
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.outer{
		width:800px;
		height:500px;
		background:black;
		color:white;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
		opacity : 0.5;
	}
	table {
		border:1px solid white;
		text-align:center;
		border-collapse:collapse;
	}
	.tableArea {
		width:650px;
		height:350px;
		margin-left:auto;
		margin-right:auto;
	}
	.searchArea {
		width:650px;
		margin-left:auto;
		margin-right:auto;
	}
	td, th{
		border-bottom: 1px solid white;
	}
</style>
<title>공지사항</title>
</head>
<body>
	<%@ include file ="../common/menubar.jsp" %>
	
	<div class="outer">
		<br>
		<h2 align="center">공지사항</h2>
		
		<div class="tableArea">
			
			<!-- 공지사항 목록 -->
			<table align="center" id="listArea">
				<tr>
					<th>글번호</th>
					<th width="300px">제목</th>
					<th width="100px">작성자</th>
					<th>조회수</th>
					<th width="100px">작성일</th>
				</tr>
				
				<!-- for문을 이용하여 조회된 공지사항 목록 출력하기 -->
				<% if(!list.isEmpty()) {%>
				
				<% for( Notice no : list ){ %>
					<tr>
						<td><%= no.getnNo() %></td>
						<td><%= no.getnTitle() %></td>
						<td><%= no.getnWriter() %></td>
						<td><%= no.getnCount() %></td>
						<td><%= no.getnDate() %></td>
					</tr>
					<% } %>
				<% } else { %>
					<tr>
						<td colspan="5">조회 결과가 없습니다.</td>
					</tr>
					<% } %>
			</table>
		
		</div>
		
	
	<div class="searchArea" align="center">
		<select id="searchCondition" name="searchCondition">
			<option>----</option>
			<option value="writer">작성자</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
		</select>
		<input type="search">
		<button type="submit">검색하기</button>
		
		<!-- 글쓰기 버튼 -->
		<!-- 공지사항은 관리자만 작성 가능 
			-> 접속한 id가 admin일때만 글쓰기 버튼 노출
		-->
		<% if(loginUser != null && loginUser.getUserId().equals("admin")){ %>
			<button onclick="location.href='<%= request.getContextPath() %>/insertForm.no'">글쓰기 </button>
		<% } %>
		
		</div>
	</div>
	<script>
		// 공지사항 상세보기	 onload
		$(function(){
			
			$("#listArea td").mouseenter(function(){
				$(this).parent().css({"background" : "darkgrey",
									  "cursor" : "pointer"		
									});
				
			}).mouseout(function(){
				$(this).parent().css("background", "black");
			}).click(function(){
				var num = $(this).parent().children().eq(0).text();
				// Get 방식의 쿼리스트링을 이용하여 글 번호 전달
				location.href="<%= request.getContextPath()%>/detail.no?nno="+num;
			});
		});
	
	
	
	</script>
	
	
	
	
	
	
</body>
</html>
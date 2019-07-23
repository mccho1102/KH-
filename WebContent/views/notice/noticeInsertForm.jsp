<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
	Date date = new Date(); // 현재 시간 정보 저장됨.
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	
	String today = sf.format(date);
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
	}
	table {
		border:1px solid white;
		text-align:center;
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
</style>
<title>공지사항 작성</title>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div class="outer">
		<br>
		<h2 align="center">공지사항 작성</h2>
		<div class="tableArea">
			<form method="post" action="<%=request.getContextPath()%>/insert.no"> 
				<table>
					<tr>
						<td>제목</td>
						<td colspan="3">
						<input type="text" size="50" name="title">
						</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td>
							<input type="text" name="writer"value="<%= loginUser.getUserId() %>"readonly>
						</td>
						<td>작성일</td>
						<td>
							<input type="date" name="date"
								value="<%=today %>" readonly>
								<!-- "yyyy-MM-dd" -->
						</td>
						
					</tr>
					<tr>
						<td>내용</td>
						<td colspan="3">
							<textarea rows="15" cols="60" name="content"
								style="resize:none;"></textarea>
					</tr>
				</table>
				<br>
				<div align="center">
					<!-- form 태그 내부에서 button의 기본 타입은 submit -->
					<button type="button" onclick="javascript:history.back();">cancel</button>
					<button>OK</button>
				</div>			
			</form>
		</div>
	</div>
</body>
</html>
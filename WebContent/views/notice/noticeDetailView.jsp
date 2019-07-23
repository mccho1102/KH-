<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="notice.model.vo.Notice"%>
<%
	// NoticeDetailServlet에서 넘겨져온 Notice 받기
	Notice n = (Notice)request.getAttribute("notice");
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
	}

	.tableArea {
		width:450px;
		height:350px;
		margin-left:auto;
		margin-right:auto;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div class="outer">
		<br>
		<h2 align="center">공지사항 상세보기</h2>
		<div class="tableArea">
			<!-- noticeInsertForm.jsp에서 table 부분 복사해와서 value값 적용하기-->
			<table>
				<tr>
					<td>제목</td>
					<td colspan="3">
						<input type="text" size="50" name="title" value="<%= n.getnTitle() %>" readonly>
					</td>				
				</tr>
				<tr>
					<td>작성자</td>
					<td>
						<input type="text" value="<%= n.getnWriter() %>" name="writer" readonly>
					</td>
					<td>작성일</td>
					<td>
						<input type="date" name="date" value="<%= n.getnDate() %>" readonly>
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td colspan="3">
						<textarea name="content" cols="50" rows="15" style="resize:none;" readonly><%= n.getnContent() %></textarea>
					</td>
				</tr>
			</table>
			<br>
		</div>
	</div>
</body>
</html>
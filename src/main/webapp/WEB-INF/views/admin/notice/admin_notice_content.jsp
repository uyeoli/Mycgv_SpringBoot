<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYCGV</title>
<link rel="stylesheet" href="http://localhost:9000http://localhost:9000/css/mycgv_jsp.css">
</head>
<body>
	<!-- header -->
	<!-- <iframe src="http://localhost:9000/header.jsp"
			scrolling="no" width="100%" height="149px" frameborder=0></iframe> -->
	<jsp:include page="../../header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="content">
		<section class="board">
			<h1 class="title">관리자 - 공지사항</h1>
			<table class="board_content">
				<tr>
					<th>제목</th>
					<td>${nvo.ntitle}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${nvo.ncontent}<br><br><br>
					<c:if test = "${nvo.nsfile1 != null}">
							<img src = "http://localhost:9000/upload/${nvo.nsfile1}">
					</c:if>
					<br><br><br>
					<c:if test = "${nvo.nsfile2 != null}">
						<img src = "http://localhost:9000/upload/${nvo.nsfile2}">
					</c:if>
					</td>
					
				</tr>
				<tr>
					<th>조회수</th>
					<td>${nvo.nhits}</td>
				</tr>
				<tr>
					<th>작성일자</th>
					<td>${nvo.ndate}</td>
				</tr>
				<tr>
					<td colspan="2">
						<a href="admin_notice_update.do?nid=${nvo.nid}">
							<button type="button">수정하기</button></a>
						<a href="admin_notice_delete.do?nid=${nvo.nid}">
							<button type="button">삭제하기</button></a>
						<a href="admin_notice_list.do">
							<button type="button">리스트</button></a>
						<a href="http://localhost:9000/admin_index.do">
						<button type="button">관리자홈</button></a>
					</td>
				</tr>
			</table>
		</section>
	</div>
	
	<!-- footer -->
	<!-- <iframe src="http://localhost:9000/footer.jsp"
			scrolling="no" width="100%" height="500px" frameborder=0></iframe> -->	
	<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>

















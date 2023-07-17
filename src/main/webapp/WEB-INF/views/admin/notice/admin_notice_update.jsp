<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYCGV</title>
<link rel="stylesheet" href="http://localhost:9000http://localhost:9000/css/mycgv_jsp.css">
<script src="http://localhost:9000/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/js/mycgv_jsp_jquery.js"></script>
</head>
<body>
	<!-- header -->
	<!-- <iframe src="http://localhost:9000/header.jsp"
			scrolling="no" width="100%" height="149px" frameborder=0></iframe> -->
	<jsp:include page="../../header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="content">
	<h1>${nvo.nfile1}</h1>
	<h1>${nvo.nfile2}</h1>
	<h1>${nvo.nsfile1}</h1>
	<h1>${nvo.nsfile2}</h1>
		<section class="board">
			<h1 class="title">관리자 - 공지사항</h1>
			<form name="updateForm" action="admin_notice_update_proc.do" method="post">
				<table>
					<tr>
						<th>제목</th>
						<td>
							<input type="text" name="ntitle" value="${nvo.ntitle}">
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<textarea name="ncontent">${nvo.ncontent}</textarea>
							<input type = "hidden" name = "nid" value = "${nvo.nid}">
						</td>
					</tr>
					<tr>
						<th>파일업로드</th>
						<td>
							<input type = "hidden" name = "nfile1" value = "${nvo.nfile1}">
							<input type = "hidden" name = "nsfile" value = "${nvo.nsfile1}">
							<input type = "hidden" name = "nfile2" value = "${nvo.nfile2}">
							<input type = "hidden" name = "nsfile2" value = "${nvo.nsfile2}">
							<input type="file" name="files" id = "files">
							<input type="file" name="files" id = "files">
							<c:choose>
								<c:when test = "${nvo.nfile1 != null}">
									<span id = "update_file1">${nvo.nfile1}</span>
								</c:when>
								<c:when test = "${nvo.nfile2 != null}">
									<span id = "update_file2">${nvo.nfile2}</span>
								</c:when>
								<c:otherwise>
									<span>선택된 파일 없음</span>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="button" id = "btnNoticeUpdate">수정완료</button>
							<button type="reset">다시쓰기</button>
							<a href="admin_notice_content.do?nid=${nvo.nid}">
								<button type="button">이전페이지</button></a>
							<a href="admin_notice_list.do">
								<button type="button">리스트</button></a>							
						</td>				
					</tr>
				</table>
			</form>
		</section>
	</div>
	
	<!-- footer -->
	<!-- <iframe src="http://localhost:9000/footer.jsp"
			scrolling="no" width="100%" height="500px" frameborder=0></iframe> -->	
	<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>


















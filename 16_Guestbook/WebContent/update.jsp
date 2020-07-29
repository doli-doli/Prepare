<%@page import="com.jh.mybatis.GuestbookDao"%>
<%@page import="com.jh.mybatis.GuestbookDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<%
	request.setCharacterEncoding("UTF-8");
	GuestbookDto dto = new GuestbookDto();
	dto.setIdx(Integer.parseInt(request.getParameter("idx")));
	dto.setWriter(request.getParameter("writer"));
	dto.setPw(request.getParameter("pw"));
	dto.setTitle(request.getParameter("title"));
	dto.setEmail(request.getParameter("email"));
	dto.setContent(request.getParameter("content"));	
	
	int result = GuestbookDao.updateByIdx(dto);
	pageContext.setAttribute("result", result);
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 수정</title>
</head>
<body>
	<c:choose>
		<c:when test="${result gt 0}">
			<script type="text/javascript">
				alert("방명록이 수정 되었습니다.");
				// location.href="view.jsp?idx=${dto.idx}";	 c:redirect 태그로도 처리가능함!
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("방명록 수정이 실패하였습니다.");
				history.back();
			</script>
		</c:otherwise>
	</c:choose>
	<c:redirect url="view.jsp">
		<c:param name="idx" value="${dto.idx }"></c:param>
	</c:redirect>
</body>
</html>
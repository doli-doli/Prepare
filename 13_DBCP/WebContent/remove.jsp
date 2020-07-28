<%@page import="com.jh.DB.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		GreenDao dao = GreenDao.getInstance();
		GreenDto dto = new GreenDto();
		
		int result = dao.getRemove(id,pw);
	%>
	
	<%if(result > 0){
		response.sendRedirect("view_all.jsp");
	 }else{%>
		<script type="text/javascript">
			alert("회원삭제가 실패했습니다");
			history.back();
		</script>
	<% }%>





</body>
</html>
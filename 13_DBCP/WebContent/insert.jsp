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
	%>

	<jsp:useBean id="dto" class="com.jh.DB.GreenDto" />
	<jsp:setProperty property="*" name="dto"/>
	
	<%
		GreenDao dao = GreenDao.getInstance();
		int result = dao.getInsert(dto);
	%>	
	
	<%if(result > 0){
		response.sendRedirect("view_all.jsp");
	 }else{%>
		<script type="text/javascript">
			alert("회원추가가 실패했습니다");
			history.back();
		</script>
	<% }%>
	
	
</body>
</html>
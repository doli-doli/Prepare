<%@page import="com.jh.ex.*"%>
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
		
		GreenDto dto = new GreenDto();
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		dto.setName(request.getParameter("name"));
		dto.setAge(Integer.parseInt(request.getParameter("age")));
		dto.setAddr(request.getParameter("addr"));
	
		GreenDao dao = GreenDao.getInstance();
		int result = dao.insert(dto);
		
		if(result > 0 ){
			out.println("<script>");
			out.println("alert('회원 추가 성공!')");
			out.println("location.href = 'view_all.jsp'");
			out.println("</script>");
		}
		else{
			out.println("<script>");
			out.println("alert('회원 추가 실패!')");
			out.println("history.go(-1)");
			out.println("</script>");
		}
	%>


</body>
</html>
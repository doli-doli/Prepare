<%@ page import="com.jh.DB.GreenDao" %>
<%@ page import="com.jh.DB.GreenDto" %>
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
     String name = request.getParameter("name");
     String age = request.getParameter("age");
     String addr = request.getParameter("addr");
     
    GreenDto dto = new GreenDto();
 	dto.setId(id);
 	dto.setPw(pw);
 	dto.setName(name);
 	dto.setAge(Integer.parseInt(age));
 	dto.setAddr(addr);
 	
 	int result = GreenDao.getInstance().getUpdate(dto);
 	
 	if ( result > 0 ) {
		response.sendRedirect("view_all.jsp");
	} else { %>
		<script type="text/javascript">
			alert("회원 수정이 실패했습니다. 다시 시도하세요.");
			history.back();
		</script>
 <% } %>
</body>
</html>
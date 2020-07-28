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
	<jsp:include page="index.jsp"/>
	<br/><hr/><br/>
	
	<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		
		GreenDao dao = GreenDao.getInstance();
		GreenDto dto = dao.getOneList(id);
		pageContext.setAttribute("dto", dto);
	
	
	%>
	
	
	<div>
		<h1>${param.id} 회원 목록</h1>
		<table>
			<thead>
				<tr>
					<th>순번</th>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>성명</th>
					<th>나이</th>
					<th>주소</th>
					<th>가입일</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${dto ne null}">
					<tr>
						<td>${dto.idx}</td>
						<td>${dto.id}</td>
						<td>${dto.pw}</td>
						<td>${dto.name}</td>
						<td>${dto.age}</td>
						<td>${dto.addr}</td>
						<td>${dto.reg_date}</td>
					</tr>
				</c:if>
				<c:if test="${dto eq null}">
					<tr>
						<td colspan="7">${param.id} 회원이 없습니다.</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>
	
	

</body>
</html>
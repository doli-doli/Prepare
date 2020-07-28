<%@page import="com.jh.DB.*"%>
<%@page import="java.util.List"%>
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
		GreenDao dao = GreenDao.getInstance();
		List<GreenDto> list = dao.getAllList();
	
		pageContext.setAttribute("list", list);
	%>
	
	<div>
		<h1>전체 녹색 회원 목록</h1>
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
				<c:if test="${not empty list}">
					<c:forEach var="dto" items="${list}">
						<tr>
							<td>${dto.idx}</td>
							<td>${dto.id}</td>
							<td>${dto.pw}</td>
							<td>${dto.name}</td>
							<td>${dto.age}</td>
							<td>${dto.addr}</td>
							<td>${dto.reg_date}</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty list}">
					<tr>
						<td colspan="7">녹색 회원이 없습니다.</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>
	
	
	
</body>
</html>
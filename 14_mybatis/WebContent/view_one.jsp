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
		String id = request.getParameter("id");
		
		GreenDao dao = GreenDao.getInstance();
		GreenDto dto = dao.selectById(id);
		
		pageContext.setAttribute("dto", dto);
	%>
	
	<jsp:include page="index.jsp"/>
	<br/><hr/><br/>
	<div>
		<h1>${param.id } 회원의 정보</h1>
			<table>
				<thead>
					<tr>
						<td>순번</td>
						<td>아이디</td>
						<td>성명</td>
						<td>비밀번호</td>
						<td>나이</td>
						<td>주소</td>
						<td>가입일</td>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${dto ne null }">
								<tr>
									<td>${dto.idx }</td>
									<td>${dto.id }</td>
									<td>${dto.name }</td>
									<td>${dto.pw }</td>
									<td>${dto.age }</td>
									<td>${dto.addr }</td>
									<td>${dto.reg_date }</td>
						</c:when>
						<c:otherwise>
						<tr><td colspan="7">${param.id} 회원 정보가 없습니다.<del></del></td></tr>
						</c:otherwise>
					</c:choose>
					
				</tbody>
			</table>
	</div>
	
	
</body>
</html>
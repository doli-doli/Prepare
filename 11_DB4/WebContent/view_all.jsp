<%@ page import="com.jh.DB.GreenDao" %>
<%@ page import="com.jh.DB.GreenDto" %>
<%@ page import="java.util.List" %>

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
		List<GreenDto> list = GreenDao.getInstance().getAllList();
	%>
	
	<div>
		<table>
			<thead>
				<tr>
					<td>순번</td>
					<td>아이디</td>
					<td>비밀번호</td>
					<td>성명</td>
					<td>나이</td>
					<td>주소</td>
					<td>가입일</td>
				</tr>
			</thead>
			<tbody>
				<%if(list.size() > 0){%>
						<%for(GreenDto dto : list){ %>
						<tr>
							<td><%=dto.getIdx() %></td>
							<td><%=dto.getId() %></td>
							<td><%=dto.getPw() %></td>
							<td><%=dto.getName() %></td>
							<td><%=dto.getAge() %></td>
							<td><%=dto.getAddr() %></td>
							<td><%=dto.getReg_date() %></td>
						</tr>
				<%} }else {%>
					
				
				<%}%>
			</tbody>
		</table>
	
	</div>


</body>
</html>
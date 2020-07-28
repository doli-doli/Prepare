<%@page import="jdk.nashorn.internal.runtime.regexp.JoniRegExp.Factory"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.jh.ex.*"%>
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

	<!-- sqlSession 생성 -->
	<%
		//SqlSessionFactory factory = DBService.getFactory();
		//SqlSession sqlSession = factory.openSession();
		
		/*
			openSession() select 문에서 사용 (노커밋)
			openSession(true) 자동 커밋
			openSession(false) 수동 커밋
			//일반적인 트랜잭션처리는 수동 커밋으로 처리한다.
		*/
	
	%>

	<!-- sqlSession을 통해서 mapper에 접근 -->
	
	<%
		//List<GreenDto> list = sqlSession.selectList("select_all");
		//pageContext.setAttribute("list",list);
		
		/*
			select문의 메소드
			1.selectList("sql문의 id") --검색 결과가 여러개 일때
			2.selectList("sql문의 id", 파라미터)
			3.selectOne("sql문의 id")  --검색 결과가 하나일때
			4.selectOne("sql문의 id", 파라미터)
		*/
	%>

	<!-- GreenDao를 통한 List<GreenDto> list 처리 -->
	
	<%
		GreenDao dao = GreenDao.getInstance();
		List<GreenDto> list = dao.selectAll();
		pageContext.setAttribute("list", list);
	%>

	<jsp:include page="index.jsp"/>
	<br/><hr/><br/>
	<div>
		<h1>녹색 회원 전체 명단</h1>
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
						<c:when test="${not empty list }">
							<c:forEach var="dto" items="${list}">
								<tr>
									<td>${dto.idx }</td>
									<td>${dto.id }</td>
									<td>${dto.name }</td>
									<td>${dto.pw }</td>
									<td>${dto.age }</td>
									<td>${dto.addr }</td>
									<td>${dto.reg_date }</td>
							</c:forEach>
						</c:when>
						<c:otherwise>
						<tr><td colspan="7">녹색 회원이 한명도 없습니다.<del></del></td></tr>
					</c:otherwise>
					</c:choose>
					
				</tbody>
			</table>
	</div>



</body>
</html>
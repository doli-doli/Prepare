<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.*" %>
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
		// WebContent 아래 upload 폴더의 실제 경로를 알아내기
		String realPath = request.getServletContext().getRealPath("/upload");
	
		// request 대신 MultipartRequest 클래스 사용하기
		MultipartRequest mr = new MultipartRequest(
				request,
				realPath,
				1024*1024*10,
				"UTF-8",
				//동일한 이름의 파일이 업로드 되면 어떤 방식으로 저장할지? 기본 값을 따른다.
				new DefaultFileRenamePolicy()
				);
	%>
	
	<% File file = mr.getFile("filename");	%>
	
	<div>
		<ul>
			<li>실제 저장 경로 : <%=realPath %></li>
			<li>업로더 : <%=mr.getParameter("uploader") %></li>
			<li>원본 파일 명 : <%=mr.getOriginalFileName("filename") %></li>
			<li>저장 파일 명 : <%=mr.getFilesystemName("filename") %></li>
			
			<%-- File 클래스를 통해 확인 --%>
			<li>파일 명 : <%=file.getName() %></li>
			<li>파일 크기 : <%=file.length() %>KB(킬로바이트)</li>
			<li>파일 수정 날짜 : <%=file.lastModified() %></li>
			<% SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 hh시 mm분"); %>
			<li>파일 수정 날짜 : <%=sdf.format(file.lastModified()) %></li>
		</ul>
	</div>

	<br/><br/>
	
	<a href="download.jsp?path=upload&filename=<%=mr.getFilesystemName("filename")%>">다운로드</a>
	
</body>
</html>
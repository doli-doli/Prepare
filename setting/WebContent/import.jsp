<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -JSTL사용
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.util.HashMap"%> - 페이징 begin-end
<%@page import="java.util.Map"%>	- 페이징 begin-end
<!-- 싹다! -->
<%@page import="mybatis.mapper.*"%>
<%@page import="java.net.*"%>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <% request.setCharacterEncoding("utf-8"); %>


<!-- 자바   -->
import org.apache.ibatis.session.SqlSession; 세션
import org.apache.ibatis.session.SqlSessionFactory; 팩토리
import java.util.List; 리스트
import java.sql.Date; 날짜
import java.util.Date; 날짜


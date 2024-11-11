<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
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
	DiskFileItemFactory dfif = new DiskFileItemFactory();
	dfif.setDefaultCharset("utf-8");
	dfif.setSizeThreshold(1024*1024);/* 1메가바이트 */
	dfif.setRepository(new File("c:/upload/tmp"));
	
%>
</body>
</html>
<%@ include file="../init.jsp" %>    
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Magazine</title>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/main.css"/>'>
</head>
<body>
	<div id="header"><tiles:insertAttribute name="header"/></div>
	<div id="body"><tiles:insertAttribute name="body"/></div>
	<div id="footer"><tiles:insertAttribute name="footer"/></div>
</body>
</html>
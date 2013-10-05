<%@ include file="../init.jsp" %>    
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Magazine</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/main.css"/>'>
	<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.10.2.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/jquery.validate.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/jquery.infieldlabel.js"/>'></script>
</head>
<body>
	<div id="header"><t:insertAttribute name="header"/></div>
	<div id="content"><t:insertAttribute name="content"/></div>
	<div id="footer"><t:insertAttribute name="footer"/></div>
</body>
</html>
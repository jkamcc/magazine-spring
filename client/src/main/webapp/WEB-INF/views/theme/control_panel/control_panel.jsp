<%@ include file="/WEB-INF/views/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Magazine - Control Panel</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- css -->
    <link href='<c:url value="/resources/css/main.css"/>' rel="stylesheet" media="screen">

    <!-- js -->
    <script type="text/javascript" src='<c:url value="/resources/js/jquery-1.10.2.js"/>'></script>
</head>
<body>
<div id="header"><t:insertAttribute name="header"/></div>
<%--control panel class: container-fluid, home page: container--%>
<div class="container-fluid">
    <div class="row-fluid">
        <div id="control-menu" class="span3">
            <t:insertAttribute name="menu"/>
        </div>
        <div id="content" class="span8" >
            <t:insertAttribute name="content"/>
        </div>
    </div>
    <footer>
        <t:insertAttribute name="footer"/>
    </footer>
    <script type="text/javascript" src='<c:url value="/resources/js/bootstrap.js"/>'></script>
</body>
</html>
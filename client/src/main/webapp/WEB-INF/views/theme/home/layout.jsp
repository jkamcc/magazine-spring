<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/init.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Magazine</title>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- css -->
    <%--<link href='<c:url value="/resources/css/bootstrap.css"/>' rel="stylesheet" media="screen">--%>
    <%--<link href='<c:url value="/resources/css/bootstrap-responsive.css"/>' rel="stylesheet" type="text/css" >--%>
    <link href='<c:url value="/resources/css/main.css"/>' rel="stylesheet" media="screen">

    <!-- js -->
    <script type="text/javascript" src='<c:url value="/resources/js/jquery-1.10.2.js"/>'></script>
    <%--<script type="text/javascript" src='<c:url value="/resources/js/angular.js"/>'></script>--%>
    <%--<script type="text/javascript" src='<c:url value="/resources/js/script.js"/>'></script>--%>
</head>
<body>
<div id="header"><t:insertAttribute name="header"/></div>
<div id="content"><t:insertAttribute name="content"/></div>
<footer>
    <t:insertAttribute name="footer"/>
</footer>
<script type="text/javascript" src='<c:url value="/resources/js/bootstrap.js"/>'></script>
</body>
</html>
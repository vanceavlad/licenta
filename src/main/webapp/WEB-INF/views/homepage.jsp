<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homepage</title>
    <spring:url value="/resources/css/homepage.css" var="homepage"/>
    <link href="${homepage}" rel="stylesheet">
    <link rel="stylesheet" href="../../resources/bootstrap/css/bootstrap.css">

</head>
<body>


<div id="container">
    <button id="register"><a href="${pageContext.request.contextPath}/register/registerForm">Register</a></button>
    <button id="login"><a href="${pageContext.request.contextPath}/login/loginForm">Login</a></button>
</div>

<script type="text/javascript" src="../../resources/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="../../resources/jQuery/jquery-3.3.1.js"></script>

</body>
</html>

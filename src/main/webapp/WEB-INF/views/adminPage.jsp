<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
    <link rel="stylesheet" href="../../resources/bootstrap/css/bootstrap.css">

</head>
<body>
<c:url var="addAllergyUrl" value="/allergies"/>
<div class="container">

    <div href="${addAllergyUrl}">
        <a href="${addAllergyUrl}"> Add Allergy</a>
    </div>


</div>


<script type="text/javascript" src="../../resources/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="../../resources/jQuery/jquery-3.3.1.js"></script>
</body>
</html>

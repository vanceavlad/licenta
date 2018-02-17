<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:url var="addAllergyUrl" value="/allergies"/>
<div class="container">

    <div href="${addAllergyUrl}">
        <a href="${addAllergyUrl}"> Add Allergy</a>
    </div>


</div>

</body>
</html>

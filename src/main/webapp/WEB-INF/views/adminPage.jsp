<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:url var="addAllergyUrl" value="/secret/admin/path/addAllergy"/>
<div class="container">

    <div href="${addAllergyUrl}">
        Add Allergy
    </div>

</div>

</body>
</html>

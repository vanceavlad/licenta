<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User profile</title>


    <link rel="stylesheet" href="../../resources/bootstrap/css/bootstrap.css">


</head>
<body>
<c:choose>
    <c:when test="${currentUser.role == 'USER'}">

<div class="container">

    <div class="row">
        <div class="col-sm-12">
            <h2 class="text-center">Your unique ID is: <strong>${currentUser.uniqKey}</strong></h2>
        </div>
    </div>

    <div class="row ">
        <div class="col-sm-4">
            <button  class="btn btn-danger" ><a href="${pageContext.request.contextPath}/user/addAllergies">Adauga alergii</a></button>
        </div>
        <div class="col-sm-4">
            <button><a href="${pageContext.request.contextPath}/user/files">My files</a></button>
        </div>
        <div class="col-sm-4">
            <button><a href="#">Adauga ceva</a></button>
        </div>

    </div>

</div>
    </c:when>
    <c:otherwise>
        <c:redirect url="/errors"/>
    </c:otherwise>
</c:choose>



<script type="text/javascript" src="../../resources/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="../../resources/jQuery/jquery-3.3.1.js"></script>
</body>
</html>

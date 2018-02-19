<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User profile</title>


    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">

</head>
<body>
<c:choose>
    <c:when test="${currentUser.role == 'USER'}">

<div class="container">

    <div class="row">
        <div class="col-sm-12">
            <h2 class="text-center">Your unique ID is: <strong>${currentUser.uniqKey}</strong><h2>
        </div>
    </div>

    <div class="row ">
        <div class="col-sm-4">
            <button  class="btn btn-danger" ><a href="/user/addAllergies">Adauga alergii</a></button>
        </div>
        <div class="col-sm-4">
            <button><a href="#">Adauga boli</a></button>
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

</body>
</html>

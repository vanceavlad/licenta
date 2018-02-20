<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Searched Patient/user</title>
    <link rel="stylesheet" href="../../resources/bootstrap/css/bootstrap.css">


</head>
<body>


<!-- Main Container -->
<div class="container" style="background-color: #f1f2ed;">

    <!-- Listing Name -->

    <div class="form-group required">
        <label for="name" class="control-label"> Name </label>
        <input type="text" path="name" class="form-control" id="name" value="${resultUser.name}"
               data-fv-notempty="true"
               data-fv-notempty-message="A name is required for users!"
               required="true" readonly="true"/>
    </div>

    <!-- Listing LastName -->
    <div class="form-group required">
        <label for="lastName" class="control-label"> Last name </label>
        <input type="text" path="lastName" class="form-control" id="lastName" value="${resultUser.lastName}"
               data-fv-notempty="true"
               data-fv-notempty-message="A last name is required for users!"
               required="true" readonly="true"/>
    </div>


    <!-- Listing Email -->
    <div class="form-group required">
        <label for="email" class="control-label"> Email </label>
        <input type="text" path="email" class="form-control" id="email" value="${resultUser.email}"
               data-fv-notempty="true"
               data-fv-notempty-message="An email is required for users!"
               required="true" readonly="true"/>
    </div>


    <!-- Listing allergies -->

    <h3>User allergies:</h3>

    <c:forEach var="allergyExisted" items="${existedAllergies}">
        <%--<input type="text" name="allergyIds"/>--%>
        <c:out value="${allergyExisted.name}"/>
        <br>
    </c:forEach>
    <br/>


    <div class="text-center">
        <button type="submit" class="btn btn-primary" style="text-align:center">
            Request access
        </button>
    </div>


    <!-- Simple div to let a little bit of space from the end of container -->
    <div style="height: 10px;"></div>
</div>


<script type="text/javascript" src="../../resources/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="../../resources/jQuery/jquery-3.3.1.js"></script>
</body>
</html>

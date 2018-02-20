<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="div" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>

    <title>Register a new user</title>


    <link rel="stylesheet" href="../../resources/bootstrap/css/bootstrap.css">

    <style>
        .form-group.required .control-label:after {
            content: "*";
            color: red;
        }

    </style>

</head>
<body>
<div style="text-align: center;">
    <h1>Fill all info</h1>
</div>


<div class="container" style="background-color: #f1f2ed;">
    <c:url var="createUserUrl" value="/register/create"/>
    <form:form id="addUser" action="${createUserUrl}" method="post" modelAttribute="userGenericDTO">

        <!-- Warning messages from the server ... -->


        <c:forEach items="${errors}" var="error">

            <div class="alert alert-warning">
                    <%-- do want you want with ${error} --%>
                <strong>Warning! </strong><c:out value="${error.defaultMessage}"/>

            </div>
        </c:forEach>


        <div class="form-group required">
            <label for="name" class="control-label"> Name </label>
            <form:input type="text" path="name" class="form-control" id="name"
                        placeholder="Enter user's name..."
                        data-fv-notempty="true"
                        data-fv-notempty-message="A name is required for user!"
                        required="true"
            />
        </div>

        <div class="form-group required">
            <label for="lastName" class="control-label"> Surname </label>
            <form:input type="text" path="lastName" class="form-control" id="lastName"
                        placeholder="Enter user's last name..."
                        data-fv-notempty="true"
                        data-fv-notempty-message="A last name is required for user!"
                        required="true"
            />
        </div>

        <div class="form-group required">
            <label for="password" class="control-label"> Password </label>
            <form:input type="password" path="password" class="form-control" id="password"
                        placeholder="Enter user's password..."
                        data-fv-notempty="true"
                        data-fv-notempty-message="A pass is required for user!"
                        required="true"
            />
        </div>


        <div class="form-group required">
            <label for="email" class="control-label"> Email </label>
            <form:input type="email" path="email" class="form-control" id="email"
                        placeholder="Enter user's email..."
                        data-fv-notempty="true"
                        data-fv-notempty-message="An email is required for user!"
                        required="true"
            />
        </div>

        <!-- Dropdown menu for Roles -->
        <div class="form-group required">
            <label class="control-label">Please select a role</label>
            <br>
            <form:select path="role">
                <form:option value="USER"> User </form:option>
                <form:option value="DOCTOR"> Doctor</form:option>
            </form:select>
        </div>


        <!-- Button for SUBMIT -->
        <div class="text-center">
            <button type="submit" class="btn btn-primary" style="text-align:center">
                Submit
            </button>
        </div>
    </form:form>
</div>

<script type="text/javascript" src="../../resources/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="../../resources/jQuery/jquery-3.3.1.js"></script>
</body>
</html>

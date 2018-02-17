<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="div" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Admin Login</title>


    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <style>
        .form-group.required .control-label:after {
            content: "*";
            color: red;
        }

    </style>
</head>
<body>


<!-- Main Container -->
<div class="container" style="background-color: #f1f2ed;">
    <c:url var="adminLoginUrl" value="/secret/admin/path/admin/login"/>
    <form:form id="loginAdminForm" action="${adminLoginUrl}" method="post" modelAttribute="admin">

        <!-- Warning messages from the server ... -->
        <c:forEach items="${errors}" var="error">

            <div class="alert alert-warning">
                    <%-- do want you want with ${error} --%>
                <strong>Warning! </strong><c:out value="${error.defaultMessage}"/>

            </div>
        </c:forEach>


        <!-- Form for EMAIL -->
        <div class="form-group required">
            <label for="email" class="control-label"> Email </label>
            <form:input type="email" path="email" class="form-control" id="email" placeholder="Enter your email..."
                        data-fv-notempty="true"
                        data-fv-notempty-message="An email is required for login!"
                        required="true"/>
        </div>


        <!-- Form for PASSWORD -->
        <div class="form-group">
            <label for="password" class="control-label"> Code </label>
            <form:input path="password" type="password" class="form-control" id="password"
                        placeholder="Enter your password..."
                        data-fv-notempty="true"
                        data-fv-notempty-message="A password is required for login!"
                        required="true"/>
        </div>


        <!-- Button for SUBMIT -->
        <div class="text-center">
            <button type="submit" class="btn btn-primary" style="text-align:center">
                Login
            </button>
        </div>
    </form:form>

    <!-- Simple div to let a little bit of space from the end of container -->
    <div style="
    height: 10px;"></div>

    <div class="text-center">
        <button class="btn btn-danger" ><a href="${pageContext.request.contextPath}/register/registerForm">Register</a></button>
    </div>
</div>
</body>
</html>

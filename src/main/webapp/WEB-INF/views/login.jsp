<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Vlad Vancea
  Date: 2/15/2018
  Time: 9:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>


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
    <c:url var="loginUrl" value="/login/doLogin"/>
    <form:form id="loginForm" modelAttribute="user" action="${loginUrl}" enctype="multipart/form-data" method="post">

        <!-- Warning messages from the server  ... -->
        <c:forEach items="${errors}" var="error">

            <div class="alert alert-warning">
                    <%-- do want you want with ${error} --%>
                <strong>Warning! </strong><c:out value="${error.defaultMessage}"/>

            </div>
        </c:forEach>


        <!-- Form for EMAIL -->
        <div class="form-group required">
            <label for="email" class="control-label"> Name </label>
            <form:input type="text" path="email" class="form-control" id="email" placeholder="Enter your email..."
                        data-fv-notempty="true"
                        data-fv-notempty-message="An email is required for login!"
                        required="true"/>
        </div>


        <!-- Form for CODE -->
        <div class="form-group">
            <label for="password" class="control-label"> Code </label>
            <form:input path="password" type="text" class="form-control" id="password"  placeholder="Enter your password..."
                        data-fv-notempty="true"
                        data-fv-notempty-message="A password is required for login!"
                        required="true"/>
        </div>


        <!-- Checkbox for NEW/OLD -->
        <div class="form-check">
            <label class="form-check-label">
                <c:if test="${userType == 'DOCTOR'}">
                    You will login as ${userType}
                    <form:radiobutton checked="checked" path="role" id="language" value="DOCTOR" name="radios"/>


                    You want to login as USER?
                    <form:radiobutton path="role" id="language" value="USER" name="radios"/>


                </c:if>
                <br>
                <c:if test="${userType == 'USER'}">
                    You will login as ${userType}
                    <form:radiobutton path="role" checked="checked" id="language" value="USER" name="radios"/>


                    You want to login as DOCTOR?
                    <form:radiobutton path="role" id="language" value="DOCTOR" name="radios"/>

                </c:if>
                <br>
                <c:if test="${userType != 'USER' && userType != 'DOCTOR'}">
                    How you want to login?
                    <form:radiobutton path="role" id="language" value="DOCTOR" name="radios"/>
                    <form:radiobutton path="role" id="language" value="USER" name="radios"/>

                </c:if>
            </label>
        </div>


        <!-- Button for SUBMIT -->
        <div class="text-center">
            <button type="submit" class="btn btn-primary" style="text-align:center">
                Submit
            </button>
        </div>
    </form:form>

    <!-- Simple div to let a little bit of space from the end of container -->
    <div style="height: 10px;"></div>
</div>


</body>
</html>

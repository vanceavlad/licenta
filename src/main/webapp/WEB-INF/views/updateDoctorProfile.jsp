<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update profile</title>
    <link rel="stylesheet" href="../../resources/bootstrap/css/bootstrap.css">

</head>
<body>
<!-- Main Container -->
<div class="container" style="background-color: #f1f2ed;">
    <c:url var="updateProfileUrl" value="/doctor/updateDoctorProfile"/>
    <form:form id="editForm" modelAttribute="doctor" action="${updateProfileUrl}" method="post">

        <%--<!-- Warning messages from the server ... -->--%>
        <%--<c:forEach items="${errors}" var="error">--%>

            <%--<div class="alert alert-warning">--%>
                    <%--&lt;%&ndash; do want you want with ${error} &ndash;%&gt;--%>
                <%--<strong>Warning! </strong><c:out value="${error.defaultMessage}"/>--%>

            <%--</div>--%>
        <%--</c:forEach>--%>


        <!-- Form for NAME -->
        <div class="form-group required">
            <label for="name" class="control-label"> Name </label>
            <form:input type="text" path="name" class="form-control" id="name"
                        data-fv-notempty="true"
                        data-fv-notempty-message="A name is required for users!"
                        required="true" />
        </div>

        <!-- Form for LastName -->
        <div class="form-group required">
            <label for="lastName" class="control-label"> Last name </label>
            <form:input type="text" path="lastName" class="form-control" id="lastName"
                        data-fv-notempty="true"
                        data-fv-notempty-message="A last name is required for users!"
                        required="true" />
        </div>


        <!-- Form for Email -->
        <div class="form-group required">
            <label for="email" class="control-label"> Email </label>
            <form:input type="text" path="email" class="form-control" id="email"
                        data-fv-notempty="true"
                        data-fv-notempty-message="An email is required for users!"
                        required="true" />
        </div>


        <!-- Form for City -->
        <div class="form-group required">
            <label for="city" class="control-label"> City </label>
            <form:input type="text" path="addressDTO.city" class="form-control" id="city"
                        data-fv-notempty="true"
                        data-fv-notempty-message="A city is required for doctor!"
                        required="true"/>
        </div>

        <!-- Form for Street -->
        <div class="form-group required">
            <label for="street" class="control-label"> Street </label>
            <form:input type="text" path="addressDTO.street" class="form-control" id="street"
                        data-fv-notempty="true"
                        data-fv-notempty-message="A street is required for doctor!"
                        required="true" />
        </div>

        <!-- Form for Number -->
        <div class="form-group required">
            <label for="number" class="control-label"> Str Number </label>
            <form:input type="text" path="addressDTO.number" class="form-control" id="number"
                        data-fv-notempty="true"
                        data-fv-notempty-message="A number is required for doctor!"
                        required="true" />
        </div>

        <!-- Form for Tel -->
        <div class="form-group required">
            <label for="phone" class="control-label"> Telephone </label>
            <form:input type="text" path="addressDTO.phone" class="form-control" id="phone"
                        data-fv-notempty="true"
                        data-fv-notempty-message="A phone is required for doctor!"
                        required="true"/>
        </div>


        <!-- Form for ZipCode -->
        <div class="form-group required">
            <label for="zipCode" class="control-label"> Zip code </label>
            <form:input type="text" path="addressDTO.zipCode" class="form-control" id="zipCode"
                        data-fv-notempty="true"
                        data-fv-notempty-message="A zip code is required for doctor!"
                        required="true" />
        </div>


        <div class="form-group required">
             <label for="zones" class="control-label"> Zone </label>
             <form:radiobuttons path="addressDTO.zone" items="${zones}" id="zones" />
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

<script type="text/javascript" src="../../resources/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="../../resources/jQuery/jquery-3.3.1.js"></script>
</body>
</html>

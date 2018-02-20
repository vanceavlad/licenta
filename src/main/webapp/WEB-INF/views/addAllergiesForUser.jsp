<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new allergies</title>
    <link rel="stylesheet" href="../../resources/bootstrap/css/bootstrap.css">


</head>
<body>
<c:choose>
    <c:when test="${currentUser.role == 'USER'}">

        <!-- Main Container -->
        <div class="container" style="background-color: #f1f2ed;">
            <c:url var="ddUrl" value="/user/addAllergies"/>
            <form:form id="editForm" modelAttribute="user" action="${addUrl}" method="post">

                <!-- Warning messages from the server ... -->
                <c:forEach items="${errors}" var="error">

                    <div class="alert alert-warning">
                            <%-- do want you want with ${error} --%>
                        <strong>Warning! </strong><c:out value="${error.defaultMessage}"/>

                    </div>
                </c:forEach>


                <!-- Form for NAME -->
                <div class="form-group required">
                    <label for="name" class="control-label"> Name </label>
                    <form:input type="text" path="name" class="form-control" id="name"
                                data-fv-notempty="true"
                                data-fv-notempty-message="A name is required for users!"
                                required="true" readonly="true"/>
                </div>

                <!-- Form for LastName -->
                <div class="form-group required">
                    <label for="lastName" class="control-label"> Last name </label>
                    <form:input type="text" path="lastName" class="form-control" id="lastName"
                                data-fv-notempty="true"
                                data-fv-notempty-message="A last name is required for users!"
                                required="true" readonly="true"/>
                </div>


                <!-- Form for Email -->
                <div class="form-group required">
                    <label for="email" class="control-label"> Email </label>
                    <form:input type="text" path="email" class="form-control" id="email"
                                data-fv-notempty="true"
                                data-fv-notempty-message="An email is required for users!"
                                required="true" readonly="true"/>
                </div>


                <%--Form for allergies--%>


                <h3>Allergies for user:</h3>

                <c:forEach var="allergyExisted" items="${existedAllergies}">
                    <input type="checkbox" name="allergyIds" value="${allergyExisted.id}" checked="checked"/>
                    <c:out value="${allergyExisted.name}"/>
                    <br>
                </c:forEach>
                <br/>


                <h3> Add other allergies</h3>

                <c:forEach var="allergyForSelect" items="${allergiesForSelect}">
                    <input type="checkbox" name="allergyIds" value="${allergyForSelect.id}"/>
                    <c:out value="${allergyForSelect.name}"/>
                    <br>
                </c:forEach>
                <br/>


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

    </c:when>
    <c:otherwise>
        <c:redirect url="/errors"/>
    </c:otherwise>
</c:choose>


<script type="text/javascript" src="../../resources/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="../../resources/jQuery/jquery-3.3.1.js"></script>
</body>
</html>

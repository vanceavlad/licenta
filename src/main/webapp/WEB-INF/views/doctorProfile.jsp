<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Doctor HomePage</title>

    <link rel="stylesheet" href="../../resources/bootstrap/css/bootstrap.css">

</head>
<body>

<c:choose>
    <c:when test="${currentDoctor.role == 'DOCTOR'}">
        <c:url var="searchUserURL" value="/doctor/searchUser"/>
        <c:url var="updateProfile" value="/doctor/updateDoctorProfile"/>

        <div class="container">


            <div class="row">
                <div class="col-sm-3">
                    <button class="btn btn-danger"><a href="#">My patient</a></button>
                </div>
                <div class="col-sm-3">
                    <button><a href="#">Vezi programari</a></button>
                </div>
                <div class="col-sm-3">
                    <button><a href="#">Adauga programare</a></button>
                </div>


                <div class="col-sm-3">
                    <button><a href="/doctor/updateDoctorProfile/${currentDoctor.uniqKey}">Edit Profile</a></button>
                </div>

            </div>


            <div class="row">

                <div class="col-sm-3 mt-2">
                    <h2>Search for an user:</h2>
                </div>

                <div class="col-sm-3 mt-4">
                    <!-- Warning messages from the server ... -->
                    <c:forEach items="${errors}" var="error">

                        <div class="alert alert-warning">
                                <%-- do want you want with ${error} --%>
                            <strong>Warning! </strong><c:out value="${error.defaultMessage}"/>

                        </div>
                    </c:forEach>


                    <form:form id="loginForm" action="${searchUserURL}" method="post" modelAttribute="searchedUser">
                        <!-- Form for Unique key -->
                        <div class="form-group required">
                            <label for="uniqKey" class="control-label"> Email </label>
                            <form:input type="text" path="uniqKey" class="form-control" id="uniqKey"
                                        placeholder="Enter his key..."
                                        data-fv-notempty="true"
                                        data-fv-notempty-message="An email is required for login!"
                                        required="true"/>
                        </div>

                        <!-- Button for SUBMIT -->
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary" style="text-align:center">
                                Search User
                            </button>
                        </div>
                    </form:form>

                </div>
            </div>

            <div class="row">

                <div class="col-sm-6 mt-4">
                    <h3>Your requests: </h3>

                    <table border="2">
                        <c:forEach var="doctorRequest" items="${doctorRequests}">
                            <%--<input type="text" name="allergyIds"/>--%>
                            <tr>
                                <td><c:out value="${doctorRequest.user}"/></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <br/>
                </div>

                <div class="col-sm-6 mt-4">
                    <h3>Your patients: </h3><br>

                    <table border="4px">

                        <c:forEach var="user" items="${currentDoctor.users}">
                            <tr class="${user.email}">
                                    <%--<input type="text" name="allergyIds"/>--%>
                                <td>Name:<c:out value="${user.name}"/></td>
                                <td>Last name: <c:out value="${user.lastName}"/></td>
                                <td>Email: <c:out value="${user.email}"/></td>
                                <td style="text-align: center"><a href=<c:url
                                        value="/doctor/viewUserByDoctor/${user.uniqKeyGenerated}"/>>
                                    <button class="viewButton" name="${user.name}">View</button>
                                </a></td>

                            </tr>
                        </c:forEach>
                    </table>
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

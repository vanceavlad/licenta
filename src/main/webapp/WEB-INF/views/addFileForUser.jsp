<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="div" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>

    <title>Register a new doctor</title>


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
    <c:url var="createFileUser" value="/files/addFileForUserPost"/>
    <form:form id="addFile" action="${createFileUser}" method="post" modelAttribute="file">

        <!-- Warning messages from the server ... -->


        <c:forEach items="${errors}" var="error">

            <div class="alert alert-warning">
                    <%-- do want you want with ${error} --%>
                <strong>Warning! </strong><c:out value="${error.defaultMessage}"/>

            </div>
        </c:forEach>


        <div class="form-group required">
            <label for="userEmail" class="control-label"> User which file it is </label>
            <form:input type="email" path="userEmail" class="form-control" id="userEmail"
                        placeholder="Enter user's email..."
                        data-fv-notempty="true"
                        data-fv-notempty-message="An email is required for user!"
                        required="true" readonly="true"
            />
        </div>


        <div class="form-group required">
            <label for="description" class="control-label"> Description </label>
            <form:textarea type="text" path="description" class="form-control" id="description" rows="3" cols="4"
                           placeholder="Enter description's name..."
                           data-fv-notempty="true"
                           data-fv-notempty-message="A description is required for file!"
                           required="true"
            />
        </div>

        <div class="form-group required">
            <label for="problems" class="control-label"> Problems </label>
            <form:textarea path="problems" class="form-control" id="problems" rows="3" cols="4"
                           placeholder="Enter problems's..."
                           data-fv-notempty="true"
                           data-fv-notempty-message="A problems required for file!"
                           required="true"
            />
        </div>

        <div class="form-group required">
            <label for="utilities" class="control-label"> Utilities </label>
            <form:input type="text" path="utilities" class="form-control" id="utilities"
                        placeholder="Enter utilities..."
                        data-fv-notempty="true"
                        data-fv-notempty-message="Utilities is required for user!"
                        required="true"
            />
        </div>


        <p>Date: <form:input type="text" path="date" id="datepicker"/></p>



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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>

<script>
    $(function() {
        $("#datepicker").datepicker();
    });
</script>


</body>
</html>

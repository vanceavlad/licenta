<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title> View a file </title>
    <link rel="stylesheet" href="../../resources/bootstrap/css/bootstrap.css">

</head>
<body>
<div style="text-align: center;">
    <h1>Info about file</h1>
</div>
<!-- Main Container -->
<div class="container" style="background-color: #f1f2ed;">
    <%--<c:url var="editUrl" value="/products/edit"/>--%>
    <%--<form:form id="editForm" modelAttribute="product" action="${editUrl}" enctype="multipart/form-data" method="post">--%>



        <!-- Form for CODE -->
        <div class="form-group">
            <label for="code" class="control-label"> Code </label>
            <input path="code" type="text" class="form-control" id="code" value="${file.fileCode}"
                        data-fv-notempty="true"
                        data-fv-notempty-message="A code is required for products!"
                        required="true" readonly="true"/>
        </div>

        <!-- Form for Problems -->
        <div class="form-group">
            <label for="userEmail" class="control-label"> User email </label>
            <input type="text" readonly class="form-control" id="userEmail" value="${file.userEmail}"/>
        </div>

        <!-- Form for Problems -->
        <div class="form-group ">
            <label for="doctorEmail" class="control-label"> Doctor Email </label>
            <input type="text" readonly class="form-control" id="doctorEmail" value="${file.doctorEmail}"/>
        </div>


        <!-- Form for Description -->
        <div class="form-group required">
            <label for="description" class="control-label"> Description </label>
            <textarea readonly class="form-control" id="description">
                ${file.description}
            </textarea>
        </div>

        <!-- Form for Problems -->
        <div class="form-group required">
            <label for="problems" class="control-label"> Description </label>
            <textarea readonly class="form-control" id="problems">
                ${file.problems}
            </textarea>
        </div>


        <!-- Form for Problems -->
        <div class="form-group required">
            <label for="utilities" class="control-label"> Utilities </label>
            <input type="text" readonly class="form-control" id="utilities" value="${file.utilities}"/>
        </div>

        <!-- Form for Problems -->
        <div class="form-group required">
            <label for="date" class="control-label"> Date </label>
            <input type="text" readonly class="form-control" id="date" value="${file.date}"/>
        </div>


        <!-- Button for SUBMIT -->
        <div class="text-center">
            <%--<button type="submit" class="btn btn-primary" style="text-align:center">--%>
                <a href="${pageContext.request.contextPath}/user/files">See all files</a>
            <%--</button>--%>
        </div>

    <!-- Simple div to let a little bit of space from the end of container -->
    <div style="height: 10px;"></div>
</div>
</body>
</html>
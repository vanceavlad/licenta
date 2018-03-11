<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
    <title>View products</title>
    <link rel="stylesheet" href="../../resources/bootstrap/css/bootstrap.css">


</head>

<body>

<div class="container" style="text-align: right">

    <h1><a href="/doctor/myProfile">Doctor profile</a></h1>
    <br>
    <h1>
        <div style="text-align: center">View files</div>
        <br></h1>

    <%--<a href="${pageContext.request.contextPath}/products/add">--%>
    <%--<button class="btn btn-success">Add</button>--%>
    <%--</a>--%>
    <%--<button type="button" class="btn btn-danger deleteBatch">Delete Batch</button>--%>
    <%--<button type="button" class="btn btn-info downloadCMV">Download CSV file</button>--%>
    <br>
    <br>
    <table id="filesTable" class="table table-striped table-bordered">
        <tr>
            <th style="text-align: center">Code</th>
            <th style="text-align: center">Date</th>
            <th style="text-align: center">Doctor</th>
            <th colspan="2" style="text-align: center">Actions</th>
        </tr>
        <c:forEach items="${files}" var="file">
            <tr name="${file.date}">

                <td style="text-align: center">${file.fileCode}</td>
                <td style="text-align: center">${file.date}</td>
                <td style="text-align: center">${file.doctorEmail}</td>
                    <%--<td style="text-align: center">--%>
                    <%--<c:url var="deleteUrl" value="/products/code/delete/${product.code}"/>--%>
                    <%--<button name="${product.code}">--%>
                    <%--<a href="${deleteUrl}">--%>
                    <%--Delete--%>
                    <%--</a>--%>
                    <%--</button>--%>
                    <%--</td>--%>
                <td style="text-align: center"><a href=<c:url value="/files/viewFileFromDoctorView/${file.fileCode}"/>>
                    <button class="editButton" name="${file.fileCode}">View</button>
                </a></td>
            </tr>
        </c:forEach>
    </table>
</div>

<!-- Javascript for Bootstrap -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Javascript for Bootstrap -->
<spring:url value="/resources/js/bootstrap.min.js" var="mainJs"/>
<script href="${mainJs}" rel="javascript"></script>
</body>
</html>



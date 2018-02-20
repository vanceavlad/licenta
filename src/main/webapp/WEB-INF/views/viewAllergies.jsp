<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Allergies</title>

    <link rel="stylesheet" href="../../resources/bootstrap/css/bootstrap.css">

</head>
<body>
<div class="container" style="text-align: center">
    <div class="row ">
        <div class="col text-center"><h1>View allergies</h1></div>
    </div>
    <div class="col-12" style="text-align: right">
        <a href="/allergies/addAllergy"> <button class="btn btn-success">Add</button> </a>
    </div>
    <table id="allergyTable" class="table table-striped table-bordered">
        <tr>
            <th style="text-align: center"></th>
            <th style="text-align: center">Name</th>
            <th style="text-align: center">Action</th>
        </tr>
        <c:forEach items="${allergies}" var="allergy">
            <tr id="${allergy.id}">
                <td style="text-align: center"></td>
                <td style="text-align: center">${allergy.name}</td>
                <td style="text-align: center"><a href=<c:url value="/allergies/editAllergy/${allergy.id}"/>>
                    <button class="editButton" name="${allergy.id}">Edit</button>
                </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<script type="text/javascript" src="../../resources/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="../../resources/jQuery/jquery-3.3.1.js"></script>
</body>
</html>

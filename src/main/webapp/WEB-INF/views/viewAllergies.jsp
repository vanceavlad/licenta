<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Allergies</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
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

</body>
</html>

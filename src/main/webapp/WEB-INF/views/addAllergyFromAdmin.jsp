<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add a new allergy</title>

    <link rel="stylesheet" href="../../resources/bootstrap/css/bootstrap.css">

</head>
<body>
<div style="text-align: center;">
    <h1>Add a new category</h1>
</div>
<div class="container" style="background-color: #f1f2ed;">
    <c:url var="addUrl" value = "/allergies/addAllergy"/>
    <form action="${addUrl}" method="post">
        <!-- Form for NAME -->
        <div class="form-group required">
            <label for="name" class="control-label"> Name </label>
            <input type="text" name="name" class="form-control" id="name" placeholder="Enter allergy's name..."  required>

        </div>

        <!-- Button for SUBMIT -->
        <div class="text-center">
            <button type="submit" class="btn btn-primary" style="text-align:center">
                Submit
            </button>
        </div>
    </form>

    <!-- Simple div to let a little bit of space from the end of container -->
    <div style="height: 10px;"></div>
</div>

<script type="text/javascript" src="../../resources/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="../../resources/jQuery/jquery-3.3.1.js"></script>
</body>
</html>

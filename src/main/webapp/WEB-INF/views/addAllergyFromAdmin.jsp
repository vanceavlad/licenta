<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add a new allergy</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
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
</body>
</html>

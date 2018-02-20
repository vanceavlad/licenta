<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Edit Allergy</title>

    <link rel="stylesheet" href="../../resources/bootstrap/css/bootstrap.css">

</head>
<body>

<div style="height: 100px;"></div>
<div style="text-align: center;">
    <h1>Edit a allergy</h1>
</div>

<div class="container" style="background-color: #f1f2ed;">
    <c:url var="editUrl" value ="/allergies/editAllergy/"/>
    <form  action="${editUrl}" method="post" >

        <!-- Form for ID and OLD NAME -->
        <div class="form-group">
            <input  type="text" class="form-control" id="oldAllergy" name="oldAllergy" value="${ oldAllergy.id}"
                    data-fv-notempty="true"
                    data-fv-notempty-message=""
                    required readonly
                    style="visibility: hidden">
        </div>

        <!-- Form for NEW  NAME -->
        <div class="form-group">
            <label for="newAllergy" class="control-label"> Name </label>
            <input type="text" class="form-control" id="newAllergy" name="newAllergy" value="${ newAllergy }"
                   data-fv-notempty="true"
                   data-fv-notempty-message="A name is required for categories!"
                   required>
        </div>

        <!-- Button for SUBMIT -->
        <div class="text-center">
            <button type="submit" class="btn btn-primary" style="text-align:center">
                Submit
            </button>
        </div>
    </form>
    <a href="/categories">
        <button>Cancel</button>
    </a>
    <!-- Simple div to let a little bit of space from the end of container -->
    <div style="height: 10px;"></div>
</div>

<script type="text/javascript" src="../../resources/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="../../resources/jQuery/jquery-3.3.1.js"></script>
</body>
</html>

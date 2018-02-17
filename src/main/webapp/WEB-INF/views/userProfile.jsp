<%--
  Created by IntelliJ IDEA.
  User: Vlad Vancea
  Date: 2/16/2018
  Time: 10:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User profile</title>


    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">

</head>
<body>


<div class="container">

    <div class="row">
        <div class="col-sm-12">
            <p class="text-center">Your unique ID is: <strong>${currentUser.uniqKey}</strong><p>
        </div>
    </div>

    <div class="row ">
        <div class="col-sm-4">
            <button><a href="#">Adauga alergii</a></button>
        </div>
        <div class="col-sm-4">
            <button><a href="#">Adauga boli</a></button>
        </div>
        <div class="col-sm-4">
            <button><a href="#">Adauga ceva</a></button>
        </div>

    </div>

</div>

</body>
</html>

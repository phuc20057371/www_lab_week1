<%--
  Created by IntelliJ IDEA.
  User: catly
  Date: 09/19/2023
  Time: 9:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
    <div class="container">
        <h1 class="text-center">Register form</h1>
        <hr>
        <div class="col-9">
            <form method="post" action="account">
                <div class="form-group">
                    <label for="Email1">Email address</label>
                    <input type="email" class="form-control" id="Email1" name="email" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label for="Password1">Password</label>
                    <input type="password" class="form-control" id="Password1" name="pwd" placeholder="Password">
                </div>
                <div class="form-group">
                    <label for="fullname1">Password</label>
                    <input type="text" class="form-control" id="fullname1" name="fullname" placeholder="Full name">
                </div>
                <div class="form-group">
                    <label for="phone">Password</label>
                    <input type="text" class="form-control" id="phone" name="phone" placeholder="Phone number">
                </div>
                <button type="submit" class="btn btn-primary">Create</button>
            </form>
        </div>
    </div>



</body>
</html>

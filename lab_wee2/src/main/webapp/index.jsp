<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<h2>Today is <%= new java.util.Date() %></h2>
<form method="post" action="login">
    <input type="text" name="id" placeholder="Username"/><br/><br/>
    <input type="password" name="pwd" placeholder="Password"/><br/><br/>
    <input type="submit" value="Login"/>
</form>
</body>
</html>
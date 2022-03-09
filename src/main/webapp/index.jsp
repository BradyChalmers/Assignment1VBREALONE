<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<div id="login" align="center">
<form action="IndexServlet" method="POST">
    <h1>Login
    </h1>
    <h4>UserName: </h4>
    <input type="text" name="txtUsername"/>
    <br/>
    <h4>Password: </h4>
    <input type="text" name="txtPassword"/>
    <br/>
    <input type="submit" placeholder="submit"/>
</form>
</div>
<br/>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: timbe
  Date: 2022-03-07
  Time: 10:58 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>YOU LOGGED IN</h1>
<a href="<%=request.getContextPath()%>/AgeServlet">Age Lists</a>
<form action="IndividualGeographicServlet" method="GET">
    <h4>Type in a country name</h4>
    <input type="text" name="txtCountryName"/>
    <input type="submit" name="submit"/>
</form>
<form action="GeographicServlet" method="GET">
    <h4>Choose category type</h4>
    <select name="cmbCategory">
        <option value="0">Category 1</option>
        <option value="1">Category 2</option>
        <option value="2">Category 3</option>
        <option value="3">Category 4</option>
    </select>
    <input type="submit" name="submit"/>
</form>
</body>
</html>

<%@ page import="com.example.assignment1vb.GeographicArea" %><%--
  Created by IntelliJ IDEA.
  User: Vaiden
  Date: 2022-03-08
  Time: 9:49 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Individual Geographic Area</h1>
<table>
    <tr>
        <th><b>Name</b></th>
        <th><b>Code</b></th>
        <th><b>Level</b></th>
        <th><b>Total Population</b></th>
    </tr>
    <%-- Fetching the attributes of the request object
         which was previously set by the servlet
          "StudentServlet.java"
    --%>
    <%GeographicArea ga =
            (GeographicArea)request.getAttribute("GeoArea");%>
    <%-- Arranging data in tabular form
    --%>
    <tr>
        <td><%=ga.getName()%></td>
        <td><%=ga.getCode()%></td>
        <td><%=ga.getLevel()%></td>
        <td><%=ga.getPopulation()%></td>
    </tr>
</table>
</body>
</html>

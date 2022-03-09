<%@ page import="java.util.List" %>
<%@ page import="com.example.assignment1vb.AgeGroup" %><%--
  Created by IntelliJ IDEA.
  User: timbe
  Date: 2022-03-08
  Time: 11:24 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>2011</h1>
<table>
    <tr>
        <th><b>Census Year</b></th>
        <th><b>Description</b></th>
        <th><b>Male Population</b></th>
        <th><b>Female Population</b></th>
    </tr>
    <%-- Fetching the attributes of the request object
         which was previously set by the servlet
          "StudentServlet.java"
    --%>
    <%List<AgeGroup> ag =
            (List<AgeGroup>)request.getAttribute("age2011");
        for(AgeGroup a:ag){%>
    <%-- Arranging data in tabular form
    --%>
    <tr>
        <td><%=a.getCensusYear()%></td>
        <td><%=a.getDescription()%></td>
        <td><%=a.getMale()%></td>
        <td><%=a.getFemale()%></td>
    </tr>
    <%}%>
</table>
<h1>2016</h1>
<table>
    <tr>
        <th><b>Census Year</b></th>
        <th><b>Description</b></th>
        <th><b>Male Population</b></th>
        <th><b>Female Population</b></th>
    </tr>
    <%-- Fetching the attributes of the request object
         which was previously set by the servlet
          "StudentServlet.java"
    --%>
    <%List<AgeGroup> ag2 =
            (List<AgeGroup>)request.getAttribute("age2016");
        for(AgeGroup a:ag2){%>
    <%-- Arranging data in tabular form
    --%>
    <tr>
        <td><%=a.getCensusYear()%></td>
        <td><%=a.getDescription()%></td>
        <td><%=a.getMale()%></td>
        <td><%=a.getFemale()%></td>
    </tr>
    <%}%>
</table>
<form action="AgeServlet" method="POST">
    <input type="submit" name="GoBack" value="Go Back"/>
</form>
</body>
</html>

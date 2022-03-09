<%@ page import="com.example.assignment1vb.GeographicArea" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Geographic Area Classification</title>
</head>
<body>
<header>
  <h1>Geographic Area Classification List</h1>
</header>
<table>
  <tr>
    <th><b>Area Name</b></th>
  </tr>
  <%List<String> ga = (List<String>)request.getAttribute("category");
    for(String g:ga){%>
  <tr>
    <td><%=g%></td>
  </tr>
  <%}%>
</table>
</body>
</html>
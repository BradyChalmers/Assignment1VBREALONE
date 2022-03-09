<%--
  Created by IntelliJ IDEA.
  User: Vaiden
  Date: 2022-03-08
  Time: 9:42 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Geographic Area Classification</title>
</head>
<body>
<header>
    <h1>Geographic Area Classification List</h1>
</header>
<div id="tableDiv" align="center">
    <jsp:useBean id="gACL" class="com.example.assignment1vb.GeographicServlet"></jsp:useBean>
    <div id="category0">
        <table>
            <tr>
                <th>Category 0</th>
                <jsp:getProperty name="gACL" property="cat0"/>
            </tr>
        </table>
    </div>
    <div id="category1">
        <table>
            <tr>
                <th>Category 1</th>
                <jsp:getProperty name="gACL" property="cat1"/>
            </tr>
        </table>
    </div>
    <div id="category2">
        <table>
            <tr>
                <th>Category 2</th>
                <jsp:getProperty name="gACL" property="cat2"/>
            </tr>
        </table>
    </div>
</div>

</body>
</html>
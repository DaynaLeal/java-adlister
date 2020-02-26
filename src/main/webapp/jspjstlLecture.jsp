<%--
  Created by IntelliJ IDEA.
  User: dayna
  Date: 2/26/20
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! int counter = 0; %>
<% counter++; %>
<html>
<head>
    <title>JSP Curriculum</title>
</head>
<body>

<% if (request.getParameter("reset") != null) {counter = Integer.parseInt(request.getParameter("reset"));} %>
<%--${param.reset}--%>

<h1>The current count is <%= counter %></h1>

View the page source!

<!-- this is an HTML comment, you *will* see this in the html -->

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: dayna
  Date: 2/26/20
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login JSP</title>
</head>
<body>
    <h1>Please Login</h1>

    <form action="/login.jsp" method="POST" >
        Username: <input type="text" name="username" id="username" placeholder="enter your username"/><br/>
        Password: <input type="password" name="password" id="password" placeholder="enter your password"/><br/>
        <input type="submit" value="login"/>
    </form>

    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username != null && username.equals("admin") &&
           password != null && password.equals("password"))
//            response.sendRedirect("/profile.jsp");
    %>

<%--    <c:choose>--%>
<%--        <c:when test="${(username.equals('admin')) && (password.equals('password'))}">--%>
<%--            <% response.sendRedirect("/profile.jsp"); %>--%>
<%--        </c:when>--%>
<%--        <c:otherwise>--%>
<%--            <p>login failed</p>--%>
<%--        </c:otherwise>--%>
<%--    </c:choose>--%>



</body>
</html>

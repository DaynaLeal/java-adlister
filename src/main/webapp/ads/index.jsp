<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
<%--    <meta charset="UTF-8">--%>
<%--    <meta name="viewport"--%>
<%--          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">--%>
<%--    <meta http-equiv="X-UA-Compatible" content="ie=edge">--%>
<%--    <title>View Ads</title>--%>

    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Welcome to my Site!" />
    </jsp:include>
</head>
<body>

    <jsp:include page="../partials/navbar.jsp" />

    <h1>Advertisements</h1>

    <ul>
        <c:forEach items="${ads}" var="ad">
            <h4>${ad.title}</h4>
            <li>ID: ${ad.id}</li>
            <li>User ID: ${ad.userId}</li>
            <li>Item Description: ${ad.description}</li>
        </c:forEach>
    </ul>



</body>
</html>
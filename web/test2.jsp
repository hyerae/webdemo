<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/2/14
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%=
        pageContext.getAttribute("test")
    %>
    <%=
        request.getAttribute("test")
    %>
    <%=
        session.getAttribute("test")
    %>
    <%=
        application.getAttribute("test")
    %>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/2/14
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("test","pageContext");
        request.setAttribute("test","request");
        session.setAttribute("test","session");
        application.setAttribute("test","application");
//        request.getRequestDispatcher("test2.jsp").forward(request, response);
        response.sendRedirect("test2.jsp");
    %>
    <%=
        pageContext.getAttribute("test")
    %>
    <%=
        request.getAttribute("test")
    %>

</body>
</html>

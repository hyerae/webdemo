<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/2/13
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--通过jsp进行页面显示--%>
<html>
<head>
    <title>网站主页</title>
</head>
<body>
<%--共用一个request response对象--%>
<%--java片段--%>
    <%
        String result = (String)request.getAttribute("test");
        System.out.println(result);
    %>
<%--java表达式 if（a>b）{}--%>
    <%=
        request.getAttribute("test")
    %>
    <div style="width: 500px; height: 100px; background: linear-gradient(90deg,#5f9ea0,#4a78c2)">新创建的JSP页面</div> <%-- linear-gradient(90deg,#00A000,#4a78c2)渐变色--%>
</body>
</html>

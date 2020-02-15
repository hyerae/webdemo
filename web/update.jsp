<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/2/15
  Time: 3:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${stu}
    <form action="doUpdate">
        sno: <input type="text" name="sno" value="${stu.sno}"><br>
        sname: <input type="text" name="sname" value="${stu.sname}"><br>
        sage: <input type="text" name="sage" value="${stu.sage}"><br>
        ssex: <input type="text" name="ssex" value="${stu.ssex}"><br>
        dept: <input type="text" name="dept" value="${stu.dept}"><br>
        <input type="submit" value="修改">
    </form>
</body>
</html>

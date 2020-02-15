<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/2/14
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="doAdd">
        <%--input 输入 数据提交发送  一个servlet 接收这个数据 --%>
        sno: <input type="text" name="sno"><br>
        sname: <input type="text" name="sname"><br>
        sage: <input type="text" name="sage"><br>
        ssex: <input type="text" name="ssex"><br>
        dept: <input type="text" name="dept"><br>
        <%--input 输入完内容后，在发起一个请求，在请求中 把input框中的值传到后台 --%>
       <%--表单提交  提交到一个地址 -servlet- --%>
        <input type="submit" value="添加" />
    </form>
</body>
</html>

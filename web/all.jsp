<%@ page import="java.util.List" %>
<%@ page import="pojo.Student" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/2/13
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%--导入jar包库--%>
<html>
<head>
    <title>Title</title>
    <style>
        *{
            padding: 0;
            margin: 0;
        }
        table {
            border: solid 1px black;
            border-collapse: collapse; // 变得紧凑
        }
        tr td, tr th{
            border: solid 1px black;
            padding: 5px 10px;
        }
    </style>
</head>
<body>
<a href="add.jsp">添加</a>
    <table>
        <thead>
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>性别</th>
                <th>所在系</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
        <%--不用自己创建，本身存在 ---->"内置对象"，可直接使用--%>
        <%--只出现标签 不出现Java代码 ---> el表达式+jstl标签
        --%>
        <%--数据进行遍历循环：每一个对象形成一条数据--%>
        <%--get/set toString --%>
        <c:forEach items="${stus}" var="stu">
            <tr>
                <%--在el表达式中${stu.sno} 调用了get方法进行值的获取--%>
                <td>${stu.sno}</td> <%-- sno 唯一区分的数据，根据sno进行删除、修改--%>
                <td>${stu.sname}</td>
                <td>${stu.sage}</td>
                <td>${stu.ssex}</td>
                <td>${stu.dept}</td>
                <td><a href="delete?sno=${stu.sno}">删除</a>|<a href="update?sno=${stu.sno}">修改</a></td>
            </tr>
        </c:forEach>

        <%--<%--%>
            <%--List<Student> stus = (List<Student>)request.getAttribute("stus");--%>
        <%--%>--%>
        <%--<%--%>
            <%--for (Student stu : stus){ %>--%>
                <%--<tr>--%>
                    <%--<td><%= stu.getSno()%></td>  // sno: 唯一区分一条数据--%>
                    <%--<td><%= stu.getSname()%></td>--%>
                    <%--<td><%= stu.getSage()%></td>--%>
                    <%--<td><%= stu.getSsex()%></td>--%>
                    <%--<td><%= stu.getDept()%></td>--%>
                    <%--<td><a href="delete?">删除</a></td>--%>
                <%--</tr>--%>
            <%--<% }--%>
        <%--%>--%>

        </tbody>
    </table>
</body>
</html>

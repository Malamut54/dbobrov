<%@ page import="ru.job4j.mvc.logic.UserStore" %>
<%@ page import="ru.job4j.mvc.logic.User" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Dmitriy Bobrov
  Date: 31.01.2018
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<center>

    <table border="1">
        <tr>
            <th>Name</th>
            <th>Login</th>
            <th>Email</th>
            <th>Date</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${users}" var="user">
        <tr>
            <td>
                <c:out value="${user.name}"></c:out>
            </td>
            <td>
                <c:out value="${user.login}"></c:out>
            </td>
            <td>
                <c:out value="${user.email}"></c:out>
            </td>
            <td>
                <c:out value="${user.createDate}"></c:out>
            </td>
            <td>
                <form action='${pageContext.request.contextPath}/update' method='get'>
                    <button value='${user.login}' name='login' type='submit'>Update</button>
                </form>
            </td>
            <td>
                <form action='${pageContext.request.contextPath}/delete' method='get'>
                    <button value='${user.login}' name='login' type='submit'>Delete</button>
                </form>
            </td>
        </tr>
        </c:forEach>
        <p><a href="${pageContext.request.contextPath}/create">Create User</a></p>
</center>
</body>
</html>

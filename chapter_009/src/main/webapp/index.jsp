<%@ page import="ru.job4j.jsp.logic.UserStore" %>
<%@ page import="ru.job4j.jsp.logic.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Dmitriy Bobrov
  Date: 31.01.2018
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! private final UserStore userStore = UserStore.getInstance(); %>

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
        <% for (User user : userStore.getAllUser()) { %>
        <tr>
            <td>
                <%= user.getName() %>
            </td>
            <td>
                <%= user.getLogin() %>
            </td>
            <td>
                <%= user.getEmail() %>
            </td>
            <td>
                <%= user.getCreateDate() %>
            </td>
            <td>
                <form action='<%=request.getServerName() %> <%=request.getServerPort() %> <%= request.getContextPath()%>/main/update'
                      method='get'>
                    <button value='<%= user.getName() %>' name='login' type='submit'>Update</button>
                </form>
            </td>
            <td>
                <form action='<%= request.getContextPath()%>/main/delete/' method='get'>
                    <button value='<%= user.getLogin() %>' name='login' type='submit'>Delete</button>
                </form>
            </td>
        </tr>
        <% } %>
    </table>
    <p><a href="http://localhost:8080/userstore/main/create/">Create user</a></p>
</center>
</body>
</html>

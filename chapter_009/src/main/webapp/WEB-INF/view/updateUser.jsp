<%--
  Created by IntelliJ IDEA.
  User: malamut
  Date: 1/31/18
  Time: 9:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="update" method='post' class='reg-form'>
    <div class='form-row'>
        <label for='form_login'>Current Login: </label>
        <input type='text' id='form_login' name='login' value='${param["login"]}' readonly>
    </div>
    <div class='form-row'>
        <label for='form_fname'>First Name: </label>
        <input type='text' id='form_fname' name='first_name'>
    </div>
    <div class='form-row'>
        <label for='form_email'>Email: </label>
        <input type='email' id='form_email' name='email'>
    </div>
    <div class="form-row">
        <input type="submit" value='Update'>
    </div>
</form>
</body>
</html>

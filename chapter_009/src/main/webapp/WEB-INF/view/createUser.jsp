<%--
  Created by IntelliJ IDEA.
  User: kvazimoda
  Date: 31.01.2018
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crete User</title>

</head>
<body>
<form action="create" method='post' class='reg-form'>
    <div class='form-row'>
        <label for='form_fname'>First Name: </label>
        <input type='text' id='form_fname' name='first_name'>
    </div>
    <div class='form-row'>
        <label for='form_flogin'>Login: </label>
        <input type='text' id='form_flogin' name='login'>
    </div>
    <div class='form-row'>
        <label for='form_email'>Email: </label>
        <input type='email' id='form_email' name='email'>
    </div>
    <div class="form-row">
        <input type="submit" value='Create'>
    </div>
</form>
</body>
</html>

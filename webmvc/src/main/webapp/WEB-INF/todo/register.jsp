<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2025-10-23
  Time: 오후 1:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Register Page</title>
</head>
<body>
<form action="/todo/register" method="post">
    <div><input name="title" type="text" placeholder="INSERT TITLE" /></div>
    <div><input name="date" type="date" /></div>
    <div>
        <button type="reset">RESET</button>
        <button type="submit">REGISTER</button>
    </div>
</form>
</body>
</html>
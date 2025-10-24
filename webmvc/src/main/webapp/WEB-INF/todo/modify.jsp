<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2025-10-23
  Time: 오후 1:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div><input type="text" value="${dto.tno}" /></div>
<div><input type="text" name="" value="${dto.title}" /></div>
<div><input type="date" value="${dto.dueDate}" /></div>
<div><input type="checkbox" name="" value="${dto.finished}" /></div>
<form action="/todo/update" method="post">
    <div><button name="modify" type="submit">Modify</button></div>
</form>
<form action="/todo/remove" method="post">
    <div><button name="remove" type="submit">Remove</button></div>
</form>
</body>
</html>



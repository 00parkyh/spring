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
    <title>Title</title>
</head>
<body>
<div><input type="text" value="${dto.tno}" /></div>
<div><input type="text" name=""  value="${dto.title}" /></div>
<div><input type="date" value="${dto.dueDate}" /></div>
<div><input type="checkbox" name=""   value="${dto.finished}" /></div>
<div><a href="/todo/modify?tno=${dto.tno}">modify</a></div>
</body>
</html>

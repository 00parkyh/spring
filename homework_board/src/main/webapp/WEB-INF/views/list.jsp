<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2025-10-24
  Time: 오전 11:49
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <style>
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            font-family: "Segoe UI", Arial, sans-serif;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        th, td {
            padding: 12px 15px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background-color: #4CAF50;
            color: white;
            font-weight: bold;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
            transition: 0.2s ease-in;
        }
        a {
            color: #2a7ae2;
            text-decoration: none;
            font-weight: bold;
        }
        a:hover {
            text-decoration: underline;
        }
        caption {
            caption-side: top;
            font-size: 1.3em;
            font-weight: bold;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

<h1>Board</h1>

<table>
    <caption>Board</caption>
    <thead>

    <tr>
        <th>NO</th>
        <th>Title</th>
        <th>Content</th>
        <th>Writer</th>
        <th>created_at</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${dtoList}" var="dto" varStatus="status">
        <tr>
            <!-- 자동 글번호 (1부터 시작) -->
            <td>${dto.post_id}</td>

            <!-- 제목에 링크 걸기 -->
            <td>
                ${dto.title}
            </td>
            <td>${dto.content}</td>

            <td>${dto.writer}</td>

            <td>${dto.created_at} </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


    <div>
        <a href="/posts/new" class="btn-write">글쓰기</a>

    </div>


</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2025-10-28
  Time: 오후 5:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <thead>
    <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>이메일</th>
        <th>가입일 (joinDate)</th>
    </tr>
    </thead>
    <tbody>
    <%--
      Controller가 model.addAttribute("list", memberList)로 보낸 "list"를
      items 속성에 받아서 var="member"라는 변수명으로 반복합니다.
    --%>
    <c:forEach items="${memberList}" var="member">
        <tr>
                <%-- DTO의 getter를 호출 (member.getUserid()) --%>
            <td><c:out value="${member.userid}" /></td>
            <td><c:out value="${member.userName}" /></td>
            <td><c:out value="${member.userEmail}" /></td>
            <td><c:out value="${member.joinDate}" /></td>
        </tr>
    </c:forEach>

    <%-- (선택) 목록이 비어있을 경우 --%>
    <c:if test="${empty memberList}">
        <tr>
            <td colspan="4">등록된 회원이 없습니다.</td>
        </tr>
    </c:if>
    </tbody>
</table>

</body>
</html>

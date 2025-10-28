<%@ page import="com.ssg.homework_board.domain.PostVO" %>
<%@ page import="com.ssg.homework_board.dao.PostDAOImpl" %><%--
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
    <title>게시판 글 작성</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/posts/save" method="post">

    <%-- 1. 에러 메시지를 여기에 표시합니다. --%>
    <c:if test="${not empty errorMessage}">
        <div style="color: red; font-weight: bold; margin: 10px 0;">
            <c:out value="${errorMessage}" />
        </div>
    </c:if>

    <div>
        <%-- 2. value 속성을 추가하여 입력했던 값을 복원합니다. --%>
        <input type="text" name="title" placeholder="제목 작성 (2~200)" value="<c:out value='${post.title}'/>">
    </div>

    <div>
        <%-- 3. textarea는 태그 사이에 값을 넣어 복원합니다. --%>
        <textarea name="content" placeholder="내용 작성 (5자 이상)"><c:out value='${post.content}'/></textarea>
    </div>

    <div>
        <input type="text" name="writer" placeholder="작성자 작성 (1~50)" value="<c:out value='${post.writer}'/>">
    </div>

    <div>
        <input type="text" name="passphrase" placeholder="비밀 번호 입력 (4~20)">
        <%-- (비밀번호는 보안상 복원하지 않습니다) --%>
    </div>
    <div>
        <button type="submit">
            작성
        </button>
    </div>
</form>

</body>
</html>


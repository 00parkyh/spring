<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2025-10-28
  Time: 오후 5:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/member/register" method="post">
  <div>
    <label for="userid">아이디:</label>
    <%-- name="userid"가 MemberDTO의 userid 필드와 매핑됩니다. --%>
    <input type="text" id="userid" name="userid" required>
  </div>
  <div>
    <label for="userPwd">비밀번호:</label>
    <%-- name="userpwd"가 MemberDTO의 userpwd 필드와 매핑됩니다. --%>
    <input type="password" id="userPwd" name="userPwd" required>
  </div>
  <div>
    <label for="userName">이름:</label>
    <%-- name="username"가 MemberDTO의 username 필드와 매핑됩니다. --%>
    <input type="text" id="userName" name="userName" required>
  </div>
  <div>
    <label for="userEmail">이메일:</label>
    <%-- name="useremail"가 MemberDTO의 useremail 필드와 매핑됩니다. --%>
    <input type="email" id="userEmail" name="userEmail">
  </div>
  <div>
    <button type="submit">가입하기</button>
    <button type="reset">다시작성</button>
  </div>
</form>

</body>
</html>

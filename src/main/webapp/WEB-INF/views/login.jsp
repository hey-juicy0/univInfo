<%--
  Created by IntelliJ IDEA.
  User: jeewoo
  Date: 2024-04-11
  Time: 오후 2:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>로그인</title>
    <%@ include file="navigation.jsp" %>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/styles.css' />">
</head>
<body>
<div class="login_app">
    <h1>로그인</h1>
    <form class="login_form" method="POST" action="<c:url value="/login"/>">
        <c:if test="${not empty errorMsg}">
            <div style="color: #ff0000;"> <h3> ${errorMsg} </h3></div>
        </c:if>

        <c:if test="${not empty logoutMsg}">
            <div style="color: #0000ff;" > <h3> ${logoutMsg} </h3></div>
        </c:if>

        <p class="login_p">
            <label for="username" class="login_label">아이디 </label>
            <input type="text" id="username" name="username" class="login_input" placeholder="아이디를 입력해주세요" required autofocus>
        </p>
        <p class="login_p">
            <label for="password" class="login_label">비밀번호</label>
            <input type="password" id="password" name="password" class="login_input" placeholder="비밀번호를 입력해주세요" required>
        </p>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"  />
        <button type="submit" class="login_submit">로그인</button>
    </form>
</div>
</body>
</html>



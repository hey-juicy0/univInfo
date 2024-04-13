<%--
  Created by IntelliJ IDEA.
  User: jeewoo
  Date: 2024-04-11
  Time: 오후 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>학사 정보 시스템</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
    <style>
        .navbar_box {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #001F99 ;
            color: white;
            height: 60px;
            box-sizing: border-box;
            padding: 0 30px;
        }

        /* 왼쪽 부분의 내비게이션 바 스타일 */
        .navbar_left {
            text-align: center;
        }

        /* 드롭다운 버튼 스타일 */
        .dropdown-btn {
            cursor: pointer;
            font-size: 16px;
            font-weight: 700;
        }

        .dropdown-btn:hover {
            color: #33CCFF;
        }

        /* 드롭다운 컨텐츠 스타일 */
        .dropdown-content {
            display: none;
            position: absolute;
            background-color: white;
            top: 68px;
            text-align: center;
            min-width: 160px;
            box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
            z-index: 100;
            margin-left: -30px;
        }

        /* 드롭다운 링크 스타일 */
        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        /* 드롭다운 링크 호버 스타일 */
        .dropdown-content a:hover {
            font-weight: bolder;
            background-color: darkgray;
        }

        .home_login {
            font-size: 16px;
            font-weight: 700;
            cursor: pointer;
            text-decoration: none;
            color: white;
        }

        .navbar_title {
            margin: 0;
            text-align: center;
        }

        .home_login:hover {
            color: #33CCFF;
        }

    </style>
</head>
<body>
<div class="navbar_box">
    <div class="navbar_left">
        <div class="dropdown-btn" onclick="toggleDropdown()">메뉴</div>
        <div class="dropdown-content" id="navbar">
            <a href="${pageContext.request.contextPath}/">홈</a>
            <a href="${pageContext.request.contextPath}/semesters">학년별 이수 학점 조회</a>
            <a href="${pageContext.request.contextPath}/register">수강 신청하기</a>
            <a href="${pageContext.request.contextPath}/registerList">수강 신청 조회</a>
        </div>
    </div>
    <h1 class="navbar_title">학사 정보 시스템</h1>
    <c:choose>
        <c:when test="${empty pageContext.request.userPrincipal.name}">
            <a href="${pageContext.request.contextPath}/login" class="home_login">로그인</a>
        </c:when>
        <c:otherwise>
            <a href="javascript:document.getElementById('logout').submit()" class="home_login">로그아웃</a>
        </c:otherwise>
    </c:choose>

    <form id="logout" style="display: none" action="<c:url value="/logout" />" method="post">
        <input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}" />
    </form>

</div>

<script>
    function toggleDropdown() {
        const navbar = document.getElementById("navbar");
        if (navbar.style.display === "block") {
            navbar.style.display = "none";
        } else {
            navbar.style.display = "block";
        }
    }
</script>
</body>
</html>

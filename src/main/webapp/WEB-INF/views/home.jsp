<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jeewoo
  Date: 2024-04-08
  Time: 오후 8:36
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="navigation.jsp" %>

<html>
<head>
    <title>학사 정보 시스템</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/styles.css' />">
   </head>
<body>
<div class="home_container">
    <div class="home_left">
        <h2>학년별 이수 학점 조회</h2>
        <img src="${pageContext.request.contextPath}/resources/images/totalGrade.png" class="home_image" alt="학년별 이수 학점 조회"/>
        <button onclick="location.href='/semesters'" class="home_button">조회하기</button>
    </div>
    <div class="home_center">
        <h2>수강 신청</h2>
        <img src="${pageContext.request.contextPath}/resources/images/register.png" class="home_image" alt="수강 신청하기"/>
        <button onclick = "location.href='/register'" class="home_button">신청하기</button>
    </div>
    <div class="home_right">
        <h2>수강 신청 조회</h2>
        <img src="${pageContext.request.contextPath}/resources/images/registerList.png" class="home_image" alt="수강 신청 조회"/>
        <button onclick = "location.href='/registerList'" class="home_button">조회하기</button>
    </div>
</div>
</body>
</html>
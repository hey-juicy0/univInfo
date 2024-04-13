<%--
  Created by IntelliJ IDEA.
  User: jeewoo
  Date: 2024-04-12
  Time: 오전 2:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="navigation.jsp" %>
<html>
<head>
    <title>수강 신청 조회</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/styles.css' />">
</head>
<body>
<h2>2024년 2학기 수강 신청 조회</h2>
<table>
    <thead>
    <tr>
        <th>연도</th>
        <th>학기</th>
        <th>교과목명</th>
        <th>교과구분</th>
        <th>담당교수</th>
        <th>학점</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${registerList}" var="course">
        <tr>
            <td>${course.year}</td>
            <td>${course.semester}</td>
            <td>${course.courseName}</td>
            <td>${course.courseType}</td>
            <td>${course.professor}</td>
            <td>${course.credits}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

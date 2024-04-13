<%--
  Created by IntelliJ IDEA.
  User: jeewoo
  Date: 2024-04-12
  Time: 오전 3:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="navigation.jsp" %>

<html>
<head>
    <title>학년별 이수 학점 조회</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/styles.css' />">
</head>
<body>
<h2>학년별 이수 학점 조회</h2>
<table>
    <thead>
    <tr>
        <th class="table_head">연도</th>
        <th  class="table_head">학기</th>
        <th  class="table_head">취득 학점</th>
        <th class="table_head">상세보기</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${semesters}" var="semester">
        <tr>
            <td>${semester.year}</td>
            <td>${semester.semester}</td>
            <td>${semester.totalCredits}</td>
            <td class="url"><a href="<c:url value="/registerDetail">
                <c:param name="year" value="${semester.year}" />
                <c:param name="semester" value="${semester.semester}" />
                </c:url>"
            >링크</a>
            </td>
        </tr>
    </c:forEach>
    <tr >
        <th class="total_credits">총계</th>
        <th class="total_blank"></th>
        <th class="total_credits">${totalCredits}</th>
        <th class="total_blank"></th>

    </tr>
    </tbody>
</table>
</body>
</html>


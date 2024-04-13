<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: jeewoo
  Date: 2024-04-12
  Time: 오전 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="navigation.jsp" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/styles.css' />">
</head>
<body>
<div class="register_app">
    <h2>수강 신청</h2>
    <script>
        var successMessage = "${successMessage}";
        if (successMessage) {
            alert(successMessage);
            window.location.href = '/'
        }
    </script>

    <sf:form method="post"
             action="${pageContext.request.contextPath}/register" modelAttribute="course">

        <div class="register_table">
            <p class = "register_p">
                <label>교과목명</label>
                <sf:input path="courseName"/>
            </p>
            <sf:errors path="courseName"/>

            <p class="register_p">
                <label>과목코드</label>
                <sf:input path="courseCode" />
            </p>
            <sf:errors path="courseCode" />
            <p class="register_p">
                <label>교과구분</label>
                <sf:select path="courseType">
                    <sf:option value="전필">전필</sf:option>
                    <sf:option value="전선">전선</sf:option>
                    <sf:option value="교양">교양</sf:option>
                </sf:select>
            </p>
            <sf:errors path="courseType"/>
            <p class="register_p">
                <label>담당교수</label>
                <sf:input path="professor"/>
            </p>
            <sf:errors path="professor"/>
            <p class="register_p">
                <label>학점</label>
                <sf:select path="credits">
                    <sf:option value="3">3</sf:option>
                    <sf:option value="2">2</sf:option>
                    <sf:option value="1">1</sf:option>
                </sf:select>
            </p>
            <sf:errors path="credits"/>
        </div>
        <div class="register_button">
            <button type="reset">초기화</button>
            <button type="submit">신청</button>
        </div>
    </sf:form>
</div>
</body>
</html>

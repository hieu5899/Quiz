<%-- 
    Document   : checkGetQuiz
    Created on : May 24, 2021, 12:11:02 AM
    Author     : Hieu Mau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Quiz</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
        <script src="<%=request.getContextPath()%>/js/index.js" type="text/javascript"></script>
    </head>
    <body>
        <!--Page Body-->
        <div class="container">
            <div class="box">
                <div class="box__top"></div>
                <div class="box__content">
                    <!--Header Content-->
                    <jsp:include page="header.jsp"/>
                    <div class="managequiz">
                        <c:set var="listQuestion" value="${list}"></c:set>
                        <c:choose>
                            <c:when test="${not empty sessionScope.account}">
                                <div class="login__label">
                                    <p>Start ${questionNumber} questions in ${time}</p>
                                    <button type="button" onclick="window.location.href = '<%=request.getContextPath()%>/takeQuizNumber.jsp'">Back</button>
                                    <button type="button" onclick="window.location.href = 'takeQuiz'">Start</button>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="login__label">
                                    <a href="login.jsp">Click here to login</a>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>


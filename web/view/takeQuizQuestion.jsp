<%-- 
    Document   : takeQuizQuestion
    Created on : May 24, 2021, 7:43:16 AM
    Author     : Hieu Mau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Doing Test</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
        <script src="<%=request.getContextPath()%>/js/index.js" type="text/javascript"></script>
    </head>
    <!--Body Content-->
    <!--When user accepted the test, timing will start countdown-->
    <body onload="currentTime(${sessionScope.time})">
        <div class="container">
            <div class="box">
                <div class="box__top"></div>
                <div class="box__content">
                    <!--Header Content-->
                    <jsp:include page="header.jsp"/>
                    <div class="takequiz">
                        <div class="takequiz__label">Welcome <span>${sessionScope.account.username}</span></div>
                        <div class="takequiz__time">Time Remaining <span id="clock"></span></div>
                        <div class="takequiz__question">
                            <!--Questtion UI-->
                            <form action="takeQuiz" method="post">
                                <input type="hidden" name="questionIndex" value="${sessionScope.questionIndex}"/>
                                <p class="takequiz__question__label">${currentQuestion.questionContent}</p>
                                <div class="takequiz__question__option">
                                    <c:forEach var="i" items="${currentQuestion.option}">
                                        <div class="item">
                                            <input type="checkbox" name="answer" value="${i.optionCode}"/>
                                            ${i.optionContent}</div>
                                        </c:forEach>
                                </div>
                                <div class="takequiz__button">
                                    <input type="submit" name="submit" value="Next" />
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
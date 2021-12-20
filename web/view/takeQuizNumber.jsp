<%-- 
    Document   : takeQuizNumber
    Created on : May 24, 2021, 7:42:12 AM
    Author     : Hieu Mau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Take Quiz</title>
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
                    <div class="takequiz">
                        <c:choose>
                            <c:when test="${not empty sessionScope.account}">

                                <c:if test="${not empty message}">
                                    <p class="message" style="color:red">${message}</p>
                                </c:if>
                                <div class="takequiz__label">Welcome <span>${sessionScope.account.username}</span></div>
                                <div class="takequiz__question">
                                    <form action="${pageContext.servletContext.contextPath}/getRandom" method="post" onsubmit="return validateTakeQuizNumber()">
                                        <span class="takequiz__number__label">Enter number of questions:</span>
                                        <div>
                                            <input class="takequiz__number__text" name="number" type="text">
                                        </div>
                                        <div class="takequiz__number__button">
                                            <input type="submit" name="submit" value="Start" />
                                        </div>
                                    </form>
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

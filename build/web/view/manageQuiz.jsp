<%-- 
    Document   : manageQuiz
    Created on : May 24, 2021, 12:17:26 AM
    Author     : Hieu Mau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Manager Quiz</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
        <script src="<%=request.getContextPath()%>/js/index.js" type="text/javascript"></script>
    </head>
    <body>
        <!--Page body-->
        <div class="container">
            <div class="box">
                <div class="box__top"></div>
                <div class="box__content">
                    <!--Header-->
                    <jsp:include page="header.jsp"/>
                    <div class="managequiz">
                        <div class="login__label">
                            <c:if test="${not empty message}">
                                <p id="message" style="color:red">${message}</p>
                            </c:if>
                        </div>
                        <!--Get list into parameter-->
                        <c:set var="listQuestion" value="${list}"></c:set>
                        <c:choose>
                            <c:when test="${not empty sessionScope.account}">
                                <c:choose>
                                    <c:when test="${sessionScope.account.role == 1}">
                                        <div class="managequiz__title">Number of questions: <span>${numberOfQuestion}</span></div>
                                        <div class="managequiz__content">
                                            <table class="quickTable">
                                                <tbody>
                                                    <tr class="managequiz__content__head">
                                                        <td>Question</td>
                                                        <td>Date Created</td>
                                                    </tr>
                                                    <c:forEach items="${listQuestion}" var="i">
                                                        <tr class="managequiz__content__question">
                                                    <div>
                                                        <td><p>${i.questionContent}</p></td>
                                                    </div>
                                                    <td>${i.createdAt}</td>
                                                    <td><form action="${pageContext.request.contextPath}/deleteQuiz" method="POST"><input type="hidden" name="questionCode" value="${i.questionCode}"/> 
                                                            <input type="submit" class="table_submit" name="submit" value="Delete"/> </form></td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                            <ul class="page">
                                                <c:forEach begin="1" end="${page}" step="1" var="x">
                                                    <li class="page_item"><a href="${pageContext.servletContext.contextPath}/manageQuiz?page=${x}">${x}</a></li>
                                                    </c:forEach>
                                            </ul>
                                        </div>
                                    </c:when>
                                </c:choose>
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


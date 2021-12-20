<%-- 
    Document   : makeQuiz
    Created on : May 24, 2021, 12:17:26 AM
    Author     : Hieu Mau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Make Quiz</title>
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
                    <div class="makequiz">
                        <c:choose>
                            <c:when test="${not empty sessionScope.account}">
                                <c:choose>
                                    <c:when test="${sessionScope.account.role == 1}">
                                        <c:if test="${not empty message}">
                                            <p style="color:red">${message}</p>
                                        </c:if>
                                        <form action="${pageContext.servletContext.contextPath}/makeQuiz" onsubmit="return validateMakeQuiz()" method="post">
                                            <div class="makequiz_item">
                                                <label for="question">Question:</label>
                                                <textarea name="question" id="" cols="70" rows="8"></textarea>
                                            </div>
                                            <div class="makequiz_item">
                                                <label for="question">Option1:</label>
                                                <textarea name="option" id="" cols="70" rows="3"></textarea>
                                            </div>
                                            <div class="makequiz_item">
                                                <label for="question">Option2:</label>
                                                <textarea name="option" id="" cols="70" rows="3"></textarea>
                                            </div>
                                            <div class="makequiz_item">
                                                <label for="question">Option3:</label>
                                                <textarea name="option" id="" cols="70" rows="3"></textarea>
                                            </div>
                                            <div class="makequiz_item">
                                                <label for="question">Option4:</label>
                                                <textarea name="option" id="" cols="70" rows="3"></textarea>
                                            </div>
                                            <div class="makequiz_item_checkbox">
                                                <label for="question">Answer(s):</label>
                                                <input type="checkbox" name="answer" value="1">Option 1&nbsp;&nbsp;&nbsp;
                                                <input type="checkbox" name="answer" value="2">Option 2&nbsp;&nbsp;&nbsp;
                                                <input type="checkbox" name="answer" value="3">Option 3&nbsp;&nbsp;&nbsp;
                                                <input type="checkbox" name="answer" value="4">Option 4&nbsp;&nbsp;&nbsp;
                                            </div>
                                            <div class="makequiz_item">
                                                <input class="makequiz_button" type="submit" name="submit" value="Save">
                                            </div>
                                        </form>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="login__label">
                                            <p>Only teacher's account can use Make Quiz</p>
                                        </div>
                                    </c:otherwise>
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
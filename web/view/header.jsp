<%-- 
    Document   : header
    Created on : May 23, 2021, 8:42:31 PM
    Author     : Hieu Mau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
Header Content
--%>
<div class="menu_bar">
    <c:if test="${not empty sessionScope.account}">
        <c:choose>
            <c:when test="${sessionScope.account.role == 1}">
                <div class="menu_item"> <a href="${empty sessionScope.questionIndex?"login":"#"}" id="home">Home</a> </div>
                <div class="menu_item"> <a href="${empty sessionScope.questionIndex?"takeQuiz":"#"}" id="takeQuiz">Take Quiz</a> </div>
                <div class="menu_item"> <a href="${empty sessionScope.questionIndex?"makeQuiz":"#"}" id="makeQuiz">Make quiz</a> </div>
                <div class="menu_item"> <a href="${empty sessionScope.questionIndex?"manageQuiz?page=1":"#"}" id="manageQuiz">Manager Quiz</a> </div>
            </c:when>
            <c:otherwise>
                <div class="menu_item"> <a href="${empty sessionScope.questionIndex?"login":"#"}" id="home">Home</a> </div>
                <div class="menu_item"> <a href="${empty sessionScope.questionIndex?"takeQuiz":"#"}" id="takeQuiz">Take Quiz</a> </div>
            </c:otherwise>
        </c:choose>
                <div class="menu_item"> <a href="<%=request.getContextPath()%>/logout" id="logout">Logout</a> </div>
    </c:if>
</div>

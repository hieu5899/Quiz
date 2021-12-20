<%-- 
    Document   : takeQuizOption
    Created on : May 24, 2021, 7:49:02 AM
    Author     : Hieu Mau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Result</title>
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
                    <jsp:include page="header.jsp"/>
                    <div class="takequiz">
                        <!--Display score-->
                        <div class="takequiz__label">Your score <span>${result}</span></div>
                        <div class="takequiz__question">
                            <div class="takequiz__label">Take another test <button type="button" onclick="window.location.href = 'view/takeQuizNumber.jsp'">Start</button></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

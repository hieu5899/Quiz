<%-- 
    Document   : error
    Created on : May 23, 2021, 9:00:22 PM
    Author     : Hieu Mau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
        <script src="<%=request.getContextPath()%>/js/index.js" type="text/javascript"></script>
    </head>
    <body>
        <!--Body Page-->
        <div class="container">
            <div class="box">
                <div class="box__top"></div>
                <div class="box__content">
                    <!--Header Content-->
                    <jsp:include page="header.jsp"/>

                    <div class="login">
                        <p class="login__label">Page not found!</p>
                </div>
            </div>
        </div>
    </body>
</html>
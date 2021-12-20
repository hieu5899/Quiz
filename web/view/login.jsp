<%-- 
    Document   : login
    Created on : May 23, 2021, 8:46:17 PM
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
        <!--Page body-->
        <div class="container">
            <div class="box">
                <div class="box__top"></div>
                <div class="box__content">
                    <!--Header-->
                    <jsp:include page="header.jsp"/>

                    <div class="login">
                        <c:choose>
                            <c:when test="${not empty sessionScope.account}">
                                <div class="login__label">
                                    <p>Welcome ${sessionScope.account.username} to Online Quiz</p>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="login__label">
                                    <c:if test="${not empty message}">
                                        <p id="message" style="color:red">${message}</p>
                                    </c:if>
                                    <p>Login Form</p>
                                </div>
                                <div class="login__content">
                                    <!--Form Login-->
                                    <form action="${pageContext.request.contextPath}/login" method="post" onsubmit="return validateLogin()">
                                        <table class="login_table" width="100%" cellpadding="1">
                                            <tbody>
                                                <tr>
                                                    <td class="table_label"><label for="username">User Name:</label></td>
                                                    <td><input type="text" name="username"></td>
                                                </tr>
                                                <tr>
                                                    <td class="table_label"><label for="password">Password:</label></td>
                                                    <td><input type="password" name="password"></td>
                                                </tr>
                                                <!--Move to register page-->
                                                <tr>
                                                    <th>&nbsp;</th>
                                                    <td><input type="submit" class="table_submit" name="submit" value="Sign in"/>
                                                        <a href="view/register.jsp">Register</a></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </form>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </body>
</html>
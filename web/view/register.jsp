<%-- 
    Document   : register
    Created on : May 23, 2021, 10:22:24 PM
    Author     : Hieu Mau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>
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
                        <div class="login__label">
                            <!--Show warning message--> 
                            <c:if test="${not empty message}">
                                <p id="message" style="color:red">${message}</p>
                            </c:if>
                            <p>Registration Form</p>
                        </div>
                        <div class="login__content">
                            <!--Register form-->
                            <form action="${pageContext.request.contextPath}/register" method="POST" onsubmit="return validateLogin()">
                                <table class="login_table" width="100%" cellpadding="1">
                                    <tbody>
                                        <tr>
                                            <td class="table_label"><label for="username">User Name:</label></td>
                                            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="username" required="true"></td>
                                        </tr>
                                        <tr>
                                            <td class="table_label"><label for="password">Password:</label></td>
                                            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="password" required="true"></td>
                                        </tr>
                                        <tr>
                                            <td class="table_label"><label for="role">User Type:</label></td>
                                            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <select name="role" id="">
                                                    <option value="1">Teacher</option>
                                                    <option value="0">Student</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="table_label"><label for="email">Email:</label></td>
                                            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="email" required="true"></td>
                                        </tr>
                                        <tr>
                                            <th>&nbsp;</th>
                                            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="table_submit" name="submit" value="Register"/></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

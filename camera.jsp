<%-- 
    Document   : camera.jsp
    Created on : Apr 23, 2023, 5:29:41 PM
    Author     : jcorbett
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Camera data</title>
    </head>
    <body>
        <h1>Camera settings</h1>
        <table>
            <thead>
            <th>Camera ID</th>
            <th>Camera Location</th>
            <th>Camera Resolution</th>
            <th>Camera Name</th>
            </thead>
            <tbody>
                <c:forEach items="${datas}" var="data">
                    <tr>
                        <td>
                            <c:out value="${data.getCameraID()}"></c:out>
                        </td>
                        <td>
                            <c:out value="${data.getCLocation()}"></c:out>
                        </td>
                        <td>
                            <c:out value="${data.getResolution()}"></c:out>
                        </td>
                        <td>
                        <c:out value="${data.getCName()}"></c:out>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>

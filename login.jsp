<%-- 
    Document   : login
    Created on : Apr 25, 2023, 12:10:21 PM
    Author     : monte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Smart Home</title>
    </head>
    <body>
        <h1>Please enter your email & password</h1>
        <form action="loginCTL" method="post">
            <div id ="email">Email</div>
            <input type="text" name="email"</> </br>
            <div id="pwd">Password</div>
            <input type="text" name="pwd" /> </br>
            <input type="submit" value="login" id="submit">
        </form>
    </body>
</html>

<%-- 
    Document   : thermostat
    Created on : Apr 24, 2023, 4:16:48 PM
    Author     : Whoslala
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>thermostat</title>
    </head>
    <body>
        <h1>SmartHome Thermostat</h1>
        <form action="ThermostatCTL" method="post">
            <div id="thermostat">Current Temperature:</div>
            <!-- W3Schools
                 Version N/A
                 N/A
                 https://www.w3schools.com/html/html_form_input_types.asp
            -->
            <input type="number" name="temperature" id="thermostat">
            <input type="submit" value="Adjust Thermostat">
        </form>
    </body>
</html>

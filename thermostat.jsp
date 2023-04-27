<%-- 
    Document   : thermostat
    Created on : Apr 24, 2023, 4:16:48 PM
    Author     : Whoslala
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>thermostat</title>
    </head>
    <body>
        <h1>SmartHome Thermostat</h1
            <label for="thermostat">Current Temperature:</label>
            <!-- Rahul R.
                 Version N/A
                 09/21/2013
                 https://stackoverflow.com/questions/10004723/html5-input-type-range-show-range-value
            -->
            <input type="range" id="thermostat" value="temperature" min="32" max="100" oninput="this.nextElementSibling.value = this.value">
            <output></output>
    </body>
</html>

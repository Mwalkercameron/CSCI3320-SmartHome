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
        <form action="ThermostatCTL" method="post">
            <input type="submit" id="incTemp" name="turnUpTemperature" value="Increase Temperature"><br>
            <input type="submit" id="decTemp" name="turnDownTemperature" value="Decrease Temperature">
        </form>
    </body>
</html>

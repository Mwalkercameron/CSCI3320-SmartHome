<%-- 
    Document   : enabledOrDisabled
    Created on : Apr 25, 2023, 12:47:18 PM
    Author     : Whoslala
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>enabledOrDisabled</title>
    </head>
    <body>
        <h1>SmartHome Configurations</h1>
            <form action="EnabledOrDisabledCTL" method="post">
                <label for ="smarthome">Enable SmartHome</label>
                <input type="checkbox" id="smarthome" name="smarthome" value="SmartHome">
                </br><label for ="doors">Enable Doors</label>
                <input type="checkbox" id="doors" name="doors" value="Door">
                </br><label for ="lights">Enable Lights</label>
                <input type="checkbox" id="lights" name="lights" value="Light">
                </br><label for ="cameras">Enable Camera</label>
                <input type="checkbox" id="cameras" name="cameras" value="Camera">
                </br><label for ="thermostat">Enable Thermostat</label>
                <input type="checkbox" id="thermostat" name="thermostat" value="Thermostat">
            </form>
    </body>
</html>

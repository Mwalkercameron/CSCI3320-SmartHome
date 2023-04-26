<%-- 
    Document   : adjustaudio
    Created on : Apr 23, 2023, 5:31:37 PM
    Author     : jcorbett
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Audio data</title>
    </head>
    <body>
        <h1>Configure volume/sound</h1>
        <form action="AdjustAudioCTL" method="post">
            <div id ="vlm">Volume</div>
            <input type="text" name="email" /> </br>
            <div id ="snd">Sound</div>
            <input type="text" name="pwd" /> </br>
            <input type="submit" value="Confirm" id="submit">
        </form>
    </body>
</html>

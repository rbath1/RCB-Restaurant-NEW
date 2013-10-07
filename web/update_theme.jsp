<%-- 
    Document   : update_theme
    Created on : Oct 6, 2013, 6:36:47 PM
    Author     : Bob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Object obj = session.getAttribute("color");
    String color = (obj == null) ? "white" : obj.toString();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Theme</title>
    </head>
    <body bgcolor="<%= color  %>">
        <form method="POST" action="FrontController?action=update_theme">
            Enter Desired Background Color: <input name="color" value="" /> <br/>
            <input name="submit" value="Submit" type="submit"/>
        </form>
    </body>
</html>

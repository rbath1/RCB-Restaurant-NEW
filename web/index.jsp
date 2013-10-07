<%-- 
    Document   : index
    Created on : Sep 19, 2013, 11:58:50 PM
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
        <link rel="stylesheet" type="text/css" href="css/css.css">
        <title>Restaurant</title>
    </head>
    <body bgcolor="<%= color  %>">
        <a href="MenuController?action=menu">Begin Order </a><br/>
        <a href="UpdateController?action=update">Update Menu </a>
    </body>
    <footer>
        <% out.print(getServletContext().getInitParameter("webmaster"));
        %>
        <br/>
        <a href="FrontController?action=change">Change Page Theme</a>
        <br/>
        <a href="FrontController?action=end">End Theme (Set to Default)</a>
        <br/>
    </footer>
</html>

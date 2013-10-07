<%-- 
    Document   : menu
    Created on : Sep 18, 2013, 9:26:52 PM
    Author     : Bob
--%>

<%@page import="model.MenuItem"%>
<%@page import="java.util.List"%>
<%@page import="java.text.NumberFormat"%>
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
         <%
	List<MenuItem> menuList = (List<MenuItem>) request.getAttribute("menuList");
	
%>
        <title>Create an Order</title>
    </head>
    <body bgcolor="<%= color %>">
        <h1 align="center">Simple Restaurant</h1>
        <form id="form1" name="form1" method="POST" action="OrderController">
            <table border="1">
                   <%
                        NumberFormat nf = NumberFormat.getCurrencyInstance();
                        for(MenuItem menuItem : menuList) {
                            String item = menuItem.getItemName();
                            double itemPrice = menuItem.getItemPrice();
                    %>
         
                    <tr><td><input type="checkbox" name="menuItems" value="<%= item %>" /></td><td> <%= item %></td>
                        <td><%= nf.format(itemPrice) %> </td></tr>
                    
                    <%
                        }
                        
                     %>
            </table>
                     <br/>
         <input id="orderSubmit" name="Submit Order" type="submit" value="Place Order">
        </form>
                     <br/>
                     <br/>
                     <a href="index.jsp">Home</a>
    </body>
    <footer>
        <% out.print(getServletContext().getInitParameter("webmaster"));
        %>
    </footer>
</html>

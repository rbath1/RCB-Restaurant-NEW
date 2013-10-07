<%-- 
    Document   : update
    Created on : Sep 23, 2013, 9:43:22 PM
    Author     : rbath1
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="model.MenuItem"%>
<%@page import="java.util.List"%>
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
        <title>Update Menu</title>
    </head>
    <body bgcolor="<%=color%>">
        <%
	List<MenuItem> menuList = (List<MenuItem>) request.getAttribute("menuList");
	
%>

<form id="form1" name="form1" method="POST" action="UpdateController?action=updateItem">
    <table width="300" border='1'>
        <tr><td></td><td>Name</td><td>Price</td><td>ID#</td></tr>
    
         <%
                        NumberFormat nf = NumberFormat.getCurrencyInstance();
                        for(MenuItem menuItem : menuList) {
                            String item = menuItem.getItemName();
                            double itemPrice = menuItem.getItemPrice();
                            int itemId = menuItem.getItemId();
                            
                    %>
         
                    <tr><td><input type="checkbox" name="itemId" id="itemId" value="<%= itemId %>" /></td>
                        <td><%=item %></td>
                        <td><%=nf.format(itemPrice)%></td>
                        <td><%=itemId %></td></tr>
                    
                    <%
                        }
                        
                     %>
   </table
<br/>
<br/>
        <input type="submit" value="Add/Edit" name="addEdit" id="addEdit" />&nbsp;
        <input type="submit" value="Delete" name="delete" />
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

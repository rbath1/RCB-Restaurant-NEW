<%-- 
    Document   : update_item
    Created on : Sep 25, 2013, 9:13:45 PM
    Author     : rbath1
--%>

<%@page import="java.util.List"%>
<%@page import="model.MenuItem"%>
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
        <title>Update Item</title>
    </head>
    <body bgcolor="<%=color%>">
        <% MenuItem item = (MenuItem)request.getAttribute("menuItem");%>
      <form method="POST" action="UpdateController?action=store">
          <table><tr>
              <td> ITEM NAME:</td><td><input type="text" name="itemName" value="<%= item.getItemName()%>" /></td></tr>
              <tr><td>ITEM PRICE:</td><td><input type="text" name="itemPrice" value="<%= item.getItemPrice()%>" /></td></tr> 
              <tr><td>ITEM ID:</td><td><input type="hidden" name="itemId" id="itemId" value="<%=item.getItemId()%>"/><% out.print(item.getItemId());%></td></tr>
          </table>
 
        <input type="submit" value="Save" name="Save" />&nbsp;
        <input type="submit" value="Cancel" name="Cancel" />
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

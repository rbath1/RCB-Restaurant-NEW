<%-- 
    Document   : receipt
    Created on : Sep 22, 2013, 3:31:19 PM
    Author     : Bob
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.*, model.MenuItem"%>
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
        <title>Receipt</title>
    </head>
    <body bgcolor="<%= color %>">
        <h1> Receipt for your order</h1>
        
        <%
                double totalBill = 0;
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                Object objOrderList = request.getAttribute("orderList");
                if(objOrderList != null) {
                    List<MenuItem> orderList = (List<MenuItem>)objOrderList;
                    for(MenuItem item : orderList) {
        %>
        <table width="400" border="1" cellpadding="4">
            <tr><td><%  out.println(item.getItemName());%> </td>
                <td> <% out.println(nf.format(item.getItemPrice()));%> </td></tr>
                       
                 <% totalBill += item.getItemPrice();
                    } %>
       
                    
            <tr><td> <%out.println("Subtotal:");%></td>
                <td> <%out.println(nf.format(totalBill));%></td></tr>
            <tr><td> <%out.println("Tax:");%> </td>
                <td> <%out.println((nf.format(totalBill * .051))); %> </td></tr>
            <tr><td> <%out.println("Total Bill:");%> </td>
                <td> <%out.println(nf.format(totalBill * 1.051));%> </td></tr>
            <tr><td> <%out.println("Tip:");%></td>
                <td> <%out.println(nf.format(totalBill * 1.051 * 0.17));%> </td></tr>
            <tr><td> <%out.println("Total w/ Tip");%></td>
                <td> <%out.println(nf.format(totalBill * 1.051 * 1.17));%></td></tr>
    
                <%
                } else {
                    out.print("Order Cannot Be Found!!");
                }
            %>
      </table>
            <br/>
            <br/>
        <a href="index.jsp">Home</a>
    </body>
    <footer>
        <% out.print(getServletContext().getInitParameter("webmaster"));
        %>
    </footer>
</html>

<%@ page import="com.example.cart.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.cart.util.ProductDB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Shop Cart</title>
  </head>
  <body>
  <div align="center">
    <h1>Thong tin mat hang</h1>
    <form action="Controller" method="post">
      <table border="1" cellspacing="0">
      <tr>
        <td>Code</td>
        <td>Name</td>
        <td>Price</td>
      </tr>
        <%
          List<Product> list = ProductDB.getAll();
          for (Product p: list) {
        %>
      <tr>
        <td><input type="hidden" name="txtCode" value="<%= p.getCode()%>"><%= p.getCode()%></td>
        <td><input type="hidden" name="txtName" value="<%= p.getName()%>"><%= p.getName()%></td>
        <td><input type="hidden" name="txtPrice" value="<%= p.getPrice()%>"><%= p.getPrice()%></td>
        <td><input type="submit" name="action" value="Add to cart"></td>
      </tr>
        <%
          }
        %>
      </table>
    </form>
    <form action="Controller">
      <input type="submit" value="View cart" name="action">
    </form>
  </div>
  </body>
</html>

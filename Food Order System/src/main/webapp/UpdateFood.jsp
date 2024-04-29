<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="FoodWeb.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
FoodBean fb=(FoodBean)request.getAttribute("fbean");

%>

<form action="aupdate"   method="post">

              <input  type="hidden" name="fcode"  value="<%=fb.getFcode()%>">
  FoodName:   <input type="text" name="fname" value="<%=fb.getFname()%>">
  FoodPrice:  <input type="text" name="price" value="<%=fb.getPrice()%>">
  FoodQty:    <input type="text" name="qty" value="<%=fb.getQty()%>">

<input type="submit" value="Update">  






</form>

</body>
</html>
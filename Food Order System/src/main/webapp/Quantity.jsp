<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="test.*,java.util.*"%>
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
<form action="addtocartq" method="post">

Enter <%out.println(fb.getFname());%> Qty :<input type="text" name="qty">

<input type="hidden" name="fcode" value="<%=fb.getFcode()%>">
<input type="submit" value="Add">






 

</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
int random=new Random().nextInt(100000);
out.println("Your order is place with order id "+random+"<br> take money and wait for 30 minut...");

%>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

String aname=(String)request.getAttribute("aname");
out.println("WelCome Admin: "+aname);


%>
<a href="aview">ViewAllFoods</a><br>
<a href="AddNewFood.html">AddNewFood</a>

<a href="alogout">Logout</a>


</body>
</html>
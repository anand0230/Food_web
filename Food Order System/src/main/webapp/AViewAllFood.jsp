<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="FoodWeb.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
ArrayList<FoodBean> al=(ArrayList<FoodBean>)session.getAttribute("alist");


if(al==null){
	out.println("Foods are Not Available..");
}
else{
	Iterator<FoodBean> itr=al.iterator();
	
	while(itr.hasNext()){
		FoodBean fb=(FoodBean)itr.next();
		out.println(fb.getFcode()+"&nbsp&nbsp"+fb.getFname()+"&nbsp&nbsp"
		+fb.getPrice()+"&nbsp&nbsp"+fb.getQty()+"&nbsp&nbsp"+"<a href='edit?fcode="+fb.getFcode()+"'>Edit</a>"+"&nbsp&nbsp"+
		"<a href='delete?fcode="+fb.getFcode()+"'>Delete</a>"+"&nbsp&nbsp"+"<br>");
		
		
	}
}
%>

</body>
</html>
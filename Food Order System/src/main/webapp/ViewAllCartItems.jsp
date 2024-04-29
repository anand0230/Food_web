<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="test.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

*{
    margin: 0;
 }
   .container{
   
   margin:50px auto;
    color: black;
    width:100%;
    
    
   }
   .container tr th{
  background-color: lightblue;
  color: black;
   cursor:pointer;
   }
.container tr{
    border-bottom: 1px solid black;             
}
 tr:nth-of-type(even){
    
    background-color:grey;
}


</style>
</head>

<body>
<%
ArrayList<CartBean> al1=(ArrayList<CartBean>)session.getAttribute("al1list");
if(al1.size()==0){
	out.println("<div >Cart is Empty</div>");
}else{
	

Iterator itr=al1.iterator();


int totalbill=0;
out.println("<table class='container'>");
out.println("<tr><th>Rownum</th><th>FoodName</th><th>FoodPrice</th><th>FoodQty</th><th>FoodQty</th></tr>");


while(itr.hasNext()){
	
	CartBean cb=(CartBean)itr.next();
	out.println("<tr>");
	out.println("<td>"+cb.getRownum()+"</td>");
	out.println("<td>"+cb.getFname()+"</td>");
	out.println("<td>"+cb.getPrice()+"&#8377</td>");
	out.println("<td>"+cb.getQty()+"</td>");
	out.println("<td><a href='remove?rownum="+cb.getRownum()+"'>Remove</a></td>");
	out.println("</tr>");
	
}

out.println("</table>");


out.println("Total Amount:"+totalbill+"<br>");

String msg1=(String)application.getAttribute("msg");


out.println(msg1);

}

%>
<a href="Order.jsp">Order </a>

</body>
</html>
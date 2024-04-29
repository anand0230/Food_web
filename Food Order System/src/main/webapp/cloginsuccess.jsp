 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<title>Insert title here</title>
<style>
   *{
    margin: 0;
   }
   body{
    background-image: url("https://images.rawpixel.com/image_800/cHJpdmF0ZS9sci9pbWFnZXMvd2Vic2l0ZS8yMDIyLTA1L3B4MTM2OTgxMy1pbWFnZS1rd3Z4eHA5MS5qcGc.jpg");
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    height: 100vh;
   }
   header{
    display: flex;
    height: 70px;
    justify-content: space-evenly;
    align-items: center;



    
   }
#div1
{
    width: 50%;
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
}
#div2{
    height: 100%;
    width: 50%;
}
#div2 button{
    margin-left: 500px;
    margin-top: 25px;
    height: 40px;
    width: 50px;
border-radius: 5px;
border: none;



}
#div2 a{
    text-decoration: none;

}
#mainbody{

    color: blue;
    font-weight: bold;
}
#name{
    color: white;
    font-weight: bold;
    font-size: 30px;
}

</style>
</head>
<body>




<header >
    <div id="div1">
<button><a href="cview">ViewAllFoods</a>
</button> 
<button><a href="logout">Logout</a>
</button>     
</div>
<div id="div2">
    <button><a href="viewcart"><i style="font-size: 20px; font-weight: bolder; color: black;  " class="bi bi-cart"></i></a></button>
</div>



</header>

   <%
    CustomerBean cb=(CustomerBean)request.getAttribute("cbean");
    out.println("<div id='name'>Welcome "+cb.getFname()+" </div>"+cb.getLname());
    
    %> 
    
    


</body>
</html>
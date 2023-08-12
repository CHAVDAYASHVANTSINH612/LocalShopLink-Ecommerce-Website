
<%@page import="com.daoJDBC.*" %>

<%

   UserDAO user= (UserDAO)session.getAttribute("user");
if(user==null){
	session.setAttribute("failMessage","login first then access that page");
	response.sendRedirect("login.jsp");
	return;
}

%>





<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.daoJDBC.*" import="com.daoJDBC.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@include file="navbar.jsp" %>
<% 


out.println("id : "+user.getUserId() );
out.println("<br>");
out.println("username : "+user.getUserName());
out.println("<br>");
out.println("phone : "+user.getUserPhone());
out.println("<br>");
out.println("address : "+user.getUserAddress());


%>

<br>
<form action="logout" method="post">

<input type="submit" value="LOGOUT NOW">


</form>

</body>
</html>
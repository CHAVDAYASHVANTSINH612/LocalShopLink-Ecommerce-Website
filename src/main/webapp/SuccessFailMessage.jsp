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

  String failMessage = (String)session.getAttribute("failMessage");
   if(failMessage!=null){
	   
%>
<h4 style="color:red"><%= failMessage %></h4>

<%

session.removeAttribute("failMessage");
}
   
%>


<%

  String successMessage = (String)session.getAttribute("successMessage");

   if(successMessage!=null){
	   
%>
<h4 style="color:green"><%= successMessage %></h4>

<%
session.removeAttribute("successMessage");
}
 
%>





</body>
</html>
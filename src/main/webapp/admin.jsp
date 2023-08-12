

<!-- check if user/admin is loged in or  not -->
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
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin page</title>
  <link rel="stylesheet" href="./admin.css"> 
  <style >
  .card1:hover {
    background-color: #ffffff;
    
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.7);
    
     }
     
     .card2:hover {
    background-color: #ffffff;
    
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.7);
    
     }
   
</style>  
</head>
<body>
<%@include  file="navbar.jsp" %>


<div class="container">
              <div class="container text-center">
              
                  <%
                     String successCategory=(String)session.getAttribute("successCategory");
                    if(successCategory!=null){
        	
             	  %>
        	
        	<h4 style="color:green"><%= successCategory %></h4>
        	
                <% 
        	
          	session.removeAttribute("successCategory");
             }
        
                %>
        
        <!-- fail msg -->
            <%
               String failCategory=(String)session.getAttribute("failCategory");
               if(failCategory != null){
        	
        	%>
        	
        	<h4 style="color:red"><%= failCategory %></h4>
        	
           <% 
        	 session.removeAttribute("failCategory");
              }
        
            %>
              
              </div>
 
        <div class="row1"  style="text-align:center" >
            <div class="card1"   >
            <img alt="users.png" src="./imgs/admin_imgs/team.png" style="width:98%; height:75%">
                <h2>User Count</h2>
                <p>1000</p>
            </div>
            <div class="card1">
            <img alt="users.png" src="./imgs/admin_imgs/cat5.png" style="width:98%">
            <br>
             
                <h2>Categories</h2>
                <p>50</p>
            </div>
            <div class="card1">
            <img alt="users.png" src="./imgs/admin_imgs/orders1.png" style="width:98%">
           
                <h2>Orders</h2>
                <p>500</p>
            </div>
        </div>
        <br>
        <div class="row2">
            <div class="card2" style="text-align:center; align-items:center" data-bs-toggle="modal" data-bs-target="#add-category-modal">
                <h2>Add Category</h2>
                    <img id="orderimg" alt="users.png" src="./imgs/admin_imgs/cat4.png" style="width:28% ;"> 
            </div>
            <div class="card2" style="text-align:center ; align-items:center" data-bs-toggle="modal" data-bs-target="#add-product-modal">
                <h2>Add product</h2>
                 <img alt="users.png" src="./imgs/admin_imgs/add_p1.png" style="width:28% ;">
            </div>
        </div>
        
    </div>
    

<!-- Modal for add category-->
<div class="modal fade" id="add-category-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Fill Category Details</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form action="AddCategoryORProduct" method="post">
        
             <div class="form-group">
                 <input name="WhatToAdd" type="hidden" value="AddCategory">  <!--  for checking it is to add category or product -->
                  <label for="cat-name">Category name:</label>
                 <input name="categoryName" id="cat-name" type="text" class="form-control" placeholder="">
             <br> <br>
                    <label for="cat-desc">Category description:</label>
                    <textarea name="categoryDescription" id="cat-desc" rows="3" cols="30" class="form-control" placeholder=""></textarea>
                   
                   <div class="container text-center">
                      <input class="btn btn-primary" type="submit" >Add Category</button>
                   </div>
             
             </div>
        
        </form>
       
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
     
      </div>
    </div>
  </div>
</div>


<!-- Modal for add product-->
<div class="modal fade" id="add-product-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Fill Product Details</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
       
      </div>
    </div>
  </div>
</div>


</body>
</html>
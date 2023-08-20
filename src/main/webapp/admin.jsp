

<!-- check if user/admin is loged in or  not -->
<%@page import="com.daoJDBC.* , java.util.* , java.io.*" %>


<%

 //  UserDAO user= (UserDAO)session.getAttribute("user");
//if(user==null){
//	session.setAttribute("failMessage","login first then access that page");
//	response.sendRedirect("login.jsp");
//	return;
//}

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
              
                 <%@include file="SuccessFailMessage.jsp" %>
              
              </div>
 
        <div class="row1"  style="text-align:center" >
            <div class="card1"   >
            <img alt="users.png" src="./imgs/admin_imgs/team.png" style="width:98%; height:75%">
                <h2>User Count</h2>
                <% UserDAO u2= new UserDAO();%>
                <p><%=u2.getNumOfUsers() %></p>
            </div>
            <div class="card1">
            <img alt="users.png" src="./imgs/admin_imgs/cat5.png" style="width:98%">
            <br>
             
                <h2>Categories</h2>
                <% CategoryDAO c3= new CategoryDAO();%>
                <p><%=c3.getNumOfCategories() %></p>
            </div>
            <div class="card1">
            <img alt="users.png" src="./imgs/admin_imgs/orders1.png" style="width:98%">
           
                <h2>Orders</h2>
                <p>500</p>
            </div>
            <div class="card1">
            <img alt="users.png" src="./imgs/admin_imgs/cubes (1).png" style="width:98%">
           
                <h2>products</h2>
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
             
                 <input name="WhatToAdd" type="hidden" value="AddCategory" >  <!--  for checking it is to add category or product -->
                  
                  <label for="cat-name">Category name:</label> <span style="color: red; font-size: 20px;">*</span>
                 <input name="categoryName" id="cat-name" type="text" class="form-control" placeholder="" required>
             <br> <br>
                    <label for="cat-desc">Category description:</label> <span style="color: red; font-size: 20px;">*</span>
                    <textarea name="categoryDescription" id="cat-desc" rows="3" cols="30" class="form-control" placeholder="" required></textarea>
                   
                   <div class="container text-center">
                      <input class="btn btn-primary" type="submit" value="Add Category" >
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


<!-- Modal for add product : blow "id" is mapped with "add product" box by  data-bs-target="#add-product-modal"-->
    <div class="modal fade modal-lg" id="add-product-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
     <div class="modal-dialog">
       <div class="modal-content">
         <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Fill Product Details</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
      <div class="modal-body">
      
      <!-- form start -->                                   
         <form action="AddCategoryORProduct" method="post"  enctype="multipart/form-data">
        
             <div class="form-group">
             
                 <input name="WhatToAdd" type="hidden" value="AddProduct">  <!--  for checking it is to add category or product -->
                 
             <!--input name -->     
                  <label for="prod-name">Product name:</label> <span style="color: red; font-size: 20px;">*</span>
                 <input name="productName" id="prod-name" type="text" class="form-control" placeholder="" required>
              <!--input price -->  
                    <label for="prod-price">Product price ( in Indian Rupee):</label> <span style="color: red; font-size: 20px;">*</span>
                     <input type="number" id="prod-price" name="productPrice" class="form-control" required>
                     
                <!--input description -->     
                     <label for="prod-desc">Description:</label> <span style="color: red; font-size: 20px;">*</span>
                     <textarea name="productDescription" id="prod-desc" rows="3" cols="30" class="form-control" placeholder="" required></textarea>
                   
                   <br>
                     
                   <div style="display:flex">
                 <!--input Category id -->     
                       <div style="display:block">
                       <label for="prod-id">Select Category id :</label> <span style="color: red; font-size: 20px;">*</span>
                       
               <!-- fetching all categories From db to select -->       
                       <select name="productCategoryId" id="prod-name" type="number" class="form-control" style="width:100%" required>
                   
                     <%
                           CategoryDAO c2= new CategoryDAO();
                           List<CategoryDAO> list = c2.getAllCategories();
                           
                       %>
                   
                       <option value="0" selected>select</option>
                       <% for(CategoryDAO c : list ){ %>
                       
                       <option value=<%= c.getCategoryId() %>  ><% out.println( c.getCategoryName() ); %></option>
                       
                          
                       <%  } %>
                       </select>
                        
                      </div>
                      
                      <!--input quantity -->   
                      &nbsp &nbsp
                      <div style="display:block">
                      <label for="prod-quantity">Quantity available:</label> <span style="color: red; font-size: 20px;">*</span>

                         <input name="productQuantity" id="prod-quantity" type="number" class="form-control" placeholder=""style="width:100%" required>
                      </div> 
                       <!--input photo -->  
                      &nbsp &nbsp
                       <div style="display:block">
                      <label for="prod-photo">Upload photo:</label> <span style="color: red; font-size: 20px;">*</span>
               
                         <input name="productPhoto" id="prod-photo" type="file" class="form-control" placeholder="" style="width:100%" required>
                             </div> 
                       
                  </div>
                        
                   <div class="container text-center">
                      <input class="btn btn-primary" type="submit" value="Add Product" >
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


</body>
</html>
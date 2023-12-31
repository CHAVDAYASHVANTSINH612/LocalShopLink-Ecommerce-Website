
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="javax.servlet.http.* , com.daoJDBC.* , java.util.*" 
    
    %>  
   
    
 <!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>LocalShopLink</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <style>
        <%@include  file="navbar.css"%>
        </style>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

       

      </head>
      <body>

<nav >
            <a href="index.jsp" style="text-decoration: none; color:white"> <h3 id="head">LocalShopLink</h3> </a>
            <ul>
                <!-- <li class="nav-item dropdown">
                    <a id="category" class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Category
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                      <li><a class="dropdown-item" href="#">Action</a></li>
                      <li><a class="dropdown-item" href="#">Another action</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="#">Something else here</a></li>  
                      
                      
                      
                    </ul>
                  </li>
                    -->
                    <form name="categoryForm" id="categoryForm" action="index.jsp"  method="get" >
                    
                      <select name="category"  id="category" type="number" class="form-control" style="width:100%" required>
                   
                     <%
                           CategoryDAO c1= new CategoryDAO();
                           List<CategoryDAO> listCategory = c1.getAllCategories();
                           
                           String categorys=request.getParameter("category");
                           int categoryN=16;
                           
                           if(categorys!=null){
                            categoryN=Integer.parseInt( request.getParameter("category"));
                           }
                       %>
                   
                      
                       <% for(CategoryDAO c : listCategory ){ %>
                       
                       
                     <%if(c.getCategoryId()== categoryN) {
                     %>
                            <option value=null selected><% out.println( c.getCategoryName() ); %> <b>&#8964</b></option>   
                     <%} 
                     else{
                     %>
                       
                       <option value=<%= c.getCategoryId() %>  ><% out.println( c.getCategoryName() ); %></option>
                       
                          
                       <% }
                       } %>
                       </select>
                       <input type="submit" style="display:none">
                       </form>
                       
                    
                       
                       
                    
                    
                <form id="search-form" action="index.jsp" method="get">
                
                    <input name="searchBox" id="search-box" type="search" placeholder="       Search" aria-label="Search"/>
                    <Button variant="outlined" id="search-button" class="" type="submit">Search</Button>
                    
                </form>
               
             <!--     <li id="home" class="item left-item"><a href="index.jsp">Home</a></li> -->
                
                <li class="item left-item"><a href="login.jsp">Login</a><a href="signup.jsp">Register</a></li>
               
                
            </ul>
    
        </nav>
        </body>
        
           <script>
                               document.getElementById("category").addEventListener('change', function() {
                               document.getElementById('categoryForm').submit();
                                         });
                               
                               
                               
                               
           </script>
        
        </html>

    
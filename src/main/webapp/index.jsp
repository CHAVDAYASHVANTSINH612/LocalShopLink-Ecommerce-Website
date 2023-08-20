   <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="javax.servlet.http.*, com.daoJDBC.* , java.util.* , java.io.* , java.sql.* " 
    
    %>
   
    
 <!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>LocalShopLink</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        
        <link rel="stylesheet" type="text/css" href="./index.css">
        
        <style>
        <%@include file="./index.css" %>
        
        </style>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

        

      </head>
      <body>
      
        
        <%@include file="navbar.jsp" %>


       <div class="container-fluid">
       
        <div id="carouselExampleCaptions" class="carousel slide carousel-slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
              <button  type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
              <button  type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
              <button  type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
              <div class="carousel-item active">
               
                <img src="./imgs/carousel/c3.webp" class="d-block w-100 carousel-img" alt="...">
           
              </div>
              <div class="carousel-item">
                
                <img  src="./imgs/carousel/c1_asus_laptop.webp" class="d-block w-100 carousel-img" alt="...">
               
              </div>
              <div class="carousel-item">
                
                <img src="./imgs/carousel/c2_nothing_phone2.webp" class="d-block w-100 carousel-img" alt="...">
              </div>

              </div>
            
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Next</span>
            </button>
          </div>
        </div>
     
     
     
   
     <div class="container">
       <div class="row1"  >
          <%
          
             
            ProductDAO p = new ProductDAO();
            ArrayList<ProductDAO> list; 
        
         //   ArrayList<ProductDAO> list=(ArrayList<ProductDAO>)session.getAttribute("productList");
         
          
          String  category=request.getParameter("category");   //
          String searchBox = request.getParameter("searchBox");
  // product by category   
         if( !(category==null) ){
        	 
             list =  p.getProducts(Integer.parseInt(category));
         
         }
    
         
       else  if( !(searchBox==null) ){
          	 
                  list =  p.getProducts(searchBox);
           
           }
           else{
        	   
          	      list =  p.getProducts();
          	 
           }
            
          %>
        
            
            <% if(list==null){
            	response.sendRedirect("index.jsp");
            	return;
            }
            else{
            	
            for(ProductDAO product:list){
            	
        	 %>
        	<div class="card1" >
        	   
        	   
      <!--  image code --> 
        	   <%
        	     String productPhoto = product.getBase64EncodedImage();
        	   if(productPhoto!=null){
        	   
        	   %>
        	 
              
              <img id="productPhoto" src="data:image/png;base64,<%= productPhoto %>"  style="height:45%; padding:5px; width:90%;"/>
              <hr style="width:100%; margin-bottom:0px">
        
              
             <%   
             
            
             
             } %>
             
                <h6 id="productName"><%= product.getProductName() %></h6>
               
               
            <% int price= (int)(product.getProductPrice() - 0.01*product.getProductDiscount()*product.getProductPrice() ) ; %>
                         
               
               <div id="priceAndDiscount"> 
                    <div id="price"><h5> &#8377 <%= price %></h5></div>  &nbsp &nbsp
                    
                    <% int savedRs= product.getProductPrice()- price ;%>
                
                   <div id="discount"><%= product.getProductDiscount()+"% off " %></div>
              </div>    
              
              <div id="buyNowSaveRs">
                    <div id="buyNow"> Buy Now</div>
                   <div id=saveRs> Save &#8377 <%= savedRs %></div>
                    
            </div>
                
             </div>   <!-- card div end -->
          <%}
            
            }
            %>
          
        
        
           </div>
           
           </div>


      </body>
      </html>
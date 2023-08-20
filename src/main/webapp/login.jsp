<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Into LocalShopLink</title>



</head>
<body>
   <%@include file="navbar.jsp" %>
   
   
 
 
  <h1 class="text-center mt-0 mb-3">Login here </h1>
   

            <div class="row mt-2 " style="width:100vw; padding-left:39%">
             
                <div class="col-md-5">
                
              <%@include file="SuccessFailMessage.jsp" %>

                 <div>
                    <form action="login" method="post" >
                        <div class="form-group mt-4">
                            <label for="exampleInputEmail1">Username(Email)</label><span
                                style="color: red; font-size: 20px;">*</span>
                            <input type="email" name="username" class="form-control" id="exampleInputEmail1"
                                aria-describedby="emailHelp" placeholder="Enter email as username"  required>
              
                        </div>

                        <div class="form-group  mt-4">
                            <label for="password">Password</label><span style="color: red; font-size: 20px;">*</span>
                            <input type="password" name="password" class="form-control" id="password"
                                aria-describedby="emailHelp" placeholder="Enter password" required>
                        </div>
                        
                         <br>
                       
                     <a href="signup.jsp">if not registered click here</a>
                        
                         <div class="container mt-4 text-center">
                            <button type="submit" class="btn btn-primary">Login</button>
                            
                        </div>
                        </form>
                        
                 </div>
                 </div>
                 </div>


</body>
</html>